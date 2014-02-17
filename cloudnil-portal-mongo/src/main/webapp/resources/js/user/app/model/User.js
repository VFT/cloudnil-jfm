Ext.define('US.model.User', {
    extend: 'Ext.data.Model',
	fields : [
  		'id',
  		{name : 'userName',mapping : 'userName'},
  		'password',
  		'code',
  		'cnName',
  		'enName',
  		'state',
  		'displayIndex',
  		'age',
  		'sex',
  		'email',
  		'mobPhone',
  		'createTime',
  		'org.id',
  		'org.cnName'
  	]
});