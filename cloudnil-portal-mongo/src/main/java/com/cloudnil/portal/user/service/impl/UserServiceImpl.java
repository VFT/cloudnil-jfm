package com.cloudnil.portal.user.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mongodb.DB;
import com.cloudnil.framework.core.dao.BaseDao;
import com.cloudnil.framework.core.service.impl.BaseServiceImpl;
import com.cloudnil.portal.user.dao.UserDao;
import com.cloudnil.portal.user.service.UserService;
/**
 * <p>ClassName: UserServiceImpl</p>
 * <p>Description: 用户模块Dao层实现类</p>
 * @author 史绍虎
 * <p>Date: 2012-10-25 下午2:09:47</p>
 */
@Service("userService")
public class UserServiceImpl extends BaseServiceImpl implements UserService {
	@Autowired
	private UserDao dao;
	@Override
	protected BaseDao getBaseDao() {
		return dao;
	}
	
	public DB getDB(){
		return dao.getDb();
	}
}
