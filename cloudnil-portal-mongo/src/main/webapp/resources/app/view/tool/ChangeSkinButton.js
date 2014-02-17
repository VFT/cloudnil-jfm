Ext.define('VENU.view.tool.ChangeSkinButton', {
	extend: 'Ext.button.Cycle',
	alias : 'widget.changeskinbutton',
	showText: true,
	menu:{id: 'view-type-menu',
		items:[
	                    	          {file: 'ext-all.css', text: '蓝色月影 ',checked:true,  iconCls: 'icon-blue-theme'},  
	                    	          {file: 'ext-all-gray.css', text: '灰色回忆 ', iconCls: 'icon-gray-theme'},  
	                    	          {file: 'xtheme-slate.css', text: '深蓝心情 ', iconCls: 'icon-blue-theme'},  
	                    	          {file: 'xtheme-black.css', text: '黑色物语 ', iconCls: 'icon-blue-theme'},  
	                    	          {file: 'xtheme-olive.css', text: '绿色芳香 ', iconCls: 'icon-blue-theme'},  
	                    	          {file: 'xtheme-purple.css', text: '诱惑紫色 ', iconCls: 'icon-blue-theme'}  
	                    	      ]},  
	      themeVar:'style',  
	      headVar: 'head',  
	      //cssPath是你放css的位置，这个路径要是弄错了，神仙也出不来的  
	      cssPath:ctx+'/resources/ext/resources/css/',  
	      initComponent: function() {
	          if(Ext.state.Manager){
	              var selectedTheme = Ext.state.Manager.get(this.themeVar);   
	              if(selectedTheme){
	                  for(var i=0; i<this.items.length;i++){
	                      if (this.items[i].file == selectedTheme){  
	                          this.items[i].checked = true;  
	                          this.changeHandler(this, this.items[i]);  
	                          break;  
	                      }
	                  }
	              }
	          }
	          this.callParent(arguments);  
	    },
	      changeHandler: function(o, i){  
	          if(Ext.state.Manager.getProvider()) {  
	              Ext.state.Manager.set(this.themeVar, i.file);  
	              Ext.state.Manager.set(this.headVar, i.head);  
	          }  
	          Ext.util.CSS.swapStyleSheet(this.themeVar, this.cssPath + i.file);  
	          Ext.util.CSS.getRule('.x-panel-body', true).style.background = 'url(' + i.head + ')';  
	          if(Ext.getCmp('viewport')){  
	              Ext.getCmp('viewport').layout.center.panel.setSize(Ext.getCmp('viewport').layout.center.getSize().width + 1);  
	              Ext.getCmp('viewport').doLayout();  
	              Ext.getCmp('viewport').layout.center.panel.setSize(Ext.getCmp('viewport').layout.center.getSize().width - 1);  
	              Ext.getCmp('viewport').doLayout();  
	          }  
	    
	      } 
});