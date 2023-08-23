<%@ page pageEncoding="utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Quản lý đồ án tốt nghiệp PTIT</title>

<link rel="stylesheet" href="simple-v1.css">

</head>
<body>
<jsp:include page="nav.jsp" />

<h1> Phân công GVPB cho sinh viên </h1>

<h3 style="color:blue;">${message}</h3>

<form:form action = "?pcgvpb" modelAttribute="pb">
	
	<p><label>Mã sinh viên: ${da.SINHVIEN.MASV}</label></p>
	<p><label>Họ tên sinh viên: ${da.SINHVIEN.HOSV} ${da.SINHVIEN.TENSV}</label></p>
	<p><label>Tên đề tài: ${da.DETAI.TENDETAI}</label></p>
	<p><label>Giảng viên hướng dẫn: ${da.GIANGVIENHD.HOCVI} 
	${da.GIANGVIENHD.HOGV} ${da.GIANGVIENHD.TENGV}</label></p>
	<p><label>Điểm giảng viên hướng dẫn: ${da.DIEMHUONGDAN}</label></p>
	<p><label>Nhận xét giảng viên hướng dẫn: ${da.NHANXETGVHD}</label></p>

	<form:input type="hidden" path="DOAN.IDDA" value="${da.IDDA}" required="1"/>
	
	<p><label>Chọn giảng viên phản biện</label>
	<form:select path="GIANGVIENPB.IDGV" required="1">
	<c:forEach var="gv" items="${dsgv}">
    <form:option value="${gv.IDGV}">${gv.HOGV} ${gv.TENGV}</form:option>
    </c:forEach></form:select></p>

	<p>
  	<label>Thời gian phản biện:</label><br>
  	<form:input path="THOIGIANPB" type="datetime-local"/>
  	</p>
  	
  	<p>
  	<label>Địa điểm phản biện:</label><br>
  	<form:input path="DIADIEMPB"/>
  	</p>
  	
  	<button>Thêm</button>
</form:form>

<footer>
<div class="container">
Khoa Công nghệ thông tin 2
</div>
<div>© 2022 Học viện Công nghệ Bưu chính Viễn thông - Cơ sở tại Thành phố Hồ Chí Minh</div>
</footer>
</body>
</html>