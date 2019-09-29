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

        <!-- 内容 -->    
        <div class="layui-row layui-col-space10">
		     <div class="layui-col-md12">
		    	<div class="layui-row grid-demo grid-demo-bg1">
		      		<div class="layui-col-md12 " style="text-align:center;font-size:25px;height:90px;line-height:90px;margin-top:15px;">
		        		<h3>学期：2018-2019第一学期</h3>
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
   			<legend>1.语言表达清楚、准确、生动。</legend>
		</fieldset>
		<div class="test1" style="padding-left:30px"></div>
		<input id="number0" type="hidden" name="number" value="0" >
		
		<fieldset class="layui-elem-field layui-field-title"> 
   			<legend>2.用标准的普通话授课。</legend>
		</fieldset>
		<div class="test1" style="padding-left:30px"></div>
		<input id="number1" type="hidden" name="number" value="0" >
		
		<fieldset class="layui-elem-field layui-field-title"> 
   			<legend>3.讲授知识准确系统，突出重点，说理充分。</legend>
		</fieldset>
		<div class="test1" style="padding-left:30px"></div>
		<input id="number2" type="hidden" name="number" value="0" >
		
		<fieldset class="layui-elem-field layui-field-title"> 
   			<legend>4.因材施教，能激发学生兴趣，注意学生个性发展。</legend>
		</fieldset>
		<div class="test1" style="padding-left:30px"></div>
		<input id="number3" type="hidden" name="number" value="0" >
		
		<fieldset class="layui-elem-field layui-field-title"> 
   			<legend>5.遵守教学纪律，不迟到，不早退，上课时不打电话。</legend>
		</fieldset>
		<div class="test1" style="padding-left:30px"></div>
		<input id="number3" type="hidden" name="number" value="0" >
		
		<fieldset class="layui-elem-field layui-field-title"> 
   			<legend>
			</legend>
		</fieldset>
		
		<div class="layui-row layui-col-space10">
			<div class="layui-col-md12">
				<button type="button" class="layui-btn layui-btn-lg" onclick="submit()"style="width:160px;margin-left:100px;">提交</button>
				<button type="button" class="layui-btn layui-btn-lg" onclick="submit()"style="width:160px;margin-left:100px;">重置</button>
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
	
	var st_score=0;
	var student_id=${user.id};
	var classes_id=${teacher_course.classes_id};
	var teacher_id=${teacher_course.teacher_id};
	var course_name=$("#course_name1").html();
	$('input[name=number]').each(function(index,element){
		st_score=st_score+parseInt($("#number"+index).val());
	});
	alert(st_score);
	//提交内容
 	$.ajax({
		url:"${pageContext.request.contextPath}/st_score_submit",
		async:false,
		type:"post",
		dataType:"json",
		data:{student_id:student_id,classes_id:classes_id,teacher_id:teacher_id,st_score:st_score,course_name:course_name},
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