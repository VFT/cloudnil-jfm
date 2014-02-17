package com.cloudnil.portal.menu.model;
/**
 * <p>ClassName: MenuCheck</p>
 * <p>Description: 带复选框的菜单类</p>
 * @author 史绍虎
 * <p>Date: 2012-11-27 下午4:20:01</p>
 */
public class MenuCheck extends Menu {
	
	private static final long serialVersionUID = 6051223424287124218L;

	private boolean checked;

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}
}
