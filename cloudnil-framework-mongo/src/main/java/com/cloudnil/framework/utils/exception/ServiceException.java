package com.cloudnil.framework.utils.exception;
/**
 * <p>ClassName: ServiceException</p>
 * <p>Description: Service层异常类</p>
 * @author 史绍虎
 * <p>Date: 2012-5-30 下午3:29:43</p>
 */
public class ServiceException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	public ServiceException(String msg) {
		super(msg);
	}
	public ServiceException(String msg ,Throwable tw){
		super(msg, tw);
	}
}
