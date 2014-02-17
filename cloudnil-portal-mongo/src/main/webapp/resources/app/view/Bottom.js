/**
 * The application header displayed at the top of the viewport
 * @extends Ext.Component
 */
Ext.define('VENU.view.Bottom', {
    extend: 'Ext.Component',
    alias : 'widget.easyportalbottom',
    region: 'south',
    baseCls: 'app-bottom',
    dockedItems: [{
        xtype: 'toolbar',
        dock: 'bottom',
        style: 'background:transparent;',
        items: ['->',{  
                		text : '设置',  
                		iconCls : 'icon_key',
                		action: 'setting'
                	},'-',{  
                		text : '退出',  
                		iconCls : 'icon_logout',
                		action: 'exit'
                	}
               ]
    }],
    initComponent: function() {
        Ext.applyIf(this, {
            html: '<div style="float: left;">欢迎您，'+userName+'&nbsp;&nbsp;&nbsp;&nbsp;'+Ext.Date.format(new Date(),'Y年m月d日')+'</div><div style="float: right;">北京天诚星源信息技术有限公司 版权所有 Copyright © 2011-2012 cloudnil.com</div>'
        });
        this.callParent(arguments);
    }
});