package com.cloudnil.framework.core.model;

import java.io.PrintWriter;
import java.io.StringWriter;
/**
 * <p>ClassName: ExceptionReturn</p>
 * <p>Description: 异常信息返回类</p>
 * @author 史绍虎
 * <p>Date: 2012-6-12 上午10:24:21</p>
 */
public class ExceptionReturn {

	private boolean success;
	private Object exceptionMessage;
	public ExceptionReturn() {
	}
	public ExceptionReturn(Throwable exceptionMessage) {
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		exceptionMessage.printStackTrace(pw);
		this.success = false;
		this.exceptionMessage = exceptionMessage.getMessage();
	}
	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public Object getExceptionMessage() {
		return exceptionMessage;
	}
	public void setExceptionMessage(Object exceptionMessage) {
		this.exceptionMessage = exceptionMessage;
	}
}
