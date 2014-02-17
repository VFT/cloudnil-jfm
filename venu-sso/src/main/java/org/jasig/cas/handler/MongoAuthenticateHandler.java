package org.jasig.cas.handler;

import java.net.UnknownHostException;

import javax.validation.constraints.NotNull;

import org.jasig.cas.authentication.handler.AuthenticationException;
import org.jasig.cas.authentication.handler.support.AbstractUsernamePasswordAuthenticationHandler;
import org.jasig.cas.authentication.principal.UsernamePasswordCredentials;
import org.springframework.dao.IncorrectResultSizeDataAccessException;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.MongoException;
/**
 * <p>ClassName: MongoAuthenticateHandler</p>
 * <p>Description: 使用Mongo数据库进行用户登陆认证的实现类</p>
 * @author 史绍虎
 * <p>Date: 2012-10-10 下午3:48:58</p>
 */
public class MongoAuthenticateHandler extends AbstractUsernamePasswordAuthenticationHandler {
	@NotNull
	private String mongoHost;
	@NotNull
	private int mongoPort;
	@NotNull
	private String dbName;
	@NotNull
	private String dbUser;
	@NotNull
	private String dbPasd;
	@NotNull
	private String collectionName;
	@NotNull
	private String userNameColumn;
	@NotNull
	private String passwordColumn;

	protected final boolean authenticateUsernamePasswordInternal(final UsernamePasswordCredentials credentials) throws AuthenticationException {
        final String username = getPrincipalNameTransformer().transform(credentials.getUsername());
        final String password = credentials.getPassword();
        final String encryptedPassword = this.getPasswordEncoder().encode(password);
        
        try {
        	Mongo m;
        	long count=0;
			try {
				m = new Mongo(mongoHost, mongoPort);
				DB db = m.getDB(dbName);
				if(db.authenticate(dbUser, dbPasd.toCharArray())){
					DBCollection coll = db.getCollection(collectionName);
					DBObject query=new BasicDBObject();
					query.put(userNameColumn, username);
					query.put(passwordColumn, encryptedPassword);
					count=coll.count(query);
				}else{
					return false;
				}
			} catch (UnknownHostException e) {
				e.printStackTrace();
			} catch (MongoException e) {
				e.printStackTrace();
			}
        	return count>0;
        } catch (final IncorrectResultSizeDataAccessException e) {
            return false;
        }
    }

	public void setMongoHost(String mongoHost) {
		this.mongoHost = mongoHost;
	}

	public void setMongoPort(int mongoPort) {
		this.mongoPort = mongoPort;
	}

	public void setDbName(String dbName) {
		this.dbName = dbName;
	}

	public void setCollectionName(String collectionName) {
		this.collectionName = collectionName;
	}

	public void setUserNameColumn(String userNameColumn) {
		this.userNameColumn = userNameColumn;
	}

	public void setPasswordColumn(String passwordColumn) {
		this.passwordColumn = passwordColumn;
	}

	public void setDbUser(String dbUser) {
		this.dbUser = dbUser;
	}

	public void setDbPasd(String dbPasd) {
		this.dbPasd = dbPasd;
	}
}
