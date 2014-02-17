Ext.define('DS.view.datasource.MetadataWindow', {
	extend : 'Ext.window.Window',
	alias : 'widget.chooseMetadata',
	id : 'windowId',
	title : '选择元数据',
	autoShow : true,
	modal : true,
	width : 800,
	height : 460,
	plain : true,
	constrain:true,
	layout : {
		type : 'border',
		align : 'stretch'
	},
	items : [ {
		region : 'west',
		layout : 'fit',
		split : true,
		xtype : 'winTree',
		width : 175,
		height : 175,

		title : '元数据'
	}, {
		region : 'center',
		xtype : 'metadataList',
		height : 30,
		split : true,
		width : 400
	} ],
	dockedItems : [ {
		dock : 'bottom',
		xtype : 'toolbar',
		items : [ '->', {
			itemId : 'sub',
			text : '确定',
			iconCls : 'icon_accept_img',
			cls : 'x-btn-text-icon',
			handler : function() {
				var record =  Ext.getCmp('metadataListId').getSelectionModel().getSelection();
				if(record.length == 0){
					Ext.Msg.alert('提示', '请选择一个元数据!');
					return ;
				}
				Ext.getCmp('metadataId').setValue(record[0].data.metadataName);
				Ext.getCmp('backupColumn').setValue(record[0].data.id);
				var column = Ext.getCmp('column');
				if(column != undefined){
					column.setValue(record[0].data.metadataMark);
				}
				Ext.getCmp('windowId').close();
			}
		}, {
			text : '取消',
			iconCls : 'icon_cancel_img',
			cls : 'x-btn-text-icon',
			handler : function() {
				Ext.getCmp('windowId').close();
			}
		} ]
	} ]
});