<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>登陆页面</title>
    <link rel="stylesheet" type="text/css" href="css/login.css">
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script type="text/javascript">
        $(function(){
            $(".name input").focus(function(){
                $(this).prev("i").css({"background-image":"url(img/user2.png)"});
            });
            $(".name input").blur(function(){
                $(this).prev("i").css({"background-image":"url(img/user1.png)"});
            });
            $(".password input").focus(function(){
                $(this).prev("i").css({"background-image":"url(img/password2.png)"});
            });
            $(".password input").blur(function(){
                $(this).prev("i").css({"background-image":"url(img/password1.png)"});
            });
        });
    </script>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit"/>
    <meta name="force-rendering" content="webkit"/>
    <meta http-equiv="X-UA-Compatible" content="IE=Edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="名榜,wangid">
    <title>首页</title>

    <!-- CSS -->
    <link rel="stylesheet" href="css/style.css">

    <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
        <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->
	<script type="text/javascript" src="js/jquery-1.11.0.min.js"></script>
	<script type="text/javascript" src="js/Tdrag.min.js"></script>
	
</head>

<body>
    <div class="container">
        <div class="wrap">
            <header><em>Logo</em><span>教师综合评价系统</span></header>
            <article>
                <section>
                    <aside>
                        <em>
                            <img src="img/user.png">
                        </em>
                         <form id="loginid" action="" method="post">
                            <p class="name"><i></i><input type="text" name="username" class="userName" placeholder="请输入用户名"></p>
                            <p class="password"><i></i><input type="password" name="password" class="pwd" placeholder="请输入密码"></p>
                            <button onclick="login()">登录</button>
                          
                            <div class="clear"></div>
                        </form>
                    </aside>
                   
                </section>               
            </article>
            <footer>
                <ul>
                    <li><a href="#">联系我们</a></li>
                    <li><a href="#">关于我们</a></li>
                    <li><a href="#">人才招聘</a></li>
                    <li><a href="#">友情链接</a></li>
                    <li><a href="#">公司地址</a></li>
                    <li><a href="#">关注我们</a></li>
                </ul>
                <p>本网站版权归rockmorty所有，未经许可，不得转载。</p>
            </footer>
        </div>
    </div>
    <script>
    function login(){
    	var url="${pageContext.request.contextPath}/loginselectUserName";
    	var param=$("#loginid").serialize();
    	$.post(url,param,function(data){
    		if(data.flag==1){
    			alert(data.content);
    		}
    		else{
    			alert(data.content);
    		}
    	});
    }
    
    </script>
	
	<div class="bg_box" style="background: url(images/bg_default.jpg) no-repeat center center; background-size: cover;"></div>
	<div class="container">
		<div class="top_box">
	        <div class="logo">

	        	<span></span>
	        	<b></b>
	        </div>
	        <div class="top_icon">
	        	<a href="#"><img src="images/top_home.png"></a>
	        	<a href="#"><img src="images/top_person.png"></a>
	        	<a href="#"><img src="images/top_exit.png"></a>
	        </div>
	    </div>
	    <div class="content_box">
	    	<div class="left_box">
	    		<div class="head">
	    			<i><img src="images/head.jpg" /></i>
	    			<dl>
	    				<dd><b>姓名：</b>欣妈妈</dd>
	    				<dd><b>部门：</b>技术部</dd>
	    				<dd><b>职务：</b>设计师</dd>
	    				<dd><b>工号：</b>1688900</dd>
	    			</dl>
	    		</div>
	    		<div class="menu" id="style-3">
	    			<ul>
	    				<li>
	    					<h2>
		    					<img src="images/sm_icon01.png">
		    					<a>营销菜单</a>
		    					<em><img src="images/jt_left.png"></em>
		    				</h2>
	    					<dl>
	    						<dd><a href="child.html">日用资料</a></dd>
	    						<dd><a href="child.html">营销战况</a></dd>
	    						<dd><a href="child.html">渠道战况</a></dd>
	    						<dd><a href="child.html">碰单保护</a></dd>
	    						<dd><a href="child.html">拜访记录</a></dd>
	    						<dd><a href="child.html">客户维护</a></dd>
	    						<dd><a href="child.html">尾款催收</a></dd>
	    					</dl>
	    				</li>
	    				<li>
	    					<h2>
		    					<img src="images/sm_icon02.png">
		    					<a href="child.html">大数据库</a>
		    				</h2>
	    				</li>
	    				<li>
	    					<h2>
		    					<img src="images/sm_icon03.png">
		    					<a href="child.html">立项系统</a>
		    				</h2>
	    				</li>
	    				<li>
	    					<h2>
		    					<img src="images/sm_icon04.png">
		    					<a>备案查询</a>
		    					<em><img src="images/jt_left.png"></em>
		    				</h2>
	    					<dl>
	    						<dd><a href="child.html">备案查询</a></dd>
	    						<dd><a href="child.html">备案查询</a></dd>
	    					</dl>
	    				</li>
	    				<li>
	    					<h2>
		    					<img src="images/sm_icon05.png">
		    					<a>企业相关</a>
		    					<em><img src="images/jt_left.png"></em>
		    				</h2>
	    					<dl>
	    						<dd><a href="child.html">企业相关</a></dd>
	    						<dd><a href="child.html">企业相关</a></dd>
	    					</dl>
	    				</li>
	    				<li>
	    					<h2>
		    					<img src="images/sm_icon06.png">
		    					<a>个人设置</a>
		    					<em><img src="images/jt_left.png"></em>
		    				</h2>
	    					<dl>
	    						<dd><a href="child.html">IP锁定</a></dd>
	    						<dd><a href="child.html">登录记录</a></dd>
	    						<dd><a href="child.html">密码修改</a></dd>
	    						<dd><a href="child.html">背景设置</a></dd>
	    					</dl>
	    				</li>
	    			</ul>
	    			<script type="text/javascript">
	    				$(function(){
	    					var n=0;
	    					$(".left_box .menu ul li").mouseover(
	    						function(){
	    							n=$(this).index();
	    						}
	    					)
	    					$(".left_box .menu ul li h2").click(
	    						function(){
	    							$(".left_box .menu ul li").eq(n).find("dl").slideToggle();	
	    							$(".left_box .menu ul li").eq(n).siblings().find("dl").slideUp() 

	    							if ($(this).find("em").hasClass("xz")) {
										$(this).find("em").removeClass("xz")
										$(this).find("em").addClass("xz01")
									}else{
										$(this).find("em").addClass("xz")
										$(this).find("em").removeClass("xz01")
									}
									if ($(".left_box .menu ul li").eq(n).siblings().find("em").hasClass("xz")) {	
										$(".left_box .menu ul li").eq(n).siblings().find("em").removeClass("xz")	
									} 	
	    						}
	    					)
	    				})
	    			</script>
	    		</div>
	    	</div>
	    	<div class="right_box">
	    		<div class="icon_box">
	    			<ul class="boxList">
	    				<li class="list">
	    					<i>
	    						<img src="images/icon_01.png">
	    						<b></b>
	    					</i>
		    				<a href="index.html" target="blank">
		    					<span>通讯录</span>
		    				</a>
		    			</li>
		    			<li class="list">
	    					<i>
	    						<img src="images/icon_02.png">
	    						<b></b>
	    					</i>
		    				<a href="index.html" target="blank">
		    					<span>尾款催收</span>
		    				</a>
		    			</li>
		    			<li class="list">
	    					<i>
	    						<img src="images/icon_03.png">
	    						<b></b>
	    					</i>
		    				<a href="index.html" target="blank">
		    					<span>拜访记录</span>
		    				</a>
		    			</li>
		    			<li class="list">
	    					<i>
	    						<img src="images/icon_04.png">
	    						<b></b>
	    					</i>
		    				<a href="index.html" target="blank">
		    					<span>企业邮箱</span>
		    				</a>
		    			</li>
		    			<li class="list">
	    					<i>
	    						<img src="images/icon_05.png">
	    						<b></b>
	    					</i>
	    					<a href="index.html" target="blank">
		    					<span>通知公告</span>
		    				</a>
		    			</li>
		    			<li class="list">
	    					<i>
	    						<img src="images/icon_06.png">
	    						<b></b>
	    					</i>
	    					<a href="index.html" target="blank">
		    					<span>行政人事</span>
		    				</a>
		    			</li>
	    			</ul>
	    			<a href="#">
	    				<i>
    						<img src="images/icon_add.png">
    						<b></b>
    					</i>
    					<span>添加快捷方式</span>
	    			</a>
	    			<script>
						jQuery(function(){						    
						    //第九个例子的拖拽
						    $(".list").Tdrag({
						        scope:".boxList",
						        pos:true,
						        dragChange:true,
						        changeMode:"sort",
						        moveClass:"abc"
						    });
						})
					</script>
	    		</div>
	    		<!-- iconbox end -->
	    		<div class="info_box">
	    			<div class="box battle">
	    				<div class="tit">
	    					<a class="on">营销战况</a><a>渠道战况</a><!-- 注释去间隔
	    	   注释去间隔 --><div class="scrollnews">
	    	   					<span>WangID提醒您：</span>
	    	   					<ul>
	    	   						<li title="最新战报，章泽天 关晓彤 签名榜一个！2018-08-10 15:41:58">
	    	   							最新战报，<b>章泽天 关晓彤</b> 签名榜一个！<i>2018-08-10 15:41:58</i>
	    	   						</li>
	    	   						<li title="最新战报，章泽天 签名榜一个！2018-08-10 15:41:58">
	    	   							最新战报，<b>章泽天</b> 签名榜一个！<i>2018-08-10 15:41:58</i>
	    	   						</li>
	    	   						<li title="最新战报，秋名山 签名榜一个！2018-08-10 15:41:58">
	    	   							最新战报，<b>秋名山</b> 签名榜一个！<i>2018-08-10 15:41:58</i>
	    	   						</li>
	    	   					</ul>
	    	   					<script type="text/javascript">
	    	   						$(document).ready(function(){
					                    //滚动文字
					                    function runtxt(){
					                        $(".scrollnews ul").animate({marginTop:"-54px"},300,
					                            function(){
					                                $(".scrollnews ul li:last").after($(".scrollnews ul li:first"))
					                                $(".scrollnews ul").css("margin-top",0)
					                            }
					                        )
					                    }   
					                    $(".scrollnews ul li a").mouseenter(
					                        function(){
					                            clearInterval(timer)
					                        }
					                    )
					                    $(".scrollnews ul li a").mouseleave(
					                        function(){
					                            timer=setInterval(runtxt,4000)
					                        }
					                    )
					                    timer=setInterval(runtxt,4000)
					                })
	    	   					</script>
	    	   				</div>
	    				</div>
	    				<div class="conbox">
	    					<div class="con">
	    						<h1>营销部各大区本月新增业绩PK实时展示图</h1>
	    						<div class="countbox">
	    							<div class="count">
	    								<span class="x"><img src="images/X.png"> x/营销分区</span>
	    								<span class="y"><img src="images/Y.png"> y/营销业绩</span>
	    								<ul>
	    									<li class="y1" style="height: calc(2% * 2); background: #ff4e00;"></li>
	    									<li class="y2" style="height: calc(3% * 2); background: #ffa200;"></li>
	    									<li class="y3" style="height: calc(7% * 2); background: #fffc00;"></li>
	    									<li class="y6" style="height: calc(5% * 2); background: #00ff55;"></li>
	    									<li class="y8" style="height: calc(3% * 2); background: #00ffd5;"></li>
	    									<li class="y10" style="height: calc(8% * 2); background: #00c0ff;"></li>
	    									<li class="y11" style="height: calc(4% * 2); background: #0078ff;"></li>
	    									<li class="y12" style="height: calc(6% * 2); background: #4200ff;"></li>
	    									<li class="y13" style="height: calc(14% * 2); background: #fc00ff;"></li>
	    									<li class="y16" style="height: calc(8% * 2); background: #ff007e;"></li>
	    									<li class="y18 on" style="height: calc(40% * 2); background: #ff0000;">
	    								 		<img src="images/flag.png" />
	    								 	</li>
	    								 <!-- 计算出每个大区所占百分比 以两倍高度展示，所占比超过百分之五十的，超出百分百以外的隐藏 -->
	    								</ul>
	    							</div>
	    							<div class="num">
	    								<a>1区</a>
	    								<a>2区</a>
	    								<a>3区</a>
	    								<a>6区</a>
	    								<a>8区</a>
	    								<a>10区</a>
	    								<a>11区</a>
	    								<a>12区</a>
	    								<a>13区</a>
	    								<a>16区</a>
	    								<a>18区</a>
	    							</div>
	    						</div>
	    					</div>
	    					<div class="con">
	    						<h1>渠道部各部门本月新增业绩PK实时展示图</h1>
	    						<div class="countbox">
	    							<div class="count">
	    								<span class="x"><img src="images/X.png"> x/渠道部门</span>
	    								<span class="y"><img src="images/Y.png"> y/渠道业绩</span>
	    								<ul>
	    									<li class="y1" style="height: calc(40% * 2); background: #ff4e00;"></li>
	    									<li class="y2 on" style="height: calc(60% * 2); background: #ffa200;">
	    								 		<img src="images/flag.png" />
	    								 	</li>
	    								 <!-- 计算出每个大区所占百分比 以两倍高度展示，所占比超过百分之五十的，超出百分百以外的隐藏 -->
	    								</ul>
	    							</div>
	    							<div class="num">
	    								<a>6部</a>
	    								<a>8部</a>
	    							</div>
	    						</div>
	    					</div>
	    				</div>
    					<script type="text/javascript">
    						$(function(){
    							var n=0;
    							$(".right_box .info_box .battle .tit a").mouseover(
    								function(){
    									n=$(this).index();
    									$(this).addClass("on")
    									$(this).siblings().removeClass("on")
    									$(".right_box .info_box .battle .con").hide().eq(n).fadeIn()
    								}
    							)
    						})
    					</script>
	    			</div>
	    			<div class="box honor">
	    				<div class="tit">
	    					<a class="on">营销业绩排行榜</a><a>渠道业绩排行榜</a><!-- 注释去间隔
	    				 --><div></div>
	    				</div>
	    				<div class="conbox">
	    					<div class="con">
	    						<div>
		    						<ul>
		    							<li>
		    								<i><img src="images/head.jpg"></i>
		    								<dl>
		    									<dt>章泽天</dt>
		    									<dd>所属分区：营销1区</dd>
		    								</dl>
		    								<b><img src="images/honor_1.png"></b>
		    							</li>
		    							<li>
		    								<i><img src="images/head.jpg"></i>
		    								<dl>
		    									<dt>鹿晗</dt>
		    									<dd>所属分区：营销11区</dd>
		    								</dl>
		    								<b><img src="images/honor_2.png"></b>
		    							</li>
		    							<li>
		    								<i><img src="images/head.jpg"></i>
		    								<dl>
		    									<dt>关晓彤</dt>
		    									<dd>所属分区：营销3区</dd>
		    								</dl>
		    								<b><img src="images/honor_3.png"></b>
		    							</li>
		    						</ul>
		    						<dl>
		    							<dt>上月前三名</dt>
		    							<dd>鹿晗</dd>
		    							<dd>关晓彤</dd>
		    							<dd>张娜拉</dd>
		    						</dl>
		    					</div>
		    					<p>干的不错，小伙伴们继续加油哦！</p>
	    					</div>
	    					<div class="con">
	    						<div>
		    						<ul>
		    							<li>
		    								<i><img src="images/head.jpg"></i>
		    								<dl>
		    									<dt>章泽天</dt>
		    									<dd>所属分区：渠道6部</dd>
		    								</dl>
		    								<b><img src="images/honor_1.png"></b>
		    							</li>
		    							<li>
		    								<i><img src="images/head.jpg"></i>
		    								<dl>
		    									<dt>鹿晗</dt>
		    									<dd>所属分区：渠道8部</dd>
		    								</dl>
		    								<b><img src="images/honor_2.png"></b>
		    							</li>
		    							<li>
		    								<i><img src="images/head.jpg"></i>
		    								<dl>
		    									<dt>关晓彤</dt>
		    									<dd>所属分区：渠道8部</dd>
		    								</dl>
		    								<b><img src="images/honor_3.png"></b>
		    							</li>
		    						</ul>
		    						<dl>
		    							<dt>上月前三名</dt>
		    							<dd>鹿晗</dd>
		    							<dd>关晓彤</dd>
		    							<dd>张娜拉</dd>
		    						</dl>
		    					</div>
		    					<p>渠道部的同学们很给力，加油！</p>
	    					</div>
	    				</div>
	    				<script type="text/javascript">
    						$(function(){
    							var n=0;
    							$(".right_box .info_box .honor .tit a").mouseover(
    								function(){
    									n=$(this).index();
    									$(this).addClass("on")
    									$(this).siblings().removeClass("on")
    									$(".right_box .info_box .honor .con").hide().eq(n).fadeIn()
    								}
    							)
    						})
    					</script>
	    			</div>
	    		</div>
	    	</div>
	    </div>
    </div>
</body>
</html>
