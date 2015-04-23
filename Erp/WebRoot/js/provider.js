$(document).ready(function(){
	
	
	//修改
	
	
			
	$('#providerTable').datagrid({
		
		url:'/Erp/provider/providerAction_getProvider',
		columns:[[
		          {field:'id',title:'编号',checkbox:true,width:'100',fixed:true},
		          {field:'name',title:'供应商名称',width:'390',fixed:true},
		          {field:'address',title:'地址',width:'390',fixed:true},
		          {field:'phone',title:'电话',width:'150',fixed:true}
		         ]],
		fit:true,
		fitColumns:true,
		toolbar:'#manager_tool',
		idField:'id',
		pagination:true,
		rownumbers:true,
		pageSize:15,
		pageList:[15,20,25,30,35]
		
	});
	
	$('#textbox').searchbox({
		searcher:function(value,name){
			
			alert(value+" "+name);
		},
		menu:'#menu'
	});
	//供应商添加
	$('#provider_add').dialog({
		title:'供应商数据添加',
		width:300,
		height:200,

		modal:true,
		closed : true,
		buttons:[{
			text:'确认添加',
			handler:function(){
				var params = $('#provider_add input').serialize();
				if(!$('#pName').validatebox('isValid')){
					
					$('#pName').focus();
					
				}else if(!$('#pAddress').validatebox('isValid')){
					
					$('#pAddress').focus();
					
				}else if(!$('#pHone').validatebox('isValid')){
					
					$('#pHone').focus();
					
				}else{
					
					$.ajax({
						url:'/Erp/provider/providerAction_addProvider',
						data:params,
						type:'post',
						beforeSend:function(){
							$.messager.progress({
								text:'正在添加,请稍后...',
							});
						},
						success:function(data){
							if(data==1){
								$.messager.progress('close');
								$.messager.show({
									title:'提示',
									msg:'添加成功!',
							});
								$('#provider_add').dialog('close');

								$('#providerTable').datagrid('loaded');
								$('#providerTable').datagrid('reload');
								
							}else{
								$.messager.progress('close');
								$.messager.alert('添加失败','未知错误，添加失败','warning');
								$('#provider_add').dialog('close');
							}
							$('#pName').val('');
							$('#pAddress').val('');
							$('#pHone').val('');
						}
					});
				}
				
			}
		}]
	});
	$('#provider_update').dialog({
		title:'供应商数据修改',
		width:300,
		height:200,
		modal:true,
		closed : true,
		buttons:[{
			text:'确认修改',
			handler:function(){
				var params = $('#provider_update input').serialize();
				if(!$('#pName_update').validatebox('isValid')){
					
					$('#pName_update').focus();
					
				}else if(!$('#pAddress_update').validatebox('isValid')){
					
					$('#pAddress_update').focus();
					
				}else if(!$('#pHone_update').validatebox('isValid')){
					
					$('#pHone_update').focus();
					
				}else{
					
					$.ajax({
						url:'/Erp/provider/providerAction_updateProvider',
						data:params,
						type:'post',
						beforeSend:function(){
							$.messager.progress({
								text:'正在修改,请稍后...',
							});
						},
						success:function(data){
							if(data==1){
								$.messager.progress('close');
								$.messager.show({
									title:'提示',
									msg:'修改成功!',
							});
								$('#provider_update').dialog('close');
								$('#providerTable').datagrid('loaded');
								$('#providerTable').datagrid('reload');
								$('#providerTable').datagrid('unselectAll');
							}else{
								$.messager.progress('close');
								$.messager.alert('修改失败','未知错误，修改失败','warning');
								$('#provider_update').dialog('close');
								
							}
							
						}
					});
				}
				
			}
		}]
	});
	
	//添加验证
	$('#pName').validatebox({
		required:true,
		missingMessage:'供应商名字不能为空',
		
	});
	$('#pAddress').validatebox({
		required:true,
		missingMessage:'供应商地址不能为空',
	});
	$('#pHone').validatebox({
		required:true,
		validType:'mobile',
		missingMessage:'供应商手机不能为空',
		
	});
	
	$('#pName_update').validatebox({
		required:true,
		missingMessage:'供应商名字不能为空',
		
	});
	$('#pAddress_update').validatebox({
		required:true,
		missingMessage:'供应商地址不能为空',
	});
	$('#pHone_update').validatebox({
		required:true,
		validType:'mobile',
		missingMessage:'供应商手机不能为空',
		
	});
	$.extend($.fn.validatebox.defaults.rules, {     
        mobile : {     
             validator: function(value){     
                 return /^1[0-9]{10}$/i.test($.trim(value));     
             },     
             message: '手机号码格式错误.'    
         }     
     });  
	
	obj={
			add:function(){
				$('#provider_add').dialog('open');
				
			},
			edit:function(){
				
				var rows = $('#providerTable').datagrid('getSelections');
				
				if(rows.length>1 || rows.length==0){
					$.messager.alert('警告','请只选择一条数据进行修改!','warning');
				}else{
					$('#provider_update').dialog('open');
					$('#pId_update').val(rows[0].id);
					$('#pName_update').val(rows[0].name);
					$('#pAddress_update').val(rows[0].address);
					$('#pHone_update').val(rows[0].phone);
				}
				
			},
			remove:function(){
				$.messager.confirm('确定','你确定想要删除该数据吗?',function(r){
		
					if(r){
						var rows = $('#providerTable').datagrid('getSelections');
						if(rows.length==0){
							
							$.messager.alert('警告','请选择你想要删除的数据!');
						}else{
							
							var ids=[];
							for(var i =0;i<rows.length;i++){
								ids.push(rows[i].id);
							}
							$.ajax({
								url:'/Erp/provider/providerAction_delProvider',
								type:'post',
								data:{
									ids:ids.join(','),
								},
								beforeSend : function () {
									$('#providerTable').datagrid('loading');
								},
								success:function(data){
									$('#providerTable').datagrid('loaded');
									$('#providerTable').datagrid('reload');
									$('#providerTable').datagrid('unselectAll');
									$.messager.show({
											title:'提示',
											msg:'你已成功删除'+ids.length+'数据',
									});
								},
								error:function(){
									$.messager.alert('警告操作', '未知操作或无任何修改，请重新提交！', 'warning');
								}
								
								
								
							});
						}
					}
				});
				
				
			},
			reload:function(){
				$('#providerTable').datagrid('reload');
			},
			redo:function(){
				$('#providerTable').datagrid('unselectAll');
			},
	};
});

