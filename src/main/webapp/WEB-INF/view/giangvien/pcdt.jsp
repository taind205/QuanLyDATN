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

<h1> Phân công đề tài </h1>

<h3 style="color:blue;">${message}</h3>

<form:form action = "?pcdt" modelAttribute="da">

	<p><label>Mã sinh viên: ${da.SINHVIEN.MASV}</label></p>
	<p><label>Họ tên sinh viên: ${da.SINHVIEN.HOSV} ${da.SINHVIEN.TENSV}</label></p>
	<p><label>Lớp: ${da.SINHVIEN.LOP.TENLOP}</label></p>
	<p><label>Điểm trung bình tích lũy: ${da.SINHVIEN.DIEMTBTL}</label></p>
	<p><label>Số tín chỉ tích lũy: ${da.SINHVIEN.SOTCTL}</label></p>
	<p><label>Chuyên ngành: ${da.SINHVIEN.CHUYENNGANH.TENCHUYENNGANH}</label></p>
	
	<p><label>Chọn đề tài phân công cho sinh viên:</label>
	<form:select path="DETAI.IDDETAI" required="1">
	<c:forEach var="dt" items="${dsdt}">
    <form:option value="${dt.IDDETAI}">${dt.TENDETAI}</form:option>
    </c:forEach></form:select></p>
  	
  	<button>Phân công</button>
</form:form>
            
            <footer>
            <div class="container">
            Khoa Công nghệ thông tin 2
            </div>
            <div>© 2022 Học viện Công nghệ Bưu chính Viễn thông - Cơ sở tại Thành phố Hồ Chí Minh</div>
        </footer>
</body>
</html>