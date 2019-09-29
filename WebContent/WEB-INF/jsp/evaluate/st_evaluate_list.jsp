<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    
    <script type="text/javascript" src="js/jquery-1.11.0.min.js"></script>
    <!-- layui js -->
    <script src="layui/layui.js"></script>
</head>

<body>
<div >
    
        <c:forEach items="${st_list}" var="item" varStatus="status">
        	<tr>
            	<td></td>
            	<td>${status.index+1}</td>            	
            	<td>${item.getCourse().getCourse_name()}</td>
            	<td>${item.getTeacher().getTeacher_name()}</td>
            	<td>
            		<div class="layui-inline">
						<button class="layui-btn layui-btn-sm layui-btn-normal " data-id="1" onclick="submit('16')"><i class="layui-icon"></i>进入评教</button>						
					</div>
            	</td>
			</tr>
		</c:forEach>
        
</div>
<script type="text/javascript">

	
	//提交按钮
   function submit(id){
	alert(id);
	   $.ajax({
			url:"${pageContext.request.contextPath}/st_score_evaluate?id="+id,
			async:false,
			type:"post",
			success:function(data){
		  		if(data.flag==1){
					alert(data.content);	 						  	
					parent.location.reload();
				}else{
					alert(data.content);
				}
			}
		});
    }

</script>	

</body>

</html>
