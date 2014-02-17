/**
 * The application header displayed at the top of the viewport
 * @extends Ext.Component
 */
Ext.define('VENU.view.Header', {
    extend: 'Ext.panel.Panel',
    alias : 'widget.easyportalheader',
    requires : ['VENU.view.header.Toolbar'],
    collapsible: true,
    split: true,
    height: 65,
    minHeight: 60,
    bodyBorder:false,
    header:false,
    layout: {
        type: 'border',
        padding: 0
    },
    items: [ 
    {
        region: 'west',
        bodyStyle:"background-image:url('"+ctx+"/resources/images/header_left.png')",
        width:404,
        border: false,
        bodyBorder:false,
        header:false
    },
    {
        region: 'center',
        bodyStyle:"background-image:url('"+ctx+"/resources/images/header_mid.png')",
        width:'100%',
        border: false,
        bodyBorder:false,
        header:false
    },
    {
        title: '控制台',
        region: 'east',
        width:501,
        xtype:'headertoolbar',
        border: false,
        bodyBorder:false,
        header:false
    }]
});