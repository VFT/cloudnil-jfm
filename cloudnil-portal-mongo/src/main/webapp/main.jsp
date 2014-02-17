<%@page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html>
<head>
<%@ include file="/WEB-INF/jsp/common/header.jsp"%>
<title><spring:message code="common.title"/></title>
<!-- 
<script type="text/javascript" src="all-classes.js"></script> -->
<script type="text/javascript" src="${ctx}/resources/app/app.js"></script>
<script type="text/javascript">
var userName='${sessionScope.CURRENT_USER.cnName}';
window.onbeforeunload = onbeforeunload_handler;
function onbeforeunload_handler(){
	//IE
	if(navigator.userAgent.indexOf("MSIE")>0){
		if((document.body.clientWidth-event.clientX<21)||(event.clientY>document.body.clientHeight)||event.altKey||event.ctrlKey||event.clientX<20)     
		{     
			Share.AjaxRequest({
		    	url: ctx + '/loginout.do'
		    }); 
		}
	}
	//Firefox
	if(navigator.userAgent.indexOf("Firefox")>0){
		//Firefox无法区别关闭与刷新
	}
	//chrome
	if(navigator.userAgent.indexOf("Chrome")>0){
		Share.AjaxRequest({
	    	url: ctx + '/loginout.do'
	    });
	}
}
</script>
</head>
<body>
<div id="wait-div" style="width:50px;height:50px;display: none;text-align:center; position:absolute;top:50%;left:50%;margin:-25px 0 0 -25px;"><img src="${ctx}/resources/images/loading.gif"/></div>
</body>
</html>