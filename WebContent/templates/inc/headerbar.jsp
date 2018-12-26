<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="UTF-8"%>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
	<a class="navbar-brand " href="<%=request.getContextPath() %>/bookList">Library</a>

	<div class="collapse navbar-collapse" id="navbarColor01">
		<ul class="navbar-nav mr-auto">
		</ul>
		<form class="form-inline my-2 my-lg-0" id="loginForm" action="<%=request.getContextPath() %>/logout" method="POST">
				<button style="color: white;" class="btn btn-link my-2 my-sm-0" type="submit">Log out</button>
		</form>
	</div>
</nav>
	