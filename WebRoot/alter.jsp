<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>信息修改</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body bgcolor="#BCD2EE">
  <br/>
  <br/>
    <center>
    <s:form action="alter">
    	信息修改
		<s:textfield name="ISBN" label="ISBN（禁止修改）"/>
		<s:textfield name="Title" label="Title"/>
		<s:textfield name="AuthorID" label="AuthorID(禁止修改)"/>
		<s:textfield name="Publisher" label="Publisher"/>
		<s:textfield name="PublishDate" label="PublishDate"/>
		<s:textfield name="Price" label="Price"/>
		<s:submit value="确认修改" align="right"/>
	</s:form>
    </center>
  </body>
</html>
