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
            <a>评价设置</a>
            <span>启用评价</span>
        </div>
        <!-- 内容 --> 
        <div class="kehubh_tj_k">
            <form class="layui-form layui-form-pane" action="" id="CurrAppraise_form" method="post">
            <ul> 
                <li style="height: 38px; overflow:initial;">
                    <div class="left">评价学期设置：</div>
                    <div class="right"> 
                        <select name="id" lay-verify="">
	                            <option value="">请选择要评价的学期</option>
            					<c:forEach items="${terms}" var="terms">
	                            	<option value="${terms.id}">${terms.term_name}</option>
            					</c:forEach>
                        </select> 
                    </div>
                </li>
                
                <li>
                    <div class="left"> 状态：</div>
                    <div class="right">
                            <input type="radio" name="is_open" value="1" title="开启">
                            <input type="radio" name="is_open" value="0" title="关闭" checked>
                    </div>
                </li>
                <li>
                    <div class="left"> &nbsp;</div>
                    <div class="right"> 
                        <button class="button_qr" onclick="CurrAppraise()">确定</button>
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

<script src="js/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
    function CurrAppraise(){
    	var url="${pageContext.request.contextPath}/CurrAppraise";
    	var param=$("#CurrAppraise_form").serialize();
    		
    	$.ajax({
			url:url,
			async:false,
			type:"post",
			data:param,
			dataType:"json",
			success:function(data){
				if(data.flag==1){
    				alert(data.content);
    			}else if(data.flag==0){
    				alert(data.content);
    			}else if(data.flag==2){
    				alert(data.content);
    			}else if(data.flag==3){
    				alert(data.content);
    			}else if(data.flag==4){
    				alert(data.content);
    			}else if(data.flag==5){
    				alert(data.content);
    			}else if(data.flag==6){
    				alert(data.content);
    			}
      		    
			}
		});
    }
    
</script>
<script>
        layui.use(['form', 'layedit', 'laydate'], function(){
          var form = layui.form
          ,layer = layui.layer
          ,layedit = layui.layedit
          ,laydate = layui.laydate;
        });
</script>
