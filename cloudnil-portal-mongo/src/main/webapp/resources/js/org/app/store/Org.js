Ext.define('OR.store.Org', {
    extend: 'Ext.data.Store',
    pageSize: Share.PAGE_SIZE,
    model: 'OR.model.Org',
    autoLoad : true,
	proxy: {
        type: 'ajax',
        api: {
            read: ctx+'/org/orgList.do'
        },
        reader: {
            type: 'json',
            root: 'rows',
            totalProperty: 'totalNum'
        }
    },
    remoteSort : true,
    sorters: [{
        property: 'level',
        direction: 'ASC'
    },{
        property: 'displayIndex',
        direction: 'ASC'
    }]
});