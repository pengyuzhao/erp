
$(document).ready(function() {

	var depotId ; 
	var providerId ; 
	obj1={
		indexRow:undefined,
		add:function(){
			$('#orderFormId').val('');
			$('#buyer').val('');
			$('#providers').combobox('clear');
			$('#orderItems_table').datagrid('loadData', { total: 0, rows: [] }); 
			$('#orderItems').dialog('open'); //订单细节表 
			$.ajax({
				url:'/Erp/procurement/procurementAction_getOrderfromId',
				type:'post',
				success:function(data){
					
					if(data==""){
						$('#orderFormId').val(1);
					
					}else{
						$('#orderFormId').val(parseInt(data)+1);
					}
				}
			});
			
		},
		query:function(){
			var rows = $('#procureTable').datagrid('getSelections');
			if(rows.length==1){
			
				
				$('#query_orderItems').dialog('open');
				$('#query_orderFormId').val(rows[0].id);
				$('#query_handler').val(rows[0].handler);
				$('#query_orderFormDate').val(rows[0].orderDate);
				$('#query_state').val(rows[0].state);
				$('#query_orderItems_table').datagrid('load', {    
					orderformId:rows[0].id,
				}); 
				
			}else if(rows.length>1){
				
				$.messager.alert('警告','只能选择一条数据!','warning');
			}else if(rows.length==0){
				
				$.messager.alert('警告','请选择一条数据!','warning');
			}
		},
		reload:function(){
			$('#procureTable').datagrid('reload');
		},
		redo:function(){
			$('#procureTable').datagrid('unselectAll');
		},
		remove:function(){
			var rows = $('#procureTable').datagrid('getSelections');
			var ids =[];
			if(rows.length!=0){
				for(var i =0 ;i<rows.length;i++){
					ids.push(rows[i].id);
				}
				
			$.messager.confirm('删除订单','您确认想要删除记录吗?',function(f){
				if(f){
						$.ajax({
							url:'/Erp/procurement/procurementAction_delOrderForms',
							data:{
								ids:ids.join(',')
							},
							type:'post',
							success:function(){
								$.messager.show({
									title:'信息框',
									msg:'您成功删除了'+ids.length+"条数据!"
								});
								$('#procureTable').datagrid('reload');
							},
							
						});
					}
				});
				
			}
			
		},
		
	};
	$('#procureTable').datagrid({
		
		url:'/Erp/procurement/procurementAction_getOrderForms',
		fit : true,
		columns : [ [ {
			field : 'id',
			title : '编号',
			checkbox : true,
			width : '100',
			fixed : true,
			sortable:true,
			
		}, {
			field : 'orderDate',
			title : '订单时间',
			width : 350,
			fixed : true,
			sortable:true,
			
		}, {
			field : 'handler',
			title : '订单经手人',
			width : 350,
			fixed : true,
			sortable:true
		}, {
			field : 'state',
			title : '订单状态',
			width : 180,
			fixed : true,
			sortable:true,
			editor : {
				type : 'combobox',
				options : {
					valueField:'id',
					textField:'text',
					required : true,
					data:[{
						id:'等待',
						text:'等待'
					},{
						id:'完成',
						text:'完成'
					},{
						id:'取消',
						text:'取消'
					}],
					onSelect:function(){
						$('#procureTable').datagrid('endEdit', obj1.indexRow);
						
					}
				
				},
				
			},
		}, ] ],

		toolbar : '#manager_tool2',
		fit : true,
		fitColumns : true,
		rownumbers : true,
		onDblClickCell : function (rowIndex,field, rowData) {
	
			if(obj1.indexRow==undefined){
				$('#procureTable').datagrid('beginEdit', rowIndex);
				obj1.indexRow = rowIndex;
				
			
			}
			
			if(obj1.indexRow!=undefined){
				$('#procureTable').datagrid('endEdit', obj1.indexRow);
				$('#procureTable').datagrid('beginEdit', rowIndex);
				obj1.indexRow = rowIndex;
			}
			
		},

		onAfterEdit : function (rowIndex, rowData, changes) {
	
			var update = $('#procureTable').datagrid('getChanges', 'updated');
			if(update.length>0){
				rowData = 'orderForm.id='+ rowData.id+'&orderForm.handler='+ rowData.handler
				+'&orderDate='+rowData.orderDate+'&orderForm.state='+rowData.state;
				$.ajax({
					url:'/Erp/procurement/procurementAction_updateOrderForms',
					type:'post',
					data:rowData,
					beforeSend : function () {
						$('#procureTable').datagrid('loading');
					},
					success : function () {
					
							$('#procureTable').datagrid('loaded');
							$('#procureTable').datagrid('load');
							$('#procureTable').datagrid('unselectAll');
							$.messager.show({
								title : '提示',
								msg :  '修改成功！',
							});
						obj1.indexRow = undefined;
						}
					});
			}
		},
		
		
	});

	
	// 订单窗口
	$('#orderItems').dialog({

		width : 900,
		height : 450,
		title : '采购入单',
		modal : true,
		maximizable : true,
		closed :true,
		rasizable : true,
		draggable : true,
	});
	//订单细节窗口
	$('#query_orderItems').dialog({
		width:900,
		height:450,
		title:'订单查询',
		modal:true,
		maximizable : true,
		closed :true,
		rasizable : true,
		draggable : true,
	});
	// 时间控件
	$('#orderDate').datetimebox({
		required:true,
	})
	// 下拉框
	$('#providers').combobox({
		
		url:'/Erp/procurement/procurementAction_getProvider',
		valueField:'id',
		textField:'name',
		required:true,
		onSelect :function(){
			providerId =$('#providers').combobox('getValue');
		}
	});

	$('#depot').combobox({
		
		url:'/Erp/procurement/procurementAction_getDepot',
		valueField:'id',
		textField:'name',
		required:true,
		onSelect :function(){
			depotId = $('#depot').combobox('getValue');
		}
	});

	$('#query_orderItems_table').datagrid({
		url:'/Erp/procurement/procurementAction_queryOrderForm',
		columns : [ [ {
			field : 'id',
			title : '编号',
			checkbox : true,
			width:100,
			fixed : true
		}, {
			field : 'goodsName',
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
			title : '数量',
			width:100,
			fixed : true
		
			
		}, {
			field : 'sum',
			title : '金额',
			width : 180,
			fixed : true
		},{
			field : 'remark',
			title : '备注',
			width:200,
			fixed : true
		},
		]],
		
	});
	$('#orderItems_table').datagrid({

		url:'',
		columns : [ [ {
			field : 'id',
			title : '编号',
			checkbox : true,
			width:100,
			fixed : true
		}, {
			field : 'goodsName',
			title : '商品名称',
			width:200,
			fixed : true
		}, {
			field : 'type',
			title : '类型',
			width:100,
			fixed : true
		}, {
			field : 'number',
			title : '数量',
			width:100,
			fixed : true
		}, {
			field : 'price',
			title : '金额',
			width : 180,
			fixed : true
		},{
			field : 'remark',
			title : '备注',
			width:200,
			fixed : true
		},
		
		] ],

		toolbar : [ {
			text : '添加',
			iconCls : 'icon-add',
			handler : function() {
				if(!$('#providers').combobox('isValid')){
					
					$('#providers').focus();
					
				}else if(!$('#buyer').validatebox('isValid')){
					
					$('#buyer').focus();
				}else{
					
						
					$('#goodsName').combobox('clear');
					$('#goodsType').val('');
					$('#goodsPrice').val('');
					$('#goodsNum').numberbox('setValue',1);
					$('#goodsPrice').val('');
					$('#depot').combobox('clear');
					$('#add_goods').dialog('open');
						var params = $('.orderItems_content p label input[type="text"]').serialize();
						//ajax生成订单
						$.ajax({
							url:'/Erp/procurement/procurementAction_addOrderForm',
							type:'post',
							data:params,
							success:function(data){
								$('#orderFormId').val(data);
								$('#goodsName').combobox('reload',
								'/Erp/procurement/procurementAction_getGoods?providerId='+providerId);  //加载下拉框的信息	
							
							}
						});
				}
		}
		}, '-', {
			text : '删除',
			iconCls : 'icon-cancel',
			handler : function() {
			
				
				var rows = $('#orderItems_table').datagrid('getSelections');
				var ids =[];
				var indexs=[];
				 if(rows.length==0){
					$.messager.alert('警告','请选择您要删除的一条数据!','warning');
					
				}else{
					
					$.messager.confirm('确定框','您确定要删除此数据吗?',function(f){
						if(f){
							for(var i=0;i<rows.length;i++){
								
								ids.push(rows[i].id);
								indexs.push($('#orderItems_table').datagrid('getRowIndex',rows[i]));
							}
							$.ajax({
								url:'/Erp/procurement/procurementAction_delOrderItems',
								type:'post',
								data:{
									ids:ids.join(',')
								},
								beforeSend:function(){
									$('#orderItems_table').datagrid('loading');
								},
								success:function(){
									
									$.messager.show({
										title:'信息框',
										msg:'您成功删除了'+ids.length+'条数据',
									});
									$('#orderItems_table').datagrid('loaded');
									for(var i = 0; i<indexs.length;i++){
										$('#orderItems_table').datagrid('deleteRow',indexs[i]);
									}
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

		fitColumns : true,
		pagination : true,
		rownumbers : true,
		pageSize : 15,
		pageList : [ 15, 20, 25, 30, 35 ]

	});
	
	$('#add_goods').dialog({
		width:480,
		height:300,
		title:'订单商品选择',
		modal:true,
		resizable:false,
		draggable:false,
		closed : true,
		buttons:[{
			text:'确定添加',
			handler:function(){
							
				//添加入订单细节表
				var param = $('#add_goods input').serialize();
				param=param+"&depotId="+depotId+"&orderItem.remarks="+$('#remarks').val()+"&orderformId="+$('#orderFormId').val();
				
				if(!$('#goodsName').combobox('isValid')){
					
					$('#goodsName').focus();
				}else if(!$('#depot').combobox('isValid')){
					
					$('#depot').focus();
				}else{
					$.ajax({
						url:'/Erp/procurement/procurementAction_addOrderFormItem',
						data:param,
						type:'post',
						beforeSend:function(){
							$.messager.progress({
								text:'正在添加'
							});
						},
						success:function(data){
							
							$.messager.progress('close');
							$('#add_goods').dialog('close');
							$.messager.show({
								title:'信息框',
								msg:'添加成功!',
							});
							$('#procureTable').datagrid('reload');
							$('#orderItems_table').datagrid('appendRow',{	
								id: data,
								goodsName :$('#goodsName').combobox('getText'),
								type : $('#goodsType').val(),
								number :$('#goodsNum').val(),
								price :$('#goodsPrice').val(),
								remark:$('#remarks').val()
							});
							
						}
						
					});
				}
				
				
			}
		}]
	});	
	

	
	var price = 0 ;
	$('#goodsName').combobox({
	
		valueField:'id',
		textField:'name',
		required:true,
		onSelect:function(){
		$('#goodsId').val($('#goodsName').combobox('getValue'));
			$.ajax({
				url:'/Erp/procurement/procurementAction_getGoodsInfo',
				type:'post',
				data:{
					goodsId:$('#goodsName').combobox('getValue')
				},
				success:function(data){
							
					$.each(data,function(index,value){
						price =value.price;
						$('#goodsPrice').val(value.price);//赋值
						$('#goodsType').val(value.type);
					});
				}
				
			});
		}
		
	});
		
	
	$('#orderDate').validatebox({
		required:true,
	});
	$('#providers').validatebox({
		required:true,
	});
	$('#buyer').validatebox({
		required:true,
	});
	$('#goodsNum').numberspinner({
		value:1,
		min:1,
		onChange:function(newValue,oldValue){
			$('#goodsPrice').val(price*newValue);
		}
	});
	
});