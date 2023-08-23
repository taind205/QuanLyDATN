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

<h1> Sửa thông tin tài khoản giảng viên </h1>

<h3 style="color:blue;">${message}</h3>

<form:form action = "?suagv" modelAttribute="gv" method="post">

	<p>
  	<label>Mã giảng viên: ${gv.IDGV}</label><br>
  	<form:input type="hidden" path="IDGV" value="${gv.IDGV}" required="1"/>
  	</p>

	<p>
  	<label>Họ và tên đệm giảng viên:</label><br>
  	<form:input path="HOGV" required="1"/>
  	</p>
  	
	<p>
  	<label>Tên giảng viên:</label><br>
  	<form:input path="TENGV" required="1"/>
  	</p>
  	
  	<p><label>Giới tính</label>
	<form:select path="PHAI">
    <form:option value="Nam">Nam</form:option>
    <form:option value="Nữ">Nữ</form:option>
    <form:option value="Khác">Khác</form:option>
  	</form:select></p>
  	
  	<p>
	<label>Ngày sinh</label>
	<form:input path="NGAYSINH" type="date" placeholder="dd-MM-yyyy"/>
	</p>
  	
  	<p>
  	<label>Số điện thoại:</label><br>
  	<form:input path="SDT" type="tel" pattern="[0]{1}[0-9]{9}"/>
  	</p>
  	
  	<p>
  	<label>Email:</label><br>
  	<form:input path="EMAIL" type="email" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$"/>
  	</p>
  	
  	<p>
  	<label>Học vị:</label><br>
  	<form:select path="HOCVI">
    <form:option value="Tú tài">Tú tài</form:option>
    <form:option value="Cử nhân">Cử nhân</form:option>
    <form:option value="Kỹ sư">Kỹ sư</form:option>
    <form:option value="Thạc sĩ">Thạc sĩ</form:option>
    <form:option value="Tiến sĩ">Tiến sĩ</form:option>
    <form:option value="Tiến sĩ Khoa học">Tiến sĩ Khoa học</form:option>
  	</form:select></p>
	
	<p><label>Đặt mật khẩu tài khoản:</label><br>
	<input type="password" name="mk" value="${mk}" required/>
	<br>
  	<button>Lưu</button>
</form:form>
            
            <footer>
            <div class="container">
            Khoa Công nghệ thông tin 2
            </div>
            <div>© 2022 Học viện Công nghệ Bưu chính Viễn thông - Cơ sở tại Thành phố Hồ Chí Minh</div>
        </footer>
</body>
</html>