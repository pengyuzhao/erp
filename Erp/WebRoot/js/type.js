$(document).ready(function(){
	obj5={
			add:function(){
				$('#type_add').dialog('open');
				
			},
			edit:function(){
				
				var rows = $('#typeTable').datagrid('getSelections');
				
				if(rows.length>1 || rows.length==0){
					$.messager.alert('警告','请只选择一条数据进行修改!','warning');
				}else{
					$('#type_update').dialog('open');
					$('#typeId_update').val(rows[0].id);
					$('#typeName_update').val(rows[0].name);

				}
				
			},
			remove:function(){
				$.messager.confirm('确定','你确定想要删除该数据吗?',function(r){
		
					if(r){
						var rows = $('#typeTable').datagrid('getSelections');
						if(rows.length==0){
							
							$.messager.alert('警告','请选择你想要删除的数据!');
						}else{
							
							var ids=[];
							for(var i =0;i<rows.length;i++){
								ids.push(rows[i].id);
							}
							$.ajax({
								url:'/Erp/type/typeAction_delType',
								type:'post',
								data:{
									ids:ids.join(','),
								},
								beforeSend : function () {
									$('#typeTable').datagrid('loading');
								},
								success:function(data){
									$('#typeTable').datagrid('loaded');
									$('#typeTable').datagrid('reload');
									$('#typeTable').datagrid('unselectAll');
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
				$('#typeTable').datagrid('reload');
			},
			redo:function(){
				$('#typeTable').datagrid('unselectAll');
			},
	};
	
	$('#typeTable').datagrid({
		url:'/Erp/type/typeAction_getType',
		columns : [[{
			field : 'id',
			checkbox : true,
			fixed : true
		},{
			field : 'name',
			title : '商品类型名称',
			width:300,
			fixed : true
		}
		]],
		pagination:true,
		pageNumber:1,
		pageSize:15,
		rownumbers : true,
		pageList:[15,20,25,30,35],
		toolbar:'#manager_tool5',
	});
	$('#type_add').dialog({
		width:300,
		height:120,
		title:'类型添加',
		closed:true,
		modal:true,
		buttons:[{
			text:'确定添加',
			handler:function(){
				if($('#typeName').validatebox('isValid')){
					var param =$('#type_add input').serialize();
					$.ajax({
						url:'/Erp/type/typeAction_addType',
						data:param,
						type:'post',
						beforeSend:function(){
							$.messager.progress({
								title:'提示',
								msg:'正在添加...',
							});
						},
						success:function(){
							$.messager.progress('close');
							$("#type_add").dialog('close');
							$('#typeTable').datagrid('reload');
							$.messager.show({
								title:'提示',
								msg:'添加成功！'
							});
							$('#typeName').val('');
						}
					});
				}
			}
		}],
	});
	
	
	$('#type_update').dialog({
		width:300,
		height:120,
		title:'类型修改',
		closed:true,
		modal:true,
		buttons:[{
			text:'确定添加',
			handler:function(){
				if($('#typeName_update').validatebox('isValid')){
					var param =$('#type_update input').serialize();
					$.ajax({
						url:'/Erp/type/typeAction_updateType',
						type:'post',
						data:param,
						beforeSend:function(){
							$.messager.progress({
								title:'提示',
								msg:'正在修改...',
							});
						},
						success:function(){
							$.messager.progress('close');
							$("#type_update").dialog('close');
							$('#typeTable').datagrid('reload');
							$.messager.show({
								title:'提示',
								msg:'修改成功！'
							});
							
						}
					});
				}
			}
		}],
	});
	$('#typeName').validatebox({
		required:true,
	});
	$('#typeName_update').validatebox({
		required:true,
	});
});