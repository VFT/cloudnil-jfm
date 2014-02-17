Ext.define('METADATA.view.Tree', {
	extend : 'Ext.tree.Panel',
	alias : 'widget.Tree',
	title : '元数据分类',
	store : 'Tree',
	id : 'tree',
	loadMask : 'true',
	selModel : Ext.define('selModel', {
		extend : 'Ext.selection.Model',
		mode : 'SINGLE'
	}),
	split : true,
	autoScroll : true,
	collapsible : true,
	autoShow : true,
	checkModel: 'cascade',   //对树的级联多选
	onlyLeafCheckable: false,//对树所有结点都可选
	listeners : {
		checkchange :  function(node, checked) {
			node.expand();  
		}
	}
});