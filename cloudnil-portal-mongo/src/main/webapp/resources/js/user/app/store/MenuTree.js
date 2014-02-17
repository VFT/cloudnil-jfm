Ext.define('US.store.MenuTree', {
    extend: 'Ext.data.TreeStore',
    model:'US.model.MenuTree',
    proxy : {
		type : 'ajax',
		url : ctx+'/user/menuTree.do',
		reader:{
			type:'json'
		}
	},
	root: {
		id:Share.TREE_ROOT_ID,
		text: '全部',
		expanded: true,
		checked:false,
		iconCls:'icon_menu_33'
	},
	folderSort: true,
    sorters: [{
        property: 'displayIndex',
        direction: 'ASC'
    }]
});