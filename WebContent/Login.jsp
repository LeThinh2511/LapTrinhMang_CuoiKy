<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Đăng nhập</title>
<link rel="stylesheet" href="templates/css/bootstrap.min.css">
<link rel="stylesheet" href="templates/css/page.css">
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-4 col-centered login-form border-primary">
				<form action="dangNhap" method="POST">
					<h1 class="bg-dark text-white">Đăng nhập</h1>
					<fieldset>
						<legend></legend>
						<div class="form-group">
							<label for="username">Tên đăng nhập</label> <input
								type="text" class="form-control" id="username" name="username"
								aria-describedby="emailHelp">
						</div>
						<div class="form-group">
							<label for="password">Password</label> <input
								type="password" class="form-control" id="password" name="password">
						</div>
						<button type="submit" class="btn btn-dark btn-login">Đăng nhập</button>
					</fieldset>
				</form>
			</div>
		</div>
	</div>
</body>
</html>