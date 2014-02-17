package com.cloudnil.framework.core.model;

import java.io.Serializable;
import java.util.List;
/**
 * <p>ClassName: ExtGridReturn</p>
 * <p>Description: EXT分页Grid封装类</p>
 * @author 史绍虎
 * <p>Date: 2012-5-30 下午2:59:02</p>
 */
public class ExtGridReturn implements Serializable{
	/**
	 * 序列化编码
	 */
	private static final long serialVersionUID = -2898122958288735053L;
	/**
	 * 总记录数
	 */
	private long totalNum;
	/**
	 * 当前查询结果集
	 */
	private List<?> rows;

	public ExtGridReturn(){
		
	}

	public ExtGridReturn(long totalNum, List<?> rows) {
		this.totalNum = totalNum;
		this.rows = rows;
	}
	public long getTotalNum() {
		return totalNum;
	}

	public void setTotalNum(long totalNum) {
		this.totalNum = totalNum;
	}

	public List<?> getRows() {
		return rows;
	}

	public void setRows(List<?> rows) {
		this.rows = rows;
	}

}
