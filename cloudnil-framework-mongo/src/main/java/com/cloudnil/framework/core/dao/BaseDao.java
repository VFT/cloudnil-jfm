package com.cloudnil.framework.core.dao;
import java.util.Collection;
import java.util.List;

import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.mapreduce.GroupBy;
import org.springframework.data.mongodb.core.mapreduce.GroupByResults;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.mongodb.CommandResult;
import com.mongodb.DB;
import com.mongodb.DBObject;
import com.mongodb.WriteResult;
import com.cloudnil.framework.utils.exception.DaoException;
/**
 * <p>ClassName: BaseDao</p>
 * <p>Description: Core Bundle Dao层基础接口类</p>
 * @author 史绍虎
 * <p>Date: 2012-5-16 下午7:43:08</p>
 */
public interface BaseDao {
	public <T> boolean collectionExists(Class<T> entityClass)  throws DaoException;
	
	public boolean collectionExists(String collectionName) throws DaoException;
	
	public long count(Query query, Class<?> entityClass) throws DaoException;
	
	public long count(Query query, String collectionName) throws DaoException;
	
//	public <T> DBCollection createCollection(Class<T> entityClass) throws DaoException;
//	
//	public DBCollection createCollection(String collectionName) throws DaoException;
//	
//	public <T> DBCollection createCollection(Class<T> entityClass, CollectionOptions collectionOptions) throws DaoException;
//	
//	public DBCollection createCollection(String collectionName, CollectionOptions collectionOptions) throws DaoException;
//	
//	public <T> boolean dropCollection(Class<T> entityClass) throws DaoException;
//	
//	public boolean dropCollection(String collectionName) throws DaoException;
	
	public CommandResult executeCommand(DBObject command) throws DaoException;
	
	public CommandResult executeCommand(DBObject command,int options) throws DaoException;
	
	public <T> List<T> find(Query query, Class<T> entityClass) throws DaoException;
	
	public <T> List<T> find(Query query, Class<T> entityClass,String collectionName) throws DaoException;
	
	public <T> List<T> findAll(Class<T> entityClass) throws DaoException;
	
	public <T> List<T> findAll(Class<T> entityClass,String collectionName) throws DaoException;
	
	public <T> T findAndModify(Query query, Update update, Class<T> entityClass) throws DaoException;
	
	public <T> T findAndModify(Query query, Update update, Class<T> entityClass,String collectionName) throws DaoException;
	
	public <T> T findAndModify(Query query, Update update,FindAndModifyOptions options, Class<T> entityClass) throws DaoException;
	
	public <T> T findAndModify(Query query, Update update,FindAndModifyOptions options, Class<T> entityClass,String collectionName) throws DaoException;
	
	public <T> T findAndRemove(Query query,Class<T> entityClass) throws DaoException;
	
	public <T> T findAndRemove(Query query,Class<T> entityClass,String collectionName) throws DaoException;
	
	public <T> T findById(Object id,Class<T> entityClass) throws DaoException;
	
	public <T> T findById(Object id,Class<T> entityClass,String collectionName) throws DaoException;
	
	public <T> T findOne(Query query,Class<T> entityClass) throws DaoException;
	
	public <T> T findOne(Query query,Class<T> entityClass,String collectionName) throws DaoException;
	
//	public DBCollection getCollection(String collectionName) throws DaoException;
//	
//	public <T> String getCollectionName(Class<T> entityClass) throws DaoException;
//	
//	public Set<String> getCollectionNames() throws DaoException;
//	
	public DB getDb() throws DaoException;
	
	public <T> GroupByResults<T> group(String inputCollectionName, GroupBy groupBy, Class<T> entityClass) throws DaoException;
	
	public <T> GroupByResults<T> group(Criteria criteria, String inputCollectionName, GroupBy groupBy, Class<T> entityClass) throws DaoException;
	
//	public boolean insert(Object object) throws DaoException;
//	
//	public boolean insert(Object object,String collectionName) throws DaoException;
	
	public <T> boolean insert(Collection<T> collection,String collectionName) throws DaoException;
	
	public <T> boolean insert(Collection<T> collection,Class<T> entityClass) throws DaoException;
	
	public <T> boolean insert(Collection<T> collection) throws DaoException;
	
	public boolean remove(Object object) throws DaoException;
	
	public boolean remove(Query query,String collectionName) throws DaoException;
	
	public <T> boolean remove(Query query,Class<T> entityClass) throws DaoException;
	
	public boolean save(Object object) throws DaoException;
	
	public boolean save(Object object,String collectionName) throws DaoException;
	
	public <T> WriteResult update(Query query,Update update,Class<T> entityClass) throws DaoException;
	
	public WriteResult update(Query query,Update update,String collectionName) throws DaoException;
}
