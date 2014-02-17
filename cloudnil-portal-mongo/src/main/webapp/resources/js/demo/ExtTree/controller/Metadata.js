Ext.define('METADATA.controller.Metadata', {
	extend : 'Ext.app.Controller',

	models : [ 'Metadata', 'Tree' ],
	stores : [ 'Metadata', 'Tree' ],
	views : [ 'MetadataList', 'Tree','FormOne','FormTwo','FormThree'],
	refs : [ { // 做view层映射
		ref : 'MetadataList',
		selector : 'MetadataList'
	}],
	init : function() {
		this.control({
			'Tree' : {
				itemclick : function(view, rec, item, e) {
					this.showInfo(rec, item, e);
				},
				itemcontextmenu : function(menutree, record, item, index, e) {
					e.preventDefault(); // 阻止浏览器默认右键菜单显示
					rightClickAction.showAt(e.getXY());
				}
			},
			'MetadataList button[action=add]' : {
				click : function(){
					Ext.widget('formOne');
				}
			},
			'MetadataList button[action=Fome2]' : {
				click : function(){
					Ext.widget('formTwo');
				}
			},
			'MetadataList button[action=Fome3]' : {
				click : function(){
					Ext.widget('formThree');
				}
			}
		});
	},
	showInfo : function(rec, item, e) {
		var id = rec.get('id');
		var proxy = Ext.data.proxy.Proxy({
			type : 'ajax',
			url : '../metadata/getMetadataList.do',
			extraParams : {
				catalogId : id
			},
			reader : {
				type : 'json',
				root : 'rows',
				totalProperty : 'totalNum'
			}
		});
		Ext.getCmp('metadataListId').getStore('Metadata').setProxy(proxy);
		Ext.getCmp('metadataListId').getStore('Metadata').load();
	}

});

// 新增功能
var saveAction = Ext.create('Ext.Action', {
	iconCls : 'icon_add_img',
	text : '新增',
	handler : function() {
		Ext.Msg.alert('温馨提示', "这是新增按钮");
	}
});

// 编辑功能
var editAction = Ext.create('Ext.Action', {
	iconCls : 'icon_edit_img',
	text : '编辑',
	handler : function() {
		Ext.Msg.alert('温馨提示', "这是编辑按钮");
	}
});

// 删除功能
var deleteAction = Ext.create('Ext.Action', {
	iconCls : 'icon_delete_img',
	text : '删除',
	handler : function() {
		Ext.Msg.alert('温馨提示', "这是删除按钮");
		// Ext.Ajax.request({
		// url : 'deleteNode.do',
		// isLoading : true,
		// params : {
		// nodeId : treeId
		// },
		// success : function(response) {
		// Ext.Msg.alert('提示',response.responseText);
		// Ext.getCmp('tree').store.load();
		// },
		// failure : function(response) {
		// Ext.Msg.alert('提示',response.responseText);
		// }
		// });
	}
});
var rightClickAction = new Ext.menu.Menu({
	floating : true,
	plain : true,
	items : [ saveAction, editAction, deleteAction ]
});