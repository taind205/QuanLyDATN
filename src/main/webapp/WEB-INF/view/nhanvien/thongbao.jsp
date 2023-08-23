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

<h1> Thông báo </h1>

<h3 style="color:blue;">${message}</h3>

<ul>
<c:forEach var="tb" items="${dsthongbao}">
 	<li><a href="?xemthongbao&id=${tb.IDTB}">${tb.TENTB}</a> 
 	<small style="color:#666666;">(${tb.THOIGIANTB.date}/${tb.THOIGIANTB.month+1}/${tb.THOIGIANTB.year+1900})</small></li>
 	</c:forEach>
</ul>

<h4> Thông báo đã phát </h4>

<div style="margin-left:-200px; margin-right:-200px;">
<table>
  <thead>
    <tr>
      <th style="width:8%">ID Thông báo</th>
      <th style="width:20%">Tên thông báo</th>
      <th style="width:43%">Nội dung thông báo</th>
      <th style="width:13%">Đối tượng thông báo</th>
      <th style="width:11%">Thời gian thông báo</th>
      <th style="width:5%">Xóa</th>
    </tr>
  </thead>
  <tbody>
  <c:forEach var="tb" items="${dstb2}">
    <tr>
      <td>${tb.IDTB}</td>
      <td>${tb.TENTB}</td>
      <td>${tb.NOIDUNGTB}</td>
      <td>${tb.TENDOITUONGTB}</td>
      <td>${tb.THOIGIANTB}</td>
      <td><a href="?xoatb&idtb=${tb.IDTB}">Xóa</a></td>
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