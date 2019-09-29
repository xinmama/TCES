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
<<<<<<< HEAD
						<button class="layui-btn layui-btn-sm layui-btn-normal " data-id="1" onclick="submit('16')"><i class="layui-icon"></i>进入评教</button>						
=======
						<button class="layui-btn layui-btn-sm layui-btn-normal " data-id="1" onclick="st_comein('${item.id}')"><i class="layui-icon"></i>${item.id}进入评教</button>						
>>>>>>> branch 'master' of https://github.com/xinmama/TCES.git
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
=======
//查询按钮
function st_comein(id){
	
// 	$.ajax({
// 		url:"${pageContext.request.contextPath}/st_comein",
// 		async:false,
// 		type:"post",
// 		data:{id:id},
// // 		dataType:"json",
// 		success:function(data){
// 			alert(data);
// 		},
// 		error:function(){
// 			alert("error");
// 		}
// 		});
	
	
	layer.open({
        type: 2,//层类型
        title: "修改信息",//标题
        closeBtn: 1, //不显示关闭按钮
        shade: [0.3],//遮罩
        skin: 'demo_class_color',//iframe皮肤
        shadeClose:Boolean,//点击遮罩关闭
        area: ['800px', '250px'],
        // offset: 'rb', //右下角弹出
        // time: 2000, //2秒后自动关闭
        anim: 5,//动画
        content: ['${pageContext.request.contextPath}/st_comein?id='+id], //iframe的url，no代表不显示滚动条
    });
	
}

	
	//修改按钮
   function update(id){

	   layer.open({
           type: 2,//层类型
           title: "修改信息",//标题
           closeBtn: 1, //不显示关闭按钮
           shade: [0.3],//遮罩
           skin: 'demo_class_color',//iframe皮肤
           shadeClose:Boolean,//点击遮罩关闭
           area: ['800px', '460px'],
           // offset: 'rb', //右下角弹出
           // time: 2000, //2秒后自动关闭
           anim: 5,//动画
           content: ['course_update?id='+id, 'no'], //iframe的url，no代表不显示滚动条
       });
>>>>>>> branch 'master' of https://github.com/xinmama/TCES.git
    }

</script>	

</body>

</html>
