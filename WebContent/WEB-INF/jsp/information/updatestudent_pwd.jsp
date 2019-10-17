<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit" />
<meta name="force-rendering" content="webkit" />
<meta http-equiv="X-UA-Compatible" content="IE=Edge,chrome=1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="名榜,wangid">
<title>修改密码</title>

<!-- CSS -->
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/children.css">

<!-- 在线图标库 地址：http://fontawesome.dashgame.com/-->
<link
	href="http://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
	rel="stylesheet">

<!-- layui css -->
<link rel="stylesheet" href="layui/css/layui.css">
<script type="text/javascript" src="js/jquery-1.11.0.min.js"></script>

</head>

<body>
	<div class="wangid_conbox">
		<!-- 当前位置 -->
		<div class="zy_weizhi bord_b">
			<i class="fa fa-home fa-3x"></i> <a>首页</a> <a>我的信息</a> <span>修改密码</span>
		</div>
		<!-- 内容 -->
		<div class="wenxts_ke">
			<p>
				<i>温馨提示：</i>修改密码后请牢记新密码，避免忘记密码影响工作进程
			</p>
		</div>
		<!-- 下面写内容 -->
		<div class="kehubh_tj_k">
			<form class="layui-form layui-form-pane" action="" id="update_pwd">
				<ul>
					<li>
					<input type="hidden" value="${user.student_no}" id="student_no">
						<div class="left">原密码：</div>
						<div class="right">
							<input type="text" name="oldpwd" id="oldpwd" required lay-verify="required"
								placeholder="请输入原密码" autocomplete="off" class="layui-input">
						</div>
					</li>
					<li>
						<div class="left">新密码：</div>

						<div class="right">
							<input type="text" name="newpwd1"  id="newpwd1" required lay-verify="required"
								placeholder="请输入新密码" autocomplete="off" class="layui-input">
						</div>
					</li>
					<li>
						<div class="left">确认新密码：</div>
						<div class="right">
							<input type="text" name="newpwd2" id="newpwd2" required lay-verify="required"
								placeholder="请输入新密码" autocomplete="off" class="layui-input">
						</div>
					</li>
					<li>
						<div class="left">&nbsp;</div>
						<div class="right">
							<button class="button_qr" onclick="update()">确定修改密码</button>
						</div>
					</li>
				</ul>
			</form>
		</div>
	</div>
	<!-- layui js -->
	<script src="layui/layui.js">
		
	</script>

	<script type="text/javascript">
	function update(){
	  var student_no=$("#student_no").val();
	  var oldpwd=$("#oldpwd").val();
	  var newpwd2=$("#newpwd2").val();
	 // alert(student_no);
		$.ajax({
			url : "${pageContext.request.contextPath}/studentpwd_update",
			async : false,
			type : "post",
			data : {student_no:student_no,oldpwd:oldpwd,newpwd2:newpwd2},
			dataType : "json",
			success : function(data) {
				if (data.flag == -1) {
					alert(data.content);
				}
				if (data.flag == 1) {
					alert(data.content);
					//关闭当前遮罩层
					 /* location.href = "${pageContext.request.contextPath}/login"; */
				} else {
					alert(data.content);
				}

			}
		});
	}
	</script>
</body>
</html>
