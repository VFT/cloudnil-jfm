package com.cloudnil.framework.utils.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.IOException;
import java.text.SimpleDateFormat;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
/**
 * <p>ClassName: JackJsonUtil</p>
 * <p>Description: Json字符串与Java对象互转工具类</p>
 * @author 史绍虎
 * <p>Date: 2012-6-25 上午10:11:28</p>
 */
public class JackJsonUtil {
	private static final Logger logger = LoggerFactory.getLogger(JackJsonUtil.class);
	/** 格式化时间的string */
	private static final String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
	/**
	 * <p>MethodName: fromJsonToObject</p>
	 * <p>Description: (这里用一句话描述这个方法的作用)</p>
	 * @param json json数据字符串
	 * @param valueType 返回数据类型
	 * @return Object
	 * 例子：
	 * 返回User对象：User user=JackJsonUtil.fromJsonToObject(jsonStr,User.class);
	 * 返回User对象数组：User[] users=JackJsonUtil.fromJsonToObject(jsonStr,User[].class);
	 */
	public static <T> T fromJsonToObject(String json, Class<T> valueType) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.readValue(json, valueType);
		} catch (JsonParseException e) {
			logger.error("JsonParseException: ", e);
		} catch (JsonMappingException e) {
			logger.error("JsonMappingException: ", e);
		} catch (IOException e) {
			logger.error("IOException: ", e);
		}
		return null;
	}
	/**
	 * <p>MethodName: fromObjectToJson</p>
	 * <p>Description: 将对象转换为Json对象字符串</p>
	 * @param object 需要转换的对象
	 * @return JSON字符串
	 */
	public static String fromObjectToJson(Object object) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.writeValueAsString(object);
		} catch (JsonGenerationException e) {
			logger.error("JsonGenerationException: ", e);
		} catch (JsonMappingException e) {
			logger.error("JsonMappingException: ", e);
		} catch (IOException e) {
			logger.error("IOException: ", e);
		}
		return null;
	}
	/**
	 * <p>MethodName: fromObjectHasDateToJson</p>
	 * <p>Description: 将对象转换为Json对象字符串,包含日期类型的时候使用</p>
	 * @param object 需要转换的对象
	 * @return JSON字符串
	 */
	public static String fromObjectHasDateToJson(Object object) {
		ObjectMapper mapper = new ObjectMapper();
		mapper.getSerializationConfig().withDateFormat(new SimpleDateFormat(DATE_TIME_FORMAT));
		try {
			return mapper.writeValueAsString(object);
		} catch (JsonGenerationException e) {
			logger.error("JsonGenerationException: ", e);
		} catch (JsonMappingException e) {
			logger.error("JsonMappingException: ", e);
		} catch (IOException e) {
			logger.error("IOException: ", e);
		}
		return null;
	}
	/**
	 * <p>MethodName: fromObjectHasDateToJson</p>
	 * <p>Description: 将对象转换为Json对象字符串,包含日期类型的时候使用</p>
	 * @param object 需要转换的对象
	 * @return JSON字符串
	 */
	public static String fromObjectHasDateToJson(Object object, String dateTimeFormatString) {
		ObjectMapper mapper = new ObjectMapper();
		mapper.getSerializationConfig().withDateFormat(new SimpleDateFormat(dateTimeFormatString));
		try {
			return mapper.writeValueAsString(object);
		} catch (JsonGenerationException e) {
			logger.error("JsonGenerationException: ", e);
		} catch (JsonMappingException e) {
			logger.error("JsonMappingException: ", e);
		} catch (IOException e) {
			logger.error("IOException: ", e);
		}
		return null;
	}
}
