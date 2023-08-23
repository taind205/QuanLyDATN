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

<h1> Phân công giảng viên hướng dẫn cho sinh viên </h1>

<h4 style="color:blue;">${message}</h4>

<h3> Danh sách sinh viên chưa được phân công đồ án</h3>
<div style="margin-left:-200px; margin-right:-200px;">
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
    <c:forEach var="sv" items="${dssv}">
    <tr>
      <td>${sv.MASV}</td>
      <td>${sv.HOSV} ${sv.TENSV}</td>
      <td>${sv.DIEMTBTL }</td>
      <td>${sv.CHUYENNGANH.TENCHUYENNGANH}</td>
      <td><a href="?pcgvhd&idsv=${sv.MASV}"><button>Phân công</button></a></td>
    </tr>
    </c:forEach>
  </tbody>
</table>
</div>

<h3> Danh sách đồ án đã phân công</h3>
<div style="margin-left:-300px; margin-right:-300px;">
<table>
  <thead>
    <tr>
      <th>Mã SV</th>
      <th>Họ tên SV</th>
      <th>Điểm TBTL</th>
      <th>Chuyên ngành</th>
      <th>GVHD</th>
      <th>Thời gian gặp GVHD</th>
      <th>Địa điểm gặp GVHD</th>
      <th>Sửa</th>
    </tr>
  </thead>
  <tbody>
    <c:forEach var="da" items="${dsda}">
    <tr>
      <td>${da.SINHVIEN.MASV}</td>
      <td>${da.SINHVIEN.HOSV} ${da.SINHVIEN.TENSV}</td>
      <td>${da.SINHVIEN.DIEMTBTL }</td>
      <td>${da.SINHVIEN.CHUYENNGANH.TENCHUYENNGANH}</td>
      <td>${da.GIANGVIENHD.HOCVI} ${da.GIANGVIENHD.HOGV} ${da.GIANGVIENHD.TENGV}</td>
      <td>${da.THOIGIANGAPGVHD.hours}:${da.THOIGIANGAPGVHD.minutes} Ngày
      ${da.THOIGIANGAPGVHD.date}/${da.THOIGIANGAPGVHD.month+1}/${da.THOIGIANGAPGVHD.year+1900}</td>
      <td>${da.DIADIEMGAPGVHD}</td>
      <td><a href="?suagvhd&idda=${da.IDDA}"><button>Sửa</button></a></td>
    </tr>
    </c:forEach>
  </tbody>
</table>
</div>

<h3> Danh sách sinh viên xác nhận không làm đồ án</h3>
<div style="margin-left:-200px; margin-right:-200px;">
<table>
  <thead>
    <tr>
      <th>Mã SV</th>
      <th>Họ tên SV</th>
      <th>Lớp</th>
      <th>Điểm TBTL</th>
      <th>Chuyên ngành</th>
    </tr>
  </thead>
  <tbody>
    <c:forEach var="sv" items="${dssv2}">
    <tr>
      <td>${sv.MASV}</td>
      <td>${sv.HOSV} ${sv.TENSV}</td>
      <td>${sv.LOP.TENLOP}</td>
      <td>${sv.DIEMTBTL }</td>
      <td>${sv.CHUYENNGANH.TENCHUYENNGANH}</td>
    </tr>
    </c:forEach>
  </tbody>
</table>
</div>

<h3> Danh sách sinh viên chưa đủ điều kiện làm đồ án</h3>
<div style="margin-left:-200px; margin-right:-200px;">
<table>
  <thead>
    <tr>
      <th>Mã SV</th>
      <th>Họ tên SV</th>
      <th>Lớp</th>
      <th>Điểm TBTL</th>
      <th>Chuyên ngành</th>
    </tr>
  </thead>
  <tbody>
    <c:forEach var="sv" items="${dssv3}">
    <tr>
      <td>${sv.MASV}</td>
      <td>${sv.HOSV} ${sv.TENSV}</td>
      <td>${sv.LOP.TENLOP}</td>
      <td>${sv.DIEMTBTL }</td>
      <td>${sv.CHUYENNGANH.TENCHUYENNGANH}</td>
    </tr>
    </c:forEach>
  </tbody>
</table>
</div>

<h3> Danh sách sinh viên chưa xác nhận làm đồ án</h3>
<div style="margin-left:-200px; margin-right:-200px;">
<table>
  <thead>
    <tr>
      <th>Mã SV</th>
      <th>Họ tên SV</th>
      <th>Lớp</th>
      <th>Điểm TBTL</th>
      <th>Chuyên ngành</th>
    </tr>
  </thead>
  <tbody>
    <c:forEach var="sv" items="${dssv4}">
    <tr>
      <td>${sv.MASV}</td>
      <td>${sv.HOSV} ${sv.TENSV}</td>
      <td>${sv.LOP.TENLOP}</td>
      <td>${sv.DIEMTBTL }</td>
      <td>${sv.CHUYENNGANH.TENCHUYENNGANH}</td>
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