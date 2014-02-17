Ext.define('US.model.MenuTree', {
    extend: 'Ext.data.Model',
    fields: ['id',
        { name: 'text', type: 'string',mapping : 'text'},
        'iconCls',
        'url',
        'leaf',
        'expanded',
        'checked'
    ]
});