Ext.define('VENU.model.MenuNode', {
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