$(document).ready(function(){
	
	var obj4 ={num:0,}
	$('#sellGoods').datagrid({
		url:'/Erp/sell/sellAction_getGoods',
		columns : [[{
			field : 'id',
			title : '编号',
			checkbox : true,
			width:100,
			fixed : true
		}, {
			field : 'name',
			title : '商品名称',
			width:300,
			fixed : true
		}, {
			field : 'type',
			title : '类型',
			width:300,
			fixed : true
		}, {
			field : 'num',
			title : '库存数量',
			width : 200,
			fixed : true
		}, {
			field : 'price',
			title : '单价',
			width : 200,
			fixed : true
		},
		]],
		pagination:true,
		pageNumber:1,
		pageSize:15,
		pageList:[15,20,25,30,35],
		toolbar:'#tb',
	});
	$('#buy').click(function(){
		var rows = $('#sellGoods').datagrid('getSelections');
		
		if(rows.length>1 || rows.length==0){
			$.messager.alert('警告','请只选择一条数据进行修改!','warning');
		}else{
			
			$('#sellGoodsId').val(rows[0].id);
			$('#sellGoodsName').val(rows[0].name);
			$('#sellSum').val(rows[0].price);
			$('#sellNum').numberspinner({
				min:1,
				value:1,
				max:rows[0].num,
				onChange:function(newValue,oldValue){
					$('#sellSum').val(rows[0].price*newValue);
				}
			});
			$('#sellForm').dialog('open');
		}
		
	});
	$('#sellForm').dialog({
		title:'购买信息',
		width:280,
		height:230,
		modal:true,
		closed:true,
		buttons:[{
			text:'确定购买',
			handler:function(){
				if($('#customer').combobox('isValid')){
					var param =	$('#sellForm input').serialize();
					$.ajax({
						url:'/Erp/sell/sellAction_addSellForm',
						type:'post',
						data:param,
						beforeSend:function(){
							$.messager.progress({
								text:'正在购买...',
							});
						},
						success:function(){
							$.messager.progress('close');
							$('#sellForm').dialog('close');
							$.messager.show({
								title:'提示',
								msg:'购买成功!',
							});
							$('#sellGoods').datagrid('reload');
						}
					});
				
				}
			}
		}],
	});
	$('#ss').searchbox({
		menu:'#mm',
		searcher:function(value,name){ 
			if(name=='name'){
				
				$('#sellGoods').datagrid('load',{
					
					name:value
				});
				
			}else if(name=='type'){

				$('#sellGoods').datagrid('load',{
					
					type:value
				});
			}
		}, 
	});
	$('#customer').combobox({
		url:'/Erp/procurement/procurementAction_getCustomer',
		valueField:'id',
		textField:'name',
		required:true,
	});
	
	
});