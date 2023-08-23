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

<h1> Sửa thông tin lớp </h1>

<h3 style="color:blue;">${message}</h3>

<form:form action = "?sualop" modelAttribute="lop">

	<p>
  	<label>Mã lớp: ${lop.MALOP}</label><br>
  	<form:input path="MALOP" value="${lop.MALOP}" type="hidden"/>
  	</p>

	<p>
  	<label>Tên lớp:</label><br>
  	<form:input path="TENLOP" required="1" pattern="{3,49}"/>
  	</p>
  	
  	<p>
  	<label>Niên khóa:</label><br>
  	<form:input path="NIENKHOA" pattern="[0-9._-]{4,19}"/>
  	</p>

  	<p>
  	<label>Ghi chú:</label><br>
  	<form:input path="GHICHU"/>
  	</p>
  	
  	<button>Cập nhật</button>
</form:form>
            
            <footer>
            <div class="container">
            Khoa Công nghệ thông tin 2
            </div>
            <div>© 2022 Học viện Công nghệ Bưu chính Viễn thông - Cơ sở tại Thành phố Hồ Chí Minh</div>
        </footer>
</body>
</html>