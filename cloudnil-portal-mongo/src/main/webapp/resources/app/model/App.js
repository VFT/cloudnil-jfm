Ext.define('VENU.model.App', {
    extend: 'Ext.data.Model',
    fields: [
        { name: 'id', mapping: 'id' },
        'text',
        'iconCls',
        'url',
        'leaf',
        'expanded'
    ]
});