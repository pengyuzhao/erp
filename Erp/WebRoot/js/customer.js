$(document).ready(function(){
	
	
	//修改
	$('#customerTable').datagrid({
		
		url:'/Erp/customer/customerAction_getCustomer',
		columns:[[
		          {field:'id',title:'编号',checkbox:true,width:'100',fixed:true},
		          {field:'name',title:'客户名称',width:'390',fixed:true},
		          {field:'address',title:'地址',width:'390',fixed:true},
		          {field:'phone',title:'电话',width:'150',fixed:true}
		         ]],
		fit:true,
		fitColumns:true,
		toolbar:'#manager_tool1',
		idField:'id',
		pagination:true,
		rownumbers:true,
		pageSize:15,
		pageList:[15,20,25,30,35]
		
	});
	
	$('#customer_add').dialog({
		title:'客服数据添加',
		width:300,
		height:200,
		modal:true,
		closed : true,
		buttons:[{
			text:'确认添加',
			handler:function(){
				var params = $('#customer_add input').serialize();
				if(!$('#cName').validatebox('isValid')){
					
					$('#cName').focus();
					
				}else if(!$('#cAddress').validatebox('isValid')){
					
					$('#cAddress').focus();
					
				}else if(!$('#cHone').validatebox('isValid')){
					
					$('#cHone').focus();
					
				}else{
					
					$.ajax({
						url:'/Erp/customer/customerAction_addCustomer',
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
								$('#customer_add').dialog('close');

								$('#customerTable').datagrid('loaded');
								$('#customerTable').datagrid('reload');
								
							}else{
								$.messager.progress('close');
								$.messager.alert('添加失败','未知错误，添加失败','warning');
								$('#customer_add').dialog('close');
							}
							$('#cName').val('');
							$('#cAddress').val('');
							$('#cHone').val('');
						}
					});
				}
				
			}
		}]
	});
	
	$('#customer_update').dialog({
		title:'客服数据修改',
		width:300,
		height:200,
		modal:true,
		closed : true,
		buttons:[{
			text:'确认修改',
			handler:function(){
				var params = $('#customer_update input').serialize();
				if(!$('#cName_update').validatebox('isValid')){
					
					$('#cName_update').focus();
					
				}else if(!$('#cAddress_update').validatebox('isValid')){
					
					$('#cAddress_update').focus();
					
				}else if(!$('#cHone_update').validatebox('isValid')){
					
					$('#cHone_update').focus();
					
				}else{
					
					$.ajax({
						url:'/Erp/customer/customerAction_updateCustomer',
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
								$('#customer_update').dialog('close');
								$('#customerTable').datagrid('loaded');
								$('#customerTable').datagrid('reload');
								$('#customerTable').datagrid('unselectAll');
							}else{
								$.messager.progress('close');
								$.messager.alert('修改失败','未知错误，修改失败','warning');
								$('#customer_update').dialog('close');
								
							}
							
						}
					});
				}
				
			}
		}]
	});
	
	//添加验证
	$('#cName').validatebox({
		required:true,
		missingMessage:'客户名字不能为空',
		
	});
	$('#cAddress').validatebox({
		required:true,
		missingMessage:'客户地址不能为空',
	});
	$('#cHone').validatebox({
		required:true,
		validType:'mobile',
		missingMessage:'客户手机不能为空',
		
	});
	
	$('#cName_update').validatebox({
		required:true,
		missingMessage:'客户名字不能为空',
		
	});
	$('#cAddress_update').validatebox({
		required:true,
		missingMessage:'客户地址不能为空',
	});
	$('#cHone_update').validatebox({
		required:true,
		validType:'mobile',
		missingMessage:'客户手机不能为空',
		
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
				$('#customer_add').dialog('open');
				
			},
			edit:function(){
				
				var rows = $('#customerTable').datagrid('getSelections');
				
				if(rows.length>1 || rows.length==0){
					$.messager.alert('警告','请只选择一条数据进行修改!','warning');
				}else{
					$('#customer_update').dialog('open');
					$('#cId_update').val(rows[0].id);
					$('#cName_update').val(rows[0].name);
					$('#cAddress_update').val(rows[0].address);
					$('#cHone_update').val(rows[0].phone);
				}
				
			},
			remove:function(){
				$.messager.confirm('确定','你确定想要删除该数据吗?',function(r){
		
					if(r){
						var rows = $('#customerTable').datagrid('getSelections');
						if(rows.length==0){
							
							$.messager.alert('警告','请选择你想要删除的数据!');
						}else{
							
							var ids=[];
							for(var i =0;i<rows.length;i++){
								ids.push(rows[i].id);
							}
							$.ajax({
								url:'/Erp/customer/customerAction_delCustomer',
								type:'post',
								data:{
									ids:ids.join(','),
								},
								beforeSend : function () {
									$('#customerTable').datagrid('loading');
								},
								success:function(data){
									$('#customerTable').datagrid('loaded');
									$('#customerTable').datagrid('reload');
									$('#customerTable').datagrid('unselectAll');
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
				$('#customerTable').datagrid('reload');
			},
			redo:function(){
				$('#customerTable').datagrid('unselectAll');
			},
	};
	
});

