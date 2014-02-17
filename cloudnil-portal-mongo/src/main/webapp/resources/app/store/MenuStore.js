Ext.define('VENU.store.MenuStore', {
	extend : 'Ext.data.TreeStore',
	autoLoad: true,
	baseParams:{
		appId:'1'
	},
	root : {
		text : 'MenuRoot',
		id : 'root',
		expanded : true
	}

});