Ext.define('VENU.view.Viewport', {
	extend : 'Ext.Viewport',
	requires : [ 'VENU.view.AccordionPanel', 'VENU.view.Header',
			'VENU.view.Help', 'VENU.view.MainTab', 'VENU.view.Bottom'],
	layout : 'border',
	items : [ {
		xtype : 'apppanel',
		region : 'west'
	}, {
		xtype : 'easyportalheader',
		region : 'north'
	}, {
		xtype : 'helppanel',
		region : 'east'
	}, {
		xtype : 'maintab',
		region : 'center'
	}, {
		xtype : 'easyportalbottom',
		region : 'south'
	} ]
});