<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="UTF-8"%>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
	<a class="navbar-brand " href="<%=request.getContextPath() %>/">Quản lý bài hát</a>

	<div class="collapse navbar-collapse" id="navbarColor01">
		<ul class="navbar-nav mr-auto">
		</ul>
		<form class="form-inline my-2 my-lg-0" id="loginForm" action="<%=request.getContextPath() %>/dang-xuat" method="POST">
				<button style="color: white;" class="btn btn-link my-2 my-sm-0" type="submit">Đăng xuất</button>
		</form>
	</div>
</nav>
	