Ext.define('US.view.Tree', {
	extend: 'Ext.tree.Panel',
	alias:'widget.orgtree',
    title:'组织机构树',
    id:'tree',
    store:'OrgTree',
    loadMask:'true',
    split:true,
    autoScroll:true,
    collapsible: true,
    useArrows: true
});