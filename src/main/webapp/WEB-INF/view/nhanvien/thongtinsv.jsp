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

<h1> Cập nhật thông tin tài khoản sinh viên </h1>

<h3 style="color:blue;">${message}</h3>

<form action="nhanvien.htm" method="get">
	<input type="hidden" name="suasv">
  	<p><label>ID Tài khoản muốn chỉnh sửa:</label><br>
	<input type="text" name="idsv" required></p>
	
  	<button>Chỉnh sửa tài khoản</button>
  	
</form>
<p>Hoặc</p>
<a href="?themsv"><button>Thêm tài khoản sinh viên mới</button></a>

<h3>Danh sách sinh viên</h3>

<div style="margin-left:-240px; margin-right:-240px;">
<table>
  <thead>
    <tr>
      <th style="width:10%">Mã SV</th>
      <th style="width:16%">Họ tên SV</th>
      <th style="width:18%">Lớp</th>
      <th style="width:12%">Chuyên ngành</th>
      <th>Điểm TB tích lũy</th>
      <th>Số TC tích lũy</th>
      <th>Đủ ĐK xét TN</th>
      <th>Đủ ĐK làm ĐA</th>
      <th>Xác nhận làm ĐA</th>
      <th style="width:4%"></th>
      <th style="width:4.5%"></th>
    </tr>
  </thead>
  <tbody>
  <c:forEach var="sv" items="${dssv}">
    <tr>
      <td>${sv.MASV}</td>
      <td>${sv.HOSV} ${sv.TENSV}</td>
      <td>${sv.LOP.TENLOP}</td>
      <td>${sv.CHUYENNGANH.TENCHUYENNGANH}</td>
      <td>${sv.DIEMTBTL}</td>
      <td>${sv.SOTCTL}</td>
      <td>${sv.DUDKXETTN?'Có':'Không'}</td>
      <td>${sv.DUDKLAMDA?'Có':'Không'}</td>
      <td>${sv.XACNHANLAMDA?'Có':'Không'}</td>
      <td><a href="?suasv&idsv=${sv.MASV}">Sửa</a></td>
      <td><a href="?xoasv&idsv=${sv.MASV}">Xóa</a></td>
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