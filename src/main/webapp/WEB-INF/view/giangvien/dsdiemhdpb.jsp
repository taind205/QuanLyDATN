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

<h1> Chấm điểm hướng dẫn/phản biện đồ án </h1>

<h4 style="color:blue;">${message}</h4>

<h3> Danh sách đồ án đã hướng dẫn </h3>
<div style="margin-left:-300px; margin-right:-300px;">
<table>
  <thead>
    <tr>
      <th>Mã SV</th>
      <th>Họ tên SV</th>
      <th>Chuyên ngành</th>
      <th>Đề tài phân công</th>
      <th style="width:6%">Điểm hướng dẫn</th>
      <th style="width:30%">Nhận xét</th>
      <th style="width:6%">Đạt yêu cầu</th>
      <th style="width:8%">Chấm điểm</th>
    </tr>
  </thead>
  <tbody>
    <c:forEach var="da" items="${dsda}">
    <tr>
      <td>${da.SINHVIEN.MASV}</td>
      <td>${da.SINHVIEN.HOSV} ${da.SINHVIEN.TENSV}</td>
      <td>${da.SINHVIEN.CHUYENNGANH.TENCHUYENNGANH}</td>
      <td>${da.DETAI.TENDETAI}</td>
      <td>${da.DIEMHUONGDAN}</td>
      <td>${da.NHANXETGVHD}</td>
      <td>${da.DATYEUCAU?'Có':'Không'}</td>
      <td><a href="?cndiemhd&idda=${da.IDDA}">Cập nhật</a></td>
    </tr>
    </c:forEach>
  </tbody>
</table>
</div>

<h3> Danh sách đồ án đã phản biện </h3>
<div style="margin-left:-300px; margin-right:-300px;">
<table>
  <thead>
    <tr>
      <th>Mã SV</th>
      <th>Họ tên SV</th>
      <th>Chuyên ngành</th>
      <th>Tên đề tài</th>
      <th style="width:6%">Điểm phản biện</th>
      <th style="width:30%">Nhận xét</th>
      <th style="width:6%">Đạt yêu cầu</th>
      <th style="width:8%">Chấm điểm</th>
    </tr>
  </thead>
  <tbody>
    <c:forEach var="pb" items="${dspb}">
    <tr>
      <td>${pb.DOAN.SINHVIEN.MASV}</td>
      <td>${pb.DOAN.SINHVIEN.HOSV} ${pb.DOAN.SINHVIEN.TENSV}</td>
      <td>${pb.DOAN.DETAI.CHUYENNGANH.TENCHUYENNGANH}</td>
      <td>${pb.DOAN.DETAI.TENDETAI}</td>
      <td>${pb.DIEMPHANBIEN}</td>
      <td>${pb.NHANXETGVPB}</td>
      <td>${pb.DATYEUCAU?'Có':'Không'}</td>
      <td><a href="?cndiempb&idpb=${pb.IDPB}">Cập nhật</a></td>
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