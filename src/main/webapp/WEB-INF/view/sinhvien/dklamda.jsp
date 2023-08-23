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

<h1> Điều kiện làm đồ án và xác nhận làm đồ án </h1>

<h4 style="color:red;">${message}</h4>

<h3>Điều kiện xét tốt nghiệp</h3>
<textarea readonly rows="15" style="background-color:#e1e1ea; padding:10px;">
${dk.DIEUKIENXETTN}</textarea>
<p>Mức điểm trung bình cần để xét tốt nghiệp: ${dk.DIEMTBXETTN}</p>
<p>Số tín chỉ tích lũy cần để xét tốt nghiệp: ${dk.STCTLXETTN}</p>
<br>
<h3>Điều kiện làm đồ án tốt nghiệp</h3>
<textarea readonly rows="15" style="background-color:#e1e1ea; padding:10px;">
${dk.DIEUKIENLAMDATN}</textarea>

<h3>Mức điểm làm đồ án tốt nghiệp theo từng chuyên ngành</h3>
<div style="margin-left:-50px; margin-right:-50px;">
<table>
  <thead>
    <tr>
      <th>Tên chuyên ngành</th>
      <th>Mức điểm TB để làm đồ án</th>
      <th>Số tín chỉ cần để làm đồ án</th>
      <th>Ghi chú</th>
    </tr>
  </thead>
  <tbody>
  <c:forEach var="cn" items="${dscn}">
    <tr>
      <td>${cn.TENCHUYENNGANH}</td>
      <td>${cn.DIEMLAMDA}</td>
      <td>${cn.SOTCLAMDA}</td>
      <td>${cn.GHICHU}</td>
    </tr>
    </c:forEach>
  </tbody>
</table>
</div>

<h3>Xác nhận làm đồ án tốt nghiệp</h3>
<article style="background-color:#e1e1ea; padding:10px;">
<p>Điểm trung bình tích lũy của bạn: ${sv.DIEMTBTL}<br>
Số tín chỉ tích lũy của bạn: ${sv.SOTCTL}<br>
Chuyên ngành của bạn: ${sv.CHUYENNGANH.TENCHUYENNGANH}</p>
</article>
<h4 style="color:blue;">${message2}</h4>
<c:forEach var="v" items="${dudk}">
	<form:form action = "?xnlamda" modelAttribute="sv">
	  	<div>
	  	<label>Bạn có chắc chắn làm đồ án tốt nghiệp không?</label><br>
		<form:radiobutton path="XACNHANLAMDA" value="True" label="Có, tôi xác nhận." required="1"/>
		<form:radiobutton path="XACNHANLAMDA" value="False" 
		label="Không, tôi muốn học các học phần chuyên môn thay thế." required="1"/>
		</div>
	  	<button>Cập nhật</button>
	</form:form>
 </c:forEach>

<footer>
<div class="container">
Khoa Công nghệ thông tin 2
</div>
<div>© 2022 Học viện Công nghệ Bưu chính Viễn thông - Cơ sở tại Thành phố Hồ Chí Minh</div>
</footer>
</body>
</html>