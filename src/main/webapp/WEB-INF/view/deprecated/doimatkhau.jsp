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

<h1> Đổi mật khẩu tài khoản</h1>

<form>

  <p>
  <label>Nhập mật khẩu cũ:</label><br>
  <input type="password" id="oldpass" name="oldpass" required>
  </p>
  
  <p>
  <label>Nhập mật khẩu mới:</label><br>
  <input type="password" id="newpass" name="newpass" required>
  </p>
  
   <p>
  <label>Xác nhận mật khẩu mới:</label><br>
  <input type="password" id="confirmpass" name="confirmpass" required>
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