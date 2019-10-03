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
    <title>更新课程界面</title>

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
<form id="updateterm">
    <table class="if_tianjiatext layui-table" lay-size="lg">
        <tbody>
 		<tr>
 			<input type="hidden" name="id" value="${term.id}">
            <td  class="class_no" >学期名称</td>
            <td><input type="text" name="term_name" value="${term.term_name}"></td>
        </tr>
        <tr class="tianjie_button">
            <td colspan="2" style="border-right:1px solid #e6e6e6;">
                <button type="button" onclick="update_commit()">确定修改</button>
            </td>
        </tr>
        </tbody>
    </table>
    </form>
</div>

<script type="text/javascript">

/* 	$(function(){
		if(${term.is_open}==1){
			$("input[name=is_open]").attr("value","开启");
		}else{
			$("input[name=is_open]").attr("value","关闭");
		}
		
	}); */

	//修改班级信息
	//先查询班级信息并展示
	function update_commit(){
		var i=true;
		 $("input[type='text']").each(function () {
	           if ($(this).val() == "") {	   
	               alert("内容不能为空！");
	               i=false;
	           }
	     });
         
         if(i==true){
      	//提交内容
      	var id = $("input[name='id']").val();
      	var term_name = $("input[name='term_name']").val();
    		$.ajax({
				url:"${pageContext.request.contextPath}/update_term",
				async:false,
				type:"post",
				data:{id:id,term_name:term_name},
				dataType:"json",
    			success:function(data){
	      			if(data.flag==1){
    					alert(data.content);	
    					//关闭当前遮罩层
    				  	var index = parent.layer.getFrameIndex(window.name);  
    			   	 	parent.layer.close(index);//关闭当前页  
    			        
    			   		parent.location.reload();

    				}else{
    					alert(data.content);
    				}  
    			}
    		});
         } 
	}
</script>
</body>

</html>
