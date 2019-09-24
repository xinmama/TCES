<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit"/>
    <meta name="force-rendering" content="webkit"/>
    <meta http-equiv="X-UA-Compatible" content="IE=Edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="名榜,wangid">
    <title>修改班级界面</title>

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
<form id="updatestudent">
    <table class="if_tianjiatext layui-table" lay-size="lg">
        <tbody>
        			<tr>
        				<input type="hidden" name="id" value="${student.id}">
						<td class="td_1">学号</td>

						<td><input type="text" placeholder="请输入学号" name="student_no" value="${student.student_no}" readonly="readonly"></td>
					</tr>
					<tr>
						<td class="td_1">姓名</td>
						<td><input type="text" placeholder="请输入姓名"name="student_name" value="${student.student_name}"></td>
					</tr>
				 	 <tr>
						<td class="td_1">班级</td>
						<td>
							<div class="layui-input-inline">
								<select name="classes_id">
									<c:forEach items="${classes}" var="item">
										<%-- <option value="${item.id}">${item.classes_no}</option> --%>
										<option value="${item.id}" ${item.classes_no==student.classes.classes_no?'selected':''}>${item.classes_no}</option>
									</c:forEach>
								</select>
							</div>
						</td>
					</tr>  
					<tr>
						<td class="td_1">密码</td>
						<td><input type="text" placeholder="请输入新密码"name="student_pwd" value="${student.student_pwd}"></td>
					</tr>
					<tr>
						<td class="td_1">性别</td>
						<td><input type="text" placeholder="请输入性别" name="sex" value="${student.sex}"></td>
					</tr>
					<tr>
						<td class="td_1">电话</td>
						<td><input type="text" placeholder="请输入电话" name="tel" value="${student.tel}"></td>

					</tr>
					<tr class="tianjie_button">
						<td colspan="2" style="border-right: 1px solid #e6e6e6;">
							<button onclick="update_commit()">确定修改</button>
						</td>
					</tr>
        </tbody>
    </table>
    </form>
</div>
<script type="text/javascript">
	//修改班级信息
	//先查询班级信息并展示
	function update_commit(){
		//alert(111);
		var i=true;
		 $("input[type='text']").each(function () {
	           if ($(this).val() == "") {	   
	               //alert("内容不能为空！");
	               i=false;
	           }
	     })
	     if(i==true){
	    	 //alert("222");
	    		$.ajax({
					url:"${pageContext.request.contextPath}/update_student",
					async:false,
					type:"post",
					data:$("#updatestudent").serialize(),
					dataType:"json",
	      			success:function(data){
	      				if(data.flag==-1){
	      					alert(data.content);
	      				}
		      			if(data.flag==1){
	      					alert(data.content);	
	      					//关闭当前遮罩层
	      				  	var index = parent.layer.getFrameIndex(window.name);  
	      			   	 	parent.layer.close(index);//关闭当前页  
	      			        //location.reload();
	      			   		parent.location.reload();

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
