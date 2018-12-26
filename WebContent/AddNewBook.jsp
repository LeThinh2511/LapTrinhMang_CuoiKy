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
<title>Add new Book</title>
</head>
<body>
	<div class="container">
		<jsp:include page="templates/inc/headerbar.jsp"></jsp:include>
		<div class="page">
			<ol class="breadcrumb">
				<li class="breadcrumb-item"><a href="<%=request.getContextPath()%>/bookList">Book List</a></li>
				<li class="breadcrumb-item active">Add new Book</li>
			</ol>
		</div>
		<form action="<%=request.getContextPath()%>/addNewBook" method="post">
			<fieldset>
				<legend>ADD NEW BOOK</legend>
				<span class="form-group">
					<input type="text" placeholder="Enter book name..."
						name="name" />
				</span>
				<button type="submit" class="btn btn-primary">ADD</button>
			</fieldset>
		</form>
	</div>
</body>
</html>