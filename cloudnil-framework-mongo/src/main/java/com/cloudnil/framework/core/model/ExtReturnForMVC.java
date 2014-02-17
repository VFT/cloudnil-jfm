package com.cloudnil.framework.core.model;

import java.io.Serializable;
import java.util.List;
/**
 * <p>ClassName: ExtReturn</p>
 * <p>Description: EXT普通操作返回结果信息封装类</p>
 * @author 史绍虎
 * <p>Date: 2012-5-30 下午3:00:50</p>
 */
public class ExtReturnForMVC implements Serializable{
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
	private List<?> rows;
	/**
	 * <p>ConstructorName: ExtReturn</p>
	 * <p>Description: 基本构造方法</p>
	 */
	public ExtReturnForMVC() {
		
	}
	/**
	 * <p>ConstructorName: ExtReturn</p>
	 * <p>Description: 构造方法</p>
	 * @param success 操作结果
	 * @param msg 返回提示信息
	 */
	public ExtReturnForMVC(boolean success, Object msg) {
		this.success = success;
		this.msg = msg;
		this.rows = null;
	}
	/**
	 * <p>ConstructorName: ExtReturn</p>
	 * <p>Description: 构造方法</p>
	 * @param success 操作结果
	 * @param msg 返回提示信息
	 * @param other 返回其他对象
	 */
	public ExtReturnForMVC(boolean success, Object msg, List<?> rows) {
		this.success = success;
		this.msg = msg;
		this.rows=rows;
	}
	/**
	 * <p>ConstructorName: ExtReturn</p>
	 * <p>Description: 构造方法</p>
	 * @param errormsg 异常信息
	 */
	public ExtReturnForMVC(Object errormsg) {
		this.success = false;
		this.msg = errormsg;
	}
	
//	public ExtReturnForMVC(boolean success, Object msg, PO po){
//		this.success = success;
//		this.msg = msg;
//		List<PO> poList = new ArrayList<PO>();
//		poList.add(po);
//		this.rows = poList;
//	}
	
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
	public List<?> getRows() {
		return rows;
	}
	public void setRows(List<?> rows) {
		this.rows = rows;
	}
	
}
