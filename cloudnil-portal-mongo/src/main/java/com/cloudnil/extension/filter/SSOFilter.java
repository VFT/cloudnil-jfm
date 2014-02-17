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

import com.cloudnil.extension.common.PortalConstants;
import com.cloudnil.framework.utils.common.SpringContextHolder;
import com.cloudnil.portal.login.service.LoginService;
import com.cloudnil.portal.user.model.User;
/**
 * <p>ClassName: SSOFilter</p>
 * <p>Description: 单点登陆Filter，从单点信息中获取用户名并加载信息</p>
 * @author 史绍虎
 * <p>Date: 2012-6-26 下午3:11:00</p>
 */
public class SSOFilter implements Filter {
	public void destroy() {
	}
	public void doFilter(ServletRequest req, ServletResponse res,FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request=(HttpServletRequest)req;
		HttpServletResponse response=(HttpServletResponse)res;
//		_const_cas_assertion_是CAS中存放登录用户名的session标志
//		Object object = request.getSession().getAttribute(AbstractCasFilter.CONST_CAS_ASSERTION);
//		Assertion assertion = (Assertion) object;
//		String loginName = assertion.getPrincipal().getName();
		String userName=request.getRemoteUser();
		if (userName != null) {
			if(request.getSession().getAttribute(PortalConstants.CURRENT_USER)==null){
				LoginService service=SpringContextHolder.getBean("loginService");
				User user=service.loadUserByUserName(userName);
				request.getSession().setAttribute(PortalConstants.CURRENT_USER, user);
			}
		}
		chain.doFilter(request, response);
	}
	
	public void init(FilterConfig fConfig) throws ServletException {
	}

}