<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 

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
		        		<h3>学期：2019-2020学年  第一学期</h3>
		      		</div>
		        		<div class="layui-col-md6" style="text-align:right;padding-right:50px;font-size:20px;height:50px;line-height:50px;">
		        		课程：
		      			</div>
		      			<div class="layui-col-md6" style="text-align:left;padding-left:50px;font-size:20px;height:50px;line-height:50px;">
		        		教师：张三
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
	
	var score=0;
	
	$('input[type=hidden]').each(function(index,element){
		score=score+parseInt($("#number"+index).val());
	});
	
	//提交内容
 	$.ajax({
		url:"${pageContext.request.contextPath}/st_score_submit",
		async:false,
		type:"post",
		data:{score:score},
		dataType:"json",
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