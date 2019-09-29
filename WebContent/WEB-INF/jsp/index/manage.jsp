<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit"/>
    <meta name="force-rendering" content="webkit"/>
    <meta http-equiv="X-UA-Compatible" content="IE=Edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="名榜,wangid">
    <title>管理员 目录</title>

    <!-- CSS -->
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/children.css">

    <!-- 在线图标库 地址：http://fontawesome.dashgame.com/-->
	<link href="http://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">

    <!-- layui css -->
	<link rel="stylesheet" href="layui/css/layui.css">
    <script type="text/javascript" src="js/jquery-1.11.0.min.js"></script>
	
</head>

<body class="layui-layout-body control_box">
	<!-- 背景 -->
	<div class="bg_box" style="background: url(images/20190415.jpg) no-repeat center center; background-size: cover;"></div>
	<!-- content box-->
	<div class="layui-layout layui-layout-admin">
		<!-- top -->
		<div class="layui-header">
			<div class="top_box">
		        <div class="logo">
		        	<img src="images/logo_touming.gif">
		        	<span></span>
		        	<b><img src="images/word.png" /></b>
		        </div>

				<div class="top_user">
					<span><img src="images/head.jpg" /></span>
					<dl>
						<dt>欢迎 ${user.username}</dt>
						<dd>级别：管理员 </dd>
					</dl>
				</div>

		        <div class="top_icon">
		        	<a href="index.html" title="首页"><img src="images/top_home.png"></a>
		        	<a href="#" title="个人设置"><img src="images/top_person.png"></a>
		        	<a href="#" title="退出"><img src="images/top_exit.png"></a>
		        </div>
		    </div>
		</div> 
	    <!-- side menu -->
		<div class="layui-side layui-bg-black">
			<div class="layui-side-scroll">
				<!-- 左侧导航区域（可配合layui已有的垂直导航） -->
				<ul class="layui-nav layui-nav-tree"  lay-filter="test">
					<li class="layui-nav-item layui-nav-itemed">
						<a class="" href="${pageContext.request.contextPath}/student_list" target="main_self_frame"><i class="fa fa-address-card fa-fw"></i>学生管理</a>
					</li>
					<li class="layui-nav-item">
						<a class="" href="${pageContext.request.contextPath}/teacher_list" target="main_self_frame"><i class="fa fa-users fa-fw"></i>教师管理</a>
					</li>
					<li class="layui-nav-item">
						<a class="" href="${pageContext.request.contextPath}/class_list" target="main_self_frame"><i class="fa fa-hourglass-half fa-fw"></i>班级管理</a>
					</li>
					<li class="layui-nav-item">
						<a class="" href="${pageContext.request.contextPath}/department_list" target="main_self_frame"><i class="fa fa-sitemap fa-fw"></i>系别管理</a>
					</li>
					<li class="layui-nav-item">
						<a class="" href="${pageContext.request.contextPath}/term_list" target="main_self_frame"><i class="fa fa-legal fa-fw"></i>学期管理</a>
						<dl class="layui-nav-child">
							<dd><a href="${pageContext.request.contextPath}/term_list" target="main_self_frame">学期设置</a></dd>
							<dd><a href="${pageContext.request.contextPath}/isCurrAppraiseList" target="main_self_frame">学期开启</a></a>
						</dl>
					</li>
					<li class="layui-nav-item">
						<a href="${pageContext.request.contextPath}/teacher_course_list" target="main_self_frame"><i class="fa fa-address-book fa-fw"></i>授课管理</a>
					</li>
					<li class="layui-nav-item">
						<a  target="main_self_frame"><i class="fa fa-area-chart fa-fw"></i>分数管理</a>
						<dl class="layui-nav-child">
							<dd><a href="${pageContext.request.contextPath}/st_score" target="main_self_frame">学生评教分数</a></dd>
							<dd><a href="${pageContext.request.contextPath}/Tt_score" target="main_self_frame">同行教师评教分数</a></a>
						</dl>
					</li>
					<li class="layui-nav-item">
						<a href="javascript:;" target="main_self_frame"><i class="fa fa-file-text fa-fw"></i>评价管理</a>
						<dl class="layui-nav-child">
							<dd><a href="${pageContext.request.contextPath}/standart_list" target="main_self_frame">评价指标管理</a></dd>
							<dd><a href="${pageContext.request.contextPath}/teacher_list" target="main_self_frame">评价选项管理</a></a>
						</dl>
					</li>
				</ul>
			</div>
		</div>
	  
		<div class="layui-body">
			<!-- 展开收起按钮 -->
			<div class="open_shrink open" title="展开/收起">
				<span></span>
			</div>
			<script type="text/javascript">
				$(function(){
					$(".open_shrink").click(function(){
						if ($(this).hasClass("open")) {
							$(this).removeClass("open");
							$(".layui-side").stop().animate({left:-220},300);
							$(".layui-body").stop().animate({left:0},300);
						}else{
							$(this).addClass("open");
							$(".layui-side").stop().animate({left:0},300);
							$(".layui-body").stop().animate({left:220},300);
						}
					})
				})
			</script>
			<!-- iframe -->
			<iframe src="${pageContext.request.contextPath}/student_list" name="main_self_frame" frameborder="0" class="layadmin-iframe" scrolling="yes"></iframe>
		</div>
	  
	</div>
	<!-- layui js -->
	<script src="layui/layui.js"></script>
	<script>
		//JavaScript代码区域
		layui.use('element', function(){
		  var element = layui.element;
		  
		});
					
	</script>

</body>

</html>

