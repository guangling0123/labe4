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
    
    <title>图书管理系统</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
	<style type="text/css">
   		iframe#icontent 
   		{
			float: right;
			border: 1px solid black;
			width: 600px;
			height: 450px;
			margin-top: 50px;
		}
    </style>
  </head>
  
  <body bgcolor="#BCD2EE">
	<br/>
  <center>
  	<h2>图书管理系统</h2>
  </center>
  <center>	
  	<s:form action="query">
		<s:textfield name="Name" label="作者名称" />
		<s:submit value="查询书籍" align="right"/>
	</s:form>
  	
  	<s:form action="addbook" theme = "simple">
		ISBN:<s:textfield name="ISBN" label="ISBN"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Title:<s:textfield name="Title" label="Title"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;AuthorID:<s:textfield name="AuthorID" label="AuthorID" />
		<br/>
		Publisher:<s:textfield name="Publisher" label="Publisher"/>&nbsp;&nbsp;&nbsp;&nbsp;PublishDate:<s:textfield name="PublishDate" label="PublishDate"/>&nbsp;&nbsp;&nbsp;&nbsp;Price:<s:textfield name="Price" label="Price"/>
		<br/>
		Name:<s:textfield name="Name" label="Name"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Age:<s:textfield name="Age" label="Age"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Country:<s:textfield name="Country" label="Country"/>	
		<br/><s:submit value="添加书籍" align="right"/>
	</s:form>
	</center>
	<center>
		<h3>书籍列表</h3>
    	<!-- <table style="margin-left:70px;margin-top:243px;font-family:宋体;color:black;font-size:24px;text-align:left"> -->
	    <table border="1" style="font-size:18px">
		    <tr>
		    	<td align="center">ISBN</td>
		    	<td align="center">Title</td>
		    	<td align="center">AuthorID</td>
		    	<td align="center">Publisher</td>
		    	<td align="center">PublishDate</td>
		    	<td align="center">Price</td>
		    	<td align="center">Detail</td>
		    	<td align="center">Alter</td>
		    	<td align="center">Delete</td>
		   	</tr>
		    <s:iterator value="bookdetails">
		        <tr>
		            <td align="center"><s:property value="ISBN" /></td>
		            <td align="center"><s:property value="Title"/></td>
		            <td align="center"><s:property value="AuthorID"/></td>
		            <td align="center"><s:property value="Publisher"/></td>
		            <td align="center"><s:property value="PublishDate"/></td>
		            <td align="center"><s:property value="Price"/></td>
		            <td><a href='<s:url action="getdetail"><s:param name="ISBN" value="ISBN" /></s:url>'>Detail</a></td>
		            <td><a href='<s:url action="alter_prepare"><s:param name="ISBN" value="ISBN" /><s:param name="Title" value="Title" /><s:param name="AuthorID" value="AuthorID" /><s:param name="Publisher" value="Publisher" /><s:param name="PublishDate" value="PublishDate" /><s:param name="Price" value="Price" /></s:url>'>Alter</a></td>
		            <td><a href='<s:url action="delete"><s:param name="ISBN" value="ISBN" /></s:url>'>Delete</a></td>
		        </tr>
		    </s:iterator>
	    </table>
	</center>
  </body>
</html>
