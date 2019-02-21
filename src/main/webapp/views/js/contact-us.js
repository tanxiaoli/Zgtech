$(function(){
	
	/**表单获取焦点时去除提醒**/
	$("#input>input").focus(function(){
		$(this).val("")	
	})
	$("#input>textarea").focus(function(){
		$(this).val("")	
	})
	
	
	/**表移除取焦点时显示提醒**/
	$("#input-name").blur(function(){
		$(this).val("呢称")
	})
	$("#input-tel").blur(function(){
		$(this).val("联系方式")
		})
	$("#input-ver").blur(function(){
		$(this).val("验证码")	
		})
	$("#submit").blur(function(){
		$(this).val("提交")	
	})
	$("textarea").blur(function(){
		$(this).val("您的宝贵意见")	
	})
	
	
	
	
})
