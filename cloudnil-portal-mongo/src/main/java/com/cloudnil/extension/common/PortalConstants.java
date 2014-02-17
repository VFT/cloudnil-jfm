package com.cloudnil.extension.common;

/**
 * <p>ClassName: PortalConstants</p>
 * <p>Description: 系统级常量类</p>
 * @author 史绍虎
 * <p>Date: 2012-6-26 下午3:13:05</p>
 */
public class PortalConstants {
	/**
	 * Session中保存当前登录用户的key
	 */
	public static final String CURRENT_USER = "CURRENT_USER";
	/**
	 * 是否为开发模式，该模式下，菜单权限全部开放
	 */
	public static final boolean IS_DEVELOPING = true;
	/**
	 * 不进行拦截的请求，可为任意文件或者Controller
	 */
	public static final String[] UN_CATCH_FILE={"/login.do","/index.jsp","/error.jsp","/findAttributeByType.do","/findAttributeValueById.do","/saveNode.do"};
	/**
	 * 不做访问权限控制的文件或者Controller
	 */
	public static final String[] OPEN_RIGHT_FILE={"/main.jsp","/loginout.do","/loginout","/apps.do","/menu.do"};
	/**
	 * 不进行拦截的后缀
	 */
	public static final String[] UN_CATCH_SUFFIX={".js",".gif",".jpg",".css",".png"};
	/**
	 * MD5加密私钥盐值
	 */
	public static final String MD5_SALT_KEY="VF";
	
}
