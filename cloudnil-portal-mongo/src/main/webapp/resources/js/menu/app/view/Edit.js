Ext.Loader.setPath({  
    'Ext.ux' : ctx+'/resources/ext/ux'
});
Ext.require(['Ext.ux.TreePicker']);
Ext.define('MU.view.Edit', {
    extend: 'Ext.window.Window',
    alias : 'widget.menuedit',
    title : '菜单资源编辑',
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
    	var rules;
    	var clsAry=[];
    	var dropLength=4;
    	for(var i=0;i<document.styleSheets.length;i++){
    		if(document.styleSheets[i].href.indexOf("menu-icon.css")!=-1){
    			if(document.styleSheets[i].cssRules){
    				rules=document.styleSheets[i].cssRules;
    			}else{
    				rules=document.styleSheets[i].rules;
    				dropLength=7;
    				//浏览器对相对地址的判断不同，chrome下css中的相对地址正常，IE下相对地址的../多了一次识别，所以要减掉3的长度，是否IE的识别通过rules判断
    			}
    			//rules=document.styleSheets[i].cssRules?document.styleSheets[i].cssRules:document.styleSheets[i].rules;
    		}
    	}
    	for(var j = 0; j < rules.length; j++){
    		var cssText=rules[j].style.cssText;
    		var iconCls=rules[j].selectorText.substring(1);
    		var iconUrl=cssText.substring(cssText.indexOf('url(')+dropLength,cssText.lastIndexOf(')'));
    		clsAry.push({label:iconCls,value:iconUrl});
    	};
    	var clsStore=Ext.create('Ext.data.Store', {
			fields : ['label', 'value'],
			data   : clsAry
    		}
    	);
    	var myStore=Ext.create('Ext.data.Store', {
			fields : ['label', 'value'],
			data   : [
			          {label : '是',value:1},
			          {label : '否',value:0}
			          ]
			}
    	);
    	var typeStore=Ext.create('Ext.data.Store', {
			fields : ['label', 'value'],
			data   : [
			          {label : '业务应用',value: 'APP'},
			          {label : '功能(内网)',value:'FUN_INTER'},
			          {label : '功能(外网)',value:'FUN_EXTER'}
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
                items: [{
                    xtype:'fieldset',
                    columnWidth: 0.5,
                    title: '基础信息',
                    collapsible: true,
                    defaultType: 'textfield',
                    defaults: {anchor: '100%'},
                    layout: 'anchor',
                    items :[
							{
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
								fieldLabel: '菜单名称',
							    xtype: 'textfield',
							    name: 'text',
							    afterLabelTextTpl: Share.REQUIRED,
							    allowBlank: false,
							    blankText :'菜单名称不能为空!'
							},
							{
								fieldLabel: '节点类型',
								xtype: 'combobox',
							    name: 'type',
							    afterLabelTextTpl: Share.REQUIRED,
							    allowBlank: false,
							    emptyText:'请选择...',
							    store:typeStore,
							    displayField:'label',
                                valueField:'value',
                                editable:false,
							    blankText :'节点类型不能为空!'
							},
							{
								fieldLabel: '上级菜单',
			                    xtype: 'treepicker',
			                    name: 'parentId',
			                    displayField: 'text',
			                    valueField: 'id',
			                    afterLabelTextTpl: Share.REQUIRED,
							    allowBlank: false,
							    emptyText:'请选择...',
							    blankText :'上级菜单不能为空!',
			                    store:Ext.create('MU.store.MenuTree')
			                },
							{
								fieldLabel: '图标样式',
								xtype: 'combobox',
							    name: 'iconCls',
							    afterLabelTextTpl: Share.REQUIRED,
							    allowBlank: false,
							    emptyText:'请选择...',
							    store:clsStore,
                                editable:false,
							    blankText :'图标样式不能为空!',
							    displayField:'label',
							    valueField:'label',
							    tpl :'<table><tr><tpl for="."><td class="x-boundlist-item"><img width=18 height=18 src="{value}" /></td><tpl if="xindex % 10 === 0"></tr><tr></tpl></tpl></tr></table>'
							},
							{
			                    xtype: 'container',
			                    layout: 'hbox',
			                    defaultType: 'textfield',
			                    height:27,
			                    items: [{
									fieldLabel: '是否展开',
								    xtype: 'combobox',
								    name: 'expanded',
								    width:169,
								    afterLabelTextTpl: Share.REQUIRED,
								    allowBlank: false,
								    emptyText:'请选择...',
								    store:myStore,
								    displayField:'label',
	                                valueField:'value',
	                                editable:false,
								    blankText :'是否展开不能为空!'
								},
								{
									fieldLabel: '是否叶子',
									xtype: 'combobox',
								    name: 'leaf',
								    width:169,
								    afterLabelTextTpl: Share.REQUIRED,
								    allowBlank: false,
								    emptyText:'请选择...',
								    store:myStore,
								    displayField:'label',
	                                valueField:'value',
	                                editable:false,
								    blankText :'是否展开不能为空!'
								}]
							},
							{
			                    xtype: 'container',
			                    layout: 'hbox',
			                    defaultType: 'textfield',
			                    height:27,
			                    items: [{
									fieldLabel: '是否显示',
								    xtype: 'combobox',
								    name: 'isDisplay',
								    width:169,
								    afterLabelTextTpl: Share.REQUIRED,
								    allowBlank: false,
								    emptyText:'请选择...',
								    store:myStore,
								    displayField:'label',
	                                valueField:'value',
	                                editable:false,
								    blankText :'是否显示不能为空!'
								},
								{
									fieldLabel: '显示顺序',
									xtype: 'numberfield',
								    width:169,
								    name: 'displayIndex',
								    allowBlank: false,
								    blankText :'显示顺序不能为空!',
								    afterLabelTextTpl: Share.REQUIRED
								}
								]
							},
							{
								fieldLabel: 'URL地址',
							    xtype: 'textfield',
							    name: 'url'
							}
                    ]
                },
                {
                    xtype:'fieldset',
                    columnWidth: 0.5,
                    title: '扩展信息',
                    collapsible: true,
                    collapsed: true,
                    defaultType: 'textfield',
                    defaults: {anchor: '100%'},
                    layout: 'anchor',
                    items :[
            				{
            				    xtype: 'textarea',
            				    height:70,
            				    fieldLabel: '描述',
            				    name: 'comment'
            				},{
            				    xtype: 'textarea',
            				    height:70,
            				    fieldLabel: '功能说明',
            				    name: 'helpInfo'
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