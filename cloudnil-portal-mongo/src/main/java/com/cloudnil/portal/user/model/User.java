package com.cloudnil.portal.user.model;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.cloudnil.framework.utils.common.CustomDateSerializer;
import com.cloudnil.portal.menu.model.Menu;
import com.cloudnil.portal.org.model.Org;
import com.cloudnil.portal.role.model.Role;
/**
 * <p>ClassName: User</p>
 * <p>Description: 系统用户表POJO类</p>
 * @author 史绍虎
 * <p>Date: 2012-6-6 下午3:48:15</p>
 */
@Document(collection="portal.user")
public class User implements Serializable{
	/**
	 * 序列化编号
	 */
	private static final long serialVersionUID = 4642695809916499401L;
	@Id
	private String id;
	private String userName;
	private String password;
	private String cnName;
	private String enName;
	private String code;
	/**
	 * 0:停用 1：可用 99：删除 
	 */
	private Short state;
	private Short displayIndex;
	private Short age;
	private String sex;
	private String email;
	private String mobPhone;
	private Date createTime;
	@DBRef
	private Org org;
	@DBRef
	private List<Role> roles;
	@DBRef
	private List<Menu> menus;
	@Transient
	private List<Menu> menuList;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobPhone() {
		return mobPhone;
	}
	public void setMobPhone(String mobPhone) {
		this.mobPhone = mobPhone;
	}
	@JsonSerialize(using=CustomDateSerializer.class)
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public List<Menu> getMenuList() {
		return menuList;
	}
	public void setMenuList(List<Menu> menuList) {
		this.menuList = menuList;
	}
	public Org getOrg() {
		return org;
	}
	public void setOrg(Org org) {
		this.org = org;
	}
	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	public List<Menu> getMenus() {
		return menus;
	}
	public void setMenus(List<Menu> menus) {
		this.menus = menus;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Short getState() {
		return state;
	}
	public void setState(Short state) {
		this.state = state;
	}
	public Short getDisplayIndex() {
		return displayIndex;
	}
	public void setDisplayIndex(Short displayIndex) {
		this.displayIndex = displayIndex;
	}
	public Short getAge() {
		return age;
	}
	public void setAge(Short age) {
		this.age = age;
	}
}
