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
    <link rel="stylesheet" href="layui/css/layui.css">
    <script type="text/javascript" src="js/jquery-1.11.0.min.js"></script>
    
</head>

<body>
    <div class="wangid_conbox">
        <!-- 当前位置 -->
        <div class="zy_weizhi bord_b">
            <i class="fa fa-home fa-3x"></i>
            <a>首页</a>
            <a>员工管理</a>
            <span>公司员工添加</span>
        </div>
        <!-- 内容 -->    
        <div class="wenxts_ke">
            <p><i>温馨提示：</i>请认真核对员工信息正确无误后再确定添加，并上传员工的对应简历图片</p>
        </div>
        <div class="tianjia_xx">
	<form id="form" method="post">
	    <table class="if_tianjiatext layui-table" lay-size="lg">
	        <tbody>
	        	<input type="hidden" name="id" value="${teacher.id}">
	        	<tr>
		            <td  class="td_1">教师工号</td> 
		            <td><input type="text" name="teacher_no" value="${teacher.teacher_no}"></td>
	            </tr>
	            <tr>
		            <td  class="td_1">姓名</td> 
		            <td><input type="text" name="teacher_name" value="${teacher.teacher_name}"></td>
	            </tr>
	            <tr>
		            <td  class="td_1">性别</td> 
		            <td><input type="text" name="sex" value="${teacher.sex}"></td>
	            </tr>
	            <tr>
		            <td  class="td_1">电话号码</td> 
		            <td><input type="text" name="tel" value="${teacher.tel}"></td>
	            </tr>
	            <tr>
		        	<input type="hidden" name="id" value="${teacher.id}">
		            <td class="td_1">系别</td>
		            <td>
		                <div class="layui-input-inline">
		                    <select name="dep_id">                      		
		                    		<c:forEach items="${department}" var="item">
		                    		
		                    				<option value="${item.id}" ${item.dep_name==teacher.department.dep_name?'selected':''}>${item.dep_name}</option>
		                    		
		                        	</c:forEach>                      
		                    </select>
		                </div>
		            </td>
		        </tr>
		        <tr class="tianjie_button">
		            <td colspan="2" style="border-right:1px solid #e6e6e6;">
		                <button type="button"  onclick="update()">修改</button>
		            </td>  
		        </tr>
	        </tbody>
	    </table>
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
        </script>
