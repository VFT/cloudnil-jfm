Ext.define('US.store.User', {
    extend: 'Ext.data.Store',
    pageSize: Share.PAGE_SIZE,
    model: 'US.model.User',
    autoLoad : true,
	proxy: {
        type: 'ajax',
        api: {
            read: ctx+'/user/userList.do'
        },
        reader: {
            type: 'json',
            root: 'rows',
            totalProperty: 'totalNum'
        }
    },
    remoteSort : true,
    sorters: [{
        property: 'displayIndex',
        direction: 'ASC'
    }]
});