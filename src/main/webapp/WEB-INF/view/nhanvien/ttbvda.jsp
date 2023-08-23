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

<h1> Phân công bảo vệ đồ án</h1>

<h4 style="color:blue;">${message}</h4>

<h3> Danh sách đồ án chưa được xếp lịch bảo vệ</h3>
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
      <th>Điểm GVPB</th>
      <th>Xếp lịch</th>
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
      <td>${pb.DIEMPHANBIEN}</td>
      <td><a href="?pcbvda&idpb=${pb.IDPB}"><button>Xếp</button></a></td>
    </tr>
    </c:forEach>
  </tbody>
</table>
</div>

<h3> Danh sách đồ án đã xếp lịch bảo vệ</h3>
<div style="margin-left:-240px; margin-right:-240px;">
<table>
  <thead>
    <tr>
      <th style="width:20%">Tên đề tài</th>
      <th>Mã SV</th>
      <th>Họ tên SV</th>
      <th>ID Hội đồng</th>
      <th>Thời gian</th>
      <th>Địa điểm</th>
      <th>Sửa</th>
    </tr>
  </thead>
  <tbody>
    <c:forEach var="bv" items="${dsbv}">
    <tr>
      <td>${bv.DOAN.DETAI.TENDETAI}</td>
      <td>${bv.DOAN.SINHVIEN.MASV}</td>
      <td>${bv.DOAN.SINHVIEN.HOSV} ${bv.DOAN.SINHVIEN.TENSV}</td>
      <td>${bv.HOIDONG.IDHD}</td>
      <td>${bv.THOIGIANBV.hours}:${bv.THOIGIANBV.minutes} Ngày
      ${bv.THOIGIANBV.date}/${bv.THOIGIANBV.month+1}/${bv.THOIGIANBV.year+1900}</td>
      <td>${bv.DIADIEMBV}</td>
      <td><a href="?suabv&idbv=${bv.IDBV}"><button>Sửa</button></a></td>
    </tr>
    </c:forEach>
  </tbody>
</table>
</div>

<h3> Danh sách đồ án chưa đạt yêu cầu GVPB</h3>
<div style="margin-left:-240px; margin-right:-240px;">
<table>
  <thead>
    <tr>
      <th style="width:20%">Tên đề tài</th>
      <th>Mã SV</th>
      <th>Họ tên SV</th>
      <th>GVHD</th>
      <th>GVPB</th>
      <th>Điểm GVPB</th>
      <th>Nhận xét GVPB</th>
    </tr>
  </thead>
  <tbody>
    <c:forEach var="pb" items="${dspb2}">
    <tr>
      <td>${pb.DOAN.DETAI.TENDETAI}</td>
      <td>${pb.DOAN.SINHVIEN.MASV}</td>
      <td>${pb.DOAN.SINHVIEN.HOSV} ${pb.DOAN.SINHVIEN.TENSV}</td>
      <td>${pb.DOAN.GIANGVIENHD.HOCVI} ${pb.DOAN.GIANGVIENHD.HOGV} ${pb.DOAN.GIANGVIENHD.TENGV}</td>
      <td>${pb.GIANGVIENPB.HOCVI} ${pb.GIANGVIENPB.HOGV} ${pb.GIANGVIENPB.TENGV}</td>
      <td>${pb.DIEMPHANBIEN}</td>
      <td>${pb.NHANXETGVPB}</td>
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