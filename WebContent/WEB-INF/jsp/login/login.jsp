<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>登录界面</title>
    <link href="css/login_in.css" rel="stylesheet" type="text/css">
</head>
<body>
<form method="post" action="${pageContext.request.contextPath}/login_submit" name="login" id="box1">
    <h1 class="title">用户登录</h1>
    <div class="form_main">

        <div class="">
            <div class="user">
                <div class="icon_user" ><img src="images/user.png"> </div>
                <input id="username" type=text name='username' placeholder="请输入账号">
            </div>
        </div>
        <div class="">
            <div class="user">
                <div class="icon_user" ><img src="images/password.png"> </div>
                <input id="password" type=password name='password'placeholder="请输入密码"> <br>
            </div>
        </div>


        <div class="">
            <div class="user">
                <div class="login_btn">
                    <input type="submit" onclick="login_submit()" name="cmdOK" value="登  录">
                </div>
            </div>
        </div>

        <div class="">
            <div class="user">
                <a  class="forget" href="">忘记密码？</a>
            </div>
        </div>


    </div>

</form>
</body>
<script type="text/javascript" src="${pageContext.request.contextPath}/scripts/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
    function login_submit() {
        var url = "${pageContext.request.contextPath}/login_submit";
        var username = $("#username").val();
        var password = $("#password").val();
        var param={username:username,password:password};//json方式键值对传到后台去
        $.post(url,param,function(data){
        });

    }
</script>
</html>