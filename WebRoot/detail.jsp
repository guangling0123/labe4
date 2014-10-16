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
    
    <title>详细信息</title>
    
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
    <center>
    	<br/>
    	<br/>
    	<h3>书籍信息</h3>
    	<table border="1" style="font-size:18px">
		    <tr>
		    	<td align="center">ISBN</td>
		    	<td align="center">Title</td>
		    	<td align="center">AuthorID</td>
		    	<td align="center">Publisher</td>
		    	<td align="center">PublishDate</td>
		    	<td align="center">Price</td>
		    	<td align="center">Alter</td>
		    	<td align="center">Delete</td>
		   	</tr>
		    <tr>
		        <td align="center"><s:property value="ISBN" /></td>
		        <td align="center"><s:property value="Title"/></td>
		        <td align="center"><s:property value="AuthorID"/></td>
		        <td align="center"><s:property value="Publisher"/></td>
		        <td align="center"><s:property value="PublishDate"/></td>
		        <td align="center"><s:property value="Price"/></td>
		        <td><a href='<s:url action="alter_prepare"><s:param name="ISBN" value="ISBN" /><s:param name="Title" value="Title" /><s:param name="AuthorID" value="AuthorID" /><s:param name="Publisher" value="Publisher" /><s:param name="PublishDate" value="PublishDate" /><s:param name="Price" value="Price" /></s:url>'>Alter</a></td>
		        <td><a href='<s:url action="delete"><s:param name="ISBN" value="ISBN" /></s:url>'>Delete</a></td>
		    </tr>    
	    </table>
    	
    	<h3>作者信息</h3>
    	<table border="1" style="font-size:18px">
		    <tr>
		    	<td align="center">AuthorID</td>
		    	<td align="center">Name</td>
		    	<td align="center">Age</td>
		    	<td align="center">Country</td>

		    	<td align="center">Alter</td>
		    	<td align="center">Delete</td>
		   	</tr>
		    <tr>
		        <td align="center"><s:property value="AuthorID" /></td>
		        <td align="center"><s:property value="Name"/></td>
		        <td align="center"><s:property value="Age"/></td>
		        <td align="center"><s:property value="Country"/></td>

		        <td><a href='<s:url action="alter_prepare"><s:param name="ISBN" value="ISBN" /><s:param name="Title" value="Title" /><s:param name="AuthorID" value="AuthorID" /><s:param name="Publisher" value="Publisher" /><s:param name="PublishDate" value="PublishDate" /><s:param name="Price" value="Price" /></s:url>'>Alter</a></td>
		        <td><a href='<s:url action="delete"><s:param name="ISBN" value="ISBN" /></s:url>'>Delete</a></td>
		    </tr>    
	    </table>
	    <br/>
	    <s:form action="index">
			<s:submit value = "返回主界面"/>
		</s:form>
    	
    </center>
  </body>
</html>
