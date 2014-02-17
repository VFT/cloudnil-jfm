Ext.define('DS.view.datasource.WinTree', {
	 extend: 'Ext.tree.Panel',
	 alias:'widget.winTree',
    title: '元数据分类',
    store:'WinTree',
    loadMask:'true',
    selModel:Ext.define('selModel',{
    	extend:'Ext.selection.Model',
    	mode:'SINGLE'
    }),
    split:true,
    autoScroll:true,
    collapsible: true, 
    autoShow:true
});