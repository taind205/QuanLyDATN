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

<h1> Sửa đồ án </h1>

<h3 style="color:blue;">${message}</h3>

<form:form action = "?suagvhd" modelAttribute="da">

	<p><label>Mã sinh viên: ${da.SINHVIEN.MASV}</label></p>
	<p><label>Họ tên sinh viên: ${da.SINHVIEN.HOSV} ${da.SINHVIEN.TENSV}</label></p>
	<p><label>Điểm TB tích lũy: ${da.SINHVIEN.DIEMTBTL}</label></p>
	<p><label>Số tín chỉ tích lũy: ${da.SINHVIEN.SOTCTL}</label></p>
	<form:input type="hidden" path="IDDA" value="${da.IDDA}" required="1"/>
	<form:input type="hidden" path="SINHVIEN.MASV" value="${da.SINHVIEN.MASV}" required="1"/>
	
	<p><label>Chọn giảng viên hướng dẫn</label>
	<form:select path="GIANGVIENHD.IDGV" required="1">
	<c:forEach var="gv" items="${dsgv}">
    <form:option value="${gv.IDGV}">${gv.HOGV} ${gv.TENGV}</form:option>
    </c:forEach></form:select></p>

	<p>
  	<label>Thời gian gặp giảng viên hướng dẫn:</label><br>
  	<form:input path="THOIGIANGAPGVHD" type="datetime-local"/>
  	</p>
  	
  	<p>
  	<label>Địa điểm gặp giảng viên hướng dẫn:</label><br>
  	<form:input path="DIADIEMGAPGVHD"/>
  	</p>
  	
  	<button>Sửa</button>
  	<button formaction="?xoagvhd">Xóa đồ án</button>
</form:form>

<footer>
<div class="container">
Khoa Công nghệ thông tin 2
</div>
<div>© 2022 Học viện Công nghệ Bưu chính Viễn thông - Cơ sở tại Thành phố Hồ Chí Minh</div>
</footer>
</body>
</html>