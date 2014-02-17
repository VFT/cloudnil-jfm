var RowEditing = Ext.create('Ext.grid.plugin.RowEditing', {
	clicksToMoveEditor : 1,
	cancelBtnText : '取消',
	saveBtnText : '保存',
	autoCancel : false,
	cancelEdit : function() {
		var me = this;
		if (me.editing) {
			me.getEditor().cancelEdit();
			store = Ext.getCmp('dsgripd').store;
			var n = store.findBy(function(r) {
				return (r.phantom == true);
			});
			if (n != -1) {
				store.removeAt(n);
			}
		}
	},
	listeners : {
		edit : function(editor, e){
			e.store.sync({
				success : function(response) {
					e.store.load();
				 },
				 failure : function(form, action) {
						Ext.Msg.alert('温馨提示', '提交失败！');
				}
			});
		}
	}
});
Ext.define('DS.controller.DataSources', {
    extend: 'Ext.app.Controller',
    
    stores:['DataSources'],
    models:['DataSources'],
    views:[
           'datasource.List'
     ],
     
	init: function() {
	    this.control({
            'datasourcelist button[itemId = add]': {
	        	click: this.addDataSource
	        },
            'datasourcelist button[itemId = delete]': {
	        	click: this.deleteDataSource
	        }
	    });
	},
	//create a dataSource page
	addDataSource : function(){
		RowEditing.cancelEdit();
		var r = Ext.create('DS.model.DataSources', {
			dbType : 1,
			createTime : new Date()
        });
		this.getDataSourcesStore().insert(0, r);
		RowEditing.startEdit(0, 0);
	},
  
	//delete one or more dataSources 
	deleteDataSource:function(){
		var me = this;
		var record =  Ext.getCmp('dsgripd').getSelectionModel().getSelection();
		if (record.length == 0) {
			Ext.Msg.alert('温馨提示', '请选择一条数据源!');
			return;
		}
		Ext.Msg.confirm('温馨提示', '确定删除该条记录?', function(btn) {
			if (btn == 'yes') {
				RowEditing.cancelEdit();
				me.getDataSourcesStore().remove(record);
				var store = me.getDataSourcesStore().sync({
					 success : function(response) {
							store.load();
					 },
					 failure : function(form, action) {
							Ext.Msg.alert('温馨提示', '删除失败！');
						}
				 });
			}
		});
	}
});