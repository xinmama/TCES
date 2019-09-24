<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="css/bootstrap.min.css" type="text/css" rel="stylesheet">
<link href="css/font-awesome.min.css" type="text/javascript" rel="stylesheet">
<link href="css/bootsnav.css" type="text/css" rel="stylesheet">
<link href="css/normalize.css" type="text/css" rel="stylesheet">
<link href="css/css.css" rel="stylesheet" type="text/css">
<script src="js/jquery-1.11.0.min.js" type="text/javascript"></script>
<script src="js/bootstrap.min.js" type="text/javascript"></script>
<script src="js/bootsnav.js" type="text/javascript"></script>
<script src="js/jquery.js" type="text/javascript"></script>
<!--[if IE]><script src="js/html5.js"></script><![endif]-->
<title>登录</title>
</head>

<body class="logobg_style">
  	<div id="large-header" class="large-header login-page">
  		<canvas id="demo-canvas" width="1590" height="711"></canvas>
  		<div class="login-form">
  			<div class="login-content">
  				<h1 class="title_name">账户登录</h1>
  				<form method="post" role="form" id="form" class="login_padding">
				<div class="form-group clearfix">

					<div class="input-group">
						<div class="input-group-addon">
							<i class="icon_user"></i>
						</div>

						<input type="text" class="form-control" name="username" id="username" placeholder="账号" autocomplete="off">
					</div>

				</div>

				<div class="form-group clearfix">

					<div class="input-group">
						<div class="input-group-addon">
							<i class="icon_password"></i>
						</div>

						<input type="password" class="form-control" name="password" id="password" placeholder="密码" autocomplete="off">
					</div>

				</div>
					<div class=" textright"><a href="#" class="forget">忘记密码？</a></div>
                  <div class="tishi"></div>
				<div class="form-group">
					<a href="javascript:;" type="submit" class="btn btn-danger btn-block btn-login" onClick="login()">
						<i class="fa fa-sign-in"></i>
						登录
					</a>
				</div>
<div class=" textright"><a href="registered.html" class="forget">立即注册</a></div>
				<!-- Implemented in v1.1.4 -->				<div class="form-group">
					
				</div>



	
			</form>
  			</div>
  			
  		</div>
  	</div>
  	
<script src="js/TweenLite/TweenLite.min.js"></script>
<script src="js/TweenLite/EasePack.min.js"></script>
<script src="js/TweenLite/rAF.js"></script>
<script src="js/TweenLite/demo-1.js"></script>
<script>
function login(){
	 var  i=true;
	//1.先判断输入框内容是否为空，再添加班级
	 $("input[type='text']").each(function () {
          if ($(this).val() == "") {
              i=false;
          }
    });
	if(i==true){
		 //提交内容
 		$.ajax({
			url:"${pageContext.request.contextPath}/xxx",
			async:false,
			type:"post",
			data:$("#form").serialize(),
			dataType:"json",
 			success:function(data){
     		    if(data.flag==-1){		    	
     		    	alert(data.content);
     		    	
     			}else if(data.flag==1){
     				alert(data.content);
     				
     				var index = parent.layer.getFrameIndex(window.name);  
       		    parent.layer.close(index);//关闭当前页  
   		   	 	parent.location.reload();//刷新父级页面
     			}else{
	      			alert(data.content);
	      		}
     		    
 			}
 		});
	}else{
		alert("填写信息存在错误，请重新填写！");
	}

	
}
</script>
</body>
</html>
