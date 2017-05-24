<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>Diolag</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" href="<%=basePath%>resources/index.css" />
	<script type="text/javascript" src="<%=basePath%>resources/jquery.js"></script>
  </head>
  <% request.setCharacterEncoding("UTF-8"); %>
  <body>
    	<div class="main">
			<div class="main_top">
				<ul>
					<li>1</li>
					<li>2</li>
					<li>3</li>
					<li>4</li>
					<li>5</li>
					<li>6</li>
					<li>7</li>
					<li>8</li>
					<li>9</li>
					<li>10</li>
				</ul>
				
			</div>
			<div class="main_bottom">
				
				
				<input class="ii"  type="text" /><span class="send" onclick="send();" >发送</span>
			<input type="hidden" value="<%=basePath %>" class="hidden" />
			</div>
		</div>
<script>

	function send(){
		
			var mycontent=$('.ii').val();
		var url=$('.hidden').val()+"AutoReply.action";
	$.post(url,{"content":mycontent},function(data){
					$('.main_top ul').append("<li>"+mycontent+"</li>");
					alert(data);
					$('.main_top ul').append("<li>"+data+"</li>");
					$('.ii').val("");	
	},'text');
		
	}
</script>
</html>
