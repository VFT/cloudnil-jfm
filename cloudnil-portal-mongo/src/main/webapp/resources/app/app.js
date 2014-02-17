Ext.Loader.setConfig({enabled: true});
Ext.application({
    name: 'VENU',
    autoCreateViewport: true,
    appFolder: ctx+'/resources/app',
    controllers: [
        'Portal'
    ]
});

