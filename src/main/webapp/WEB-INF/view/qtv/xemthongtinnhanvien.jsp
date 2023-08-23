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

<h1> Thông tin nhân viên </h1>

<div style="margin-left:0px; margin-right:0px;">
<table>
  <thead>
    <tr>
      <th>ID Nhân viên</th>
      <th>Họ tên nhân viên</th>
      <th>Số điện thoại</th>
      <th>Email</th>
    </tr>
  </thead>
  <tbody>
  <c:forEach var="nv" items="${dsnhanvien}">
    <tr>
      <td>${nv.IDNV}</td>
      <td>${nv.HONV} ${nv.TENNV}</td>
      <td>${nv.SDT}</td>
      <td>${nv.EMAIL}</td>
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