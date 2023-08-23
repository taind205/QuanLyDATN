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

<h1> Cập nhật thông tin cá nhân</h1>

<form>

  <p>
  	<label>Họ và tên đệm:</label><br>
  	<input type="text" name="surname">
  	</p>

  	<p>
  	<label>Tên:</label><br>
  	<input type="text" name="first_name">
  	</p>

  <p>
  <label>Số điện thoại</label><br>
  <input type="tel" id="phone" name="phone">
  </p>


<p>
  <label>Email</label><br>
  <input type="email" name="email">
  </p>

  <button>Cập nhật</button>
</form>

<footer>
<div class="container">
Khoa Công nghệ thông tin 2
</div>
<div>© 2022 Học viện Công nghệ Bưu chính Viễn thông - Cơ sở tại Thành phố Hồ Chí Minh</div>
</footer>
</body>
</html>