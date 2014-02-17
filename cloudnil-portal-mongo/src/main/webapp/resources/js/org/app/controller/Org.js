Ext.define('OR.controller.Org', {
	extend:'Ext.app.Controller',
	views: ['List','Tree','Edit'],
	stores: ['Org','OrgTree'],
    models: ['Org','OrgTree'],
	init : function() {
		this.control(
			{
				'viewport > orglist':{itemdblclick:this.itemClickEdit},
				'orglist button[action=add]':{click:this.addRecord},
				'orglist button[action=edit]':{click:this.btnClickEdit},
				'orglist button[action=delete]':{click:this.deleteRecord},
				'orgedit button[action=save]':{click:this.saveRecord},
				'orglist button[action=refresh]':{click:this.refreshList},
				'viewport > orgtree':{itemclick:this.treeItemClick}
			}
		);
	},
	refreshList: function(button) {
		var grid = button.up('orglist');
		grid.store.load();
	},
	addRecord: function() {
		Ext.widget('orgedit');
	},
	deleteRecord: function(button) {
		var grid = button.up('orglist');
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
                	url: ctx +'/org/deleteOrgs.do',
                	params:{ids:ids},
                    callback: function (extReturn) {
                    	Ext.getCmp('orgList').store.load();
                    }
                });
            }
        });
	},
	itemClickEdit: function(grid, record) {
		var editView=Ext.widget('orgedit');
		editView.down('form').loadRecord(record);
	},
	btnClickEdit:function(button){
		var grid = button.up('orglist');
		var records=grid.getSelectionModel().getSelection();
		if(records.length!=1){
			Ext.Msg.alert('温馨提示', '请选择一条数据进行编辑!');
			return;
		}
		var editView=Ext.widget('orgedit');
		editView.down('form').loadRecord(records[0]);
	},
	treeItemClick:function(view, rec, item, e) {
		var store=Ext.getCmp('orgList').store;
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
            	url: ctx+'/org/saveOrg.do',
            	submitEmptyText:false,
                success: function(form, action) {
                	Share.waiting.stop();
                	win.close();
                    Ext.getCmp('orgList').store.load();
                },
                failure: function(form, action) {
                    Ext.Msg.alert('温馨提示', action.result.msg);
                }
            });
        }
	}
});
