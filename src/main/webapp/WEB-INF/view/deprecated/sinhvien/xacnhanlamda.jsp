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

<h1> Xác nhận làm đồ án</h1>

<form>

<h4> Bạn có đủ điều kiện để làm đồ án tốt nghiệp</h4>

<p>
  <label>Hãy chọn hình thức thực hiện khối kiến thức tốt nghiệp:</label><br>
  <label style="color:DodgerBlue;"><input name="type" type="radio" value="do" /> Làm Đồ án tốt nghiệp </label> <br />
  <label style="color:DodgerBlue;"><input name="type" type="radio" value="learn" /> Học các học phần chuyên môn thay thế </label> <br />
<br>
</p>

 <p>
  <label>
  <input type="checkbox" id="checkbox" value="terms">
  <b>Tôi xác nhận đã chắc chắn với quyết định này</b>
  </label>
  </p>

  <button>Xác nhận</button>

</form>

<footer>
<div class="container">
Khoa Công nghệ thông tin 2
</div>
<div>© 2022 Học viện Công nghệ Bưu chính Viễn thông - Cơ sở tại Thành phố Hồ Chí Minh</div>
</footer>
</body>
</html>