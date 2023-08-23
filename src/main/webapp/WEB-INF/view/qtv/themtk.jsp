<%@ page pageEncoding="utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Quản lý đồ án tốt nghiệp PTIT</title>

<link rel="stylesheet" href="simple-v1.css">

</head>
<body>
<jsp:include page="nav.jsp" />

<h1> Thêm tài khoản mới </h1>

<h3 style="color:blue;">${message}</h3>
<form:form action = "qtv.htm?themtk" modelAttribute="taikhoan" method="post">

  	<p><label>ID Tài khoản:</label><br>
  	<form:input path="ID" required="1"/>

	<p><label>Đặt mật khẩu tài khoản:</label><br>
	<form:input type="password" path="MATKHAU" required="1"/>

	<p><label>Chọn loại tài khoản</label>
	<form:select path="LOAITK" required="1">
    <option value="SV">Sinh viên</option>
    <option value="GV">Giảng viên</option>
    <option value="NV">Nhân viên</option>
    <option value="QTV">Quản trị viên</option>
  	</form:select></p>

	<p>
  	<label>Họ và tên đệm chủ tài khoản:</label><br>
  	<input type="text" name="hovatendem" required>
  	</p>

  	<p>
  	<label>Tên chủ tài khoản:</label><br>
  	<input type="text" name="ten" required>
  	</p>

	<p>
	<label>Số điện thoại</label><br>
	<input type="tel" id="phone" name="sdt">
	</p>

	<p>
  	<label>Email</label><br>
  	<input type="email" name="email">
  	</p>
	
  	<button class="btn btn-default">Thêm</button>
</form:form>


<footer>
<div class="container">
Khoa Công nghệ thông tin 2
</div>
<div>© 2022 Học viện Công nghệ Bưu chính Viễn thông - Cơ sở tại Thành phố Hồ Chí Minh</div>
</footer>
</body>
</html>