<%@page import="model.bean.Book"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="icon" type="image/x-icon" href="favicon.ico">
<link rel="stylesheet" href="templates/css/bootstrap.min.css">
<link rel="stylesheet" href="templates/css/page.css">
<title>Edit book</title>
</head>
<body>
	<%
		Book book = (Book) request.getAttribute("book");
	%>

	<div class="container">
		<jsp:include page="templates/inc/headerbar.jsp"></jsp:include>
		<div class="page">
			<ol class="breadcrumb">
				<li class="breadcrumb-item"><a href="<%=request.getContextPath()%>/bookList">Book List</a></li>
				<li class="breadcrumb-item active">Book detail</li>
			</ol>
		</div>
		<form action="<%=request.getContextPath()%>/modifyBook" method="post">
			<fieldset>
				<legend>CHANGE BOOK NAME</legend>
				<span class="form-group">
					<label for="name">Enter book's name: </label> 
					<input class="form-control" type="hidden" name="idBook" value="<%=book.getIdBook()%>">
					<input class="form-control" type="text" name="name" value="<%=book.getName()%>"> 
				</span>
				<span class="form-group">
					<label for="name">Enter author's name: </label> 
					<input class="form-control" type="hidden" name="idBook" value="<%=book.getIdBook()%>">
					<input class="form-control" type="text" name="name" value="<%=book.getAuthor()%>"> 
				</span>
				<button type="submit" class="btn btn-primary">Save</button>
			</fieldset>
		</form>
	</div>
</body>
</html>