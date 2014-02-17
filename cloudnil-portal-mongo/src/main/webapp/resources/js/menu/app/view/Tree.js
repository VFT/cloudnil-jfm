Ext.define('MU.view.Tree', {
	extend: 'Ext.tree.Panel',
	alias:'widget.menutree',
    title:'菜单树',
    id:'tree',
    store:'MenuTree',
    loadMask:'true',
    split:true,
    autoScroll:true,
    collapsible: true,
    useArrows: true
});