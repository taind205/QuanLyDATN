<%@ page pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Quản lý đồ án tốt nghiệp PTIT</title>

<link rel="stylesheet" href="simple-v1.css">

</head>
<body>
<jsp:include page="nav.jsp" />

<h1> Cập nhật thông tin đăng nhập trong cơ sở dữ liệu </h1>

<h3 style="color:blue;">${message}</h3>

<form action="qtv.htm" method="get">

  	<p><label>ID Tài khoản muốn chỉnh sửa:</label><br>
	<input type="text" name="id" required></p>
	
  	<button>Chỉnh sửa tài khoản</button>
  	
</form>
<p>Hoặc</p>
<a href="?themtk"><button>Thêm tài khoản mới</button></a>

<footer>
<div class="container">
Khoa Công nghệ thông tin 2
</div>
<div>© 2022 Học viện Công nghệ Bưu chính Viễn thông - Cơ sở tại Thành phố Hồ Chí Minh</div>
</footer>
</body>
</html>