Ext.define('METADATA.view.FormOne', {
	extend : 'Ext.window.Window',
	alias : 'widget.formOne',

	title : '常用Form',
	layout : 'fit',
	autoShow : true,
	modal : true,
	width : 400,
	plain : true,
	resizable : false,
	constrain : true,

	initComponent : function() {
		this.items = [ {
			xtype : 'form',
			bodyPadding : '2 10 0',
			items : [ {
				// Fieldset in Column 1 - collapsible via toggle button
				xtype : 'fieldset',
				columnWidth : 0.5,
				title : '级别信息',
				collapsible : true,
				defaultType : 'textfield',
				defaults : {
					anchor : '100%'
				},
				layout : 'anchor',
				items : [
						{
							fieldLabel : '报表名称',
							blankText : '不能为空!',
							afterLabelTextTpl : required,
							name : 'name',
							allowBlank : false
						},
						new Ext.form.field.ComboBox({
							fieldLabel : '报表类型',
							blankText : '不能为空!',
							afterLabelTextTpl : required,
							name : 'toolId',
							displayField : 'cnName',
							valueField : 'code',
							queryMode : 'local',
							emptyText : '请选择',
							allowBlank : false,
							listeners : {
								select : function(thisField, value, opts) {
									Ext.getCmp('path').setValue('');
								}
							}
						}),
						{
							xtype : 'triggerfield',
							name : 'path',
							id : 'path',
							afterLabelTextTpl : required,
							fieldLabel : '报表配置',
							triggerCls : 'x-form-search-trigger',
							editable : false,
							allowBlank : false,
							onTriggerClick : function() {
								var toolValue = this.ownerCt.up('window').down(
										'form').getForm().findField('toolId')
										.getValue();
								if (toolValue == 1) {
									createFileWindow();
								} else if (toolValue == 2) {
									createMondrianWindow();
								}
							}
						}, {
							xtype : 'textfield',
							blankText : '不能为空!',
							fieldLabel : '报表参数',
							//regex:/^\w+$/,
							afterLabelTextTpl : required,
							name : 'paramIds',
							id : 'paramIds',
							allowBlank : false,
							listeners : {
								focus : function() {
									var form = createParamForm(); //创建表参
									form = fillParamForm(form); //后台数据填充表单
									createParamWindow(form); //创建window窗口，并把表单渲染到窗口
								}
							}
						}, {
							xtype : 'combo',
							name : 'strategyId',
							afterLabelTextTpl : required,
							fieldLabel : '发布策略',
							queryMode : 'local',
							triggerAction : 'all',
							displayField : 'name',
							valueField : 'id',
							emptyText : '请选择',
							allowBlank : false,
							width : 300,
							blankText : '不能为空!'
						}, {
							xtype : 'combo',
							name : 'pushType',
							afterLabelTextTpl : required,
							fieldLabel : '推送类别',
							queryMode : 'local',
							triggerAction : 'all',
							displayField : 'name',
							valueField : 'id',
							emptyText : '请选择',
							allowBlank : false,
							blankText : '不能为空!'
						}, {
							xtype : 'combo',
							name : 'roleIds',
							multiSelect : 'true',
							afterLabelTextTpl : required,
							fieldLabel : '权限',
							queryMode : 'local',
							triggerAction : 'all',
							displayField : 'name',
							valueField : 'id',
							emptyText : '请选择',
							allowBlank : false,
							blankText : '不能为空!'
						}, {
							xtype : 'textarea',
							fieldLabel : '描述',
							name : 'description'
						} ]
			} ]
		} ];

		this.buttons = [ {
			text : '提交',
			action : 'save',
			iconCls : 'icon_accept_img',
			cls : 'x-btn-text-icon'
		}, {
			text : '取消',
			scope : this,
			handler : this.close,
			iconCls : 'icon_cancel_img',
			cls : 'x-btn-text-icon'
		} ];

		this.callParent(arguments);
	}
});
