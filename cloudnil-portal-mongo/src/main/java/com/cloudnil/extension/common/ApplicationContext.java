package com.cloudnil.extension.common;

import java.util.HashMap;
import java.util.Map;

import com.cloudnil.portal.user.model.User;
/**
 * <p>ClassName: ApplicationContext</p>
 * <p>Description: 应用级别存储容器</p>
 * @author 史绍虎
 * <p>Date: 2012-6-15 下午5:41:25</p>
 */
public class ApplicationContext {
	//存储应用系统所有登陆用户，应用级别，内存存储
	public static Map<String,User> Login_User_Map=new HashMap<String,User>();
}
