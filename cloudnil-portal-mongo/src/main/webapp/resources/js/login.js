Ext.onReady(function() {
	Ext.ns("Ext.VF.login"); // 自定义一个命名空间
	login = Ext.VF.login; // 定义命名空间的别名
	login = {
	     login: "login.do",
	     main: "main.jsp"
	};
    var formPanel = Ext.widget('form', {
        renderTo: 'login-win-div',
        frame: true,
        width: 300,
        bodyPadding: 10,
        bodyBorder: true,
        title: '欢迎光临',
        defaults: {
            anchor: '98%'
        },
        fieldDefaults: {
            labelAlign: 'center',
            msgTarget: 'none',
            invalidCls: ''
        },
        items: [{
            xtype: 'textfield',
            id:'userName',
            name: 'userName',
            fieldLabel: '帐号',
            allowBlank: false,
            anchor: '98%',
            minLength: 1,
            value:'mongo',
            listeners: {
                specialKey: function (field, e) {
                    if (e.getKey() == Ext.EventObject.ENTER) {
                        Ext.getCmp("login-button").handler();
                    }
                }
            }
        }, new Ext.form.TextField({
            inputType: 'password',
            id: 'password',
            name: 'password',
            fieldLabel: '密码',
            anchor: '98%',
            value:'1',
            allowBlank: false,
            minLength: 1,
            maxLength: 32,
            listeners: {
                specialKey: function (field, e) {
                    if (e.getKey() == Ext.EventObject.ENTER) {
                        Ext.getCmp("login-button").handler();
                    }
                }
            }
        })],
        buttons: [{
            text: '重置',
            handler: function() {
                this.up('form').getForm().reset();
            }
        },{
            text: '登录',
            id:'login-button',
            formBind: true,
            disabled: true,
            handler: function() {
                var form = this.up('form').getForm();
                if (form.isValid()) {
                	Share.waiting.start();
                    form.submit({
                    	url: login.login,
                        success: function(form, action) {
                        	Share.waiting.stop();
                        	location.href = login.main;
                        },
                        failure: function(form, action) {
                            Ext.Msg.alert('温馨提示', action.result.msg);
                        }
                    });
                }
            }
        }
        ]
    });
});