<%@ page pageEncoding="utf-8"%>
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

<h4 style="color:blue;">${message}</h4>

<h3> Danh sách sinh viên chưa được phân công đề tài</h3>
<div style="margin-left:-160px; margin-right:-160px;">
<table>
  <thead>
    <tr>
      <th>Mã SV</th>
      <th>Họ tên SV</th>
      <th>Điểm TBTL</th>
      <th>Chuyên ngành</th>
      <th>Phân công</th>
    </tr>
  </thead>
  <tbody>
    <c:forEach var="da" items="${dsda1}">
    <tr>
      <td>${da.SINHVIEN.MASV}</td>
      <td>${da.SINHVIEN.HOSV} ${da.SINHVIEN.TENSV}</td>
      <td>${da.SINHVIEN.DIEMTBTL }</td>
      <td>${da.SINHVIEN.CHUYENNGANH.TENCHUYENNGANH}</td>
      <td><a href="?pcdt&idda=${da.IDDA}">Phân công</a></td>
    </tr>
    </c:forEach>
  </tbody>
</table>
</div>

<h3> Danh sách sinh viên đã được phân công đề tài</h3>
<div style="margin-left:-250px; margin-right:-250px;">
<table>
  <thead>
    <tr>
      <th>Mã SV</th>
      <th>Họ tên SV</th>
      <th>Điểm TBTL</th>
      <th>Chuyên ngành</th>
      <th>Đề tài phân công</th>
      <th>Phân công</th>
      <th>Hủy phân công</th>
    </tr>
  </thead>
  <tbody>
    <c:forEach var="da" items="${dsda2}">
    <tr>
      <td>${da.SINHVIEN.MASV}</td>
      <td>${da.SINHVIEN.HOSV} ${da.SINHVIEN.TENSV}</td>
      <td>${da.SINHVIEN.DIEMTBTL }</td>
      <td>${da.SINHVIEN.CHUYENNGANH.TENCHUYENNGANH}</td>
      <td>${da.DETAI.TENDETAI}</td>
      <td><a href="?pcdt&idda=${da.IDDA}">Sửa</a></td>
      <td><a href="?huypcdt&idda=${da.IDDA}">Hủy phân công</a></td>
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