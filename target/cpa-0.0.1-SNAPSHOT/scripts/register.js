$(function () {
    $("input:eq(0)").blur(function () {
        // alert("我失去焦点了！");
        // swal('我失去焦点了!');
        var User_Name = $("input:eq(0)").val().trim();
        if (User_Name != "") {
            $.ajax({
                url: "user/checkname.do",
                type: "post",
                data: {
                    "username": User_Name
                },
                dataType: "json",
                success: function (result) {
                    if (result.status == 2) {
                        swal({
                            title: '当前用户已存在!',
                            text: '2秒后将自动关闭窗口',
                            timer: 2000,
                            type:'warning'
                        });
                        $("input:eq(0)").val("");
                    }
                },
                error: function () {
                    swal('错误', '当前请求出错!', 'error' );
                }
            })
        }
    });
    $("#to_register").click(function () {
        var User_Name = $("input:eq(0)").val().trim();
        var v_code = $("input:eq(3)").val().trim();
        var Password = $("input:eq(1)").val().trim();
        var repeat_Password = $("input:eq(2)").val().trim();
        if (Password != repeat_Password) {
            swal({
                title: '两次密码输入不一致!',
                text: '2秒后将自动关闭窗口',
                timer: 2000
            });
            $("input:eq(1)").val("");
            $("input:eq(2)").val("");
            return;
        }
        $.ajax({
            url: "user/register.do",
            data: {
                "username": User_Name,
                "password": Password,
                "v_code": v_code
            },
            type: "POST",
            dataType: "json",
            success: function (result) {
                if (result.status == 1) {
                    swal({
                        title:'注册成功!',
                        text:'2秒后自动跳转到登陆页面!',
                        type:'success',
                        timer: 2000,
                        showConfirmButton:false
                    });
                    setTimeout(function () {
                        window.location.href = "./login.html";
                    },2000)

                } else {
                    var msg = result.msg;
                    swal({
                        title: msg,
                        text: '2秒后将自动关闭窗口',
                        timer: 2000
                    });
                }
            },
            error: function () {
                swal({
                    title: '错误',
                    text: '当前请求出错！！！!',
                    type: 'error',
                    timer: 2000
                });
            }
        })
    });
})
