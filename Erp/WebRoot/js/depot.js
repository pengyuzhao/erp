$(document).ready(function(){
	

	 obj3={
			depotId:'',
			add:function(){
				$('#depot_add').dialog('open');
			},	
			manager:function(){
				var rows = $('#depotTable').datagrid('getSelections');
				if(rows.length>1 || rows.length==0){
					$.messager.alert('警告','只能选择一条数据进行查看!','warning');
				}else{

					obj3.depotId=rows[0].id,
					$('#depot_goods').dialog('open');		
					
					$('#depotGoodsTable').datagrid('load',{
						
						depotId:rows[0].id,
					});
				}
			},
			edit:function(){
				var rows = $('#depotTable').datagrid('getSelections');
				if(rows.length>1 || rows.length==0){
					$.messager.alert('警告','请只选择一条数据进行修改!','warning');
				}else{
					$('#depot_update').dialog('open');
					$('#dId_update').val(rows[0].id);
					$('#dName_update').val(rows[0].name);
					$('#dAddress_update').val(rows[0].address);
					$('#dManager_update').val(rows[0].manager);
				}
			},	
			remove:function(){
				$.messager.confirm('确定','你确定想要删除该数据吗?',function(r){
					
					if(r){
						var rows = $('#depotTable').datagrid('getSelections');
						if(rows.length==0){
							
							$.messager.alert('警告','请选择你想要删除的数据!');
						}else{
							
							var ids=[];
							for(var i =0;i<rows.length;i++){
								ids.push(rows[i].id);
							}
							$.ajax({
								url:'/Erp/depot/depotAction_delDepots',
								type:'post',
								data:{
									ids:ids.join(','),
								},
								beforeSend : function () {
									$('#depotTable').datagrid('loading');
								},
								success:function(data){
									$('#depotTable').datagrid('loaded');
									$('#depotTable').datagrid('reload');
									$('#depotTable').datagrid('unselectAll');
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
				$('#depotTable').datagrid('reload');
			},
			redo:function(){
				$('#depotTable').datagrid('unselectAll');
			},	
	};
	
	$('#depotTable').datagrid({
		
		url:'/Erp/depot/depotAction_getDepots',
		columns:[[
		          {
		        	  field:'id',
		        	  title:'编号',
		        	  checkbox:true,
		        	  fit:true,
		        	 
		        	  
		          },
		          {
		        	  field:'name',
		        	  title:'仓库名称',
		        	  fit:true,
		        	  width:350
		          },
		          {
		        	  field:'address',
		        	  title:'仓库地址',
		        	  fit:true,
		        	  width:350
		          },
		          {
		        	  field:'manager',
		        	  title:'仓库管理员',
		        	  fit:true,
		        	  width:200
		          }
		        
		          ]],
		          pagination:true,
		          pageNumber:1,
		          pageSize:15,
		          pageList:[15,20,25,30,35],
		          toolbar:'#manager_tool3'
		          		
	});
	
	$('#depot_add').dialog({
		width:300,
		height:200,
		modal:true,
		closed:true,
		title:'仓库添加',
		buttons:[{
			text:'确定添加',
			handler:function(){
				var params = $('#depot_add input').serialize();
				if(!$('#dName').validatebox('isValid')){
					
					$('#dName').focus();
					
				}else if(!$('#dAddress').validatebox('isValid')){
					
					$('#dAddress').focus();
					
				}else if(!$('#dManager').validatebox('isValid')){
					
					$('#dManager').focus();
					
				}else{
					
					$.ajax({
						url:'/Erp/depot/depotAction_addDepot',
						data:params,
						type:'post',
						beforeSend:function(){
							$.messager.progress({
								text:'正在添加,请稍后...',
							});
						},
						success:function(data){
						
								$.messager.progress('close');
								$.messager.show({
									title:'提示',
									msg:'添加成功!',
								});
								$('#depot_add').dialog('close');
								$('#depotTable').datagrid('loaded');
								$('#depotTable').datagrid('reload');
								$('#dName').val('');
								$('#dAddress').val('');
								$('#dManager').val('');
						}
					});
				}
				
			}
		}],
		
	});
	
	$('#depot_update').dialog({
		width:300,
		height:200,
		modal:true,
		closed:true,
		title:'仓库修改',
		buttons:[{
			text:'确认修改',
			handler:function(){
				var params = $('#depot_update input').serialize();
				if(!$('#dName_update').validatebox('isValid')){
					
					$('#dName_update').focus();
					
				}else if(!$('#dAddress_update').validatebox('isValid')){
					
					$('#dAddress_update').focus();
					
				}else if(!$('#dManager_update').validatebox('isValid')){
					
					$('#dManager_update').focus();
					
				}else{
					
					$.ajax({
						url:'/Erp/depot/depotAction_updateDepot',
						data:params,
						type:'post',
						beforeSend:function(){
							$.messager.progress({
								text:'正在修改,请稍后...',
							});
						},
						success:function(data){
						
								$.messager.progress('close');
								$.messager.show({
									title:'提示',
									msg:'修改成功!',
								});
								$('#depot_update').dialog('close');
								$('#depotTable').datagrid('loaded');
								$('#depotTable').datagrid('reload');
								$('#depotTable').datagrid('unselectAll');
							
							
						}
					});
				}
				
			}
		}]
		
	});
	$('#depot_goods').dialog({
		width:800,
		height:500,
		modal:true,
		closed:true,
		title:'仓库商品管理',
		
	});
	
	$('#depot_update_goods').dialog({
		width:300,
		height:225,
		modal:true,
		closed:true,
		title:'商品修改',
		buttons:[{
			text:'确定修改',
			handler:function(){
				if(!$('#depot_update_goodsName').validatebox('isValid')){
					
					$('#depot_update_goodsName').focus();
				}else if(!$('#depot_update_goodsType').combobox('isValid')){
					
					
				}else if(!$('#depot_update_goodsPrice').validatebox('isValid')){
					
					$('#depot_update_goodsPrice').focus();
				}else{
				 //添加	
					var param = $('#depot_update_goods input').serialize();
					$.ajax({
						url:'/Erp/depotGoods/depotGoodsAction_updateDepotGoods',
						type:'post',
						data:param+'&dg.id='+$('#depot_update_goodsId').val(),
						beforeSend:function(){
							$.messager.progress({
								msg:'正在添加...',
							});
						},
						success:function(){
							$.messager.progress('close');
							$.messager.show({
								title:'提示',
								msg:'添加成功！',
							});
							$('#depot_update_goods').dialog('close');
							$('#depot_update_goodsType').val('');
							$('#depot_update_goodsName').val('');
							$('#depot_update_goodsPrice').val('');	
							$('#depot_update_goodsType').combobox('clear');	
							$('#depotGoodsTable').datagrid('reload');
						},
						error:function(){
							$.messager.alert('提示','未知原因,添加失败!','warning');
						}
					});
				}
			}
		}]
		
		
		
	});
	$('#depot_add_goods').dialog({
		width:300,
		height:225,
		modal:true,
		closed:true,
		title:'商品添加',
		buttons:[{
			text:'确定添加',
			handler:function(){
				if(!$('#depot_goodsName').validatebox('isValid')){
					
					$('#depot_goodsName').focus();
				}else if(!$('#depot_goodsType').combobox('isValid')){
					
					
				}else if(!$('#depot_goodsPrice').validatebox('isValid')){
					
					$('#depot_goodsPrice').focus();
				}else{
				 //添加	
					var param = $('#depot_add_goods input').serialize();
					$.ajax({
						url:'/Erp/depotGoods/depotGoodsAction_addDepotGoods',
						type:'post',
						data:param+'&depotId='+obj3.depotId,
						beforeSend:function(){
							$.messager.progress({
								msg:'正在添加...',
							});
						},
						success:function(){
							$.messager.progress('close');
							$.messager.show({
								title:'提示',
								msg:'添加成功！',
							});
							$('#depot_add_goods').dialog('close');
							$('#depot_goodsType').val('');
							$('#depot_goodsName').val('');
							$('#depot_goodsPrice').val('');	
							$('#depot_goodsType').combobox('clear');	
							$('#depotGoodsTable').datagrid('reload');
						},
						error:function(){
							$.messager.alert('提示','未知原因,添加失败!','warning');
						}
					});
				}
			}
		}]
		
	});
	
	$('#depotGoodsTable').datagrid({
	
		url:'/Erp/depotGoods/depotGoodsAction_getDepotGoods',
		columns : [[{
			field : 'id',
			title : '编号',
			checkbox : true,
			width:100,
			fixed : true
		}, {
			field : 'name',
			title : '商品名称',
			width:200,
			fixed : true
		}, {
			field : 'type',
			title : '类型',
			width:100,
			fixed : true
		}, {
			field : 'num',
			title : '库存数量',
			width:100,
			fixed : true
		}, {
			field : 'price',
			title : '单价',
			width : 100,
			fixed : true
		},
		{
			field : 'depot',
			title : '所存仓库名称',
			width : 180,
			fixed : true
		}
		
		]],
		toolbar:[ {
			text : '添加商品',
			iconCls : 'icon-add',
			handler : function() {
		
				$('#depot_add_goods').dialog('open');
			}
		}, '-', {
			text : '修改商品',
			iconCls : 'icon-edit',
			handler : function() {
			
				var rows = $('#depotGoodsTable').datagrid('getSelections');
				if(rows.length>1 || rows.length==0){
					$.messager.alert('警告','请只选择一条数据进行修改!','warning');
				}else{
			
					$('#depot_update_goodsId').val(rows[0].id);
					$('#depot_update_goodsNum').val(rows[0].num);
					$('#depot_update_goodsPrice').numberbox('setValue',rows[0].price);
					$('#depot_update_goodsName').val(rows[0].name);
					$('#depot_update_goods').dialog('open');
				}
			}
		}, '-', {
			text : '商品转仓',
			iconCls : 'icon-large-smartart',
			handler : function() {
				
				
					var rows = $('#depotGoodsTable').datagrid('getSelections');
					if(rows.length>1 || rows.length==0){
						$.messager.alert('警告','请只选择一条数据进行修改!','warning');
					}else{
						$('#depot_goods_depot').combobox({
							url:'/Erp/procurement/procurementAction_getDepot',
							valueField:'id',
							textField:'name',
							required:true,
						});
						$('#update_depot').dialog('open');
						$('#update_depot_goodsId').val(rows[0].id);
					}
			}
		},'-', {
			text : '删除商品',
			iconCls : 'icon-cancel',
			handler : function() {
				var rows = $('#depotGoodsTable').datagrid('getSelections');
				var ids=[];
				if(rows==0){
					$.messager.alert('提示','请选择数据','warning');
				}else{
					$.messager.confirm('提示','您确定要删除此数据吗?',function(r){
						
						if(r){
							for(var i =0;i<rows.length;i++){
								ids.push(rows[i].id)
							}
							$.ajax({
								url:'/Erp/depotGoods/depotGoodsAction_delGoods',
								type:'post',
								data:{
									ids:ids.join(',')
								},
								beforeSend:function(){
									$.messager.progress({
										title:'提示',
										msg:'正在删除...',
									});
								},
								success:function(){
									$.messager.progress('close');
								
									$('#depotGoodsTable').datagrid('reload');
									$.messager.show({
										title:'提示',
										msg:'删除成功！'
									});
								}
							});
						}
					});
				}
			}
		}, '-', {
			text : '刷新',
			iconCls : 'icon-reload',
			handler : function() {
				$('#orderItems_table').datagrid('reload');
			}
		}, '-', {
			text : '取消选择',
			iconCls : 'icon-redo',
			handler : function() {
				$('#orderItems_table').datagrid('unselectAll');
			}
		}

		],
		pagination:true,
		pageNumber:1,
		pageSize:15,
		pageList:[15,20,25,30,35],
	});
	$("#update_depot").dialog({
		width:300,
		height:130,
		title:'更改仓库',
		closed:true,
		buttons:[{
			text:'确定迁移',
			handler:function(){
				if($('#depot_goods_depot').combobox('isValid')){
					var param = $('#update_depot_goodsId').serialize()+'&depotId='+$('#depot_goods_depot').combobox('getValue');
					$.ajax({
						url:'/Erp/depotGoods/depotGoodsAction_updateDepot',
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
							$("#update_depot").dialog('close');
							$('#depotGoodsTable').datagrid('reload');
							$.messager.show({
								title:'提示',
								msg:'迁移成功！'
							});
						}
					});
				}
				
			}
		}]
	});
	
	$('#depot_goods_depot').combobox({
		url:'/Erp/procurement/procurementAction_getDepot',
		valueField:'id',
		textField:'name',
		required:true,
	});
	$('#depot_goodsType').combobox({
		url:'/Erp/procurement/procurementAction_getType',
		valueField:'id',
		textField:'name',
		required:true,
		
	});
	$('#depot_goodsName').validatebox({
		
		required:true,
	});	
	
	$('#depot_goodsPrice').numberbox({
		min:0, 
		precision:2,
		required:true,
	});	
	
	$('#depot_goodsNum').numberspinner({
		min:1, 
		value:0,
		required:true,
	
	});	
	
	
	$('#depot_update_goodsType').combobox({
		url:'/Erp/procurement/procurementAction_getType',
		valueField:'id',
		textField:'name',
		required:true,
		
	});
	$('#depot_update_goodsName').validatebox({
		
		required:true,
	});	
	
	$('#depot_update_goodsPrice').numberbox({
		min:0, 
		precision:2,
		required:true,
	});	
	
	$('#depot_update_goodsNum').numberspinner({
		min:1, 
		value:0,
		required:true,
	
	});	
	
	//添加验证
	$('#dName').validatebox({
		required:true,
		missingMessage:'仓库名称不能为空',
		
	});
	$('#dAddress').validatebox({
		required:true,
		missingMessage:'仓库地址不能为空',
	});
	$('#dManager').validatebox({
		required:true,
		missingMessage:'仓库管理员不能为空',
		
	});
	
	$('#dName_update').validatebox({
		required:true,
		missingMessage:'仓库名称不能为空',
		
	});
	$('#dAddress_update').validatebox({
		required:true,
		missingMessage:'仓库地址不能为空',
	});
	$('#dManager_update').validatebox({
		required:true,
		missingMessage:'仓库管理员不能为空',
		
	});

});