	
	$(function(){
	/*---------banner小圆点效果----------*/
					var page=0;
					var auto=0;
					var circles=$("#banner>ul>li");
				$("#banner>ul>li").mouseover(function(){
					$(this).addClass("active");	
					$("#banner>ul>li").not(this).removeClass("active")
					var circle=$(this).index();
					if(circle==0){
						$("#banner-1,#banner-2").css("display","none");
						$("#banner-0").css("display","block");
						$("#banner-0").text("span的文本deiguai看了看记录卡健康法律交罚款来的疯了卡机的快乐发酵放了点卡就是地an的文本deiguai看了看记录卡健康法律交罚款来的疯了卡机的快乐发酵放了点卡就是地方啦了an的文本deiguai看了看记录卡健康法律交罚款来的疯了卡机的快乐发酵放了点卡就an的文本deiguai看了看记录卡健康法律交罚款来的疯了卡机的快乐发酵放了点卡就是地方啦了是地方啦了方啦了 ");
					}else if(circle==1){
						$("#banner-0,#banner-2").css("display","none")
						$("#banner-1").css("display","block");
					}else if(circle==2){
						$("#banner-0,#banner-1").css("display","none");
						$("#banner-2").css("display","block");
					}else{
						
					}	page=circle;
				})
				var page=$("#banner>ul>li").index();
				/*---------banner左箭头效果----------*/
					$("#arrow-left").click(function(){
						page--;
						if(page<-1){
							page=3;
						}
						circles.eq(page).trigger("mouseover");
					})
				/*---------banner右箭头效果----------*/
					$("#arrow-right").click(function(){
						page++;
						if(page>2){
							page=0;
						}
						circles.eq(page).trigger("mouseover");
					})
					
					
			function cir(){
						page++;
						if(page==3){
						page=0;
						}
					circles.eq(page).trigger("mouseover");
					}
					
					
					/*---------bannerk自动轮播效果----------*/
					var auto_banner=setInterval(cir,3000);
				/*---------鼠标移动上来，轮播停止----------*/
					$("#banner>img").mouseover(function(){
							
						clearInterval(auto_banner);
						})	
				/*---------鼠标移动开，轮播----------*/	
					$("#banner>img").mouseout(function(){
					
						auto_banner=setInterval(cir,3000);
					})	
						
			})