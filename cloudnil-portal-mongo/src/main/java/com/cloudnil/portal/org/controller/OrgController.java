package com.cloudnil.portal.org.controller;

import java.util.ArrayList;
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
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cloudnil.framework.core.controller.BaseController;
import com.cloudnil.framework.core.model.ExtGridReturn;
import com.cloudnil.framework.core.model.ExtPager;
import com.cloudnil.framework.core.model.ExtReturn;
import com.cloudnil.framework.core.model.Sort;
import com.cloudnil.framework.core.model.Tree;
import com.cloudnil.framework.core.model.TreeUtil;
import com.cloudnil.framework.utils.common.Constants;
import com.cloudnil.framework.utils.common.JackJsonUtil;
import com.cloudnil.portal.org.model.Org;
import com.cloudnil.portal.org.service.OrgService;
@Controller
@RequestMapping(value="org")
public class OrgController extends BaseController {
	private final static Logger log = LoggerFactory.getLogger(OrgController.class);
	@Autowired
	private OrgService service;
	@RequestMapping(value="findPage.do")
	public String findPage(){
		log.info("Acess Org!");
		return "portal/org/org";
	}
	@RequestMapping(value="orgTree.do")
	@ResponseBody
	public Object getOrgTree() {
		//获取全部菜单数据
		Query query=new Query();
		List<Org> orgList=service.find(query, Org.class);
		List<Tree> treeList=new ArrayList<Tree>();
		for(Org o:orgList){
			Tree node=new Tree();
			node.setId(o.getId());
			node.setText(o.getCnName());
			node.setParentId(o.getParentId());
			if(o.getType()==1){
				node.setIconCls("icon_menu_59");
			}else{
				node.setIconCls("icon_menu_60");
			}
			treeList.add(node);
		}
		//构造树形菜单的根节点
		Tree root=new Tree();
		root.setId(Constants.TREE_ROOT_ID);
		//生成菜单树
		Tree tree=TreeUtil.getExtTree(root, treeList);
		return tree;
	}
	
	@RequestMapping(value="orgList.do")
	@ResponseBody
	public Object getOrgList(String parentId,String param,ExtPager pager) {
		Query query=new Query();
		if(StringUtils.isNotEmpty(parentId)&&!Constants.TREE_ROOT_ID.equals(parentId)){
			Criteria crit1 = Criteria.where("parentId").is(parentId);
			Criteria crit2 = Criteria.where("id").is(new ObjectId(parentId));
			query.addCriteria(new Criteria().orOperator(crit1,crit2));
		}
		if(StringUtils.isNotEmpty(param)){
			Criteria crit1 = Criteria.where("cnName").regex(".*?"+param+".*");
			Criteria crit2 = Criteria.where("enName").regex(".*?"+param+".*");
			Criteria crit3 = Criteria.where("code").regex(".*?"+param+".*");
			query.addCriteria(new Criteria().orOperator(crit1,crit2,crit3));
		}
		Long totalNum=service.count(query, Org.class);
		if (pager.getLimit()!=null&&pager.getStart() != null) {
			query.skip(pager.getStart()).limit(pager.getLimit());
		}
		if (StringUtils.isNotBlank(pager.getSort())) {
			Sort[] sorts=JackJsonUtil.fromJsonToObject(pager.getSort(), Sort[].class);
			for(Sort s:sorts){
				query.sort().on(s.getProperty(),"DESC".equals(s.getDirection())?Order.DESCENDING:Order.ASCENDING);
			}
		}
		List<Org> rows=service.find(query, Org.class);
		return new ExtGridReturn(totalNum,rows);
	}
	
	@RequestMapping(value="saveOrg.do")
	@ResponseBody
	public Object saveOrg(Org org){
		if(StringUtils.isBlank(org.getId())){
			org.setId(null);
			org.setCreateTime(new Date());
		}
		service.save(org);
		return new ExtReturn(true,this.getMessage("common.doSuccess"));
	}
	
	@RequestMapping(value="deleteOrgs.do")
	@ResponseBody
	public Object deleteOrgs(@RequestParam(required = true) String[] ids){
		Query query=new Query(Criteria.where("id").in(Arrays.asList(ids)));
		service.remove(query, Org.class);
		return new ExtReturn(true,this.getMessage("common.doSuccess"));
	}
}
