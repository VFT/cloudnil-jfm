Ext.Loader.setConfig({enabled: true});
Ext.Loader.setPath({  
    'Ext.ux' : 'resources/ext/ux',
    'Ext.app' : 'resources/ext/ux/portal'
});
Ext.require(['Ext.ux.TabCloseMenu','Ext.app.Portlet', 'Ext.app.PortalColumn', 'Ext.app.PortalPanel',  
             'Ext.app.PortalDropZone','Ext.app.GridPortlet', 'Ext.app.ChartPortlet']);

Ext.define('VENU.view.MainTab' ,{
    extend: 'Ext.tab.Panel',
    alias : 'widget.maintab',
    region: 'center',
    activeTab: 0,
    enableTabScroll:true,
    plugins: Ext.create('Ext.ux.TabCloseMenu',{  
        closeTabText: '关闭当前面板',  
        closeOthersTabsText: '关闭其他面板',  
        closeAllTabsText: '关闭所有面板'  
      }),
    //plain: true,
    items : [{  
          iconCls : 'icon_home_tab',  
          title : '首页',  
          xtype:'portalpanel',  
          layout:'column',  
          items : [{  
                  xtype : 'portalcolumn',  
                  columnWidth : 0.7,
                  items:[
                         	{
                         		title: '百度搜索',
                         		iconCls : 'icon_find',
                         		html : '<iframe frameborder="0" width="100%" height="100%" src="http://www.baidu.com/"></iframe>'
                        	} 
                        ]  
              },{  
                  xtype : 'portalcolumn',  
                  columnWidth : 0.3,
                  items:[
                         	{
                         		title: '财务报表', 
                         		height : 200, 
                         		//iconCls : 'icon-link',
                         		items: Ext.create('Ext.app.GridPortlet')
                         	},  
                         	{
                         		title: '销售分析',
                         		//iconCls : 'icon-note',
                         		items: Ext.create('Ext.app.ChartPortlet')
                         	}]  
              }]  
      }]
});