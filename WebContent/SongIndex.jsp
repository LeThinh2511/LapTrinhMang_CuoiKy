<%@page import="model.bean.BaiHat"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Quản lý bài hát</title>
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
		ArrayList<BaiHat> items = (ArrayList<BaiHat>) request.getAttribute("items");
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
				<li class="breadcrumb-item"><a style="color: black;" class="nav-link" href="<%=request.getContextPath()%>/bai-hat">Danh sách bài hát</a></li>
			</ol>
		</div>

		<div class="row">
<!-- 			<div class="col-lg-8 col-md-7 col-sm-6">
				<h1></h1>
				<p class="lead">Danh sách bài hát</p>
			</div> -->
			<div class="col-lg-4 col-md-5 col-sm-6">
			</div>
		</div>
			<div class="row mt-2">
			
			<div class="col-md-6 col-6 col-sm-6">
				<form class="input-group" method="get" action="<%=request.getContextPath()%>/bai-hat">
					<input class="form-control" type="text" placeholder="Nhập từ khóa..." value="<%=key%>" name="key">
					<span class="input-group-btn mr-10">
						<button class="btn btn-dark" type="submit">Tìm kiếm</button>
					</span>
				</form>
			</div>
			<div class="col-md-6 col-6 col-sm-6">
				<div class="input-group">
					<span class="input-group-btn mr-10">
						<a class="btn btn-dark" href="<%=request.getContextPath()%>/tao-moi-bai-hat">+ Thêm</a>
					</span>
				</div>
			</div>
			
		</div>
		<div class="mt-2">
			<table class="table table-borderless">
				<thead class="thead-dark">
					<tr>
						<th scope="col">ID</th>
						<th scope="col">Tên bài hát</th>
						<th scope="col">Ngày tạo</th>
						<th scope="col">Chỉnh sửa</th>
					</tr>
				</thead>
				<tbody>
					<%
						for (BaiHat item : items) {
					%>
					<tr class="table-light">
						<td><%=item.getMa()%></td>
						<td><%=item.getTen()%></td>
						<td><%=item.getNgaytao()%></td>
						<td><a href="<%=request.getContextPath()%>/chinh-sua-bai-hat?id=<%=item.getMa()%>" class="btn btn-info  btn-dark sbold uppercase"> Sửa </a> 
							<a href="javascript:void(0)" data-id=<%=item.getMa()%> class="btn btn-danger btn-outline sbold uppercase deletePhongBan"> Xoá </a></td>
					
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
		$('.deletePhongBan').click(function () {
			var id = $(this).data("id");
			console.log(id);
		    var confirmText = "Are you sure you want to delete this object?";
		    if(confirm(confirmText)) {
		    	$.ajax({
		            type:"POST",
		            dataType:"json",
		            url: "<%=request.getContextPath()%>" + "/xoa-bai-hat",
		            data: {
		            	id: $(this).data("id") 
		            },
		            success: function () {
		            	alert("Xoa thanh cong");
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
