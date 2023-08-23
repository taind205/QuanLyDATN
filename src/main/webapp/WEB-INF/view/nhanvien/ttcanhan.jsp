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

<h1> Cập nhật thông tin cá nhân </h1>

<h3 style="color:blue;">${message}</h3>

<form:form action = "?ttcanhan" modelAttribute="nv">

	<p>
  	<label>ID nhân viên: ${nv.IDNV}</label>
  	</p>

	<p>
  	<label>Họ và tên đệm nhân viên:</label><br>
  	<form:input path="HONV" required="1" pattern="[^0-9]*" title="Họ và tên đệm không được chứa chữ số."/>
  	</p>
  	
	<p>
  	<label>Tên nhân viên:</label><br>
  	<form:input path="TENNV" required="1" pattern="[^0-9]*" title="Tên không được chứa chữ số."/>
  	</p>
  	
  	<p>
  	<label>Số điện thoại:</label><br>
  	<form:input path="SDT" type="tel" pattern="[0]{1}[0-9]{9}"/>
  	</p>
  	
  	<p>
  	<label>Email:</label><br>
  	<form:input path="EMAIL" type="email" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$"/>
  	</p>
  	
  	<p><label>
	<input type="checkbox" required>
	<b>Tôi xác nhận thông tin trên là đúng sự thật</b>
	</label></p>
  	
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