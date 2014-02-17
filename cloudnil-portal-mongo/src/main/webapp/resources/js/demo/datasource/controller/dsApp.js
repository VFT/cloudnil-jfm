Ext.Loader.setConfig({enabled: true});
Ext.application({
    name: 'DS',
    appFolder: '../resources/js/demo/datasource',
    controllers: [
          'DataSources'
    ],
    launch: function() {
        Ext.create('Ext.container.Viewport', {
            layout: 'fit',
            items:{
            		xtype: 'datasourcelist'
                }
        });
    }
});