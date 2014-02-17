package com.cloudnil.framework.core.model;

import java.util.ArrayList;
import java.util.List;

import com.cloudnil.framework.utils.common.Constants;
/**
 * <p>ClassName: TreeUtil</p>
 * <p>Description: Ext JSON树形菜单构造工具类</p>
 * @author 史绍虎
 * <p>Date: 2012-6-13 下午5:50:06</p>
 */
public class TreeUtil{
	/**
	 * <p>MethodName: getExtTree</p>
	 * <p>Description: 递归构造树对象Tree</p>
	 * @param <T>
	 * @param <T>
	 * @param node 根节点Menu对象
	 * @param menuList 全部权限菜单
	 * @return T
	 */
	public static <T extends Tree> T getExtTree(T node, List<T> list){
		List<T> childList = getChildList(node, list);
		T tree=node;
		//根据节点属性还是根据节点是否有下级节点设置是否展现为叶子
		tree.setLeaf(childList.size()>0?false:true);
		tree.setUrl(node.getUrl()==null?"":node.getUrl().trim());
		if (list == null||list.size()==0) {
			return tree;
		}
		if (childList.size()>0) {
			List<T> lt = new ArrayList<T>();
			for(T m:childList){
				lt.add(TreeUtil.getExtTree(m, list));
			}
			tree.setChildren(lt);
		}
		return tree;
	}
	/**
	 * <p>MethodName: getChildList</p>
	 * <p>Description: 获取当前节点的子节点</p>
	 * @param <T>
	 * @param <T>
	 * @param node 当前节点对象MENU
	 * @param list 所有MENU对象集合
	 * @return 当前节点Menu的所有子节点
	 */
	protected static <T extends Tree> List<T> getChildList(T node, List<T> list) {
		List<T> li = new ArrayList<T>();
		for(T m:list){
			if(Constants.TREE_ROOT_ID.equals(m.getParentId())){
				if(Constants.TREE_ROOT_ID.equals(node.getId())){
					li.add(m);
				}
			}else{
				if((!Constants.TREE_ROOT_ID.equals(node.getId()))&&node.getId().equals(m.getParentId())){
					li.add(m);
				}
			}
		}
		return li;
	}
}
