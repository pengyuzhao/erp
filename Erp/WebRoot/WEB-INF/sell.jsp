<table id="sellGoods">

</table>
<div id="tb">
<input type="text" id="ss"></input>
<div id="mm" style="width:220px"> 
	<div data-options="name:'name'">商品名称</div> 
	<div data-options="name:'type'">类型名称</div> 
</div> 
<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true" style="padding-left: 10px;"  id="buy">购买</a>
</div>
<div id="sellForm">
	<input type="hidden" id="sellGoodsId" name="goodsId"/>
	<p><label>客户:</label><input type="text" id="customer" name="customerId"/></p>
	<p><label>商品名称:</label><input type="text" id="sellGoodsName" readonly="readonly"/></p>
	<p><label>数量:</label><input type="text" id="sellNum" name="sellForm.num"/></p>
	<p><label>总价:</label><input type="text" id="sellSum" readonly="readonly" name="sellForm.sum"/></p>
</div>
<script type="text/javascript" src="../js/sell.js"></script>