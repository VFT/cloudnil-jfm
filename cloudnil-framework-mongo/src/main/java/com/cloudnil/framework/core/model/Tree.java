package com.cloudnil.framework.core.model;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
/**
 * <p>ClassName: Tree</p>
 * <p>Description: EXT菜单对象类</p>
 * @author 史绍虎
 * <p>Date: 2012-6-12 下午5:49:26</p>
 */
public class Tree implements Serializable {
	/**
	 * 序列化编码
	 */
	private static final long serialVersionUID = -4633085341806753337L;
	@Id
	private String id;
	private String parentId;
	private String text;
	private String iconCls;
	private boolean expanded;
	private boolean leaf;
	private String url;
	@Transient
	private List<?> children;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getIconCls() {
		return iconCls;
	}

	public void setIconCls(String iconCls) {
		this.iconCls = iconCls;
	}

	public boolean isExpanded() {
		return expanded;
	}

	public void setExpanded(boolean expanded) {
		this.expanded = expanded;
	}

	public boolean isLeaf() {
		return leaf;
	}

	public void setLeaf(boolean leaf) {
		this.leaf = leaf;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public List<?> getChildren() {
		return children;
	}

	public void setChildren(List<?> children) {
		this.children = children;
	}
}
