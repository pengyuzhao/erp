<script type="text/javascript" src="../js/customer.js"></script>
<link rel="stylesheet" type="text/css"  href="../css/customer.css"/>
<table id="customerTable">

</table>
<div id="manager_tool1" style="padding:5px;">
	<div style="margin-bottom:5px;">
		<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="obj.add();">添加</a>
		<a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="obj.edit();">修改</a>
		<a href="#" class="easyui-linkbutton" iconCls="icon-cancel" plain="true" onclick="obj.remove();">删除</a>
		<a href="#" class="easyui-linkbutton" iconCls="icon-reload" plain="true"  onclick="obj.reload();">刷新</a>
		<a href="#" class="easyui-linkbutton" iconCls="icon-redo" plain="true" onclick="obj.redo();">取消选择</a>		
	</div>
</div>

<div id="customer_update">
	<input type="hidden" id="cId_update" name="cus.id"/>
	<p><label>顾客名称:<input type="text" id="cName_update" name="cus.name"/></label></p>
	<p><label>顾客地址:<input type="text" id="cAddress_update" name="cus.address"/></label></p>
	<p><label>顾客电话:<input type="text" id="cHone_update" name="cus.phone"/></label></p>
</div>
<div id="customer_add">
	<p><label>顾客名称:<input type="text" id="cName" name="cus.name"/></label></p>
	<p><label>顾客地址:<input type="text" id="cAddress" name="cus.address"/></label></p>
	<p><label>顾客电话:<input type="text" id="cHone" name="cus.phone"/></label></p>
</div>