package org.jasig.cas.util;

import org.apache.commons.lang.StringUtils;
import org.jasig.cas.authentication.handler.PasswordEncoder;
import org.springframework.security.authentication.encoding.MessageDigestPasswordEncoder;
/**
 * 
 * <p>ClassName: VenuPasswordEncoder</p>
 * <p>Description: 加密算法类，支持MD5，SHA等加密算法</p>
 * @author 史绍虎
 * <p>Date: 2012-6-27 下午3:29:47</p>
 */
public class VenuPasswordEncoder extends MessageDigestPasswordEncoder implements PasswordEncoder {

	private final String salt;
	public VenuPasswordEncoder(String algorithm,String salt) {
		this(algorithm,salt,false);
	}
	public VenuPasswordEncoder(String algorithm,String salt,boolean encodeHashAsBase64) {
		super(algorithm, encodeHashAsBase64);
		this.salt=salt;
	}
	
	public String encode(String password) {
		if(StringUtils.isNotEmpty(password)){
			return encodePassword(password, salt);
		}
		return password;
	}

}
