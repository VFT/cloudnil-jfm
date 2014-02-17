Ext.Loader.setConfig({enabled: true});
Ext.application({
    name: 'OR',
    appFolder: ctx+'/resources/js/org/app',
    controllers: ['Org'],
    launch: function() {
        Ext.create('Ext.container.Viewport', {
        	layout:'border',
        	items:[
					{
						xtype: 'orgtree',
						height: 400,
						width: 200,
						region:'west'
					},
					{
						xtype: 'orglist',
						region:'center'
					}
		       ]
        });
    }
});