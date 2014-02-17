package com.cloudnil.framework.utils.exception;

import org.springframework.dao.DataAccessException;
/**
 * <p>ClassName: DaoException</p>
 * <p>Description: Dao层异常类</p>
 * @author 史绍虎
 * <p>Date: 2012-5-30 下午3:29:05</p>
 */
public class DaoException extends DataAccessException{
	private static final long serialVersionUID = 1L;
	public DaoException(String msg) {
		super(msg);
	}
	public DaoException(String msg ,Throwable tw){
		super(msg, tw);
	}
}
