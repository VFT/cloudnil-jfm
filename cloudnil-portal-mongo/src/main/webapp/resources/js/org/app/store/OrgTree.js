Ext.define('OR.store.OrgTree', {
    extend: 'Ext.data.TreeStore',
    model:'OR.model.OrgTree',
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
        property: 'level',
        direction: 'ASC'
    },{
        property: 'displayIndex',
        direction: 'ASC'
    }]
});