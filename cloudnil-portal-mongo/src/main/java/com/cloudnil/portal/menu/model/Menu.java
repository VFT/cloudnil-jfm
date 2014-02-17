package com.cloudnil.portal.menu.model;
import java.util.Date;

import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.springframework.data.mongodb.core.mapping.Document;

import com.cloudnil.framework.core.model.Tree;
import com.cloudnil.framework.utils.common.CustomDateSerializer;
/**
 * <p>ClassName: Menu</p>
 * <p>Description: 菜单模块POJO类</p>
 * @author 史绍虎
 * <p>Date: 2012-6-12 上午11:00:03</p>
 */
@Document(collection="portal.menu")
public class Menu extends Tree{
	/**
	 * 序列化编码
	 */
	private static final long serialVersionUID = -2638758520670476104L;
	/**
	 * APP:应用 FUN_INTER：功能(内网) FUN_EXTER：功能(外网)
	 */
	private String type;
	private boolean isDisplay;
	private Short displayIndex;
	private String comment;
	private String helpInfo;
	private Date createTime;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public boolean getIsDisplay() {
		return isDisplay;
	}
	public void setIsDisplay(boolean isDisplay) {
		this.isDisplay = isDisplay;
	}
	public Short getDisplayIndex() {
		return displayIndex;
	}
	public void setDisplayIndex(Short displayIndex) {
		this.displayIndex = displayIndex;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getHelpInfo() {
		return helpInfo;
	}
	public void setHelpInfo(String helpInfo) {
		this.helpInfo = helpInfo;
	}
	@JsonSerialize(using=CustomDateSerializer.class)
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	@Override
	public boolean equals(Object o){
		if (this == o) {
		    return true;
		}
		if (o instanceof Menu) {
			Menu mo=(Menu)o;
			if(this.getId().equals(mo.getId())&&this.getText().equals(mo.getText())){
				return true;
			}
		}
		return false;
	}
}
