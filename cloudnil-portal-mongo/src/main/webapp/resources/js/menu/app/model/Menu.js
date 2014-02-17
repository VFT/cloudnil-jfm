Ext.define('MU.model.Menu', {
    extend: 'Ext.data.Model',
	fields : [
  		'id',
  		{name : 'text',mapping : 'text'},
  		'parentId',
  		'iconCls',
  		'expanded',
  		'leaf',
  		'url',
  		'type',
  		'isDisplay',
  		'displayIndex',
  		'comment',
  		'helpInfo',
  		'createTime'
  	]
});