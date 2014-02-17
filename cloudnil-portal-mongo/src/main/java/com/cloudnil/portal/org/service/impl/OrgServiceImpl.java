package com.cloudnil.portal.org.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloudnil.framework.core.dao.BaseDao;
import com.cloudnil.framework.core.service.impl.BaseServiceImpl;
import com.cloudnil.portal.org.dao.OrgDao;
import com.cloudnil.portal.org.service.OrgService;
/**
 * <p>ClassName: OrgServiceImpl</p>
 * <p>Description: 组织机构模块Dao层实现类</p>
 * @author 史绍虎
 * <p>Date: 2012-10-25 下午2:09:47</p>
 */
@Service("orgService")
public class OrgServiceImpl extends BaseServiceImpl implements OrgService {
	@Autowired
	private OrgDao dao;
	@Override
	protected BaseDao getBaseDao() {
		return dao;
	}
}
