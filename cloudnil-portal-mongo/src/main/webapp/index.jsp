<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<script type="text/javascript">
var ctx='${ctx}';
</script>
<script type="text/javascript" src="${ctx}/resources/ext/share.js"></script>
<script type="text/javascript" src="${ctx}/resources/ext/ext-all.js"></script>
<script type="text/javascript" src="${ctx}/resources/ext/ext-lang-zh_CN.js"></script>
<script type="text/javascript" src="${ctx}/resources/js/login.js"></script>
<link rel="stylesheet" type="text/css" href="${ctx}/resources/ext/resources/css/ext-all.css" />
<title><spring:message code="common.title"/></title>
</head>
<body>
	<div id="backGround" style="width:804px;height:504px;position:absolute;top:50%;left:50%;margin:-252px 0 0 -402px;background-image: url('login.png');">
		<div id="login-win-div" style="width:300px;height:100px;position:absolute;top:50%;left:50%;margin:20px 0 0 -150px;"></div>
		<div id="wait-div" style="width:50px;height:50px;display: none;text-align:center; position:absolute;top:50%;left:50%;margin:-25px 0 0 -25px;"><img src="${ctx}/resources/images/loading.gif"/></div>
	</div>
</body>
</html>
