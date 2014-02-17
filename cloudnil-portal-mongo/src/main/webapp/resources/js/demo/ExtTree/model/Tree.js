Ext.define('METADATA.model.Tree', {
	extend : 'Ext.data.Model',
	fields : [
	// 第一个字段需要指定mapping，其他字段，可以省略掉。
	'id', {
		name : 'text',
		mapping : 'text'
	},'categoryMark', 'categoryShortMark', 'categoryParentId', 'isMainData',
			'categoryDescription' ]
});