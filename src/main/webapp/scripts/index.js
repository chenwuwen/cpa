//从Cookie获取userid
var userId = getCookie("uid");
// 从Cookie获取用户昵称
var Name = getCookie("name");
if (userId == null) {
	window.location.href = "/login.html";
}
$(document).ready(function() {
	$("p:eq(0)").html(Name);
	showUnitExam();
	})
