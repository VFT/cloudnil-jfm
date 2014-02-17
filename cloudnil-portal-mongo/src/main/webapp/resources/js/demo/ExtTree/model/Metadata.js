Ext.define('METADATA.model.Metadata', {
	extend : 'Ext.data.Model',
	fields : [ {
		name : 'id',
		mapping : 'id'
	}, 'catalogId', 'metadataName', 'metadataMark', 'definition', 'parentId',
			'valueType', 'valueFormat', 'values', 'dataLength', 'precision',
			'isAllowModl', 'unitId', 'keyword', 'langIdenti', 'createTime',
			'startDate', 'regStatus', 'remark', 'submitOrg', 'managerOrg',
			'regOrg', 'regPerson', 'lastModifyTime', 'hiddenValueType',
			'hiddenRegStatus', 'hiddenCreateTime', 'hiddenRegOrg',
			'hiddenRegPerson', 'unitName', 'parentName', 'catalogName',
			'metadataBaseCodeList', 'metadataType', 'metadataTypeName' ]
});