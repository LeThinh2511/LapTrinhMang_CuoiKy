<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="UTF-8"%>

<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarTogglerDemo03" aria-controls="navbarTogglerDemo03"
		aria-expanded="false" aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>
	<div class="collapse navbar-collapse" id="navbarTogglerDemo03">
		<ul class="navbar-nav mr-auto mt-2 mt-lg-0">
			<li class="nav-item active"><a class="nav-link"
				href="<%=request.getContextPath()%>/bookList">Home <span
					class="sr-only">(current)</span>
			</a></li>
			<li class="nav-item active"><a class="nav-link"
				href="<%=request.getContextPath()%>/addNewBook">Add New Book <span
					class="sr-only">(current)</span>
			</a></li>
			<li class="nav-item active"><a class="nav-link"
				href="<%=request.getContextPath()%>/logout">Log out <span
					class="sr-only">(current)</span>
			</a></li>
		</ul>
		<form class="form-inline my-2 my-lg-0" method="get"
					action="<%=request.getContextPath()%>/bookList">
			<input class="form-control mr-sm-2" type="search"
				placeholder="Enter book name..." aria-label="Search" name="key">
			<button class="btn btn-outline-info my-2 my-sm-0 bg-dark" type="submit">Search</button>
		</form>
	</div>
</nav>