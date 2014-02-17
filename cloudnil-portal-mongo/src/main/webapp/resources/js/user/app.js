Ext.Loader.setConfig({enabled: true});
Ext.application({
    name: 'US',
    appFolder: ctx+'/resources/js/user/app',
    controllers: ['User'],
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
						xtype: 'userlist',
						region:'center'
					}
		       ]
        });
    }
});