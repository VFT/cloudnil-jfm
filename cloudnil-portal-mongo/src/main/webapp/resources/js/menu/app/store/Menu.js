Ext.define('MU.store.Menu', {
    extend: 'Ext.data.Store',
    pageSize: Share.PAGE_SIZE,
    model: 'MU.model.Menu',
    autoLoad : true,
    remoteFilter:true,
	proxy: {
        type: 'ajax',
        api: {
            read: ctx+'/menu/menuList.do'
        },
        reader: {
            type: 'json',
            root: 'rows',
            totalProperty: 'totalNum'
        }
    },
    remoteSort:true,
    sorters: [{
        property: 'displayIndex',
        direction: 'ASC'
    }]
});