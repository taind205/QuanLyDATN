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

<h1> Thông tin hội đồng đã tham gia </h1>

<h4 style="color:blue;">${message}</h4>

<h3> Danh sách hội đồng đã tham gia </h3>
<div style="margin-left:-240px; margin-right:-240px;">
<table>
  <thead>
    <tr>
      <th style="width:7%">Mã hội đồng</th>
      <th style="width:16%">Chủ tịch hội đồng</th>
      <th style="width:16%">Thư ký hội đồng</th>
      <th style="width:16%">Ủy viên 1</th>
      <th style="width:16%">Ủy viên 2</th>
      <th style="width:16%">Ủy viên 3</th>
      <th style="width:13%">Ghi chú</th>
    </tr>
  </thead>
  <tbody>
    <c:forEach var="hd" items="${dshd}">
    <tr>
      <td>${hd.IDHD}</td>
      <td>${hd.CHUTICHHD.HOCVI} ${hd.CHUTICHHD.HOGV} ${hd.CHUTICHHD.TENGV}</td> 
      <td>${hd.THUKY.HOCVI} ${hd.THUKY.HOGV} ${hd.THUKY.TENGV}</td> 
      <td>${hd.UV1.HOCVI} ${hd.UV1.HOGV} ${hd.UV1.TENGV}</td> 
      <td>${hd.UV2.HOCVI} ${hd.UV2.HOGV} ${hd.UV2.TENGV}</td>
      <td>${hd.UV3.HOCVI} ${hd.UV3.HOGV} ${hd.UV3.TENGV}</td>  
      <td>${hd.GHICHU}</td>
    </tr>
    </c:forEach>
  </tbody>
</table>
</div>

<h3> Lịch bảo vệ đồ án của các hội đồng đã tham gia</h3>
<div style="margin-left:-240px; margin-right:-240px;">
<table>
  <thead>
    <tr>
      <th>Tên đề tài</th>
      <th>Mã SV</th>
      <th>Họ tên SV</th>
      <th>ID Hội đồng</th>
      <th>Thời gian</th>
      <th>Địa điểm</th>
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