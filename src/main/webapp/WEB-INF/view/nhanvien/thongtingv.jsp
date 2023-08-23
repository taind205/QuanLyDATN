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

<h1> Cập nhật thông tin tài khoản giảng viên </h1>

<h3 style="color:blue;">${message}</h3>

<form action="nhanvien.htm" method="get">
	<input type="hidden" name="suagv">
  	<p><label>ID Tài khoản muốn chỉnh sửa:</label><br>
	<input type="text" name="idgv" required></p>
	
  	<button>Chỉnh sửa tài khoản</button>
  	
</form>
<p>Hoặc</p>
<a href="?themgv"><button>Thêm tài khoản giảng viên mới</button></a>

<h3>Danh sách giảng viên</h3>

<div style="margin-left:-200px; margin-right:-200px;">
<table>
  <thead>
    <tr>
      <th>Mã GV</th>
      <th>Họ tên GV</th>
      <th>Học vị</th>
      <th>SĐT</th>
      <th>Email</th>
      <th style="width:5%"></th>
      <th style="width:5%"></th>
    </tr>
  </thead>
  <tbody>
  <c:forEach var="gv" items="${dsgv}">
    <tr>
      <td>${gv.IDGV}</td>
      <td>${gv.HOGV} ${gv.TENGV}</td>
      <td>${gv.HOCVI}</td>
      <td>${gv.SDT}</td>
      <td>${gv.EMAIL}</td>
      <td><a href="?suagv&idgv=${gv.IDGV}">Sửa</a></td>
      <td><a href="?xoagv&idgv=${gv.IDGV}">Xóa</a></td>
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