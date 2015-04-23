$(document).ready(function(){
	

	$('#tabs').tabs({
		
		fit:true,
		border : false,
	});
	
	$('#nav').tree({
		url:'/Erp/index/indexAction_getNav',
		lines : true,
		onClick:function(node){
			
			var _this = this;
			if($('#nav').tree('isLeaf',node.target)){
				if(!$('#tabs').tabs('exists',node.text)){
				$('#tabs').tabs('add',{
					title:node.text,
					fit:true,
					border:false,
					closable:true,
					href:node.url
				});
				}else{
					$('#tabs').tabs('select', node.text);
				}
			}
		}
	});
});