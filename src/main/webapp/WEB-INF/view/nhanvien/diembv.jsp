<%@ page pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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

<h3 style="color:blue;">${message}</h3>

<div style="margin-left:-300px; margin-right:-300px;">
<table>
  <thead>
    <tr>
      <th style="width:9%">ID Đồ án</th>
      <th style="width:22%">Tên đề tài</th>
      <th style="width:9%">ID Hội đồng</th>
      <th style="width:44%">Nhận xét hội đồng</th>
      <th style="width:7%">Điểm hội đồng</th>
      <th style="width:9%">Cập nhật</th>
    </tr>
  </thead>
  <tbody>
  <c:forEach var="bv" items="${dsbv}">
    <tr>
      <td>${bv.DOAN.IDDA}</td>
      <td>${bv.DOAN.DETAI.TENDETAI}</td>
      <td>${bv.HOIDONG.IDHD}</td>
      <td>${bv.NHANXET}</td>
      <td>${bv.DIEMHD}</td>
      <td><a href="?cndiembv&idbv=${bv.IDBV}">Cập nhật</a></td>
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