<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  <head>
    <title>My JSP 'login.jsp' starting page</title>
    
	
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="easyui/jquery.min.js"></script>
	<script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="easyui/locale/easyui-lang-zh_CN.js"></script>
	<script type="text/javascript" src="js/login.js"></script>
	<link rel="stylesheet" type="text/css" href="easyui/themes/default/easyui.css" />
	<link rel="stylesheet" type="text/css" href="easyui/themes/icon.css" />
	<link rel="stylesheet" type="text/css" href="css/login.css"/>
  </head>
  
  <body>
  	<div id="login">
  		<form action="/login/loginAction_login">
  		<p><label>登录名:<input type="text" id="user" name="admin.userName"/></label></p>
  		<p><label>密码:<input type="password" id="password" name="admin.password"/></label></p>
  		</form>
  	</div>
  	<div id="btn">
  	<a class="easyui-linkbutton">登陆</a>
  	</div>
  </body>
</html>
