$(function () {
    $("#to_login").click(function () {
        var v_code = $("input:eq(2)").val().trim();
        var User_Name = $("input:eq(0)").val().trim();
        var Password = $("input:eq(1)").val().trim();
        /*判断"记住我是否勾选"*/
        var remember_me = 0;
        if ($("#brand").is(':checked')) {
            remember_me = 168;//表示小时
        }
        var ok = true;
        if (v_code == "") {
            ok = false
        }
        ;
        if (User_Name == "") {
            ok = false
        }
        ;
        if (Password == "") {
            ok = false
        }
        ;
        if (ok) {
            $.ajax({
                url: "user/login.do",
                type: "POST",
                data: {"v_code": v_code, "username": User_Name, "password": Password},
                dataType: "json",
                success: function (result) {
                    if (result.status == 1) {
                        /*获取用户ID写入Cookie*/
                        var userId = result.data.id;
                        var Name = result.data.petName;
                        addCookie("uid", userId, remember_me);//存储remember_me小时,此处实际设置的是Cookie的失效时间，正常情况下是关闭浏览器Cookie即失效
                        addCookie("name", Name, remember_me);
                        /*跳转到指定页面，window代表浏览器，location代表当前页面*/
                        window.location.href = "./page/index.html";
                    } else if (result.status == 2) {
                        var msg = result.msg;
                        swal({
                            title: '登陆失败',
                            text: msg,
                            type: 'warning',
                            timer: 2000
                        });
                        // alert(msg);
                        setTimeout(function () {
                            window.location.reload();//刷新当前页面
                        },2000)

                    }
                },
                error: function () {
                    swal(
                        '错误',
                        '当前请求出错!',
                        'error'
                    );
                }
            })
        }
    })
})