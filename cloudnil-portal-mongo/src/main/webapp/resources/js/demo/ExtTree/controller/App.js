//设置自动加载
Ext.Loader.setConfig({
	enabled : true
});

//创建application实例
Ext.application({
	//设置命名空间
	name : 'METADATA',
	//设置指点配置项相应的路径
	appFolder : '../resources/js/demo/ExtTree',
	//设置发射器
	launch : function() {
		Ext.create('Ext.container.Viewport', {
			layout : 'border',
			//将Student视图渲染到Viewport中
			items : [ {
				xtype : 'Tree',
				height : 400,
				width : 200,
				region : 'west'
			}, {
				xtype : 'MetadataList',
				region : 'center'
			} ]
		});
	},
	//设置控制器文件
	controllers : [ 'Metadata' ]

});