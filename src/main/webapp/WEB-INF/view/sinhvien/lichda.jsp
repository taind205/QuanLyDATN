<%@ page pageEncoding="utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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

<h1> Lịch gặp mặt GVHD. Lịch phản biện/bảo vệ đồ án</h1>

<h4 style="color:red;">${message}</h4>

<c:forEach var="v" items="${lichgapgvhd}">
<h3> Lịch gặp mặt giảng viên hướng dẫn </h3>
<article style="background-color:#e1e1ea; padding:10px;">
<p style="margin-bottom: -15px;">Giảng viên hướng dẫn: ${da.GIANGVIENHD.HOCVI} 
${da.GIANGVIENHD.HOGV} ${da.GIANGVIENHD.TENGV}</p>
<ul>
<li>Số điện thoại: ${da.GIANGVIENHD.SDT}</li>
<li>Email: ${da.GIANGVIENHD.EMAIL}</li>
</ul>
<p>Thời gian gặp mặt giảng viên hướng dẫn: ${da.THOIGIANGAPGVHD.hours}:${da.THOIGIANGAPGVHD.minutes} 
Ngày ${da.THOIGIANGAPGVHD.date}/${da.THOIGIANGAPGVHD.month+1}/${da.THOIGIANGAPGVHD.year+1900}</p>
<p>Địa điểm gặp mặt giảng viên hướng dẫn: ${da.DIADIEMGAPGVHD} </p>
</article>
</c:forEach>

<c:forEach var="v" items="${lichpb}">
<h3> Lịch phản biện đồ án </h3>
<article style="background-color:#e1e1ea; padding:10px;">
<p style="margin-bottom: -15px;">Giảng viên phản biện: ${pb.GIANGVIENPB.HOCVI} 
${pb.GIANGVIENPB.HOGV} ${pb.GIANGVIENPB.TENGV}</p>
<ul>
<li>Số điện thoại: ${pb.GIANGVIENPB.SDT}</li>
<li>Email: ${pb.GIANGVIENPB.EMAIL}</li>
</ul>
<p>Thời gian phản biện: ${pb.THOIGIANPB.hours}:${pb.THOIGIANPB.minutes} 
Ngày ${pb.THOIGIANPB.date}/${pb.THOIGIANPB.month+1}/${pb.THOIGIANPB.year+1900}</p>
<p>Địa điểm phản biện: ${pb.DIADIEMPB} </p>
</article>
</c:forEach>

<c:forEach var="v" items="${lichbv}">
<h3> Lịch bảo vệ đồ án </h3>
<article style="background-color:#e1e1ea; padding:10px;">
<p>Hội đồng: ${bv.HOIDONG.IDHD} </p>
<p>Thời gian bảo vệ đồ án: ${bv.THOIGIANBV.hours}:${bv.THOIGIANBV.minutes} 
Ngày ${bv.THOIGIANBV.date}/${bv.THOIGIANBV.month+1}/${bv.THOIGIANBV.year+1900}</p>
<p>Địa điểm bảo vệ đồ án: ${bv.DIADIEMBV} </p>
</article>
</c:forEach>

<footer>
<div class="container">
Khoa Công nghệ thông tin 2
</div>
<div>© 2022 Học viện Công nghệ Bưu chính Viễn thông - Cơ sở tại Thành phố Hồ Chí Minh</div>
</footer>
</body>
</html>