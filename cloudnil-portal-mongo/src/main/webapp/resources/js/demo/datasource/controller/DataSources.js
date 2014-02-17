Ext.define('DS.controller.DataSources', {
    extend: 'Ext.app.Controller',
    
    stores:['DataSources','WinMetadata','WinTree'],
    models:['DataSources','WinMetadata','WinTree'],
    views:[
           'datasource.List',
           'datasource.Edit',
           'datasource.Add',
           'datasource.MetadataList',
           'datasource.WinTree',
           'datasource.MetadataWindow'
     ],
     
	init: function() {
	    this.control({
	        'viewport > datasourcelist': {
	        	itemdblclick: this.editResource
	        },
	        'datasourceEdit button[action=save]': {
                click: this.saveOrUpdateDatasource
            },
            'datasourcelist button[itemId = add]': {
	        	click: this.addDataSource
	        },
	        'datasourcelist button[itemId = update]': {
	        	click: this.editResource
	        },
            'datasourceAdd button[action=save]': {
                click: this.saveOrUpdateDatasource
            },
            'datasourcelist button[itemId = delete]': {
	        	click: this.deleteDataSource
	        },
            'datasourcelist button[itemId = testDRConn]': {
	        	click: this.testConnDataSource
	        },
	        'datasourcelist button[itemId = editGrid]': {
	        	click: this.editGrid
	        },
	        'datasourcelist button[itemId = extTree]': {
	        	click: this.extTree
	        },
	        'datasourcelist button[itemId = window]': {
	        	click: this.openWin
	        },
	        'winTree':{
				select: this.showInfo
			}
	    });
	},
	showInfo:function(tree,record,index,eOpts){
		var id = record.get('id');
		var proxy = Ext.data.proxy.Proxy({
			type:'ajax',
			url:'../metadata/getMetadataList.do',
			extraParams:{
				catalogId:id
			},
			reader:{
				type:'json',
				root:'rows',
				totalProperty : 'totalNum'
			}
		});
		Ext.getCmp('metadataListId').getStore('Metadata').setProxy(proxy);
		Ext.getCmp('metadataListId').getStore('Metadata').load();
	},
	openWin : function(){
		Ext.widget('chooseMetadata');
	},
	editGrid : function(){
		location.href = 'editGrid.do';
	},
	//create a dataSource page
	addDataSource : function(){
		Ext.widget('datasourceAdd');
	},
	extTree : function(){
		location.href = 'extTree.do';
	},
	//update a dataSource page
	editResource: function(grid, record) {
		 record = '';
		 record =  Ext.getCmp('dsgripd').getSelectionModel().getSelection();
		 if(record.length == 0){
			 Ext.Msg.alert('温馨提示', '请选择一条数据源!');
			 return;
		 }else if(record.length > 1){
			 Ext.Msg.alert('温馨提示', '每次都只能编辑一条数据源!');
			 return;
		 }else{
			 record = record[0];
		 }
		 var view = Ext.widget('datasourceEdit');
		 view.down('form').loadRecord(record);
		 switchConnType(record.data.hidd_connectType,view.down('form').getForm());
	},
	//delete one or more dataSources 
	deleteDataSource:function(){
		var record =  Ext.getCmp('dsgripd').getSelectionModel().getSelection();
		if (record.length == 0) {
			Ext.Msg.alert('温馨提示', '请选择一条数据源!');
			return;
		} else {
			var arrayId = [];
			for ( var i = 0; i < record.length; i++) {
				var id = record[i].get("id");
				Ext.Array.include(arrayId,id);
			}
			deleteAjaxRequest(arrayId, '温馨删除', '确定删除该条记录？', "删除成功", '删除时发生错误!',
					'deleteDbResource.do','dsgripd');
		}
	},
	
	//test dataSource 
	testConnDataSource : function() {
		var record = Ext.getCmp('dsgripd').getSelectionModel().getSelection();
		if (record.length == 0) {
			Ext.Msg.alert('温馨提示', '请选择一条数据源!');
			return;
		} else if(record.length > 1){
			Ext.Msg.alert('温馨提示', '每次只能测试一个数据源！');
			return;
		}else{
			var id = record[0].get("id");
			var myMask = new Ext.LoadMask(Ext.getBody(), {msg:"Please wait..."});
			myMask.show();
			Ext.Ajax.request({
				url : 'testConnectionById.do',
				isLoading : true,
				params : {
					id : id
				},
				success : function(response) {
					myMask.hide();
					Ext.Msg.alert('温馨提示',response.responseText);
				}
			});
		}
	},
	
	//execute create or update command
	saveOrUpdateDatasource: function(button) {
		 var win    = button.up('window'),
	        form   = win.down('form').getForm();
		 	var rName = form.findField('rName').getValue();
		 	var rId = '';
		 	if(form.findField('id') != null)
		 		rId = form.findField('id').getValue();
	        if (form.isValid()) {
	        	Ext.Ajax.request({
	        	    url: 'validateDBSource.do',
	        	    params: {
	        	    	rName: rName,
	        	    	rId:rId
	        	    },
	        	    success: function(response){
	        	        var text = response.responseText;
	        	        if(text == 'false'){
	        	        	Ext.Msg.alert('温馨提示','数据源名称已存在，请重新输入！');
	        	        }else{
	        	        	form.submit({
		                      url: 'saveDbResource.do',
		                      mthod:'post',
		                     waitMsg: '正在保存请稍后......',
		                     success: function(form, action) {
		                        win.close();
		                        //Ext.Msg.alert('提示', '保存成功！');
		                        Ext.getCmp('dsgripd').store.load();
		                     },
		                     failure: function(form, action) {
		                     	win.close();
		                         Ext.Msg.alert('提示', '保存失败！');
		                     }
		                 });
	        	        }
	        	    }
	        	});
            }
    }
});