Ext.define('VENU.view.AccordionPanel' ,{
    extend: 'Ext.panel.Panel',
    alias : 'widget.apppanel',
    border: true,
	region: 'west',
	title: '导航',
	width: 200,
	split: true,
	collapsible: true,
	layout: 'accordion',
	layoutConfig: {animate:true},
	autoScroll : false
});
