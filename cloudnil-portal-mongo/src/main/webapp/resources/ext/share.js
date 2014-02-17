var Share = {};
Share.PAGE_SIZE = 15;
Share.REQUIRED = '<span style="color:red;font-weight:bold" data-qtip="Required">*</span>';
Share.TREE_ROOT_ID='RN';
/**
 * Ajax请求方法
 * 
 * @param {Object} 		params 参数对象，必须
 * @param {String} 		url 请求地址，必须
 * @param {Function} 	callback 成功后回调方法，必须
 * @param {Function} 	falseFun 失败后回调方法，必须
 * @param {boolean} 	showMsg 处理成功时，是否显示提示信息 true:显示 false:不显示
 * @param {boolean} 	showWaiting 是否显示等待条 true:显示 false:不显示
 * @param {Number} 		timeout 超时时间
 * @param {String} 		successMsg 成功消息，ExtReturn中的消息可以覆盖该属性
 * @param {String} 		failureMsg 失败消息
 */
Share.AjaxRequest = function(settings) {
	// 参数对象
	var params = settings.params === undefined ? {} : settings.params;
	var showWaiting = settings.showWaiting === undefined ? true: settings.showWaiting;
	var showMsg = settings.showMsg === undefined ? false: settings.showMsg;
    var timeout = settings.timeout === undefined ? 60 * 1000: settings.timeout;
	if (showWaiting) {
		Share.waiting.start();
	}
	Ext.Ajax.request({
		url : settings.url,
		params : params,
		timeout : timeout,
		//Ajax异步调用成功时进入，ExtReturn中true和false时都进入该代码
		success : function(response, options) {
			if (showWaiting) {
				Share.waiting.stop();
			}
			var extReturn = Ext.decode(response.responseText);
			if (extReturn.success == true) {
				if (showMsg == true) {
					// 请求成功时的提示文字
					var successMsg = '操作成功.';
					if (extReturn.msg && extReturn.msg != '') {
						successMsg = extReturn.msg;
					} else if (settings.successMsg && settings.successMsg != '') {
						successMsg = settings.successMsg;
					}
					Ext.Msg.alert('温馨提示', successMsg, function() {
						if (settings.callback) { // 回调方法
							settings.callback(extReturn);
						}
					});
				} else {
					if (settings.callback) { // 回调方法
						settings.callback(extReturn);
					}
				}
			} else if (extReturn.success == false) {
				var message = '发生异常.';
				if (extReturn.msg && extReturn.msg != '') { // 后台设定的业务消息
					message = extReturn.msg;
				} else if (settings.failureMsg&& settings.failureMsg != '') { // 前台指定的错误信息
					message = settings.failureMsg;
				}
				if (extReturn.exceptionMessage && extReturn.exceptionMessage != '') { // 有异常信息
					//Share.ExceptionWindow(message,extReturn.exceptionMessage);
				} else {
					Ext.Msg.alert('温馨提示', message, function() {
						if (typeof settings.falseFun == "function") {//失败后想做的个性化操作函数
							settings.falseFun(extReturn);
						}
					});
				}
			}
		},
		//Ajax异步调用失败时进入，一般是由访问错误引起
		failure : function(response, options) {
			if (showWaiting) {
				Share.waiting.stop();
			}
			//Share.ExceptionWindow('错误：' + response.status + ' '+ response.statusText, response.responseText);
		}
	});
};
/**
 * 等待进度条
 */
Share.waiting=function (){
	var waiting=Ext.Msg.wait('正在处理，请稍等...', '', '');
	return waiting;
}
/**
 * 等待图标开启
 */
Share.waiting.start=function (){
	document.getElementById("wait-div").style.display='block';
}
/**
 * 等待图标关闭
 */
Share.waiting.stop=function (){
	document.getElementById("wait-div").style.display='none';
}
/**
 * 0:否 1：是 转换
 */
Share.isNotChange=function(val) {
    return val?'是':'否';
}
/**
 * 0:停用 1：启用 99：删除
 */
Share.stateChange=function(val) {
	if(val==0) return '停用';
	if(val==1) return '正常';
	if(val==99) return '删除';
}