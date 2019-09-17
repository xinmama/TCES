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
	<title>WangID办公管理系统</title>

	<!-- CSS -->
	<link rel="stylesheet" href="css/style.css">
	 <link rel="stylesheet" href="css/children.css">

	<!-- 在线图标库 地址：http://fontawesome.dashgame.com/-->
	<link href="http://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">

	<!-- layui css -->
	<link rel="stylesheet" href="layui/css/layui.css" media="all">
	<script type="text/javascript" src="js/jquery-1.11.0.min.js"></script> 
	<!-- layui js -->
	<script src="layui/layui.js"></script>
</head>


<body style="background: #fff;">
<div class="tianjia_xx">
	<form method="post" id="form">
	    <table class="if_tianjiatext layui-table" lay-size="lg"> 
	    <tbody>
	        <tr>
	            <td  class="td_1">院系名称</td> 
	            <td><input type="text" placeholder="请输入院系名称" name="dep_name"></td>
	        </tr>
	        <tr class="tianjie_button">
	            <td colspan="2" style="border-right:1px solid #e6e6e6;">
	                <button onclick="add()">确定添加</button>
	            </td>  
	        </tr>
	    </tbody>
	    </table>
    </form>
</div>
<script type="text/javascript">
	 function add(){
			
		 //判断输入框内容是否为空
		 $("input[type='text']").each(function () {
	           if ($(this).val() == "") {
	        	   
	               alert("内容不能为空！");
	           }else{
	        	   
	        	//提交内容
	      	    var url="${pageContext.request.contextPath}/add_department";
	      	    var param=$("#form").serialize();
	      			
	      		$.post(url,param,function(data){
	      		     if(data.flag==-1){
	      		    	alert("院系名称已存在，请重新输入！");
	      			 }else if(data.flag==1){
	      				alert("添加信息成功！");
	      			 }else{
		      			alert("添加信息失败！");
		      		}
	      		});
	      		 
	           }
	     })
	     
	     
	 }
</script> 
</body>

</html>
    