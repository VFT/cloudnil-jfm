package com.cloudnil.framework.core.controller;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import com.cloudnil.framework.utils.common.DateConvertEditor;
import com.cloudnil.framework.utils.common.JackJsonUtil;
/**
 * <p>ClassName: BaseController</p>
 * <p>Description: SpringMVC控制层基类,包括一些控制层底层封装</p>
 * @author 史绍虎
 * <p>Date: 2012-5-31 下午1:12:12</p>
 */
public abstract class BaseController {
	@Autowired 
	private  HttpServletRequest request;
	@Autowired
	private MessageSource messages;
	/**
	 * <p>MethodName: getRequest</p>
	 * <p>Description: 获取当前请求的Request</p>
	 * @return HttpServletRequest
	 */
	public HttpServletRequest getRequest() {
		return request;
	}
	/**
	 * <p>MethodName: getSession</p>
	 * <p>Description: 获取当前有效Session</p>
	 * @return HttpSession
	 */
	public HttpSession getSession() {
		return this.request.getSession();
	}
	/**
	 * <p>MethodName: getMessage</p>
	 * <p>Description: 从国际资源化配置文件中读取key对应value</p>
	 * @param String key 需要读取的key
	 * @param HttpServletRequest request
	 * @return String key对应的value
	 */
	public String getMessage(String key){
		String message = messages.getMessage(key,null,request.getLocale());
		return message;
	}
	/**
	 * <p>MethodName: getMessage</p>
	 * <p>Description: 从国际资源化配置文件中读取key对应value，占位符参数可配置</p>
	 * @param String key 需要读取的key
	 * @param Object[] args 占位符参数
	 * @param HttpServletRequest request
	 * @return String key对应的value
	 */
	public String getMessage(String key,Object[] args){
		String message = messages.getMessage(key,args,request.getLocale());
		return message;
	}
	/**
	 * <p>MethodName: initBinder</p>
	 * <p>Description: 日期格式字符串转换</p>
	 * @param binder
	 */
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Timestamp.class, new DateConvertEditor<Timestamp>("yyyy-MM-dd HH:mm:ss",Timestamp.class));
		binder.registerCustomEditor(Date.class, new DateConvertEditor<Date>("yyyy-MM-dd",Date.class));
		binder.registerCustomEditor(java.util.Date.class, new DateConvertEditor<java.util.Date>("yyyy-MM-dd HH:mm:ss",java.util.Date.class));
	}
	
	/**
	 * <p>MethodName: jsonToPO</p>
	 * <p>Description:输入PO对象的数据类型，必须为数组类型(如：Unit[])，返回通过sync()返回的PO对象</p>
	 * @param className 数据类型(必须是数组类型)
	 * @return 通过sync()返回改变的PO的数组对象
	 */
	public <T> T jsonToPO(Class<T> className){
		ByteArrayOutputStream bo = null;
		InputStream in = null;
		String myJSON = null;
		try {
			in = request.getInputStream();
			bo=new ByteArrayOutputStream();
			for(int i=-1;(i=in.read())!=-1;){
				bo.write(i);
			}
			myJSON = bo.toString();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				in.close();
				bo.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		 
		if(myJSON.charAt(0) != '['){
			myJSON = "[" + myJSON +"]";
		}
		return JackJsonUtil.fromJsonToObject(myJSON,className);
	}
	
}
