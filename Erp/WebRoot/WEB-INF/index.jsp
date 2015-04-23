<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  <head>
    <title>My JSP 'login.jsp' starting page</title>
    
	
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="../easyui/jquery.min.js"></script>
	<script type="text/javascript" src="../easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="../easyui/locale/easyui-lang-zh_CN.js"></script>
	<script type="text/javascript" src="../js/index.js"></script>
	
	<link rel="stylesheet" type="text/css" href="../easyui/themes/default/easyui.css" />
	<link rel="stylesheet" type="text/css" href="../easyui/themes/icon.css" />
	<link rel="stylesheet" type="text/css" href="../css/index.css" />
	
  </head>
  
  <body class="easyui-layout">   
    <div data-options="region:'north'" style="height:100px;background-color: #666">
    <div class="title">
    	进销存管理系统
    </div>
    <div class="welcome">欢迎<label>admin</label>登陆 | <a href="#">注销</a></div>
    </div>   
    <div data-options="region:'west' ,title:'导航', iconCls:'icon-tip'" style="width:200px;">
    <ul id="nav">
    </ul>
    </div>   
    <div data-options="region:'center'" style="padding:5px;background:#eee;">
    <div id="tabs">
    <div title="起始页" >
    	欢迎使用进销存管理系统
    </div>
    </div>
    </div>   
    <div data-options="region:'south',title:'footer',split:false,noheader:true" style="height:35px;line-height:30px;text-align:center;">
	&copy;2009-2015 ERP作业. Powered by jsp and EasyUI.
	</div>    
</body> 
</html>
