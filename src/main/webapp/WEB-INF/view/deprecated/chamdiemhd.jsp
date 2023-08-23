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

<h1> Chấm điểm hướng dẫn đồ án</h1>

<form>

  	<p><label>Mã số sinh viên: N19DCCN223</label></p>

 	<p><label>Họ tên sinh viên: Trần Duy B</label></p>

	<p><label>Chuyên ngành: Công nghệ phần mềm</label></p>

  	<p><label>Tên đề tài: Quản lý đồ án tốt nghiệp cho sinh viên khoa CNTT học viện cơ sở</label></p>

	<p>
  	<label>Nhận xét:</label><br>
  	<textarea rows="6"></textarea>
  	</p>
  	
  	<p>
  	<label for="mark">Điểm hướng dẫn: </label>
	<input type="number" id="mark" name="mark" min="0" max="10" step="0.01">
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