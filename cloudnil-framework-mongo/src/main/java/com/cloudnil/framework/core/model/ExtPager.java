package com.cloudnil.framework.core.model;

import java.io.Serializable;
/**
 * <p>ClassName: ExtPager</p>
 * <p>Description: Ext分页控件参数封装类</p>
 * @author 史绍虎
 * <p>Date: 2012-5-30 上午10:49:12</p>
 */
public class ExtPager implements Serializable{
	/**
	 * 序列化编码
	 */
	private static final long serialVersionUID = 7585070699046101129L;
	/**
	 * 每页显示记录数
	 */
	private Integer limit;
	/**
	 * 开始行号
	 */
	private Integer start;
	/**
	 * 排序
	 */
	private String sort;

	public Integer getLimit() {
		return limit;
	}

	public void setLimit(Integer limit) {
		this.limit = limit;
	}

	public Integer getStart() {
		return start;
	}

	public void setStart(Integer start) {
		this.start = start;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}
}

