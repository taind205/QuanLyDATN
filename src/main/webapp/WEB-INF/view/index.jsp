<%@ page pageEncoding="utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Đăng nhập</title>

<link rel="stylesheet" href="simple-v1.css">

</head>
<body>
<header>
<p style="color:DodgerBlue;"><font size="+3"><b>Phần mềm quản lý đồ án tốt nghiệp</b></font></p>
<img src="logo-ptit.png" width="120" height="120">
</header>
<main>
<h4 style="color:red;">${message}</h4>

<div class="container">
<div class="login-form">
<form:form action="?" modelAttribute="login">

<h2>Đăng nhập vào website</h2>

<div class="input-box">
    <i ></i>
    <form:input type="text" placeholder="Nhập ID tài khoản" path="TAIKHOAN" 
    pattern="[A-Za-z0-9!@#$%^&*_=+-]{1,19}"/>
</div>
<div class="input-box">
    <i ></i>
    <form:input type="password" placeholder="Nhập mật khẩu" path="MATKHAU" 
    pattern="[A-Za-z0-9!@#$%^&*_=+-]{1,19}"/>
</div>
<div class="btn-box">
    <button type="submit">
        Đăng nhập
    </button>
</div>
   </form:form>
    </div>
    </div>
</main>

	<footer>
	    <div class="container">
	    Khoa Công nghệ thông tin 2
	    </div>
	    <div>© 2022 Học viện Công nghệ Bưu chính Viễn thông - Cơ sở tại Thành phố Hồ Chí Minh</div>
	</footer>
</body>
</html>