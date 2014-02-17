Ext.define('MU.controller.Menu', {
	extend:'Ext.app.Controller',
	views: ['List','Tree','Edit'],
	stores: ['Menu','MenuTree'],
    models: ['Menu','MenuTree'],
	init : function() {
		this.control(
			{
				'viewport > menulist':{itemdblclick:this.itemClickEdit},
				'menulist button[action=add]':{click:this.addRecord},
				'menulist button[action=edit]':{click:this.btnClickEdit},
				'menulist button[action=delete]':{click:this.deleteRecord},
				'menulist button[action=refresh]':{click:this.refreshList},
				'menuedit button[action=save]':{click:this.saveRecord},
				'viewport > menutree':{itemclick:this.treeItemClick}
			}
		);
	},
	refreshList: function(button) {
		var grid = button.up('menulist');
		grid.store.load();
	},
	addRecord: function() {
		Ext.widget('menuedit');
	},
	deleteRecord: function(button) {
		var grid = button.up('menulist');
		var records=grid.getSelectionModel().getSelection();
		if(records.length==0){
			Ext.Msg.alert('温馨提示', '请选择至少一条数据进行删除!');
			return;
		}
		Ext.Msg.confirm("温馨提示", "确认删除选中数据？", function (btn) {
            if (btn == "yes") {
            	var ids = [];
        		for ( var i = 0; i < records.length; i++) {
        			ids.push(records[i].get("id"));
        		}
                Share.AjaxRequest({
                	url: ctx +'/menu/deleteMenus.do',
                	params:{ids:ids},
                    callback: function (extReturn) {
                    	Ext.getCmp('menuList').store.load();
                    }
                });
            }
        });
	},
	itemClickEdit: function(grid, record) {
		var editView=Ext.widget('menuedit');
		editView.down('form').loadRecord(record);
	},
	btnClickEdit:function(button){
		var grid = button.up('menulist');
		var records=grid.getSelectionModel().getSelection();
		if(records.length!=1){
			Ext.Msg.alert('温馨提示', '请选择一条数据进行编辑!');
			return;
		}
		var editView=Ext.widget('menuedit');
		editView.down('form').loadRecord(records[0]);
	},
	treeItemClick:function(view, rec, item, e) {
		var store=Ext.getCmp('menuList').store;
		store.proxy.setExtraParam('parentId',rec.get('id'));
		store.load();
	},
	saveRecord:function(button){
		var win = button.up('window');
		var form = win.down('form').getForm();
		var picker=win.down('treepicker');
		if (form.isValid()) {
        	Share.waiting.start();
        	picker.setRawValue(picker.getValue());
            form.submit({
            	url: ctx+'/menu/saveMenu.do',
            	submitEmptyText:false,
                success: function(form, action) {
                	Share.waiting.stop();
                	win.close();
                    Ext.getCmp('menuList').store.load();
                },
                failure: function(form, action) {
                    Ext.Msg.alert('温馨提示', action.result.msg);
                }
            });
        }
	}
});
