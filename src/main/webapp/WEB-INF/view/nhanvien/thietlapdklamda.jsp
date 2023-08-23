<%@ page pageEncoding="utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Quản lý đồ án tốt nghiệp PTIT</title>

<link rel="stylesheet" href="simple-v1.css">

</head>
<body>
<jsp:include page="nav.jsp" />

<h1> Thiết lập điều kiện làm đồ án </h1>

<h3 style="color:blue;">${message}</h3>

<p><a href="?ttcnganh">Thiết lập ngưỡng điểm làm đồ án cho từng chuyên ngành</a></p>

<form:form action = "?thietlapdklamda" modelAttribute="dk">
	<p>   	<label>Thiết lập điều kiện làm đồ án bằng văn bản:</label><br>
  	<form:textarea path="DIEUKIENLAMDATN" value="${dk.DIEUKIENLAMDATN}" rows="15" 
  	style="background-color:#e1e1ea;"/> </p>

  	<p>   	<label>Thiết lập điều kiện xét tốt nghiệp bằng văn bản:</label><br>
  	<form:textarea path="DIEUKIENXETTN" value="${dk.DIEUKIENXETTN}" rows="15" 
  	style="background-color:#e1e1ea;"/> </p>
  	<p>   	<label>Thiết lập ngưỡng điểm đủ điều kiện xét tốt nghiệp:</label><br>
  	<form:input path="DIEMTBXETTN" value="${dk.DIEMTBXETTN}" type="number" min="0" max="4" step="0.01"/> </p>
  	<p>   	<label>Thiết lập số tín chỉ tích lũy đủ điều kiện xét tốt nghiệp:</label><br>
  	<form:input path="STCTLXETTN" value="${dk.STCTLXETTN}" type="number" min="0" max="999" step="1"/> </p>  	

	<form:input type="hidden" path="IDDK" value="${dk.IDDK}"/>
	
<button>Thiết lập</button>
</form:form>

<footer>
<div class="container">
Khoa Công nghệ thông tin 2
</div>
<div>© 2022 Học viện Công nghệ Bưu chính Viễn thông - Cơ sở tại Thành phố Hồ Chí Minh</div>
</footer>
</body>
</html>