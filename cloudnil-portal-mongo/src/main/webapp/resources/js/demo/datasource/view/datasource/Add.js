Ext.define('DS.view.datasource.Add', {
    extend: 'Ext.window.Window',
    alias : 'widget.datasourceAdd',

    title : '数据源新增',
    layout: 'fit',
    autoShow: true,
    modal: true,
    width: 400,
    height: 500,
    plain: true,
    resizable:false,
    constrain:true,
    
    initComponent: function() {
        this.items = [
            {
                xtype: 'form',
                bodyPadding: '2 10 0',
                items: [{
                    // Fieldset in Column 1 - collapsible via toggle button
                    xtype:'fieldset',
                    columnWidth: 0.5,
                    title: '基本信息',
                    collapsible: true,
                    defaultType: 'textfield',
                    defaults: {anchor: '100%'},
                    layout: 'anchor',
                    items :[
            				{
            				    xtype: 'textfield',
            				    blankText :'数据源名称不能为空!',
            				    fieldLabel: '数据源名称',
            				    afterLabelTextTpl: required,
            				    name: 'rName',
            				    allowBlank: false
            				},
            				new Ext.form.field.ComboBox({
            					fieldLabel : '数据库类型', 
            					blankText :'数据库类型不能为空!',
            					afterLabelTextTpl: required,
            					name:'dbType',
            					store : submitterStore = Ext.create('Ext.data.Store', {  
            					  proxy : {
            						type : 'ajax',
            						url : '../sysBaseCode/findAllSBCodes.do?codeType=101',
            						method : 'POST',
            						reader : {
            							type : 'json',
            							root : 'rows'
            						}
            					},
            					fields : ['code','cnName']
            					}), 
            					displayField: "cnName", 
            					valueField: "code",
            					emptyText : '请选择',
            					allowBlank:false,
            					editable:false		// Only select from list
            				}),
            				{
            				    xtype: 'textarea',
            				    height:70,
            				    fieldLabel: '描述',
            				    name: 'describe'
            				}
                    ]
                },
                {
                    // Fieldset in Column 1 - collapsible via toggle button
                    xtype:'fieldset',
                    columnWidth: 0.5,
                    title: '连接信息',
                    collapsible: true,
                    defaultType: 'textfield',
                    defaults: {anchor: '100%'},
                    layout: 'anchor',
                    items :[

							new Ext.form.field.ComboBox({
								fieldLabel : '连接类型',
								blankText :'连接类型不能为空!',
								afterLabelTextTpl: required,
								name:'connectType',
								displayField: "cnName",  
								valueField: "code",
								emptyText : '请选择',
								store:subStore = Ext.create('Ext.data.Store',{
									proxy:{
										type:'ajax',
										url:'../sysBaseCode/findAllSBCodes.do?codeType=102',
										method:'post',
										reader:{
											type:'json',
											root:'rows'
										}
									},
									fields : ['code','cnName']
								}),
								listeners:{
									'select':function(){
										switchConnType(this.getValue(),this.up('form').getForm());
									}
								},
								allowBlank:false,
            					editable:false	// Only select from list
								}),
								{
	            		            xtype: 'textfield',
	            		            blankText :'JNDI名称不能为空!',
	            		            fieldLabel: 'JNDI名称',
	            		            afterLabelTextTpl: required,
	            		            name: 'jndi',
	            		            allowBlank: false
	            		        },	
							new Ext.form.field.ComboBox({
								fieldLabel : '驱动类型',
								blankText :'驱动类型不能为空!',
								afterLabelTextTpl: required,
								name:'driver',
								id:'driver',
							    displayField: "cnName",  
							    valueField: "cnName",
							    store:subStore = Ext.create('Ext.data.Store',{
							    	proxy:{
							    		type:'ajax',
							    		url:'../sysBaseCode/findAllSBCodes.do?codeType=103',
							    		method:'post',
							    		reader:{
							    			type:'json',
							    			root:'rows'
							    		}
							    	},
							    	fields : ['code','cnName']
							    }),
							    emptyText : '请选择',
							    editable:false,
							    allowBlank: false
							}),
							{
            				    xtype: 'textfield',
            				    blankText :'数据库名称不能为空!',
            				    fieldLabel: '数据库名称',
            				    afterLabelTextTpl: required,
            				    name: 'dbName',
            				    allowBlank: false
            				},
            				{
            		            xtype: 'textfield',
            		            blankText :'URL不能为空!',
            		            fieldLabel: 'URL',
            		            afterLabelTextTpl: required,
            		            name: 'url',
            		            allowBlank: false
            		        },{
            		            xtype: 'textfield',
            		            blankText :'用户名不能为空!',
            		            fieldLabel: '用户名',
            		            afterLabelTextTpl: required,
            		            name: 'username',
            		            allowBlank: false
            		        },{
            		        	 xtype:'textfield',
            		        	fieldLabel: '密码',
            		        	afterLabelTextTpl: required,
            		            blankText :'密码不能为空!',
            		            name: 'password',
            		            allowBlank: false
            		        },{
            		        	 xtype:'textfield',
            		        	fieldLabel: '参数',
            		            blankText :'参数不能为空!',
            		            name: 'para',
            		            allowBlank: true
            		        }
                    ]
                }]
            }
        ];

        this.buttons = [
            {
                text: '提交',
                action: 'save',
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

switchConnType = function(type,form){
	if(type == 1){
		form.findField('jndi').setValue('');
		form.findField('jndi').disable();
		form.findField("driver").enable();
		form.findField('url').enable();
		form.findField('username').enable();
		form.findField('password').enable();
		form.findField('para').enable();
		form.findField('dbName').enable();
	}else{
		form.findField('jndi').enable();
		
		form.findField("driver").disable();
		form.findField("driver").clearValue();
		
		form.findField('url').setValue('');
		form.findField('url').disable();
		
		form.findField('dbName').setValue('');
		form.findField('dbName').disable();
		
		form.findField('username').setValue('');
		form.findField('username').disable();
		
		form.findField('password').setValue('');
		form.findField('password').disable();
		
		form.findField('para').setValue('');
		form.findField('para').disable();
	}
};

