Ext.define('DS.view.datasource.List' ,{
    extend: 'Ext.grid.Panel',
    alias : 'widget.datasourcelist',
    title : '数据源',
    
    id:'dsgripd',
    store:'DataSources',
    selModel: Ext.create('Ext.selection.CheckboxModel'),
    initComponent: function() {
        this.columns = [
		      {
	    			text : "数据源名称",
	    			flex: 1,
	    			dataIndex : 'rName',
	    			editor: {
	    	            allowBlank: true
	    	        },
	    			sortable : true
	    		},
            {
    			text : "数据库名称",
    			flex: 1,
    			dataIndex : 'dbName',
    			editor: {
    	            allowBlank: true
    	        },
    			sortable : true
    		},{
    			text : "用户名",
    			flex: 1,
    			dataIndex : 'username',
    			editor: {
    	            allowBlank: true
    	        },
    			sortable : true
    		},{
    			text : "密码",
    			flex: 1,
    			dataIndex : 'password',
    			editor: {
    	            allowBlank: true
    	        },
    			sortable : true
    		},{
    			text : "数据库类型",
    			flex: 1,
    			dataIndex : 'dbType',
    			editor: {
    				xtype: 'numberfield',
                    allowBlank: true,
                    minValue: 1,
                    maxValue: 8	
    	        },
    			sortable : false
    		}
    		,{
    			text : "JNDI名称",
    			flex: 1,
    			dataIndex : 'jndi',
    			editor: {
    	            allowBlank: true
    	        },
    			sortable : false
    		}, {
    			text : "驱动程序",
    			flex: 2,
    			dataIndex : 'driver',
    			editor: {
    	            allowBlank: true
    	        },
    			sortable : false
    		},
    		{
    			text : "URL",
    			flex: 2,
    			dataIndex : 'url',
    			editor: {
    	            allowBlank: true
    	        },
    			sortable : true
    		}
    		,{
    			text : "创建时间",
    			dataIndex:'createTime',
    			flex: 1,
    			renderer: Ext.util.Format.dateRenderer('Y-m-d'),
    			editor: {
    	            xtype: 'datefield',
                    allowBlank: true,
                    format: 'Y-m-d',
                    minValue: '2000-01-01',
                    minText: 'Cannot have a start date before the company existed!',
                    maxValue: Ext.Date.format(new Date(), 'Y-m-d')
    	        }
    		}
        ];
        this.callParent(arguments);
    },
	
	dockedItems : [ {
		dock : 'top',
		xtype : 'toolbar',
		items : [{
			itemId : 'add',
			text : '新增',
			iconCls : 'icon_add_img'
		}, '-',{
			itemId : 'delete',
			text : '删除',
		    iconCls: 'icon_delete_img'
		},'->',{
            xtype : 'textfield',
//          xtype: 'triggerfield',
//          triggerCls : 'x-form-search-trigger',
          emptyText: '请输入数据源名称...'
      },{
			itemId : 'search',
			text : '查询',
			iconCls : 'icon_search_img'
		},'-', {
			itemId : 'refresh',
			text : '刷新',
			iconCls : 'icon_refresh_img'
		}]
	}, {
		dock : 'bottom',
		xtype : 'pagingtoolbar',
		store : 'DataSources',
		id:'dataSourcePaging',
		pageSize : page_size,
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
 			value:page_size,
 			listeners:{
 				blur:function(view,e,o){
 					if(view.value == null){
 						view.setValue(page_size);
 					}
 					if(view.value<5 || view.value>100){
 						Ext.Msg.alert('提示', '每页最少可以设置5条，最多可以设置100条！');
 						view.setValue(page_size);
 					}
 					var metadataPaging = Ext.getCmp('dataSourcePaging');
 					metadataPaging.store.pageSize = view.value;
 					metadataPaging.store.load();
 				}
 			}
 		},'条']
	} ],
	plugins : RowEditing
});