Ext.Loader.setPath({  
    'Ext.ux' : ctx+'/resources/ext/ux'
});
Ext.require(['Ext.ux.SearchField']);
Ext.define('US.view.List' ,{
    extend: 'Ext.grid.Panel',
    alias : 'widget.userlist',
    title : '用户列表',
    id:'userList',
    store: 'User',
	selModel : Ext.create('Ext.selection.CheckboxModel'),
	initComponent : function() {
		this.columns = [ {
			xtype : 'rownumberer',
			width : 40,
			sortable : false
		}, {
			text : "帐号",
			dataIndex : 'userName',
			flex : 1,
			sortable : true
		},  {
			text : "用户名称（中文）",
			dataIndex : 'cnName',
			flex : 2,
			sortable : true
		}, {
			text : "用户名称（英文）",
			dataIndex : 'enName',
			flex : 2,
			sortable : true
		}, {
			text : "用户编号",
			flex : 1,
			dataIndex : 'code',
			sortable : true
		}, {
			text : "所属机构",
			flex : 2,
			dataIndex : 'org.cnName',
			sortable : true
		}, {
			text : "当前状态",
			flex : 1,
			dataIndex : 'state',
			sortable : true,
			renderer:Share.stateChange
		}, {
			text : "创建时间",
			flex : 2,
			dataIndex : 'createTime',
			sortable : true
		}, {
			text : "显示顺序",
			flex : 1,
			dataIndex : 'displayIndex',
			sortable : true
		}];
		this.dockedItems=[ {
			dock : 'top',
			xtype : 'toolbar',
			items : [{
				action : 'add',
				text : '新增',
				iconCls : 'icon_add_img'
			}, '-', {
				action : 'edit',
				text : '编辑',
				iconCls : 'icon_edit_img'
			} , '-',{
				action : 'delete',
				text : '删除',
			    iconCls: 'icon_delete_img'
			},'->',{ 
				width: 260,
				labelWidth: 40,
				fieldLabel: '搜索',
				xtype: 'searchfield',
				paramName:'param',
				emptyText:'帐号、中、英文名称、编号',
				store:'User'
			},'-', {
				action : 'refresh',
				text : '刷新',
				iconCls : 'icon_refresh_img'
			}]
		}, {
			dock : 'bottom',
			xtype : 'pagingtoolbar',
			store : 'User',
			id:'dataPaging',
			pageSize : Share.PAGE_SIZE,
			displayInfo : true,
			displayMsg : '显示 {0} - {1} 条，共计 {2} 条',
			emptyMsg : '没有数据',
			items:['-','每页',{
	 			xtype:'numberfield',
	 			cls: 'x-tbar-page-number',
	 			width: 40,
	 			minValue:5,
	 			minText:'每页不允许少于5条！',
	 			maxValue:100,
	 			maxText:'每页不允许多余于100条！',
	 			value:Share.PAGE_SIZE,
	 			listeners:{
	 				blur:function(view,e,o){
	 					if(view.value == null){
	 						view.setValue(Share.PAGE_SIZE);
	 					}
	 					if(view.value<5 || view.value>100){
	 						Ext.Msg.alert('提示', '每页最少可以设置5条，最多可以设置100条！');
	 						view.setValue(Share.PAGE_SIZE);
	 					}
	 					var dataPaging = Ext.getCmp('dataPaging');
	 					dataPaging.store.pageSize = view.value;
	 					dataPaging.store.load();
	 				}
	 			}
	 		},'条']
		} ];
        this.callParent(arguments);
    }
});
