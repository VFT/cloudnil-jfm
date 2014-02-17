package com.cloudnil.portal.menu.controller;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Order;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cloudnil.framework.core.controller.BaseController;
import com.cloudnil.framework.core.model.ExtGridReturn;
import com.cloudnil.framework.core.model.ExtPager;
import com.cloudnil.framework.core.model.ExtReturn;
import com.cloudnil.framework.core.model.Sort;
import com.cloudnil.framework.core.model.TreeUtil;
import com.cloudnil.framework.utils.common.Constants;
import com.cloudnil.framework.utils.common.JackJsonUtil;
import com.cloudnil.portal.menu.model.Menu;
import com.cloudnil.portal.menu.service.MenuService;
@Controller
@RequestMapping(value="menu")
public class MenuController extends BaseController {
	private final static Logger log = LoggerFactory.getLogger(MenuController.class);
	@Autowired
	private MenuService service;
	@RequestMapping(value="findPage.do")
	public String findPage(){
		log.info("Acess Menu!");
		return "portal/menu/menu";
	}
	@RequestMapping(value="menuTree.do")
	@ResponseBody
	public Object getMenuTree() {
		//获取全部菜单数据
		Query query=new Query();
		query.addCriteria(Criteria.where("isDisplay").is(true));
		List<Menu> menuList=service.find(query, Menu.class);
		//构造树形菜单的根节点
		Menu root=new Menu();
		root.setId(Constants.TREE_ROOT_ID);
		//生成菜单树
		Menu tree=TreeUtil.getExtTree(root, menuList);
		return tree;
	}
	
	@RequestMapping(value="menuList.do")
	@ResponseBody
	public Object getMenuList(String parentId,String param,ExtPager pager) {
		Query query=new Query();
		if(StringUtils.isNotEmpty(parentId)&&!Constants.TREE_ROOT_ID.equals(parentId)){
			Criteria crit1 = Criteria.where("parentId").is(parentId);
			Criteria crit2 = Criteria.where("id").is(parentId);
			query.addCriteria(new Criteria().orOperator(crit1,crit2));
		}
		if(StringUtils.isNotEmpty(param)){
			Criteria crit1 = Criteria.where("text").regex(".*?"+param+".*");
			Criteria crit2 = Criteria.where("url").regex(".*?"+param+".*");
			query.addCriteria(new Criteria().orOperator(crit1,crit2));
		}
		Long totalNum=service.count(query, Menu.class);
		if (pager.getLimit()!=null&&pager.getStart() != null) {
			query.skip(pager.getStart()).limit(pager.getLimit());
		}
		if (StringUtils.isNotBlank(pager.getSort())) {
			Sort[] sorts=JackJsonUtil.fromJsonToObject(pager.getSort(), Sort[].class);
			for(Sort s:sorts){
				query.sort().on(s.getProperty(),"DESC".equals(s.getDirection())?Order.DESCENDING:Order.ASCENDING);
			}
		}
		List<Menu> rows=service.find(query, Menu.class);
		return new ExtGridReturn(totalNum,rows);
	}
	
	@RequestMapping(value="saveMenu.do")
	@ResponseBody
	public Object saveMenu(Menu menu){
		if(StringUtils.isBlank(menu.getId())){
			menu.setId(null);
			menu.setCreateTime(new Date());
		}
		service.save(menu);
		return new ExtReturn(true,this.getMessage("common.doSuccess"));
	}
	
	@RequestMapping(value="deleteMenus.do")
	@ResponseBody
	public Object deleteMenus(@RequestParam(required = true) String[] ids){
		Query query=new Query(Criteria.where("id").in(Arrays.asList(ids)));
		service.remove(query, Menu.class);
		return new ExtReturn(true,this.getMessage("common.doSuccess"));
	}
}
