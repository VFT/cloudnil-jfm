<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<script type="text/javascript">
var ctx='${ctx}';
</script>
<script type="text/javascript" src="${ctx}/resources/ext/share.js"></script>
<script type="text/javascript" src="${ctx}/resources/ext/ext-all.js"></script>
<script type="text/javascript" src="${ctx}/resources/ext/ext-lang-zh_CN.js"></script>
<link rel="stylesheet" type="text/css" href="${ctx}/resources/ext/resources/css/ext-all.css" />
<link rel="stylesheet" type="text/css" href="${ctx}/resources/css/portal.css" />
<link rel="stylesheet" type="text/css" href="${ctx}/resources/css/menu-icon.css" />
<link rel="stylesheet" type="text/css" href="${ctx}/resources/css/button-icon.css" />
<div id="wait-div" style="width:50px;height:50px;display: none;text-align:center; position:absolute;top:50%;left:50%;margin:-25px 0 0 -25px;"><img src="${ctx}/resources/images/loading.gif"/></div>

