Ext.Loader.setPath({  
    'Ext.ux' : ctx+'/resources/ext/ux'
});
Ext.require(['Ext.ux.TreePicker']);
Ext.define('OR.view.Edit', {
    extend: 'Ext.window.Window',
    alias : 'widget.orgedit',
    title : '组织机构编辑',
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
    	var typeStore=Ext.create('Ext.data.Store', {
			fields : ['label', 'value'],
			data   : [
			          {label : '单位',value:1},
			          {label : '部门',value:2}
			          ]
			}
    	);
        this.items = [
            {
                xtype: 'form',
                bodyPadding: '2 10 0',
                fieldDefaults: {
                    labelWidth: 75
                },
                defaults: {anchor: '100%'},
                items: [{
				    xtype: 'hiddenfield',
				    name: 'id'
				},
				{
				    xtype: 'datefield',
				    name: 'createTime',
				    format:'Y-m-d H:i:s',
				    hidden:true
				},
				{
					fieldLabel: '中文名称',
				    xtype: 'textfield',
				    name: 'cnName',
				    afterLabelTextTpl: Share.REQUIRED,
				    allowBlank: false,
				    blankText :'中文名称不能为空!'
				},
				{
					fieldLabel: '英文名称',
				    xtype: 'textfield',
				    name: 'enName',
				    afterLabelTextTpl: Share.REQUIRED,
				    allowBlank: false,
				    blankText :'英文名称不能为空!'
				},
				{
					fieldLabel: '机构编码',
				    xtype: 'textfield',
				    name: 'code',
				    afterLabelTextTpl: Share.REQUIRED,
				    allowBlank: false,
				    blankText :'机构编码不能为空!'
				},
				{
				    fieldLabel: '所属机构',
			        xtype: 'treepicker',
			        name: 'parentId',
			        displayField: 'text',
			        valueField: 'id',
			        afterLabelTextTpl: Share.REQUIRED,
					allowBlank: false,
					emptyText:'请选择...',
					blankText :'所属机构不能为空!',
					store:Ext.create('OR.store.OrgTree')
                },
                {
                    xtype: 'container',
                    layout: 'hbox',
                    defaultType: 'textfield',
                    height:27,
                    items: [{
    					fieldLabel: '机构类型',
                        xtype: 'combobox',
                        name: 'type',
                        width:183,
                        displayField: 'label',
                        valueField: 'value',
                        afterLabelTextTpl: Share.REQUIRED,
    				    allowBlank: false,
    				    emptyText:'请选择...',
    				    blankText :'机构类型不能为空!',
    				    editable:false,
                        store:typeStore
                    },
    				{
    					fieldLabel: '当前状态',
                        xtype: 'combobox',
                        name: 'state',
                        width:183,
                        displayField: 'label',
                        valueField: 'value',
                        afterLabelTextTpl: Share.REQUIRED,
    				    allowBlank: false,
    				    emptyText:'请选择...',
    				    blankText :'当前状态不能为空!',
    				    editable:false,
    				    value:1,
                        store:myStore
                    }
					]
				},
				{
                    xtype: 'container',
                    layout: 'hbox',
                    defaultType: 'textfield',
                    height:27,
                    items: [{
    					fieldLabel: '层级',
    					xtype: 'numberfield',
    				    width:183,
    				    name: 'level',
    				    allowBlank: false,
    				    blankText :'层级不能为空!',
    				    afterLabelTextTpl: Share.REQUIRED
    				},
                    {
    					fieldLabel: '显示顺序',
    					xtype: 'numberfield',
    				    width:183,
    				    name: 'displayIndex',
    				    allowBlank: false,
    				    blankText :'显示顺序不能为空!',
    				    afterLabelTextTpl: Share.REQUIRED
    				}
					]
				}
                ]
            }
        ];

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