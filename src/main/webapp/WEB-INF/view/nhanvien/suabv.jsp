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

<h1> Sửa thông tin bảo vệ đồ án </h1>

<h3 style="color:blue;">${message}</h3>

<form:form action = "?suabv" modelAttribute="bv">
	
	<form:input type="hidden" path="IDBV" value="${bv.IDBV}" required="1"/>		
	<p><label>Tên đề tài: ${bv.DOAN.IDDA}</label></p>
	<p><label>Sinh viên thực hiện: ${bv.DOAN.SINHVIEN.HOSV} ${bv.DOAN.SINHVIEN.TENSV}</label></p>
	<p><label>Giảng viên hướng dẫn: ${bv.DOAN.GIANGVIENHD.HOGV} ${bv.DOAN.GIANGVIENHD.TENGV}</label></p>
	<form:input type="hidden" path="DOAN.IDDA" value="${bv.DOAN.IDDA}" required="1"/>	
	
	<p><label>Chọn hội đồng chấm</label>
	<form:select path="HOIDONG.IDHD" required="1">
	<c:forEach var="hd" items="${dshd}">
    <form:option value="${hd.IDHD}">${hd.IDHD}</form:option>
    </c:forEach></form:select></p>

	<p>
  	<label>Thời gian bảo vệ đồ án:</label><br>
  	<form:input path="THOIGIANBV" type="datetime-local"/>
  	</p>
  	
  	<p>
  	<label>Địa điểm bảo vệ đồ án:</label><br>
  	<form:input path="DIADIEMBV"/>
  	</p>
  	
  	<button>Sửa</button>
  	<button formaction="?xoabv">Bỏ phân công</button>
</form:form>

<h4 style="color:#3333cc;"> Thông tin các hội đồng </h4>

<div style="margin-left:-200px; margin-right:-200px;">
<table>
  <thead>
    <tr>
      <th style="width:8%">ID Hội đồng</th>
      <th style="width:14%">Chủ tịch hội đồng</th>
      <th style="width:14%">Thư ký</th>
      <th style="width:14%">Ủy viên 1</th>
      <th style="width:14%">Ủy viên 2</th>
      <th style="width:14%">Ủy viên 3</th>
      <th style="width:12%">Ghi chú</th>
    </tr>
  </thead>
  <tbody>
  <c:forEach var="hd" items="${dshd2}">
    <tr>
      <td>${hd.IDHD}</td>
      <td>${hd.CHUTICHHD.HOGV} ${hd.CHUTICHHD.TENGV}</td>
      <td>${hd.THUKY.HOGV} ${hd.THUKY.TENGV}</td>
      <td>${hd.UV1.HOGV} ${hd.UV1.TENGV}</td>
      <td>${hd.UV2.HOGV} ${hd.UV2.TENGV}</td>
      <td>${hd.UV3.HOGV} ${hd.UV3.TENGV}</td>
      <td>${hd.GHICHU}</td>
    </tr>
    </c:forEach>
  </tbody>
</table>
</div>

<footer>
<div class="container">
Khoa Công nghệ thông tin 2
</div>
<div>© 2022 Học viện Công nghệ Bưu chính Viễn thông - Cơ sở tại Thành phố Hồ Chí Minh</div>
</footer>
</body>
</html>