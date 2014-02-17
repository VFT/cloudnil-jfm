Ext.Loader.setPath({  
    'Ext.ux' : ctx+'/resources/ext/ux'
});
Ext.require(['Ext.ux.TreePicker']);
Ext.define('US.view.Edit', {
    extend: 'Ext.window.Window',
    alias : 'widget.useredit',
    title : '用户信息编辑',
    layout: 'fit',
    autoShow: true,
    modal: true,
    minWidth: 400,
    width: 400,
    autoScroll:true,
    plain: true,
    resizable:true,
    constrain:true,
    initComponent: function() {
    	var myStore=Ext.create('Ext.data.Store', {
			fields : ['label', 'value'],
			data   : [
			          {label : '正常',value:1},
			          {label : '停用',value:0}
			          ]
			}
    	);
    	var sexType=Ext.create('Ext.data.Store', {
			fields : ['label', 'value'],
			data   : [
			          {label : '男',value:'男'},
			          {label : '女',value:'女'}
			          ]
			}
    	);
		this.items = [ {
			xtype : 'form',
			bodyPadding : '2 10 0',
			fieldDefaults : {
				labelWidth : 75
			},
			items : [ {
				xtype : 'fieldset',
				columnWidth : 0.5,
				title : '基础信息',
				collapsible : true,
				defaultType : 'textfield',
				defaults : {
					anchor : '100%'
				},
				layout : 'anchor',
				items : [ {
					xtype : 'hiddenfield',
					name : 'id'
				},{
					xtype : 'hiddenfield',
					name : 'password'
				}, {
					xtype : 'datefield',
					name : 'createTime',
					format : 'Y-m-d H:i:s',
					hidden : true
				}, {
					fieldLabel : '登录帐号',
					xtype : 'textfield',
					name : 'userName',
					afterLabelTextTpl : Share.REQUIRED,
					allowBlank : false,
					blankText : '登录帐号不能为空!'
				}, {
					fieldLabel : '中文名称',
					xtype : 'textfield',
					name : 'cnName',
					afterLabelTextTpl : Share.REQUIRED,
					allowBlank : false,
					blankText : '中文名称不能为空!'
				}, {
					fieldLabel : '英文名称',
					xtype : 'textfield',
					name : 'enName',
					afterLabelTextTpl : Share.REQUIRED,
					allowBlank : false,
					blankText : '英文名称不能为空!'
				}, {
					fieldLabel : '用户编号',
					xtype : 'textfield',
					name : 'code',
					afterLabelTextTpl : Share.REQUIRED,
					allowBlank : false,
					blankText : '机构编码不能为空!'
				}, {
					fieldLabel : '所属机构',
					xtype : 'treepicker',
					name : 'org.id',
					displayField : 'text',
					valueField : 'id',
					afterLabelTextTpl : Share.REQUIRED,
					allowBlank : false,
					emptyText : '请选择...',
					blankText : '所属机构不能为空!',
					store : Ext.create('US.store.OrgTree')
				}, {
					xtype : 'container',
					layout : 'hbox',
					defaultType : 'textfield',
					height : 27,
					items : [ {
						fieldLabel : '当前状态',
						xtype : 'combobox',
						name : 'state',
						width : 169,
						displayField : 'label',
						valueField : 'value',
						afterLabelTextTpl : Share.REQUIRED,
						allowBlank : false,
						emptyText : '请选择...',
						blankText : '当前状态不能为空!',
						editable : false,
						value : 1,
						store : myStore
					}, {
						fieldLabel : '显示顺序',
						xtype : 'numberfield',
						width : 169,
						name : 'displayIndex',
						allowBlank : false,
						blankText : '显示顺序不能为空!',
						afterLabelTextTpl : Share.REQUIRED
					} ]
				} ]
			}, {
				xtype : 'fieldset',
				columnWidth : 0.5,
				title : '扩展信息',
				collapsible : true,
				collapsed : false,
				defaultType : 'textfield',
				defaults : {
					anchor : '100%'
				},
				layout : 'anchor',
				items : [{
					fieldLabel : '菜单权限',
					xtype : 'treepicker',
					name : 'menus',
					displayField : 'text',
					valueField : 'id',
					emptyText : '请选择...',
					store : Ext.create('US.store.MenuTree')
				} ,{
					fieldLabel : '邮箱',
					xtype : 'textfield',
					name : 'email'
				}, {
					fieldLabel : '手机',
					xtype : 'textfield',
					name : 'mobPhone'
				}, {
					xtype : 'container',
					layout : 'hbox',
					defaultType : 'textfield',
					height : 27,
					items : [ {
						fieldLabel : '性别',
						xtype : 'combobox',
						name : 'sex',
						width : 169,
						displayField : 'label',
						valueField : 'value',
						emptyText : '请选择...',
						editable : false,
						store : sexType
					}, {
						fieldLabel : '年龄',
						xtype : 'numberfield',
						width : 169,
						name : 'age'
					} ]
				} ]
			} ]
		} ];
        this.buttons = [
            {
                text: '提交',
                action: 'save',
                formBind: true,
                iconCls:'icon_accept_img',
                cls:'x-btn-text-icon'
            },
            {
                text: '取消',
                scope: this,
                handler: this.close,
                iconCls:'icon_cancel_img',
                cls:'x-btn-text-icon'
            }
        ];

        this.callParent(arguments);
    }
});