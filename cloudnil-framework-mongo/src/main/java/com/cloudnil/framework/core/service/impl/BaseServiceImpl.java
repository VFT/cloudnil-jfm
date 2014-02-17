package com.cloudnil.framework.core.service.impl;

import java.util.Collection;
import java.util.List;

import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.mapreduce.GroupBy;
import org.springframework.data.mongodb.core.mapreduce.GroupByResults;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.mongodb.CommandResult;
import com.mongodb.DBObject;
import com.mongodb.WriteResult;
import com.cloudnil.framework.core.dao.BaseDao;
import com.cloudnil.framework.core.service.BaseService;
import com.cloudnil.framework.utils.exception.ServiceException;
/**
 * <p>ClassName: BaseServiceImpl</p>
 * <p>Description: Core Bundle Service层基础实现类</p>
 * @author 史绍虎
 * <p>Date: 2012-9-13 下午3:32:28</p>
 */
public abstract class BaseServiceImpl implements BaseService {

	protected abstract BaseDao getBaseDao();

	public <T> boolean collectionExists(Class<T> entityClass) throws ServiceException{
		return getBaseDao().collectionExists(entityClass);
	}

	public boolean collectionExists(String collectionName) throws ServiceException{
		return getBaseDao().collectionExists(collectionName);
	}

	public long count(Query query, Class<?> entityClass) throws ServiceException{
		return getBaseDao().count(query, entityClass);
	}

	public long count(Query query, String collectionName) throws ServiceException{
		return getBaseDao().count(query, collectionName);
	}

	public CommandResult executeCommand(DBObject command) throws ServiceException{
		return getBaseDao().executeCommand(command);
	}

	public CommandResult executeCommand(DBObject command,int options) throws ServiceException{
		return getBaseDao().executeCommand(command, options);
	}

	public <T> List<T> find(Query query, Class<T> entityClass) throws ServiceException{
		return getBaseDao().find(query, entityClass);
	}

	public <T> List<T> find(Query query, Class<T> entityClass,String collectionName) throws ServiceException{
		return getBaseDao().find(query, entityClass, collectionName);
	}

	public <T> List<T> findAll(Class<T> entityClass) throws ServiceException{
		return getBaseDao().findAll(entityClass);
	}

	public <T> List<T> findAll(Class<T> entityClass,String collectionName) throws ServiceException{
		return getBaseDao().findAll(entityClass, collectionName);
	}

	public <T> T findAndModify(Query query, Update update, Class<T> entityClass) throws ServiceException{
		return getBaseDao().findAndModify(query, update, entityClass);
	}

	public <T> T findAndModify(Query query, Update update, Class<T> entityClass,String collectionName) throws ServiceException{
		return getBaseDao().findAndModify(query, update, entityClass, collectionName);
	}

	public <T> T findAndModify(Query query, Update update,FindAndModifyOptions options, Class<T> entityClass) throws ServiceException{
		return getBaseDao().findAndModify(query, update, options, entityClass);
	}

	public <T> T findAndModify(Query query, Update update,FindAndModifyOptions options, Class<T> entityClass,String collectionName) throws ServiceException{
		return getBaseDao().findAndModify(query, update, options, entityClass, collectionName);
	}

	public <T> T findAndRemove(Query query,Class<T> entityClass) throws ServiceException{
		return getBaseDao().findAndRemove(query, entityClass);
	}

	public <T> T findAndRemove(Query query,Class<T> entityClass,String collectionName) throws ServiceException{
		return getBaseDao().findAndRemove(query, entityClass, collectionName);
	}

	public <T> T findById(Object id,Class<T> entityClass) throws ServiceException{
		return getBaseDao().findById(id, entityClass);
	}

	public <T> T findById(Object id,Class<T> entityClass,String collectionName) throws ServiceException{
		return getBaseDao().findById(id, entityClass, collectionName);
	}

	public <T> T findOne(Query query,Class<T> entityClass) throws ServiceException{
		return getBaseDao().findOne(query, entityClass);
	}

	public <T> T findOne(Query query,Class<T> entityClass,String collectionName) throws ServiceException{
		return getBaseDao().findOne(query, entityClass, collectionName);
	}

	public <T> GroupByResults<T> group(String inputCollectionName, GroupBy groupBy, Class<T> entityClass) throws ServiceException{
		return getBaseDao().group(inputCollectionName, groupBy, entityClass);
	}

	public <T> GroupByResults<T> group(Criteria criteria, String inputCollectionName, GroupBy groupBy, Class<T> entityClass) throws ServiceException{
		return getBaseDao().group(criteria, inputCollectionName, groupBy, entityClass);
	}
	
	public <T> boolean insert(Collection<T> collection,String collectionName) throws ServiceException{
		return getBaseDao().insert(collection, collectionName);
	}
	
	public <T> boolean insert(Collection<T> collection,Class<T> entityClass) throws ServiceException{
		return getBaseDao().insert(collection, entityClass);
	}
	
	public <T> boolean insert(Collection<T> collection) throws ServiceException{
		return getBaseDao().insert(collection);
	}

	public boolean remove(Object object) throws ServiceException{
		return getBaseDao().remove(object);
	}

	public boolean remove(Query query,String collectionName) throws ServiceException{
		return getBaseDao().remove(query, collectionName);
	}

	public <T> boolean remove(Query query,Class<T> entityClass) throws ServiceException{
		return getBaseDao().remove(query, entityClass);
	}

	public boolean save(Object object) throws ServiceException{
		return getBaseDao().save(object);
	}

	public boolean save(Object object,String collectionName) throws ServiceException{
		return getBaseDao().save(object, collectionName);
	}

	public <T> WriteResult update(Query query,Update update,Class<T> entityClass) throws ServiceException{
		return getBaseDao().update(query, update, entityClass);
	}

	public WriteResult update(Query query,Update update,String collectionName) throws ServiceException{
		return getBaseDao().update(query, update, collectionName);
	}
}
