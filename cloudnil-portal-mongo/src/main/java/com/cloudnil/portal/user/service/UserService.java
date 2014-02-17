package com.cloudnil.portal.user.service;

import com.mongodb.DB;
import com.cloudnil.framework.core.service.BaseService;
/**
 * <p>ClassName: UserService</p>
 * <p>Description: 用户模块Service层接口类</p>
 * @author 史绍虎
 * <p>Date: 2012-10-25 下午2:08:52</p>
 */
public interface UserService extends BaseService {
	public DB getDB();
}
