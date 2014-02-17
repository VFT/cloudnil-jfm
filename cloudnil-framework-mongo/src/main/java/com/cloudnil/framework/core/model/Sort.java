package com.cloudnil.framework.core.model;

import java.io.Serializable;

public class Sort implements Serializable {
	/**
	 * FieldName: serialVersionUID
	 */
	private static final long serialVersionUID = -2383727077215677185L;
	/**
	 * 排序字段
	 */
	private String property;
	/**
	 * 排序方向，大写的ASC or DESC
	 */
	private String direction;
	
	public String getProperty() {
		return property;
	}
	public void setProperty(String property) {
		this.property = property;
	}
	public String getDirection() {
		return direction;
	}
	public void setDirection(String direction) {
		this.direction = direction;
	}
}
