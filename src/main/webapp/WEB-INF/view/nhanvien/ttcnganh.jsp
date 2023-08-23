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

<h1> Thông tin các chuyên ngành </h1>

<h3 style="color:blue;">${message}</h3>

<div style="margin-left:-50px; margin-right:-50px;">
<table>
  <thead>
    <tr>
      <th style="width:15%">ID Chuyên ngành</th>
      <th>Tên chuyên ngành</th>
      <th style="width:15%">Mức điểm TB để làm đồ án</th>
      <th style="width:15%">Số tín chỉ cần để làm đồ án</th>
      <th style="width:20%">Ghi chú</th>
      <th style="width:7%"></th>
      <th style="width:7%"></th>
    </tr>
  </thead>
  <tbody>
  <c:forEach var="cn" items="${dscn}">
    <tr>
      <td>${cn.IDCN}</td>
      <td>${cn.TENCHUYENNGANH}</td>
      <td>${cn.DIEMLAMDA}</td>
      <td>${cn.SOTCLAMDA}</td>
      <td>${cn.GHICHU}</td>
      <td><a href="?suacn&idcn=${cn.IDCN}">Sửa</a></td>
      <td><a href="?xoacn&idcn=${cn.IDCN}">Xóa</a></td>
    </tr>
    </c:forEach>
  </tbody>
</table>
</div>

<a href="?themcn">Thêm chuyên ngành mới</a>

<footer>
<div class="container">
Khoa Công nghệ thông tin 2
</div>
<div>© 2022 Học viện Công nghệ Bưu chính Viễn thông - Cơ sở tại Thành phố Hồ Chí Minh</div>
</footer>
</body>
</html>