<table id="typeTable">

</table>
<div id="manager_tool5" style="padding:5px;">
	<div style="margin-bottom:5px;">
		<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="obj5.add();">添加</a>
		<a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="obj5.edit();">修改</a>
		<a href="#" class="easyui-linkbutton" iconCls="icon-cancel" plain="true" onclick="obj5.remove();">删除</a>
		<a href="#" class="easyui-linkbutton" iconCls="icon-reload" plain="true"  onclick="obj5.reload();">刷新</a>
		<a href="#" class="easyui-linkbutton" iconCls="icon-redo" plain="true" onclick="obj5.redo();">取消选择</a>		
	</div>
</div>

<div id="type_update">
	<input type="hidden" id="typeId_update" name="t.id"/>
	<p><label>类型名称:<input type="text" id="typeName_update" name="t.name"/></label></p>
</div>

<div id="type_add">
	<p><label>类型名称:<input type="text" id="typeName" name="t.name"/></label></p>
</div>

 <script type="text/javascript" src="../js/type.js"></script>