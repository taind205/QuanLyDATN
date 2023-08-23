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

<h1> Cập nhật điểm hướng dẫn đồ án </h1>

<h3 style="color:blue;">${message}</h3>

<form:form action = "?cndiemhd" modelAttribute="da">
	
	<p><label>Tên đề tài: ${da.DETAI.TENDETAI}</label></p>
	<p><label>Sinh viên thực hiện: ${da.SINHVIEN.HOSV} ${da.SINHVIEN.TENSV}</label></p>
	<p><label>Mã sinh viên: ${da.SINHVIEN.MASV}</label></p>
	<p><label>Chuyên ngành: ${da.DETAI.CHUYENNGANH.TENCHUYENNGANH}</label></p>	
	
	<p><label>Điểm hướng dẫn:</label><br>
  	<form:input path="DIEMHUONGDAN" type="number" min="0" max="10" step="0.05" required="1"/> </p>
  	
  	<p><label>Nhận xét:</label><br>
  	<form:textarea path="NHANXETGVHD" rows="16" required="1"/> </p>
  	
  	<div>
	<form:radiobutton path="DATYEUCAU" value="True" label="Đạt yêu cầu" required="1"/>
	<form:radiobutton path="DATYEUCAU" value="False" label="Không đạt yêu cầu" required="1"/>
	</div>
  	
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