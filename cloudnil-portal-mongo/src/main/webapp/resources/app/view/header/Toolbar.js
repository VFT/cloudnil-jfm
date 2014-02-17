Ext.define('VENU.view.header.Toolbar', {
    extend: 'Ext.panel.Panel',
    alias : 'widget.headertoolbar',
//    requires : [ 'VENU.view.tool.ChangeSkinButton'],
    collapsible: false,
    floatable: false,
    width: 501,
    height:65,
    title: 'East',
    border: false,
    bodyBorder:false,
    header:false,
    bodyStyle:"background-image:url('"+ctx+"/resources/images/header_right.png');",
    width:501,
//    layout: {
//        type: 'hbox',
//        padding: 5,
//        align:'top'
//    },
    items: [{
        xtype: 'toolbar',
        height:26,
        style: "background: transparent !important;",
        items: ['->',{  
                		text : '设置',  
                		iconCls : 'icon_key',
                		action: 'setting'
                	},{  
                		text : '退出',  
                		iconCls : 'icon_logout',
                		action: 'exit'
                	}
               ]
    }]
});