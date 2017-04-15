//点击图片更换验证码（jquery方式）	
$(function(){
		$("#changecode").click(function(){	
			/*alert("sdfsdf");*/
			$(this).attr("src","code.do?id="+Math.random())
		})
	})
//点击图片更换验证码（js方式，需要在页面添加点击时间 onclick="f1(this)"）		
/* 
 * function f1(obj){
		obj.src="code.do?id="+Math.random();
		*/
	