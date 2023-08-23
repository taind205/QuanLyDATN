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

<h1> Cập nhật điểm hội đồng cho đồ án </h1>

<form:form action = "?cndiembv" modelAttribute="bv">
	
	<form:input type="hidden" path="IDBV" value="${bv.IDBV}" required="1"/>		
	<p><label>Tên đề tài: ${bv.DOAN.DETAI.TENDETAI}</label></p>
	<p><label>Sinh viên thực hiện: ${bv.DOAN.SINHVIEN.HOSV} ${bv.DOAN.SINHVIEN.TENSV}</label></p>
	<p><label>Giảng viên hướng dẫn: ${bv.DOAN.GIANGVIENHD.HOGV} ${bv.DOAN.GIANGVIENHD.TENGV}</label></p>
	<p><label>Chuyên ngành: ${bv.DOAN.DETAI.CHUYENNGANH.TENCHUYENNGANH}</label></p>	
	
	<p><label>Hội đồng chấm: ${bv.HOIDONG.IDHD}</label>
	<ul>
		<li>Chủ tịch hội đồng: ${bv.HOIDONG.CHUTICHHD.HOCVI} 
		${bv.HOIDONG.CHUTICHHD.HOGV} ${bv.HOIDONG.CHUTICHHD.TENGV}</li>
		<li>Thư ký: ${bv.HOIDONG.THUKY.HOCVI} 
		${bv.HOIDONG.THUKY.HOGV} ${bv.HOIDONG.THUKY.TENGV}</li>
		<li>Ủy viên 1: ${bv.HOIDONG.UV1.HOCVI} 
		${bv.HOIDONG.UV1.HOGV} ${bv.HOIDONG.UV1.TENGV}</li>
		<c:forEach var="v" items="${uv2}">
		<li>Ủy viên 2: ${bv.HOIDONG.UV2.HOCVI} 
		${bv.HOIDONG.UV2.HOGV} ${bv.HOIDONG.UV2.TENGV}</li>
		</c:forEach>
		<c:forEach var="v" items="${uv3}">
		<li>Ủy viên 3: ${bv.HOIDONG.UV3.HOCVI} 
		${bv.HOIDONG.UV3.HOGV} ${bv.HOIDONG.UV3.TENGV}</li>
		</c:forEach>
	</ul>
	
	<p>   	<label>Điểm chủ tịch hội đồng:</label><br>
  	<form:input path="DIEMCTHD" type="number" min="0" max="10" step="0.05" required="1"/> </p>
  	<p>   	<label>Điểm thư ký:</label><br>
  	<form:input path="DIEMTK" type="number" min="0" max="10" step="0.05" required="1"/> </p>
  	<p>   	<label>Điểm ủy viên 1:</label><br>
  	<form:input path="DIEMUV1" type="number" min="0" max="10" step="0.05" required="1"/> </p>
  	<c:forEach var="v" items="${uv2}">
  	<p>   	<label>Điểm ủy viên 2:</label><br>
  	<form:input path="DIEMUV2" type="number" min="0" max="10" step="0.05"/> </p>
  	</c:forEach>
  	<c:forEach var="v" items="${uv3}">
  	<p>   	<label>Điểm ủy viên 3:</label><br>
  	<form:input path="DIEMUV3" type="number" min="0" max="10" step="0.05"/> </p>
  	</c:forEach>
  	<p>   	<label>Nhận xét của hội đồng:</label><br>
  	<form:textarea path="NHANXET" rows="16"/> </p>
  	
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