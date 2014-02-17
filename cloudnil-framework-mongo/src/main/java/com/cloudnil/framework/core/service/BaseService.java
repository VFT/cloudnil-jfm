package com.cloudnil.framework.core.service;

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
import com.cloudnil.framework.utils.exception.ServiceException;
/**
 * <p>ClassName: BaseService</p>
 * <p>Description: Core Bundle Service层基础实现类</p>
 * @author 史绍虎
 * <p>Date: 2012-5-16 下午7:44:06</p>
 */
public interface BaseService {
	
	public <T> boolean collectionExists(Class<T> entityClass) throws ServiceException;
	
	public boolean collectionExists(String collectionName) throws ServiceException;
	
	public long count(Query query, Class<?> entityClass) throws ServiceException;
	
	public long count(Query query, String collectionName) throws ServiceException;
	
	public CommandResult executeCommand(DBObject command) throws ServiceException;
	
	public CommandResult executeCommand(DBObject command,int options) throws ServiceException;
	
	public <T> List<T> find(Query query, Class<T> entityClass) throws ServiceException;
	
	public <T> List<T> find(Query query, Class<T> entityClass,String collectionName) throws ServiceException;
	
	public <T> List<T> findAll(Class<T> entityClass) throws ServiceException;
	
	public <T> List<T> findAll(Class<T> entityClass,String collectionName) throws ServiceException;
	
	public <T> T findAndModify(Query query, Update update, Class<T> entityClass) throws ServiceException;
	
	public <T> T findAndModify(Query query, Update update, Class<T> entityClass,String collectionName) throws ServiceException;
	
	public <T> T findAndModify(Query query, Update update,FindAndModifyOptions options, Class<T> entityClass) throws ServiceException;
	
	public <T> T findAndModify(Query query, Update update,FindAndModifyOptions options, Class<T> entityClass,String collectionName) throws ServiceException;
	
	public <T> T findAndRemove(Query query,Class<T> entityClass) throws ServiceException;
	
	public <T> T findAndRemove(Query query,Class<T> entityClass,String collectionName) throws ServiceException;
	
	public <T> T findById(Object id,Class<T> entityClass) throws ServiceException;
	
	public <T> T findById(Object id,Class<T> entityClass,String collectionName) throws ServiceException;
	
	public <T> T findOne(Query query,Class<T> entityClass) throws ServiceException;
	
	public <T> T findOne(Query query,Class<T> entityClass,String collectionName) throws ServiceException;
	
	public <T> GroupByResults<T> group(String inputCollectionName, GroupBy groupBy, Class<T> entityClass) throws ServiceException;
	
	public <T> GroupByResults<T> group(Criteria criteria, String inputCollectionName, GroupBy groupBy, Class<T> entityClass) throws ServiceException;
	
	public <T> boolean insert(Collection<T> collection,String collectionName) throws ServiceException;
	
	public <T> boolean insert(Collection<T> collection,Class<T> entityClass) throws ServiceException;
	
	public <T> boolean insert(Collection<T> collection) throws ServiceException;
	
	public boolean remove(Object object) throws ServiceException;
	
	public boolean remove(Query query,String collectionName) throws ServiceException;
	
	public <T> boolean remove(Query query,Class<T> entityClass) throws ServiceException;
	
	public boolean save(Object object) throws ServiceException;
	
	public boolean save(Object object,String collectionName) throws ServiceException;
	
	public <T> WriteResult update(Query query,Update update,Class<T> entityClass) throws ServiceException;
	
	public WriteResult update(Query query,Update update,String collectionName) throws ServiceException;
}
