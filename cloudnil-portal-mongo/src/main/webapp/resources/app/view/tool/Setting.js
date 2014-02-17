Ext.define('VENU.view.tool.Setting', {
    extend: 'Ext.window.Window',
    alias : 'widget.syssetting',

    title : '系统设置',
    layout: 'fit',
    autoShow: true,
    modal:true,
    initComponent: function() {
        this.items = [
            {
                xtype: 'form',
                padding:5,
                items: [
                    {
                        xtype: 'textfield',
                        name : 'password',
                        fieldLabel: '旧密码'
                    },
                    {
                        xtype: 'textfield',
                        name : 'password1',
                        fieldLabel: '新密码'
                    },
                    {
                        xtype: 'textfield',
                        name : 'password2',
                        fieldLabel: '确认密码'
                    }
                ]
            }
        ];

        this.buttons = [
            {
                text: '保存',
                action: 'save'
            },
            {
                text: '取消',
                scope: this,
                handler: this.close
            }
        ];

        this.callParent(arguments);
    }
});