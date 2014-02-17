package com.cloudnil.framework.core.dao.impl;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.CollectionOptions;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.mapreduce.GroupBy;
import org.springframework.data.mongodb.core.mapreduce.GroupByResults;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.mongodb.CommandResult;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.WriteResult;
import com.cloudnil.framework.core.dao.BaseDao;
import com.cloudnil.framework.utils.exception.DaoException;

/**
 * <p>ClassName: BaseDaoImpl</p>
 * <p>Description: Core Bundle Dao层基础实现类</p>
 * @author 史绍虎
 * <p>Date: 2012-5-16 下午7:42:25</p>
 * @param <T>
 */
public abstract class BaseDaoImpl implements BaseDao{
	@Autowired
    private MongoTemplate mongoTemplate;
	@Override
	public <T> boolean collectionExists(Class<T> entityClass) throws DaoException{
		return mongoTemplate.collectionExists(entityClass);
	}
	
	public boolean collectionExists(String collectionName) throws DaoException{
		return mongoTemplate.collectionExists(collectionName);
	}
	
	public long count(Query query, Class<?> entityClass) throws DaoException{
		return mongoTemplate.count(query, entityClass);
	}
	
	public long count(Query query, String collectionName) throws DaoException{
		return mongoTemplate.count(query, collectionName);
	}
	
	public <T> DBCollection createCollection(Class<T> entityClass) throws DaoException{
		return mongoTemplate.createCollection(entityClass);
	}
	
	public DBCollection createCollection(String collectionName) throws DaoException{
		return mongoTemplate.createCollection(collectionName);
	}
	
	public <T> DBCollection createCollection(Class<T> entityClass, CollectionOptions collectionOptions) throws DaoException{
		return mongoTemplate.createCollection(entityClass, collectionOptions);
	}
	
	public DBCollection createCollection(String collectionName, CollectionOptions collectionOptions) throws DaoException{
		return mongoTemplate.createCollection(collectionName, collectionOptions);
	}
	
	public <T> boolean dropCollection(Class<T> entityClass) throws DaoException{
		mongoTemplate.dropCollection(entityClass);
		return true;
	}
	
	public boolean dropCollection(String collectionName) throws DaoException{
		mongoTemplate.dropCollection(collectionName);
		return true;
	}
	
	public CommandResult executeCommand(DBObject command) throws DaoException{
		return mongoTemplate.executeCommand(command);
	}
	
	public CommandResult executeCommand(DBObject command,int options) throws DaoException{
		return mongoTemplate.executeCommand(command,options);
	}
	
	public <T> List<T> find(Query query, Class<T> entityClass) throws DaoException{
		return mongoTemplate.find(query, entityClass);
	}
	
	public <T> List<T> find(Query query, Class<T> entityClass,String collectionName) throws DaoException{
		return mongoTemplate.find(query, entityClass,collectionName);
	}
	
	public <T> List<T> findAll(Class<T> entityClass) throws DaoException{
		return mongoTemplate.findAll(entityClass);
	}
	
	public <T> List<T> findAll(Class<T> entityClass,String collectionName) throws DaoException{
		return mongoTemplate.findAll(entityClass, collectionName);
	}
	
	public <T> T findAndModify(Query query, Update update, Class<T> entityClass) throws DaoException{
		return mongoTemplate.findAndModify(query, update, entityClass);
	}
	
	public <T> T findAndModify(Query query, Update update, Class<T> entityClass,String collectionName) throws DaoException{
		return mongoTemplate.findAndModify(query, update, entityClass,collectionName);
	}
	
	public <T> T findAndModify(Query query, Update update,FindAndModifyOptions options, Class<T> entityClass) throws DaoException{
		return mongoTemplate.findAndModify(query, update, options, entityClass);
	}
	
	public <T> T findAndModify(Query query, Update update,FindAndModifyOptions options, Class<T> entityClass,String collectionName) throws DaoException{
		return mongoTemplate.findAndModify(query, update, options, entityClass,collectionName);
	}
	
	public <T> T findAndRemove(Query query,Class<T> entityClass) throws DaoException{
		return mongoTemplate.findAndRemove(query, entityClass);
	}
	
	public <T> T findAndRemove(Query query,Class<T> entityClass,String collectionName) throws DaoException{
		return mongoTemplate.findAndRemove(query, entityClass,collectionName);
	}
	
	public <T> T findById(Object id,Class<T> entityClass) throws DaoException{
		return mongoTemplate.findById(id, entityClass);
	}
	
	public <T> T findById(Object id,Class<T> entityClass,String collectionName) throws DaoException{
		return mongoTemplate.findById(id, entityClass,collectionName);
	}
	
	public <T> T findOne(Query query,Class<T> entityClass) throws DaoException{
		return mongoTemplate.findOne(query, entityClass);
	}
	
	public <T> T findOne(Query query,Class<T> entityClass,String collectionName) throws DaoException{
		return mongoTemplate.findOne(query, entityClass,collectionName);
	}
	
	public DBCollection getCollection(String collectionName) throws DaoException{
		return mongoTemplate.getCollection(collectionName);
	}
	
	public <T> String getCollectionName(Class<T> entityClass) throws DaoException{
		return mongoTemplate.getCollectionName(entityClass);
	}
	
	public Set<String> getCollectionNames() throws DaoException{
		return mongoTemplate.getCollectionNames();
	}
	
	public DB getDb() throws DaoException{
		return mongoTemplate.getDb();
	}
	
	public <T> GroupByResults<T> group(String inputCollectionName, GroupBy groupBy, Class<T> entityClass) throws DaoException{
		return mongoTemplate.group(inputCollectionName, groupBy, entityClass);
	}
	
	public <T> GroupByResults<T> group(Criteria criteria, String inputCollectionName, GroupBy groupBy, Class<T> entityClass) throws DaoException{
		return mongoTemplate.group(criteria, inputCollectionName, groupBy, entityClass);
	}
	
	public boolean insert(Object object) throws DaoException{
		mongoTemplate.insert(object);
		return true;
	}
	
	public boolean insert(Object object,String collectionName) throws DaoException{
		mongoTemplate.insert(object, collectionName);
		return true;
	}
	
	public <T> boolean insert(Collection<T> collection,String collectionName) throws DaoException{
		mongoTemplate.insert(collection, collectionName);
		return true;
	}
	
	public <T> boolean insert(Collection<T> collection,Class<T> entityClass) throws DaoException{
		mongoTemplate.insert(collection, entityClass);
		return true;
	}
	
	public <T> boolean insert(Collection<T> collection) throws DaoException{
		mongoTemplate.insertAll(collection);
		return true;
	}
	
	public boolean remove(Object object) throws DaoException{
		mongoTemplate.remove(object);
		return true;
	}
	
	public boolean remove(Query query,String collectionName) throws DaoException{
		mongoTemplate.remove(query, collectionName);
		return true;
	}
	
	public <T> boolean remove(Query query,Class<T> entityClass) throws DaoException{
		mongoTemplate.remove(query, entityClass);
		return true;
	}
	
	public boolean save(Object object) throws DaoException{
		mongoTemplate.save(object);
		return true;
	}
	
	public boolean save(Object object,String collectionName) throws DaoException{
		mongoTemplate.save(object, collectionName);
		return true;
	}
	
	public <T> WriteResult update(Query query,Update update,Class<T> entityClass) throws DaoException{
		return mongoTemplate.updateMulti(query, update, entityClass);
	}
	
	public WriteResult update(Query query,Update update,String collectionName) throws DaoException{
		return mongoTemplate.updateMulti(query, update, collectionName);
	}
}
