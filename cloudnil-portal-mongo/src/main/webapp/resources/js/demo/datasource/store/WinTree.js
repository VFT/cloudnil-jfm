Ext.define('DS.store.WinTree', {
    extend: 'Ext.data.TreeStore',
    alias:'widget.WinTree',
    model:'DS.model.WinTree',
    proxy : {
		// 异步获取数据，这里的URL可以改为任何动态页面，只要返回JSON数据即可
		type : 'ajax',
		url : '../categoryManager/findCategoryTree.do',
		reader:{
			type:'json'
		}
	},
	root:{
		id:null,
		text:'全部'
	}
});