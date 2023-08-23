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

<h1> Chỉnh sửa đề tài </h1>

<h3 style="color:blue;">${message}</h3>

<div style="margin-left:-50px; margin-right:-50px;">
<table>
  <thead>
    <tr>
      <th>ID Đề tài</th>
      <th>Tên đề tài</th>
      <th>Chuyên ngành</th>
      <th>Ghi chú</th>
      <th style="width:7%"></th>
      <th style="width:7%"></th>
    </tr>
  </thead>
  <tbody>
  <c:forEach var="dt" items="${dsdt}">
    <tr>
      <td>${dt.IDDETAI}</td>
      <td>${dt.TENDETAI}</td>
      <td>${dt.CHUYENNGANH.TENCHUYENNGANH}</td>
      <td>${dt.GHICHU}</td>
      <td><a href="?suadt&iddt=${dt.IDDETAI}">Sửa</a></td>
      <td><a href="?xoadt&iddt=${dt.IDDETAI}">Xóa</a></td>
    </tr>
    </c:forEach>
  </tbody>
</table>
</div>

<a href="?themdt">Thêm đề tài mới</a>

<footer>
<div class="container">
Khoa Công nghệ thông tin 2
</div>
<div>© 2022 Học viện Công nghệ Bưu chính Viễn thông - Cơ sở tại Thành phố Hồ Chí Minh</div>
</footer>
</body>
</html>