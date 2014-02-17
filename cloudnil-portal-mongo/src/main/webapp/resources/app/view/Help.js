/**
 * The application header displayed at the top of the viewport
 * @extends Ext.Component
 */
Ext.define('VENU.view.Help', {
    extend: 'Ext.panel.Panel',
    alias : 'widget.helppanel',
    region: 'east',
    collapsible: true,
    collapsed:true,
    split: true,
    width: 200,
    title: '帮助',
    
    initComponent: function() {
        Ext.applyIf(this, {
            html: '　　Easy Portal 是由北京天诚星源信息技术有限公司自主开发研制的内部开发产品，任何个人和单位未经同意，严禁盗用！谢谢合作！'
        });
        this.callParent(arguments);
    }
});