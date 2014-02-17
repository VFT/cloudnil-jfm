package com.cloudnil.portal.org.model;

import java.io.Serializable;
import java.util.Date;

import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.cloudnil.framework.utils.common.CustomDateSerializer;
/**
 * <p>ClassName: Org</p>
 * <p>Description: 组织机构POJO类</p>
 * @author 史绍虎
 * <p>Date: 2012-6-6 下午2:33:05</p>
 */
@Document(collection="portal.org")
public class Org implements Serializable{
	/**
	 * 序列化编号
	 */
	private static final long serialVersionUID = 671248496403723024L;
	@Id
	private String id;
	private String cnName;
	private String enName;
	private String code;
	private String parentId;
	private Short level;
	/**
	 * 1：单位 2：部门 
	 */
	private Short type;
	/**
	 * 0:停用 1：可用 99：删除 
	 */
	private Short state;
	private Short displayIndex;
	private Date createTime;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCnName() {
		return cnName;
	}
	public void setCnName(String cnName) {
		this.cnName = cnName;
	}
	public String getEnName() {
		return enName;
	}
	public void setEnName(String enName) {
		this.enName = enName;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getParentId() {
		return parentId;
	}
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	public Short getLevel() {
		return level;
	}
	public void setLevel(Short level) {
		this.level = level;
	}
	public Short getType() {
		return type;
	}
	public void setType(Short type) {
		this.type = type;
	}
	public Short getState() {
		return state;
	}
	public void setState(Short state) {
		this.state = state;
	}
	@JsonSerialize(using=CustomDateSerializer.class)
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Short getDisplayIndex() {
		return displayIndex;
	}
	public void setDisplayIndex(Short displayIndex) {
		this.displayIndex = displayIndex;
	}
}
