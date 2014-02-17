Ext.Loader.setConfig({enabled: true});
Ext.application({
    name: 'MU',
    appFolder: ctx+'/resources/js/menu/app',
    controllers: ['Menu'],
    launch: function() {
        Ext.create('Ext.container.Viewport', {
        	layout:'border',
        	items:[
					{
						xtype: 'menutree',
						height: 400,
						width: 200,
						region:'west'
					},{
						xtype: 'menulist',
						region:'center'
					}
		       ]
        });
    }
});