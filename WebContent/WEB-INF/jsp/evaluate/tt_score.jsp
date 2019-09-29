<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit"/>
    <meta name="force-rendering" content="webkit"/>
    <meta http-equiv="X-UA-Compatible" content="IE=Edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="名榜,wangid">
    <title>教师综合评价系统</title>

    <!-- CSS -->
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/children.css">

    <!-- 在线图标库 地址：http://fontawesome.dashgame.com/-->
    <link href="http://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">

    <!-- layui css -->
    <link rel="stylesheet" href="layui/css/layui.css">
    <script type="text/javascript" src="js/jquery-1.11.0.min.js"></script>
    
</head>

<body>
    <div class="wangid_conbox">
        <!-- 当前位置 -->
        <div class="zy_weizhi bord_b">
            <i class="fa fa-home fa-3x"></i>
            <a>首页</a>
            <span>评价</span>
        </div>
        <!-- 内容 -->    
        <div class="layui-row layui-col-space10">
		     <div class="layui-col-md12">
		    	<div class="layui-row grid-demo grid-demo-bg1">
		      		<div class="layui-col-md12 " style="text-align:center;font-size:25px;height:90px;line-height:90px;margin-top:15px;">
		        		<h3>学期：${teacher_course.term.term_name}</h3>
		      		</div>
		        		<div class="layui-col-md6" style="text-align:right;padding-right:50px;font-size:20px;height:50px;line-height:50px;">
		        		课程：<span id="course_name1">${teacher_course.course.course_name }</span>
		      			</div>
		      			<div class="layui-col-md6" style="text-align:left;padding-left:50px;font-size:20px;height:50px;line-height:50px;">
		        		教师：${teacher_course.teacher.teacher_name}
		      			</div>
		    	</div>
		  	</div>
		</div>
		
		<fieldset class="layui-elem-field layui-field-title"> 
   			<legend>概念的讲解</legend>
		</fieldset>
		<div class="test1" style="padding-left:30px"></div>
		<input id="number0" type="hidden" name="number" value="0" >
		
		<fieldset class="layui-elem-field layui-field-title"> 
   			<legend>重点和难点</legend>
		</fieldset>
		<div class="test1" style="padding-left:30px"></div>
		<input id="number1" type="hidden" name="number" value="0" >
		
		<fieldset class="layui-elem-field layui-field-title"> 
   			<legend>逻辑性和条理性</legend>
		</fieldset>
		<div class="test1" style="padding-left:30px"></div>
		<input id="number2" type="hidden" name="number" value="0" >
		
		<fieldset class="layui-elem-field layui-field-title"> 
   			<legend>趣味性和生动性</legend>
		</fieldset>
		<div class="test1" style="padding-left:30px"></div>
		<input id="number3" type="hidden" name="number" value="0" >
		
		<div class="layui-row layui-col-space10">
		     
			<div class="layui-col-md12">
				<button type="button" class="layui-btn layui-btn-lg" onclick="submit()">提交</button>
			</div>
		</div>
<script src="layui/layui.js" charset="utf-8"></script>
<script>
layui.use(['rate'], function(){
	  var rate = layui.rate;
	  var $ = layui.jquery;
	  layui.each($('.test1'),function (index,elem){
		  //自定义文本
		  rate.render({
			  elem: elem
			  ,value: 0
			  ,text: true
			  ,choose: function(value){
				  $("#number"+index).val(value);
			  }
			  ,setText: function(value){ //自定义文本的回调
			    var arrs = {
			      '0': '',  
			      '1': '极差',
			      '2': '差',
			      '3': '中等',
			      '4': '好',
			      '5': '极好'
			    };
			    this.span.text(arrs[value] || ( value + "星"));
			  }			   
			    
		  });
	  });

 });

function submit(){
	
	var tt_score=0;
	var teacher1_id=${user.id};
	var dep_id=${user.dep_id};
	var teacher2_id=${teacher_course.teacher_id};
	var course_name=$("#course_name1").html();
	$('input[name=number]').each(function(index,element){
		tt_score=tt_score+parseInt($("#number"+index).val());
	});
	//提交内容
 	$.ajax({
		url:"${pageContext.request.contextPath}/tt_score_submit",
		async:false,
		type:"post",
		dataType:"json",
		data:{teacher1_id:teacher1_id,dep_id:dep_id,teacher2_id:teacher2_id,tt_score:tt_score,course_name:course_name},
 		success:function(data){
     		  if(data.flag==1){
     				alert(data.content); 
   		   	 		parent.location.reload();//刷新父级页面
     			}else{
	      			alert(data.content);
	      		}
     		    
 			}
 		});
	
}
</script>
</body>

</html>