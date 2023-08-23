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

<h1> Lịch hướng dẫn/phản biện đồ án </h1>

<h4 style="color:blue;">${message}</h4>

<h3> Lịch hướng dẫn đồ án</h3>
<div style="margin-left:-260px; margin-right:-260px;">
<table>
  <thead>
    <tr>
      <th>Mã SV</th>
      <th>Họ tên SV</th>
      <th>SĐT sinh viên</th>
      <th>Chuyên ngành</th>
      <th>Đề tài phân công</th>
      <th>Thời gian gặp GVHD</th>
      <th>Địa điểm gặp GVHD</th>
    </tr>
  </thead>
  <tbody>
    <c:forEach var="da" items="${dsda}">
    <tr>
      <td>${da.SINHVIEN.MASV}</td>
      <td>${da.SINHVIEN.HOSV} ${da.SINHVIEN.TENSV}</td>
      <td>${da.SINHVIEN.SDT}</td>
      <td>${da.SINHVIEN.CHUYENNGANH.TENCHUYENNGANH}</td>
      <td>${da.DETAI.TENDETAI}</td>
      <td>${da.THOIGIANGAPGVHD.hours}:${da.THOIGIANGAPGVHD.minutes} Ngày
      ${da.THOIGIANGAPGVHD.date}/${da.THOIGIANGAPGVHD.month+1}/${da.THOIGIANGAPGVHD.year+1900}</td>
      <td>${da.DIADIEMGAPGVHD}</td>
    </tr>
    </c:forEach>
  </tbody>
</table>
</div>

<h3> Lịch phản biện đồ án</h3>
<div style="margin-left:-300px; margin-right:-300px;">
<table>
  <thead>
    <tr>
      <th>Tên đề tài</th>
      <th>Mã SV</th>
      <th>Họ tên SV</th>
      <th>SĐT sinh viên</th>
      <th>GVHD</th>
      <th>Điểm GVHD</th>
      <th>Thời gian phản biện</th>
      <th>Địa điểm phản biện</th>
    </tr>
  </thead>
  <tbody>
    <c:forEach var="pb" items="${dspb}">
    <tr>
      <td>${pb.DOAN.DETAI.TENDETAI}</td>
      <td>${pb.DOAN.SINHVIEN.MASV}</td>
      <td>${pb.DOAN.SINHVIEN.HOSV} ${pb.DOAN.SINHVIEN.TENSV}</td>
      <td>${pb.DOAN.SINHVIEN.SDT}</td>
      <td>${pb.DOAN.GIANGVIENHD.HOCVI} ${pb.DOAN.GIANGVIENHD.HOGV} ${pb.DOAN.GIANGVIENHD.TENGV}</td>
      <td>${pb.DOAN.DIEMHUONGDAN}</td>
      <td>${pb.THOIGIANPB.hours}:${pb.THOIGIANPB.minutes} Ngày
      ${pb.THOIGIANPB.date}/${pb.THOIGIANPB.month+1}/${pb.THOIGIANPB.year+1900}</td>
      <td>${pb.DIADIEMPB}</td>
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