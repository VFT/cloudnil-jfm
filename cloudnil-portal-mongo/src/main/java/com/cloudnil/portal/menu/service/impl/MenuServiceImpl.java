package com.cloudnil.portal.menu.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloudnil.framework.core.dao.BaseDao;
import com.cloudnil.framework.core.service.impl.BaseServiceImpl;
import com.cloudnil.portal.login.dao.LoginDao;
import com.cloudnil.portal.menu.service.MenuService;
/**
 * <p>ClassName: MenuDaoImpl</p>
 * <p>Description: 菜单资源模块Dao层实现类</p>
 * @author 史绍虎
 * <p>Date: 2012-10-25 下午2:09:47</p>
 */
@Service("menuService")
public class MenuServiceImpl extends BaseServiceImpl implements MenuService {
	@Autowired
	private LoginDao dao;
	@Override
	protected BaseDao getBaseDao() {
		return dao;
	}
}
