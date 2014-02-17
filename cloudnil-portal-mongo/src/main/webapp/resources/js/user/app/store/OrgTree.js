Ext.define('US.store.OrgTree', {
    extend: 'Ext.data.TreeStore',
    model:'US.model.OrgTree',
    proxy : {
		type : 'ajax',
		url : ctx+'/org/orgTree.do',
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