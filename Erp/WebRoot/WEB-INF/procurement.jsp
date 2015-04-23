<script type="text/javascript" src="../js/procurement.js"></script>
<link rel="stylesheet" type="text/css" href="../css/procurement.css" />
<table id="procureTable">


</table>
<div id="manager_tool2" style="padding:5px;">
	<div style="margin-bottom:5px;">
			<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="obj1.add();">添加订单</a>
			<a href="#" class="easyui-linkbutton" iconCls="icon-search" plain="true" onclick="obj1.query();">查看子订单</a> 
			<a href="#" class="easyui-linkbutton" iconCls="icon-cancel" plain="true" onclick="obj1.remove();">删除订单</a> 
			<a href="#" class="easyui-linkbutton" iconCls="icon-reload" plain="true" onclick="obj1.reload();">刷新页面</a> 
			<a href="#" class="easyui-linkbutton" iconCls="icon-redo" plain="true" onclick="obj1.redo();">取消选择</a>
	</div>
</div>

<div id="query_orderItems">
	<div class="orderItems_title">采购入库单</div>
	<div class="query_orderItems_content">
	<p>
		<label>订单号:</label><input type="text" readonly="readonly" id="query_orderFormId"/>
		<label>经手人:</label><input type="text" readonly="readonly" id="query_handler"/>
		<label>状态:</label><input type="text" readonly="readonly" id="query_state"/>
		<label>日期:</label><input type="text" readonly="readonly" id="query_orderFormDate"/>
	</p>
	<div>
		<table id="query_orderItems_table">
		</table>
	</div>
	</div>

</div>


<div id="orderItems">
	<div class="orderItems_title">采购入库单</div>
	<div class="orderItems_content">
		<p>
				<label>订单号:<input type="text" readonly="readonly" id="orderFormId" name="orderForm.id" /> </label>
				<label style="padding-left: 60px;">供应商:<input id="providers" type="text"/></label>
				<label style="padding-left: 60px;">采购员:<input type="text" id="buyer" name="orderForm.handler" /></label>
		</p>
		
			
		
	</div>
	<table id="orderItems_table">
		<tbody>

		</tbody>
	</table>

</div>

<div id="add_goods">

	<p>
			<label style="padding-left: 10px;">商品名称:<input type="text"
			id="goodsName" name="goodsId" /> </label> <label style="padding-left: 10px;">商品类型<input
			type="text" id="goodsType" /> </label>
	</p>
	<p>
		<label style="padding-left: 10px;">数量:<input type="text"
			id="goodsNum" name="orderItem.num" /> </label> <label
			style="padding-left: 55px;">价格:<input type="text"
			id="goodsPrice" name="orderItem.sum" /> </label>
	</p>
	<p>
		<label style="padding-left: 10px;">存放仓库:<input type="text"
			id="depot"/></label>
		
	</p>
	<p>
		<label style="vertical-align:top;padding-left: 10px;">备注:<textarea
			id="remarks" name="orderItem.remarks"></textarea> </label>
	</p>
</div>


