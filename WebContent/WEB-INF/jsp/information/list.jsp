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
    <link rel="stylesheet" href="layui/css/layui.css">
    <script type="text/javascript" src="js/jquery-1.11.0.min.js"></script>

</head>

<body>
<div class="wangid_conbox">
    <!-- 当前位置 -->
    <div class="zy_weizhi bord_b">
        <i class="fa fa-home fa-3x"></i>
        <a>首页</a>
        <a>教师管理</a>
        <span>教师个人信息</span>
    </div>
    <!-- 内容 -->
    <div class="wenxts_ke">
        <p><i>温馨提示：</i>请认真核对教师信息正确无误后再确定修改</p>
    </div>
    <div class="kehubh_tj_k">
        <form class="layui-form layui-form-pane" action="" id="form">
            <ul>
            
                <li>
                    <div class="left">教师工号：</div>
                    <div class="right">
                    	<input type="hidden" name="id" value="${teacher.id}">
                        <input type="text" name="teacher_no"  value="${teacher.teacher_no}"  class="layui-input" disabled>
                    </div>
                </li>
                <li>
                    <div class="left">姓名：</div>
                    <div class="right">
                        <input type="text" name="teacher_name"  value="${teacher.teacher_name}"  class="layui-input">
                    </div>
                </li>
                
                <li>
                    <div class="left">性别：</div>
                    <div class="right">
                        <input type="text" name="sex"  value="${teacher.sex}"  class="layui-input">
                    </div>
                </li>
                <li>
                    <div class="left">电话号码：</div>
                    <div class="right">
                        <input type="text" name="tel"  value="${teacher.tel}"  class="layui-input">
                    </div>
                </li>
                <li>
                    <div class="left">院系：</div>
                    <div class="right">
                    	<input type="hidden" name="dep_id" value="${teacher.dep_id}">
                        <input type="text"  value="${teacher.department.dep_name}"  class="layui-input" disabled>
                    </div>
                </li>
                <li>
                    <div class="left"> &nbsp;</div>
                    <div class="right">
                        <button class="button_qr" onclick="teacherUpdate()">确定修改</button>
                    </div>
                </li>
            </ul>
        </form>
        
    </div>
</div>
<style>

    .layui-form-pane .layui-form-checkbox {
        margin: 12px 0 4px 10px!important;
    }
</style>
<!-- houl -->
<!-- 结束 -->
<!-- layui js -->
<script src="layui/layui.js"></script>

</body>

</html>
<script>
    layui.use(['form', 'layedit', 'laydate'], function(){
        var form = layui.form
            ,layer = layui.layer
            ,layedit = layui.layedit
            ,laydate = layui.laydate;
    });
    
    function teacherUpdate(){
		 var  i=true;
		 //判断输入框内容是否为空
		 $("input[type='text']").each(function () {
	           if ($(this).val() == "") {
	               alert("内容不能为空！");
	          
	        	   i=false;
	           }
	     });
	     if(i==true){
	    	//提交内容
	      		$.ajax({
					url:"${pageContext.request.contextPath}/update_information",
					async:false,
					type:"post",
					data:$("#form").serialize(),
					dataType:"json",
	      			success:function(data){
		      		    if(data.flag==-1){
		      		    	alert(data.content);	
	      					//关闭当前遮罩层
	      				  	 				
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
	     
	 }
	
	
</script>
