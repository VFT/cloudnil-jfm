package com.cloudnil.portal.role.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.cloudnil.portal.menu.model.Menu;
/**
 * <p>ClassName: Role</p>
 * <p>Description: 角色POJO类</p>
 * @author 史绍虎
 * <p>Date: 2012-6-13 下午5:54:30</p>
 */
@Document(collection="portal.role")
public class Role implements Serializable {
	/**
	 * 序列化编号
	 */
	private static final long serialVersionUID = 4822381519180461583L;
	@Id
	private String id;
	private String name;
	private String code;
	/**
	 * 1：xxx 2：xxxx 
	 */
	private Short type;
	/**
	 * 0:停用 1：可用 99：删除 
	 */
	private Short state;
	private String comment;
	private Date createTime;
	private Date updateTime;
	@DBRef
	private List<Menu> menus;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
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
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public List<Menu> getMenus() {
		return menus;
	}
	public void setMenus(List<Menu> menus) {
		this.menus = menus;
	}
	
}
