Ext.define('US.controller.User', {
	extend:'Ext.app.Controller',
	views: ['List','Tree','Edit'],
	stores: ['User','OrgTree'],
    models: ['User','OrgTree'],
	init : function() {
		this.control(
			{
				'viewport > userlist':{itemdblclick:this.itemClickEdit},
				'userlist button[action=add]':{click:this.addRecord},
				'userlist button[action=edit]':{click:this.btnClickEdit},
				'userlist button[action=delete]':{click:this.deleteRecord},
				'useredit button[action=save]':{click:this.saveRecord},
				'userlist button[action=refresh]':{click:this.refreshList},
				'viewport > orgtree':{itemclick:this.treeItemClick}
			}
		);
	},
	refreshList: function(button) {
		var grid = button.up('userlist');
		grid.store.load();
	},
	addRecord: function() {
		Ext.widget('useredit');
	},
	deleteRecord: function(button) {
		var grid = button.up('userlist');
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
                	url: ctx +'/user/deleteUsers.do',
                	params:{ids:ids},
                    callback: function (extReturn) {
                    	Ext.getCmp('userList').store.load();
                    }
                });
            }
        });
	},
	itemClickEdit: function(grid, record) {
		var editView=Ext.widget('useredit');
		editView.down('form').loadRecord(record);
	},
	btnClickEdit:function(button){
		var grid = button.up('userlist');
		var records=grid.getSelectionModel().getSelection();
		if(records.length!=1){
			Ext.Msg.alert('温馨提示', '请选择一条数据进行编辑!');
			return;
		}
		var editView=Ext.widget('useredit');
		editView.down('form').loadRecord(records[0]);
	},
	treeItemClick:function(view, rec, item, e) {
		var store=Ext.getCmp('userList').store;
		store.proxy.setExtraParam('orgId',rec.get('id'));
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
            	url: ctx+'/user/saveUser.do',
            	submitEmptyText:false,
                success: function(form, action) {
                	Share.waiting.stop();
                	win.close();
                    Ext.getCmp('userList').store.load();
                },
                failure: function(form, action) {
                    Ext.Msg.alert('温馨提示', action.result.msg);
                }
            });
        }
	}
});
