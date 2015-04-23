$(document).ready(function(){

	$('#login').dialog({
		
		width:300,
		height:180,
		title:'登陆窗口',
		modal:true,
		draggable:false,
		buttons:'#btn',
		iconCls:'icon-login',
	});
	
	$('#user').validatebox({
		
		required:true,
		validType:'length[5,15]',
		missingMessage : '请填写登录名',
		invalidMessage:'登陆名位数必须5~15位',
		
	});
	
	$('#password').validatebox({
		
		required:true,
		validType:'length[5,15]',
		missingMessage : '请填写密码',
		invalidMessage : '密码位数必须5~15位',
	});
	
	if(!$('#user').validatebox('isValid')){
		
		$('#user').focus();
		
	}else if(!$('#password').validatebox('isValid')){
		
		$('#password').focus();
	}
	
	$('#btn a').click(function(){
		
		if(!$('#user').validatebox('isValid')){
			
			$('#user').focus();
			
		}else if(!$('#password').validatebox('isValid')){
			
			$('#password').focus();
			
		}else{
			
			
			var params=$("input").serialize();
		
			$.ajax({
				url:'login/loginAction_login',
				type:'post',
				data:params,
				beforeSend:function(){
					
					$.messager.progress({
						text:'正在尝试登陆...'
					});
				},
				success:function(data){
					if(data>0){
						$.messager.progress('close');
						window.location.replace('login/loginAction_goToIndex');
					
					}else{
						$.messager.progress('close');
						$.messager.alert('登陆失败!','密码或者登陆名错误...','warning', function () {
							
							$('#password').select();
						});
					}
				}
				
				
				
			});
		}
	});
});