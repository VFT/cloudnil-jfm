<%@page import="com.cloudnil.framework.utils.common.Constants"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<%@ include file="/WEB-INF/jsp/common/header.jsp"%>
<script type="text/javascript">
var msg='<%=request.getAttribute(Constants.ACCESS_FAILED_MSG)%>';
Ext.onReady(function(){
	Ext.Msg.show({
	     title:'温馨提示',
	     msg: msg=='null'?'请求访问的资源无效或错误，拒绝访问！':msg,
	     buttons: Ext.Msg.YES,
	     fn: sendRedirect,
	     buttonText:{yes:'确认'},
	     icon: Ext.window.MessageBox.QUESTION
	});
	
	function sendRedirect (){
		if(msg!='null'){
			location.href=ctx+"/index.jsp";
		}
	}

	});
</script>
<title><spring:message code="common.accessError"/></title>
</head>
<body style="text-align: center;">
</body>
</html>
