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

<h1> Phân công giảng viên hướng dẫn và phản biện đồ án </h1>

<form>

  	<p><label>MSSV: N19DCCN154</label></p>
  	<p><label>Họ tên sinh viên: Vũ Trung D</label></p>
	<p><label>Chuyên ngành: Công nghệ phần mềm</label></p>
	<p><label>Điểm TB tích lũy: 3.0</label></p>

 	<p><select>
    <option selected="selected" value="1">Chọn giảng viên hướng dẫn</option>
    <option value="2">Nguyễn Văn C</option>
    <option value="3">Trần Trung A</option>
    <option value="4">Lê Thị D</option>
    <option value="5">Đặng Văn B</option>
    <option value="6">Nguyễn Đức T</option>
  </select></p>
  	
  	<p><select>
    <option selected="selected" value="1">Chọn giảng viên phản biện</option>
    <option value="2">Nguyễn Văn C</option>
    <option value="3">Trần Trung A</option>
    <option value="4">Lê Thị D</option>
    <option value="5">Đặng Văn B</option>
    <option value="6">Nguyễn Đức T</option>
  </select></p>

	<button>Phân công</button>
</form>

<footer>
<div class="container">
Khoa Công nghệ thông tin 2
</div>
<div>© 2022 Học viện Công nghệ Bưu chính Viễn thông - Cơ sở tại Thành phố Hồ Chí Minh</div>
</footer>
</body>
</html>