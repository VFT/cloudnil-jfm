package com.cloudnil.framework.core.model;

import java.io.Serializable;
/**
 * <p>ClassName: ExtReturn</p>
 * <p>Description: EXT普通操作返回结果信息封装类</p>
 * @author 史绍虎
 * <p>Date: 2012-5-30 下午3:00:50</p>
 */
public class ExtReturn implements Serializable{
	/**
	 * 序列化ID
	 */
	private static final long serialVersionUID = -2648601442010008349L;
	/**
	 * 操作结果是否成功
	 */
	private boolean success;
	/**
	 * 返回提示消息
	 */
	private Object msg;
	/**
	 * 返回其他对象
	 */
	private Object object;
	/**
	 * <p>ConstructorName: ExtReturn</p>
	 * <p>Description: 基本构造方法</p>
	 */
	public ExtReturn() {
		
	}
	/**
	 * <p>ConstructorName: ExtReturn</p>
	 * <p>Description: 构造方法</p>
	 * @param success 操作结果
	 * @param msg 返回提示信息
	 */
	public ExtReturn(boolean success, Object msg) {
		this.success = success;
		this.msg = msg;
		this.object=null;
	}
	/**
	 * <p>ConstructorName: ExtReturn</p>
	 * <p>Description: 构造方法</p>
	 * @param success 操作结果
	 * @param msg 返回提示信息
	 * @param other 返回其他对象
	 */
	public ExtReturn(boolean success, Object msg, Object object) {
		this.success = success;
		this.msg = msg;
		this.object = object;
	}
	/**
	 * <p>ConstructorName: ExtReturn</p>
	 * <p>Description: 构造方法</p>
	 * @param errormsg 异常信息
	 */
	public ExtReturn(Object errormsg) {
		this.success = false;
		this.msg = errormsg;
		this.object = "";
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public Object getMsg() {
		return msg;
	}
	public void setMsg(Object msg) {
		this.msg = msg;
	}
	public Object getObject() {
		return object;
	}
	public void setObject(Object object) {
		this.object = object;
	}
	
}
