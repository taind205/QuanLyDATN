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

<h1> Phân công giảng viên phản biện cho đồ án</h1>

<h4 style="color:blue;">${message}</h4>

<h3> Danh sách đồ án chưa được phân công GVPB</h3>
<div style="margin-left:-240px; margin-right:-240px;">
<table>
  <thead>
    <tr>
      <th style="width:20%">Tên đề tài</th>
      <th>Mã SV</th>
      <th>Họ tên SV</th>
      <th>GVHD</th>
      <th>Điểm GVHD</th>
      <th>Phân GVPB</th>
    </tr>
  </thead>
  <tbody>
    <c:forEach var="da" items="${dsda}">
    <tr>
      <td>${da.DETAI.TENDETAI}</td>
      <td>${da.SINHVIEN.MASV}</td>
      <td>${da.SINHVIEN.HOSV} ${da.SINHVIEN.TENSV}</td>
      <td>${da.GIANGVIENHD.HOCVI} ${da.GIANGVIENHD.HOGV} ${da.GIANGVIENHD.TENGV}</td>
      <td>${da.DIEMHUONGDAN}
      <td><a href="?pcgvpb&idda=${da.IDDA}"><button>Phân công</button></a></td>
    </tr>
    </c:forEach>
  </tbody>
</table>
</div>

<h3> Danh sách đồ án đã phân công GVPB</h3>
<div style="margin-left:-240px; margin-right:-240px;">
<table>
  <thead>
    <tr>
      <th style="width:20%">Tên đề tài</th>
      <th>Mã SV</th>
      <th>Họ tên SV</th>
      <th>GVHD</th>
      <th>Điểm GVHD</th>
      <th>GVPB</th>
      <th style="width:7%">Sửa</th>
    </tr>
  </thead>
  <tbody>
    <c:forEach var="pb" items="${dspb}">
    <tr>
      <td>${pb.DOAN.DETAI.TENDETAI}</td>
      <td>${pb.DOAN.SINHVIEN.MASV}</td>
      <td>${pb.DOAN.SINHVIEN.HOSV} ${pb.DOAN.SINHVIEN.TENSV}</td>
      <td>${pb.DOAN.GIANGVIENHD.HOCVI} ${pb.DOAN.GIANGVIENHD.HOGV} ${pb.DOAN.GIANGVIENHD.TENGV}</td>
      <td>${pb.DOAN.DIEMHUONGDAN}</td>
      <td>${pb.GIANGVIENPB.HOCVI} ${pb.GIANGVIENPB.HOGV} ${pb.GIANGVIENPB.TENGV}</td>
      <td><a href="?suagvpb&idpb=${pb.IDPB}"><button>Sửa</button></a></td>
    </tr>
    </c:forEach>
  </tbody>
</table>
</div>

<h3> Danh sách đồ án chưa đạt yêu cầu GVHD</h3>
<div style="margin-left:-240px; margin-right:-240px;">
<table>
  <thead>
    <tr>
      <th style="width:20%">Tên đề tài</th>
      <th>Mã SV</th>
      <th>Họ tên SV</th>
      <th>GVHD</th>
      <th>Điểm GVHD</th>
      <th>Nhận xét GVHD</th>
    </tr>
  </thead>
  <tbody>
    <c:forEach var="da" items="${dsda2}">
    <tr>
      <td>${da.DETAI.TENDETAI}</td>
      <td>${da.SINHVIEN.MASV}</td>
      <td>${da.SINHVIEN.HOSV} ${da.SINHVIEN.TENSV}</td>
      <td>${da.GIANGVIENHD.HOCVI} ${da.GIANGVIENHD.HOGV} ${da.GIANGVIENHD.TENGV}</td>
      <td>${da.DIEMHUONGDAN}
      <td>${da.NHANXETGVHD}</td>
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