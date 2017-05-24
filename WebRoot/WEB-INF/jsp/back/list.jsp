<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
		<link rel="stylesheet" href="<%=basePath %>/resources/my.css" />
		<script type="text/javascript" src="<%=basePath %>/resources/jquery.js" ></script>
		<script type="text/javascript" src="<%=basePath %>/resources/my.js" ></script>
	</head>
	<body>
	<% request.setCharacterEncoding("utf-8"); %>
	    <form class="navbar-form navbar-left" action="<%=basePath %>List.action">
        <div class="form-group">
          <input name="command" type="text" class="form-control" placeholder="写入命令">
        </div>
   
        <div class="form-group">
          <input name="desc"  type="text" class="form-control" placeholder="写入描述">
        </div>
        <button type="submit" class="btn btn-default">描述搜索</button>
      </form>
		<div class="bs-example" data-example-id="hoverable-table">
    <table class="table table-hover">
      <thead>
        <tr>
          <th>ID</th>
          <th>命令</th>
          <th>描述</th>
          <th>内容</th>
          
        </tr>
      </thead>
      <tbody>
      <C:forEach items="${messages}" var="message" varStatus="status">
           <tr>
          <th scope="row">${message.id}</th>
          <td>${message.command}</td>
          <td>${message.desc}</td>
          <td>${message.content}</td>
          <td>修改</td>
          <td>删除</td>
        </tr>
      </C:forEach>
   
    
      </tbody>
    </table>
  </div>
	</body>
</html>

