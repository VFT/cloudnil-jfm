package com.cloudnil.portal.user.controller;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Order;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cloudnil.extension.common.PortalConstants;
import com.cloudnil.framework.core.controller.BaseController;
import com.cloudnil.framework.core.model.ExtGridReturn;
import com.cloudnil.framework.core.model.ExtPager;
import com.cloudnil.framework.core.model.ExtReturn;
import com.cloudnil.framework.core.model.Sort;
import com.cloudnil.framework.core.model.TreeUtil;
import com.cloudnil.framework.utils.common.Constants;
import com.cloudnil.framework.utils.common.JackJsonUtil;
import com.cloudnil.portal.menu.model.MenuCheck;
import com.cloudnil.portal.user.model.User;
import com.cloudnil.portal.user.service.UserService;
@Controller
@RequestMapping(value="user")
public class UserController extends BaseController {
	private final static Logger log = LoggerFactory.getLogger(UserController.class);
	@Autowired
	private UserService service;
	@RequestMapping(value="findPage.do")
	public String findPage(){
		log.info("Acess User!");
		return "portal/user/user";
	}
	@RequestMapping(value="userList.do")
	@ResponseBody
	public Object getUserList(String orgId,String param,ExtPager pager) {
		Query query=new Query();
		if(StringUtils.isNotEmpty(orgId)&&!Constants.TREE_ROOT_ID.equals(orgId)){
			query.addCriteria(Criteria.where("org.$id").is(new ObjectId(orgId)));
		}
		if(StringUtils.isNotEmpty(param)){
			Criteria crit1 = Criteria.where("userName").regex(".*?"+param+".*");
			Criteria crit2 = Criteria.where("cnName").regex(".*?"+param+".*");
			Criteria crit3 = Criteria.where("enName").regex(".*?"+param+".*");
			Criteria crit4 = Criteria.where("code").regex(".*?"+param+".*");
			query.addCriteria(new Criteria().orOperator(crit1,crit2,crit3,crit4));
		}
		Long totalNum=service.count(query, User.class);
		if (pager.getLimit()!=null&&pager.getStart() != null) {
			query.skip(pager.getStart()).limit(pager.getLimit());
		}
		if (StringUtils.isNotBlank(pager.getSort())) {
			Sort[] sorts=JackJsonUtil.fromJsonToObject(pager.getSort(), Sort[].class);
			for(Sort s:sorts){
				query.sort().on(s.getProperty(),"DESC".equals(s.getDirection())?Order.DESCENDING:Order.ASCENDING);
			}
		}
		List<User> rows=service.find(query, User.class);
		return new ExtGridReturn(totalNum,rows);
	}
	
	@RequestMapping(value="menuTree.do")
	@ResponseBody
	public Object getMenuTree() {
		//获取全部菜单数据
		Query query=new Query();
		query.addCriteria(Criteria.where("isDisplay").is(true));
		List<MenuCheck> menuList=service.find(query, MenuCheck.class);
		//构造树形菜单的根节点
		MenuCheck root=new MenuCheck();
		root.setId(Constants.TREE_ROOT_ID);
		//生成菜单树
		MenuCheck tree=TreeUtil.getExtTree(root, menuList);
		return tree;
	}
	
	@RequestMapping(value="saveUser.do")
	@ResponseBody
	public Object saveUser(User user){
		if(StringUtils.isBlank(user.getId())){
			user.setId(null);
			user.setCreateTime(new Date());
			user.setPassword(this.MD5Password(user.getUserName()));
		}
		service.save(user);
		return new ExtReturn(true,this.getMessage("common.doSuccess"));
	}
	
	@RequestMapping(value="deleteUsers.do")
	@ResponseBody
	public Object deleteUsers(@RequestParam(required = true) String[] ids){
		Query query=new Query(Criteria.where("id").in(Arrays.asList(ids)));
		service.remove(query, User.class);
		return new ExtReturn(true,this.getMessage("common.doSuccess"));
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
