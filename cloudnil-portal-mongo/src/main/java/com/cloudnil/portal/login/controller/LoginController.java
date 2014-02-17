package com.cloudnil.portal.login.controller;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cloudnil.extension.common.ApplicationContext;
import com.cloudnil.extension.common.PortalConstants;
import com.cloudnil.framework.core.controller.BaseController;
import com.cloudnil.framework.core.model.ExtReturn;
import com.cloudnil.framework.core.model.TreeUtil;
import com.cloudnil.portal.login.service.LoginService;
import com.cloudnil.portal.menu.model.Menu;
import com.cloudnil.portal.user.model.User;
/**
 * <p>ClassName: LoginController</p>
 * <p>Description: 处理用户登陆、菜单资源加载、退出登陆等操作的Action</p>
 * @author 史绍虎
 * <p>Date: 2012-6-15 下午3:00:41</p>
 */
@Controller
public class LoginController extends BaseController {
	private final static Logger log = LoggerFactory.getLogger(LoginController.class);
	@Autowired
	private LoginService service;
	/**
	 * <p>MethodName: login</p>
	 * <p>Description: 账号登陆Action</p>
	 * @param userName
	 * @param password
	 * @return ExtReturn 登陆结果信息
	 */
	@RequestMapping(value="/login.do")
	@ResponseBody
	public Object login(@RequestParam(required=false) String userName, @RequestParam(required=false) String password){
//		User u=new User();
//		u.setCode("SLC001");
//		u.setAge((short)15);
//		u.setCnName("shishaohu");
//		u.setUserName("tiger435");
//		u.setPassword(this.MD5Password("123456"));
//		service.save(u);
		if (StringUtils.isBlank(userName)) {
			return new ExtReturn(false, this.getMessage("common.account.notBlank"));
		}
		if (StringUtils.isBlank(password)) {
			return new ExtReturn(false, this.getMessage("common.password.notBlank"));
		}
		User user=service.loadUser(userName,this.MD5Password(password));
		if(user!=null){
			this.getSession().setAttribute(PortalConstants.CURRENT_USER, user);
			return new ExtReturn(true, "success");
		}else{
			log.info(this.getMessage("common.securityFailed"));
			return new ExtReturn(false, this.getMessage("common.securityFailed"));
		}
//		List menus=service.findAll(Menu.class);
//		user.setMenus(menus);
//		service.save(user);
//		return new ExtReturn(false, this.getMessage("common.securityFailed"));
	}
	/**
	 * <p>MethodName: loginOut</p>
	 * <p>Description: 退出登陆的Action</p>
	 * @return ExtReturn
	 */
	@RequestMapping(value="/loginout.do")
	@ResponseBody
	public Object loginOut(){
		ApplicationContext.Login_User_Map.remove(((User)this.getSession().getAttribute(PortalConstants.CURRENT_USER)).getUserName());
		this.getSession().removeAttribute(PortalConstants.CURRENT_USER);
		this.getSession().invalidate();
		return new ExtReturn(true, this.getMessage("common.logoutInfo"));
	}
	/**
	 * <p>MethodName: getApps</p>
	 * <p>Description: 获取当前登陆用户的应用信息</p>
	 * @return
	 */
	@RequestMapping(value="/apps.do")
	@ResponseBody
	public Object getApps() {
		User user=(User)this.getSession().getAttribute(PortalConstants.CURRENT_USER);
		List<Menu> appList=new ArrayList<Menu>();
		for(Menu m:user.getMenuList()){
			if("RN".equals(m.getParentId())){
				appList.add(m);
			}
		}
		return appList;
	}
	/**
	 * <p>MethodName: getTreeMenu</p>
	 * <p>Description: 获取当前登陆用户的菜单信息</p>
	 * @param appId
	 * @return
	 */
	@RequestMapping("/menu.do")
	@ResponseBody
	public Object getTreeMenu(@RequestParam(required=false) String appId) {
		User user=(User)this.getSession().getAttribute(PortalConstants.CURRENT_USER);
		//获取全部菜单数据
		List<Menu> menuList=user.getMenuList();
		//构造树形菜单的根节点
		Menu root=new Menu();
		root.setId(appId);
		//生成菜单树
		Menu tree=TreeUtil.getExtTree(root, menuList);
		return tree;
	}
	/**
	 * <p>MethodName: MD5Password</p>
	 * <p>Description: 对用户密码进行MD5加密</p>
	 * @param password 密码明文
	 * @return String 加密后的密码密文
	 */
	public String MD5Password(String password){
		Md5PasswordEncoder md5=new Md5PasswordEncoder();
		if(StringUtils.isNotEmpty(password)){
			return md5.encodePassword(password, PortalConstants.MD5_SALT_KEY);
		}
		return password;
	}
}
