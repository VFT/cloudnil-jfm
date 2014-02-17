Ext.define('MU.store.MenuTree', {
    extend: 'Ext.data.TreeStore',
    model:'MU.model.MenuTree',
    proxy : {
		type : 'ajax',
		url : ctx+'/menu/menuTree.do',
		reader:{
			type:'json'
		}
	},
	root: {
		id:Share.TREE_ROOT_ID,
		text: '全部',
		expanded: true,
		iconCls:'icon_menu_33'
	},
	folderSort: true,
    sorters: [{
        property: 'displayIndex',
        direction: 'ASC'
    }]
});