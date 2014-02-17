Ext.define('METADATA.view.FormTwo', {
	extend : 'Ext.window.Window',
	alias : 'widget.formTwo',

	title : 'FormTwo',
	layout : 'fit',
	autoShow : true,
	modal : true,
	width : 400,
	
	initComponent : function() {
		this.items = [ {
			xtype : 'form',
			bodyPadding: '5',
			labelAlign: 'right',
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
				items : [ {
					fieldLabel : '名称',
					blankText : '不能为空!',
					afterLabelTextTpl : required,
					name : 'name',
					allowBlank : false
				}, {
					fieldLabel : '排序',
					blankText : '不能为空!',
					name : 'name',
					allowBlank : false
				},{
                    xtype: 'datefield',
                    fieldLabel: '日期',
                    name: 'dob',
                    allowBlank: false,
                    format: 'Y-m-d',
                    maxValue: new Date()
                }, {
                    xtype: 'radiogroup',
                    fieldLabel: 'Auto Layout',
                    items: [
                        {boxLabel: 'Item 1', name: 'rb-auto', inputValue: 1},
                        {boxLabel: 'Item 2', name: 'rb-auto', inputValue: 2, checked: true}
                    ]
                },{
                    xtype: 'radiogroup',
                    fieldLabel: 'Single Column',
                    columns: 1,
                    items: [
                        {boxLabel: 'Item 1', name: 'rb-col', inputValue: 1},
                        {boxLabel: 'Item 2', name: 'rb-col', inputValue: 2, checked: true},
                        {boxLabel: 'Item 3', name: 'rb-col', inputValue: 3}
                    ]
                },{
                    // Use the default, automatic layout to distribute the controls evenly
                    xtype: 'checkboxgroup',
                    fieldLabel: 'Auto Layout',
                    items: [
                        {boxLabel: 'Item 1', name: 'cb-auto-11'},
                        {boxLabel: 'Item 2', name: 'cb-auto-21',},
                        {boxLabel: 'Item 3', name: 'cb-auto-31'}
                    ]
                },{
                    xtype: 'checkboxgroup',
                    fieldLabel: 'Single Column',
                    // Put all controls in a single column with width 100%
                    columns: 1,
                    items: [
                        {boxLabel: 'Item 1', name: 'cb-col-1'},
                        {boxLabel: 'Item 2', name: 'cb-col-2', checked: true},
                        {boxLabel: 'Item 3', name: 'cb-col-3'}
                    ]
                },{
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
