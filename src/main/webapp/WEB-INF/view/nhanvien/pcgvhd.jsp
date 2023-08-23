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

<h1> Phân công GVHD cho sinh viên </h1>

<h3 style="color:blue;">${message}</h3>

<form:form action = "?pcgvhd" modelAttribute="da">

	<p><label>Mã sinh viên: ${sv.MASV}</label></p>
	<p><label>Họ tên sinh viên: ${sv.HOSV} ${sv.TENSV}</label></p>
	<p><label>Điểm TB tích lũy: ${sv.DIEMTBTL}</label></p>
	<p><label>Số tín chỉ tích lũy: ${sv.SOTCTL}</label></p>
	<form:input type="hidden" path="SINHVIEN.MASV" value="${sv.MASV}" required="1"/>
	
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