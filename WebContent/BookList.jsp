<%@page import="model.bean.Book"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Book list</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="icon" type="image/x-icon" href="favicon.ico">
<link rel="stylesheet" href="templates/css/bootstrap.min.css">
<link rel="stylesheet" href="templates/css/page.css">
<script src="templates/js/jquery.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
</head>
<body>
	<%
		// set table
		ArrayList<Book> books = (ArrayList<Book>) request.getAttribute("books");
		int start = 0;
		int totals = 8;
		if (request.getAttribute("totals") != null)
			totals = Integer.parseInt((String) request.getAttribute("totals"));

		try {
			start = Integer.parseInt(request.getParameter("page"));
		} catch (Exception e) {
			// TODO: handle exception
		}
		// check search
		String key = request.getParameter("key") != null ? request.getParameter("key") : "";
	%>
	<div class="container">
		<jsp:include page="templates/inc/headerbar.jsp"></jsp:include>
		<div class="page">
			<ol class="breadcrumb">
				<li class="breadcrumb-item"><a style="color: black;" class="nav-link" href="<%=request.getContextPath()%>/bookList">Book List</a></li>
			</ol>
		</div>

		<div class="row">
			<div class="col-lg-4 col-md-5 col-sm-6">
			</div>
		</div>
			<div class="row mt-2">
			
			<div class="col-md-6 col-6 col-sm-6">
				<form class="input-group" method="get" action="<%=request.getContextPath()%>/bookList">
					<input class="form-control" type="text" placeholder="Enter book name..." value="<%=key%>" name="key">
					<span class="input-group-btn mr-10">
						<button class="btn btn-dark" type="submit">Search</button>
					</span>
				</form>
			</div>
			<div class="col-md-6 col-6 col-sm-6">
				<div class="input-group">
					<span class="input-group-btn mr-10">
						<a class="btn btn-dark" href="<%=request.getContextPath()%>/addNewBook">Add new Book</a>
					</span>
				</div>
			</div>
			
		</div>
		<div class="mt-2">
			<table class="table table-borderless">
				<thead class="thead-dark">
					<tr>
						<th scope="col">ID</th>
						<th scope="col">Book name</th>
						<th scope="col">Date added</th>
						<th scope="col">Modify</th>
					</tr>
				</thead>
				<tbody>
					<%
						for (Book book : books) {
					%>
					<tr class="table-light">
						<td><%=book.getIdBook()%></td>
						<td><%=book.getName()%></td>
						<td><%=book.getDateAdded()%></td>
						<td><a href="<%=request.getContextPath()%>/modifyBook?id=<%=book.getIdBook()%>" class="btn btn-info  btn-dark sbold uppercase"> Modify </a> 
							<a href="javascript:void(0)" data-id=<%=book.getIdBook()%> class="btn btn-danger btn-outline sbold uppercase deleteBook"> Delete </a></td>
					
					</tr>
					<%
						}
					%>
				</tbody>
			</table>
		</div>
	</div>
</body>
<script>
	$(document).ready(function() {
		$('.deleteBook').click(function () {
			var id = $(this).data("id");
			console.log(id);
		    var confirmText = "Are you sure you want to delete this book?";
		    if(confirm(confirmText)) {
		    	$.ajax({
		            type:"POST",
		            dataType:"json",
		            url: "<%=request.getContextPath()%>" + "/deleteBook",
		            data: {
		            	id: $(this).data("id") 
		            },
		            success: function () {
		            	alert("Delete Successfully!");
		            	$(this).closest('tr').remove();
		            }
		            	
		        });
		    	$(this).closest('tr').remove();
		    }
		    
		    return false;
		});
	})
	
</script> 
</html>
