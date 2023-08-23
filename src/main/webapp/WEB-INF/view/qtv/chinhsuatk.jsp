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

<h1> Chỉnh sửa thông tin tài khoản </h1>

<h3 style="color:blue;">${message}</h3>
<form:form modelAttribute="taikhoan" method="post">

  	<p><label>ID Tài khoản: ${taikhoan.ID}</label><br>
  	<form:input type="hidden" value="${ID}" path="ID"/>
  	<p><label>Loại tài khoản: ${taikhoan.LOAITK}</label><br>
  	<form:input type="hidden" value="${LOAITK}" path="LOAITK"/>

	<p><label>Đặt mật khẩu tài khoản:</label><br>
	<form:input type="password" path="MATKHAU" required="1"/>
	<br>
  	<button formaction = "qtv.htm?chinhsuatk" >Lưu</button>
  	<button type="reset">Nhập lại</button>
  	<button formaction="qtv.htm?xoatk">Xóa tài khoản</button>
  	<% session.invalidate(); %>
</form:form>



<footer>
<div class="container">
Khoa Công nghệ thông tin 2
</div>
<div>© 2022 Học viện Công nghệ Bưu chính Viễn thông - Cơ sở tại Thành phố Hồ Chí Minh</div>
</footer>
</body>
</html>