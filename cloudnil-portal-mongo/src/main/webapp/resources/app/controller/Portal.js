Ext.require('VENU.view.MenuTree');
Ext.define(
				'VENU.controller.Portal',
				{
					extend : 'Ext.app.Controller',
					stores : [ 'AppStore', 'MenuStore' ],
					models : [ 'App'],
					refs : [ {
						ref : 'appPanel',
						selector : 'apppanel'
					}, {
						ref : 'menuTree',
						selector : 'menutree'
					}, {
						ref : 'mainTab',
						selector : 'maintab'
					}, {
						ref : 'helpPanel',
						selector : 'helppanel'
					}, {
						ref : 'easyPortalHeader',
						selector : 'easyportalheader'
					}, {
						ref : 'sysSettingPanel',
						selector : 'syssetting'
					} ],
					init : function() {
						var me = this;
						me.getAppStoreStore().on({
							scope : me,
							load : me.loadApp
						});
						this.control({
									'menutree' : {
										itemclick : this.treeItemClick
									},
									'easyportalheader > headertoolbar button[action=exit]' : {
										click : this.logout
									},
									'easyportalheader > headertoolbar button[action=changeskin]' : {
										click : this.changeSkin
									},
									'easyportalheader > headertoolbar button[action=setting]' : {
										click : this.sysSetting
									},
									'syssetting button[action=save]' : {
										click : this.sysSettingSave
									}
								});
						
					},
					logout : function() {
						Ext.Msg.confirm("温馨提示", "确定要退出吗？", function (btn) {
				            if (btn == "yes") {
				                Share.AjaxRequest({
				                	url: ctx + '/loginout.do',
				                    showMsg: true,
				                    callback: function (extReturn) {
				                    	//单点退出URL
				                    	var ssoLogOut='https://sso.venumeta.com:9443/vso/logout?service=http://sso.venumeta.com:9080/vportal/main.jsp';
				                    	//启用单点退出时请配置下边的href=ssoLogOut;
				                    	location.href = ctx+'/index.jsp';
				                    	//location.href = ssoLogOut;
				                    }
				                });
				            }
				        });
					},
					changeSkin : function() {
						console.log("更改皮肤");
					},
					sysSetting : function() {
						var edit = Ext.create('VENU.view.tool.Setting').show();
						edit.down('form').loadRecord({
							password : '23423423'
						});
					},
					sysSettingSave : function() {
						console.log("保存系统设置");
					},
					// Launch时绑定Store到View
					onLaunch : function() {
						// this.getAppPanel().bindStore(this.getAppStoreStore());
					},
					treeItemClick : function(view, record, item, index, e,eOpts) {
						//获取当前激活的Accordion Panel
						var ap=view.up('panel').up('panel');
						var url=record.raw.url;
						if(url==''){
							return;
						}
						//内网菜单配置上应用前缀，外网菜单不需要
						if(record.raw.type=='FUN_INTER'){
							url=ap.data.raw.url+url;
						}
						var me = this;
						me.getHelpPanel().update(record.raw.helpInfo);
						var tab = Ext.getCmp(record.raw.id);
						if (tab) {
							me.getMainTab().setActiveTab(tab);
						} else {
							var panel = new Ext.Panel(
									{
										id : record.raw.id,
										title : record.raw.text,
										closable : true,
										iconCls : record.raw.iconCls,
										html : '<iframe frameborder="0" width="100%" height="100%" src=\"'+url+'"></iframe>',
										listeners : {
											'activate' : function (){
												me.getHelpPanel().update(record.raw.helpInfo);
											}
										}
									});
							me.getMainTab().add(panel);
							me.getMainTab().doLayout();
							me.getMainTab().setActiveTab(panel);
						}
					},

					loadApp : function(records, operation, success) {
						var me = this;
						var panels = [];
						records.each(function(r) {
							var store = Ext.create('VENU.store.MenuStore', {
								proxy : {
									type : 'ajax',
									url : ctx + '/menu.do',
									actionMethods : 'POST',
									extraParams : {
										appId : r.get('id')
									}
								}
							});
							var treeView = Ext.create('VENU.view.MenuTree', {
								store : store
							});
							panels.push(new Ext.Panel({
								title : r.get('text'),
								layout : 'fit',// 解决树的自适应问题
								iconCls : r.get('iconCls'),
								items : [ treeView ],
								data:r
							}));
						});
						me.getAppPanel().add(panels);
						me.getAppPanel().doLayout();
					}
				});