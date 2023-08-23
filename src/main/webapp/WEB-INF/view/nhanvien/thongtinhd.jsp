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

<h1> Thông tin các hội đồng </h1>

<h3 style="color:blue;">${message}</h3>

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
      <th style="width:5%"></th>
      <th style="width:5%"></th>
    </tr>
  </thead>
  <tbody>
  <c:forEach var="hd" items="${dshd}">
    <tr>
      <td>${hd.IDHD}</td>
      <td>${hd.CHUTICHHD.HOGV} ${hd.CHUTICHHD.TENGV}</td>
      <td>${hd.THUKY.HOGV} ${hd.THUKY.TENGV}</td>
      <td>${hd.UV1.HOGV} ${hd.UV1.TENGV}</td>
      <td>${hd.UV2.HOGV} ${hd.UV2.TENGV}</td>
      <td>${hd.UV3.HOGV} ${hd.UV3.TENGV}</td>
      <td>${hd.GHICHU}</td>
      <td><a href="?suahd&idhd=${hd.IDHD}">Sửa</a></td>
      <td><a href="?xoahd&idhd=${hd.IDHD}">Xóa</a></td>
    </tr>
    </c:forEach>
  </tbody>
</table>
</div>

<a href="?themhd">Thêm hội đồng mới</a>

<footer>
<div class="container">
Khoa Công nghệ thông tin 2
</div>
<div>© 2022 Học viện Công nghệ Bưu chính Viễn thông - Cơ sở tại Thành phố Hồ Chí Minh</div>
</footer>
</body>
</html>