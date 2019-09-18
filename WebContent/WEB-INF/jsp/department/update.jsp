<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	    	<input type="hidden" name="id" value="${department.id}">
	        <tr>
	            <td  class="td_1">院系名称</td> 
	            <td><input type="text" name="dep_name" value="${department.dep_name}"></td>
	        </tr>
	        <tr class="tianjie_button">
	            <td colspan="2" style="border-right:1px solid #e6e6e6;">
	                <button onclick="update()">确定修改</button>
	            </td>  
	        </tr>
	    </tbody>
	    </table>
    </form>
</div>
<script type="text/javascript">
	 function update(){
		 //判断输入框内容是否为空
		 $("input[type='text']").each(function () {
	           if ($(this).val() == "") {
	               alert("内容不能为空！");
	           }else{
	        	   
	        	//提交内容
	      		$.ajax({
					url:"${pageContext.request.contextPath}/update_department",
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
	      		 
	           }
	     })
	     
	     
	 }
</script> 
</body>

</html>
    