Ext.define('METADATA.view.MetadataList', {
	extend : 'Ext.grid.Panel',
	alias : 'widget.MetadataList',

	id : 'metadataListId',
	store : 'Metadata',
	selModel : Ext.create('Ext.selection.CheckboxModel'),
	title : '元数据管理列表',
	initComponent : function() {
		this.columns = [ new Ext.grid.RowNumberer({
			header : "序号",
			width : 40,
			renderer : function(value, metadata, record, rowIndex) {
				return 0 + 1 + rowIndex;
			}
		}), {
			text : '名称',
			dataIndex : 'metadataName',
			flex: 1,
			sortable : true
		}, {
			text : '标识符',
			dataIndex : 'metadataMark',
			flex: 1,
			sortable : true
		}, {
			text : '元数据类型',
			dataIndex : 'metadataTypeName',
			flex: 1,
			sortable : true
		}, {
			text : '数据类型',
			dataIndex : 'hiddenValueType',
			flex: 1,
			sortable : true
		}, {
			text : '状态',
			dataIndex : 'hiddenRegStatus',
			flex: 1,
			sortable : true
		}, {
			text : '生效日期',
			dataIndex : 'startDate',
			flex: 1,
			sortable : true
		} ];
		this.callParent(arguments);
	},

	dockedItems : [ {
		dock : 'top',
		xtype : 'toolbar',
		items : [ {
			itemId : 'add',
			text : 'Fome1',
			iconCls : '',
			action : 'add'
		}, '-', {
			itemId : 'update',
			text : 'Fome2',
			iconCls : '',
			action : 'Fome2'
		}, '-', {
			itemId : 'delete',
			text : 'Fome3',
			iconCls : '',
			action : 'Fome3'
		}, '->', {
			xtype : 'textfield',
			// xtype: 'triggerfield',
			// triggerCls : 'x-form-search-trigger',
			emptyText : '请输入名称...'
		}, {
			itemId : 'search',
			text : '查询',
			iconCls : 'icon_search_img'
		}, '-', {
			itemId : 'refresh',
			text : '刷新',
			iconCls : 'icon_refresh_img'
		} ]
	}, {
		dock : 'bottom',
		xtype : 'pagingtoolbar',
		store : 'Metadata',
		id : 'metadataPaging',
		pageSize : page_size,
		displayInfo : true,
		displayMsg : '显示 {0} - {1} 条，共计 {2} 条',
		emptyMsg : '没有数据',
		items : [ '-', '每页', {
			xtype : 'numberfield',
			cls : 'x-tbar-page-number',
			width : 40,
			minValue : 5,
			minText : '每页不允许少于5条！',
			maxValue : 100,
			maxText : '每页不允许多余于100条！',
			value : page_size,
			listeners : {
				blur : function(view, e, o) {
					if (view.value == null) {
						view.setValue(page_size);
					}
					if (view.value < 5 || view.value > 100) {
						Ext.Msg.alert('提示', '每页最少可以设置5条，最多可以设置100条！');
						view.setValue(page_size);
					}
					var metadataPaging = Ext.getCmp('metadataPaging');
					metadataPaging.store.pageSize = view.value;
					metadataPaging.store.load();
				}
			}
		}, '条' ]
	} ]
});