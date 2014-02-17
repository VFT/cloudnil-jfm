Ext.define('OR.model.Org', {
    extend: 'Ext.data.Model',
	fields : [
  		'id',
  		{name : 'cnName',mapping : 'cnName'},
  		'enName',
  		'code',
  		'parentId',
  		'level',
  		'type',
  		'state',
  		'displayIndex',
  		'createTime'
  	]
});