package com.cloudnil.portal.login.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.cloudnil.extension.common.ApplicationContext;
import com.cloudnil.framework.core.dao.BaseDao;
import com.cloudnil.framework.core.service.impl.BaseServiceImpl;
import com.cloudnil.portal.login.dao.LoginDao;
import com.cloudnil.portal.login.service.LoginService;
import com.cloudnil.portal.menu.model.Menu;
import com.cloudnil.portal.role.model.Role;
import com.cloudnil.portal.user.model.User;
/**
 * <p>ClassName: LoginServiceImpl</p>
 * <p>Description: 登陆功能模块的Service实现类</p>
 * @author 史绍虎
 * <p>Date: 2012-6-13 下午1:40:17</p>
 */
@Service("loginService")
public class LoginServiceImpl extends BaseServiceImpl implements LoginService {
	@Autowired
	private LoginDao dao;
	@Override
	protected BaseDao getBaseDao() {
		return dao;
	}
	public User loadUser(String userName,String password) {
		Query query=new Query(Criteria.where("userName").is(userName).and("password").is(password));
		User user=dao.findOne(query, User.class);
		return this.loadUserInfo(user);
	}
	
	public User loadUserByUserName(String userName){
		Query query=new Query(Criteria.where("userName").is(userName));
		User user=dao.findOne(query, User.class);
		return this.loadUserInfo(user);
	}
	private User loadUserInfo(User user){
		if(user!=null){
			//将登陆成功的用户基本信息放入应用中静态保存
			ApplicationContext.Login_User_Map.put(user.getUserName(), user);
			List<Menu> menuList=new ArrayList<Menu>();
			if(null!=user.getMenus()){
				menuList.addAll(user.getMenus());
			}
			if(null!=user.getRoles()){
				for(Role r:user.getRoles()){
					if(null!=r.getMenus()){
						for(Menu m:r.getMenus()){
							if(menuList.contains(m)){
								continue;
							}
							menuList.add(m);
						}
					}
				}
			}
			user.setMenuList(menuList);
		}
		return user;
	}
}
