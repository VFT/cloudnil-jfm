Ext.define('DS.model.DataSources', {
    extend: 'Ext.data.Model',
	fields : [
  		// 第一个字段需要指定mapping，其他字段，可以省略掉。
  		'id',
  		{name : 'dbName',mapping : 'dbName'},
  		'rName',
  		'dbType',
  		'connectType',
  		'jndi',
  		'username',
  		'password',
  		'driver',
  		'para',
  		'createTime',
  		'url',
  		'describe',
  		]
});