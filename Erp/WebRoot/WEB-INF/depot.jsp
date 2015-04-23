<script type="text/javascript" src="../js/depot.js"></script>
<link rel="stylesheet" type="text/css"  href="../css/depot.css"/>
<table id="depotTable">
</table>
<div id="manager_tool3" style="padding:5px;">
	<div style="margin-bottom:5px;">
		<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="obj3.add();">添加</a>
		<a href="#" class="easyui-linkbutton" iconCls="icon-search" plain="true" onclick="obj3.manager();">管理商品</a>
		<a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="obj3.edit();">修改</a>
		<a href="#" class="easyui-linkbutton" iconCls="icon-cancel" plain="true" onclick="obj3.remove();">删除</a>
		<a href="#" class="easyui-linkbutton" iconCls="icon-reload" plain="true"  onclick="obj3.reload();">刷新</a>
		<a href="#" class="easyui-linkbutton" iconCls="icon-redo" plain="true" onclick="obj3.redo();">取消选择</a>		
	</div>
</div>
<div id="depot_goods">
<input type="hidden" id="depot_goods_depotId"/>
<p class="depotGoods_title"><label >仓库商品管理</label></p>
<table id="depotGoodsTable">

</table>
</div>

<div id="depot_update">
	<input type="hidden" id="dId_update" name="depot.id"/>
	<p><label>仓库名称:<input type="text" id="dName_update" name="depot.name"/></label></p>
	<p><label>仓库地址:<input type="text" id="dAddress_update" name="depot.address"/></label></p>
	<p><label>仓库管理员:<input type="text" id="dManager_update" name="depot.manager"/></label></p>
</div>

<div id="depot_add">
	<p><label>仓库名称:<input type="text" id="dName" name="depot.name"/></label></p>
	<p><label>仓库地址:<input type="text" id="dAddress" name="depot.address"/></label></p>
	<p><label>仓库管理员:<input type="text" id="dManager" name="depot.manager"/></label></p>
</div>

<div id="depot_add_goods">

	<p>
	<label style="padding-left: 10px;">商品名称:<input type="text" id="depot_goodsName" name="dg.name"/> </label>
	</p>
	<p>		
	 <label style="padding-left: 10px;">商品类型:<input type="text" id="depot_goodsType" name="typeId" /> </label>
	</p>
	<p>
		<label style="padding-left: 10px;">数量:<input type="text" id="depot_goodsNum"  name="dg.num"/> </label> 
	</p>
	<p>
		<label style="padding-left: 10px;">价格:<input type="text" id="depot_goodsPrice"  name="dg.price"/> </label>
	</p>
</div>

<div id="depot_update_goods">
	
	<input type="hidden" id="depot_update_goodsId"/>
	<p>
	<label style="padding-left: 10px;">商品名称:<input type="text" id="depot_update_goodsName" name="dg.name"/> </label>
	</p>
	<p>		
	 <label style="padding-left: 10px;">商品类型:<input type="text" id="depot_update_goodsType" name="typeId" /> </label>
	</p>
	<p>
		<label style="padding-left: 10px;">数量:<input type="text" id="depot_update_goodsNum"  name="dg.num"/> </label> 
	</p>
	<p>
		<label style="padding-left: 10px;">价格:<input type="text" id="depot_update_goodsPrice"  name="dg.price"/> </label>
	</p>
</div>

<div id="update_depot">
<input type="hidden" id="update_depot_goodsId" name="goodsId"/>
<p><label style="padding-left: 10px;">迁移仓库名称:</label><input type="text" id="depot_goods_depot"/></p>
</div>
