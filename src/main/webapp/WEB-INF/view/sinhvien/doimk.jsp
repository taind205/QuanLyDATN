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

<h1> Đổi mật khẩu tài khoản</h1>

<h3 style="color:red;">${message}</h3>

<form:form action = "?doimk" modelAttribute="passchange">
  <p>
  <label>Nhập mật khẩu cũ:</label><br>
  <form:input type="password" path="OLDPASS" required="1" pattern="[A-Za-z0-9!@#$%^&*_=+-]{1,19}"/>
  </p>
  
  <p>
  <label>Nhập mật khẩu mới:</label><br>
  <form:input type="password" path="NEWPASS" required="1" pattern="[A-Za-z0-9!@#$%^&*_=+-]{1,19}"/>
  </p>
  
   <p>
  <label>Xác nhận mật khẩu mới:</label><br>
  <form:input type="password" path="CONFIRMPASS" required="1" pattern="[A-Za-z0-9!@#$%^&*_=+-]{1,19}"/>
  </p>

  <button>Cập nhật</button>
</form:form>

<footer>
<div class="container">
Khoa Công nghệ thông tin 2
</div>
<div>© 2022 Học viện Công nghệ Bưu chính Viễn thông - Cơ sở tại Thành phố Hồ Chí Minh</div>
</footer>
</body>
</html>