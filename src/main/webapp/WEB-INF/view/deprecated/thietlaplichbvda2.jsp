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

<h1> Thiết lập lịch bảo vệ đồ án</h1>

<form>

  	<p><label>ID Đồ án: 35</label></p>

 	<p><label><b>Tên đề tài: Quản lý đồ án tốt nghiệp cho sinh viên khoa CNTT học viện cơ sở</b></label></p>

	<p><label>Chuyên ngành: Công nghệ phần mềm</label></p>
	
	<p><label>GVHD: Nguyễn Văn A</label></p>
	
	<p><label>Điểm hướng dẫn: <b>8.0</b></label></p>
	
	<p><label>GVPB: Trần Trung B</label></p>
	
	<p><label>Điểm phản biện: <b>7.0</b></label></p>

  	<p>
  	<label for="idtb">Chọn ID Tiểu ban: </label>
	<input type="number" id="idtb" name="idtb">
	</p>
  	
  	<p><select>
    <option selected="selected" value="1">Chọn chủ tịch hội đồng</option>
    <option value="2">Nguyễn Văn C</option>
    <option value="3">Trần Trung A</option>
    <option value="4">Lê Thị D</option>
    <option value="5">Đặng Văn B</option>
    <option value="6">Nguyễn Đức T</option>
  </select></p>
  	
	<p>
  	<label>Thời gian</label><br>
  	<input type="text" name="time">
  	</p>
  	
  	<p>
  	<label>Địa điểm</label><br>
  	<input type="text" name="place">
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