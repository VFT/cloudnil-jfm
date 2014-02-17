Ext.define('DS.store.DataSources', {
    extend: 'Ext.data.Store',
    
    pageSize: page_size,
    id:'dsStore',
    model: 'DS.model.DataSources',
    
    proxy : {
		// 异步获取数据，这里的URL可以改为任何动态页面，只要返回JSON数据即可
		type : 'ajax',
		api : {
			read : 'getDbResourceList.do',
			create : 'saveDataSource.do',
			update : 'saveDataSource.do',
			destroy : 'deleteDatasource.do'
		},
		reader : {
			type : 'json',
			root : 'rows',
			totalProperty : 'totalNum'
		}
	},
	autoLoad : true
});