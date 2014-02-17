package com.cloudnil.portal.login.service;
import com.cloudnil.framework.core.service.BaseService;
import com.cloudnil.portal.user.model.User;
/**
 * <p>ClassName: LoginService</p>
 * <p>Description: 登陆功能模块的Service接口类</p>
 * @author 史绍虎
 * <p>Date: 2012-6-13 下午1:40:44</p>
 */
public interface LoginService extends BaseService {
	/**
	 * <p>MethodName: loadUser</p>
	 * <p>Description: 校验登陆用户，初始化登陆用户的权限信息</p>
	 * @param userName
	 * @param password
	 * @return User
	 */
	public User loadUser(String userName,String password);
	/**
	 * <p>MethodName: loadUserByUserName</p>
	 * <p>Description: 根据登陆用户名加载用户的权限信息，主要用于SSO登陆通过后加载用户信息</p>
	 * @param userName
	 * @return User
	 */
	public User loadUserByUserName(String userName);
}
