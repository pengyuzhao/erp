<script type="text/javascript" src="../js/provider.js"></script>
<link rel="stylesheet" type="text/css" href="../css/provider.css" />
<table id="providerTable">

</table>


<div id="manager_tool" style="padding:5px;">
	<div style="margin-bottom:5px;">
		<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="obj.add();">添加</a>
		<a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="obj.edit();">修改</a>
		<a href="#" class="easyui-linkbutton" iconCls="icon-cancel" plain="true" onclick="obj.remove();">删除</a>
		<a href="#" class="easyui-linkbutton" iconCls="icon-reload" plain="true"  onclick="obj.reload();">刷新</a>
		<a href="#" class="easyui-linkbutton" iconCls="icon-redo" plain="true" onclick="obj.redo();">取消选择</a>		
		<input type="text" id="textbox" name="user" style="width:210px;">
		
	</div>
</div>

<div id="provider_update">
	<input type="hidden" id="pId_update" name="pro.id"/>
	<p><label>供应商名称:<input type="text" id="pName_update" name="pro.name"/></label></p>
	<p><label>供应商地址:<input type="text" id="pAddress_update" name="pro.address"/></label></p>
	<p><label>供应商电话:<input type="text" id="pHone_update" name="pro.phone"/></label></p>
</div>

<div id="provider_add">
<form>
	<p><label>供应商名称:<input type="text" id="pName" name="pro.name"/></label></p>
	<p><label>供应商地址:<input type="text" id="pAddress" name="pro.address"/></label></p>
	<p><label>供应商电话:<input type="text" id="pHone" name="pro.phone"/></label></p>
</form>
</div>



<div id="menu">
		<div data-options="name:'all'">全部</div>
		<div data-options="name:'id'">编号</div>
		<div data-options="name:'pName'">名称</div>
</div>


