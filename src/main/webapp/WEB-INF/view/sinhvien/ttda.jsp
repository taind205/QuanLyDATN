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

<h1> Thông tin đồ án</h1>

<h4 style="color:red;">${message}</h4>

<h3> Đề tài: </h3>
<h5 style="margin-top: -15px;">${da.DETAI.TENDETAI}</h5>

<textarea readonly rows="20" style="background-color:#e1e1ea; padding:10px;">
${da.DETAI.CHITIETDETAI}
</textarea>

<p style="margin-bottom: -15px;">Giảng viên hướng dẫn: ${da.GIANGVIENHD.HOCVI} 
${da.GIANGVIENHD.HOGV} ${da.GIANGVIENHD.TENGV}</p>
<ul>
<li>Số điện thoại: ${da.GIANGVIENHD.SDT}</li>
<li>Email: ${da.GIANGVIENHD.EMAIL}</li>
</ul>

<h3> Kết quả đồ án </h3>
<article style="background-color:#e1e1ea; padding:10px;">
<p>Điểm hướng dẫn: ${da.DIEMHUONGDAN}</p>
<p>Nhận xét của giảng viên hướng dẫn: <br>
<textarea readonly rows="7">${da.NHANXETGVHD}</textarea></p>
</article>
<br>
<article style="background-color:#e1e1ea; padding:10px;">
<p>Điểm phản biện: ${pb.DIEMPHANBIEN}</p>
<p>Nhận xét của giảng viên phản biện: <br>
<textarea readonly rows="7">${pb.NHANXETGVPB}</textarea></p>
</article>
<br>
<article style="background-color:#e1e1ea; padding:10px;">
<p>Điểm hội đồng: ${bv.DIEMHD}</p>
<p>Nhận xét của hội đồng: <br>
<textarea readonly rows="7">${bv.NHANXET}</textarea></p>
</article>

<p><b>Điểm cuối cùng: ${diemcuoicung}</b></p>

<footer>
<div class="container">
Khoa Công nghệ thông tin 2
</div>
<div>© 2022 Học viện Công nghệ Bưu chính Viễn thông - Cơ sở tại Thành phố Hồ Chí Minh</div>
</footer>
</body>
</html>