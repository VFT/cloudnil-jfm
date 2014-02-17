package com.cloudnil.extension.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.ArrayUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cloudnil.extension.common.ApplicationContext;
import com.cloudnil.extension.common.PortalConstants;
import com.cloudnil.framework.utils.common.Constants;
import com.cloudnil.portal.menu.model.Menu;
import com.cloudnil.portal.user.model.User;
/**
 * <p>ClassName: SecurityFilter</p>
 * <p>Description: Filter方式请求拦截,做用户登陆校验</p>
 * @author 史绍虎
 * <p>Date: 2012-6-7 下午4:46:07</p>
 */
public class SecurityFilter implements Filter {
	private final static Logger log=LoggerFactory.getLogger(SecurityFilter.class); 
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request=(HttpServletRequest)req;
		HttpServletResponse response=(HttpServletResponse)res;
		String servletPath=request.getServletPath();
		log.info("请求信息：地址【"+servletPath+"】||当前登陆用户数："+ApplicationContext.Login_User_Map.size());
		if(ArrayUtils.contains(PortalConstants.UN_CATCH_FILE, servletPath)){
			if("/index.jsp".equals(servletPath)&&request.getSession().getAttribute(PortalConstants.CURRENT_USER)!=null){
				request.getRequestDispatcher("/main.jsp").forward(request, response);
			}
			chain.doFilter(req, res);
		}else{
			if(request.getSession().getAttribute(PortalConstants.CURRENT_USER)==null){
				log.info("尚未登陆，跳转到登陆界面！");
				request.setAttribute(Constants.ACCESS_FAILED_MSG, "尚未登陆，拒绝访问！");
				request.getRequestDispatcher("/error.jsp").forward(request, response);
			}else{
				User user=(User)request.getSession().getAttribute(PortalConstants.CURRENT_USER);
				/**
				 * 标记访问权限
				 */
				boolean accessAuthority=PortalConstants.IS_DEVELOPING?true:false;
				/**
				 * 校验请求是否来自ajax，如果是（值为：XMLHttpRequest），则通过过滤
				 */
				if(!accessAuthority){
					String requestedWith = request.getHeader("x-requested-with");
					accessAuthority=(requestedWith != null && "XMLHttpRequest".equals(requestedWith))?true:false;
				}
				/**
				 * 校验请求是否在权限访问例外配置之中
				 */
				if(!accessAuthority){
					accessAuthority=ArrayUtils.contains(PortalConstants.OPEN_RIGHT_FILE, servletPath)?true:false;
				}
				/**
				 * 校验请求地址是否是当前用户的权限范围
				 */
				if(!accessAuthority){
					for(Menu m:user.getMenuList()){
						if(servletPath.equals(m.getUrl())){
							accessAuthority=true;
							break;
						}
					}
				}
				if(accessAuthority){
					chain.doFilter(req, res);
				}else{
					request.setAttribute(Constants.ACCESS_FAILED_MSG, "权限不足，拒绝访问！");
					request.getRequestDispatcher("/error.jsp").forward(request, response);
				}
			}
		}
	}
	public void destroy() {
		
	}

}
