Ext.define('VENU.store.AppStore', {
    extend: 'Ext.data.Store',
    model: 'VENU.model.App',
    autoLoad: true,
    proxy : {
        type : 'ajax',
        api : {
            read : ctx+'/apps.do'
        },
        reader : {
            type : 'json',
            root : ''
        }
    }
});