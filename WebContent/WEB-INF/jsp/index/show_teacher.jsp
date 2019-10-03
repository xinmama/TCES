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
    <title>展示界面</title>

    <!-- CSS -->
    <link rel="stylesheet" href="css/style.css">
    <style>
		.scroll-bar {
		    height: 40px;
		    width:100%;
		    line-height: 40px;
		    font-size: 40px;
			color:#fff;
		}
		#marquee{
			margin: 0;
			padding: 0;
		}
		#marquee li{
			width:100%;
		}
	
	</style>

    <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
        <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->
	<script type="text/javascript" src="js/jquery-1.11.0.min.js"></script>
	<script type="text/javascript" src="js/Tdrag.min.js"></script>
	
</head>

<body>
	
	<div class="bg_box" style="background: url(images/bg_default.jpg) no-repeat center center; background-size: cover;"></div>
	<div class="container">
		<div class="top_box">
	        <div class="logo">

	        	<span></span>
	        	<b></b>
	        </div>
	        <div class="top_icon">
	        	<a href="${pageContext.request.contextPath}/ReturnTeacherIndex"><img src="images/top_home.png"></a>
	        	<a href="#"><img src="images/top_person.png"></a>
	        	<a href="${pageContext.request.contextPath}/exit"><img src="images/top_exit.png"></a>
	        </div>
	    </div>
	    <div class="content_box">
	    	<div class="left_box">
	    		<div class="head">
	    			<i><img src="images/head.jpg" /></i><!-- 注释去间隔
	    	     --><dl>
	    				<dd><b>姓名：</b>${teacher1.getTeacher_name()}</dd>
	    				<dd><b>工号：</b>${teacher1.getTeacher_no()}</dd>
	    				<dd><b>院系：</b>${teacher1.getDepartment().getDep_name()}</dd>
	    				
	    			</dl>
	    		</div>
	    		<div class="menu" id="style-3">
	    			<ul>
	    				<li>
	    					<h2>
		    					<img src="images/sm_icon04.png">
		    					<a href="${pageContext.request.contextPath}/teacher_ml">进入系统</a>
		    				</h2>
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
	    		<div class="icon_box" >
								       
						<section class="scroll-bar" id="scrollText">
   						 <ul id="marquee">
       						 <li>欢迎来到重庆工程学院教师综合评价系统！</li>
   						 </ul>
						</section>
					
				    
					<script src="https://cdn.bootcss.com/jquery/2.2.4/jquery.min.js"></script>
					<script type="text/javascript" src="js/jquery.marquee.min.js"></script> 
					<script>
					$(function(){
						$("#marquee").marquee({
							duration: 15000,//时间
							gap: 400,//间距
							delayBeforeStart: 0,//开始滚动延迟时间
							direction: 'left',//滚动方向
							duplicated: true,//是否循环播放
						}); 
					})
					</script>
	    		</div>
	    		<!-- iconbox end -->
	    		<div class="info_box">
	    			<div class="box battle">
	    				<div class="tit">
	    					<a class="on">学生评价</a><a>教师评价</a><!-- 注释去间隔
	    	   注释去间隔 --><div class="scrollnews">
	    	   					<span>最新情况：</span>
	    	   					<ul>
	    	   						<li title="最新战报，章泽天 关晓彤 签名榜一个！2018-08-10 15:41:58">
	    	   							<b>彭彭</b> 6666666<i>2018-08-10 15:41:58</i>
	    	   						</li>
	    	   						<li title="最新战报，章泽天 签名榜一个！2018-08-10 15:41:58">
	    	   							<b>郎朗</b> 777777<i>2018-08-10 15:41:58</i>
	    	   						</li>
	    	   						<li title="最新战报，秋名山 签名榜一个！2018-08-10 15:41:58">
	    	   							<b>秋名山</b> 88888<i>2018-08-10 15:41:58</i>
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
					                    timer=setInterval(runtxt,2000)
					                })
	    	   					</script>
	    	   				</div>
	    				</div>
	    				<div class="conbox">
	    					<div class="con">
	    						<h1>2018-2019学年第一学期最佳教师度展示图</h1>
	    						<div class="countbox">
	    							<div class="count">
	    								<span class="x"><img src="images/X.png"> x/教师</span>
	    								<span class="y"><img src="images/Y.png"> y/分数</span>
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

    