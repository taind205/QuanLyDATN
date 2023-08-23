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

<h1> Thêm tài khoản sinh viên</h1>

<h3 style="color:blue;">${message}</h3>

<form:form action = "?themsv" modelAttribute="sv">

	<p>
  	<label>Mã sinh viên: </label><br>
  	<form:input path="MASV" required="1"/>
  	</p>

	<p>
  	<label>Họ và tên đệm sinh viên:</label><br>
  	<form:input path="HOSV" required="1" pattern="[^0-9]*" title="Họ và tên đệm không được chứa chữ số."/>
  	</p>
  	
	<p>
  	<label>Tên sinh viên:</label><br>
  	<form:input path="TENSV" required="1" pattern="[^0-9]*" title="Tên không được chứa chữ số."/>
  	</p>
  	
  	<p><label>Lớp</label>
	<form:select path="LOP.MALOP">
	<c:forEach var="lop" items="${dslop}">
    <form:option value="${lop.MALOP}">${lop.TENLOP}</form:option>
    </c:forEach></form:select></p>
  	
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
  	
  	<p><label>Chuyên Ngành</label>
	<form:select path="CHUYENNGANH.IDCN" required="1">
	<c:forEach var="cn" items="${dscn}">
    <form:option value="${cn.IDCN}">${cn.TENCHUYENNGANH}</form:option>
    </c:forEach></form:select></p>
  	
  	<p>
  	<label>Số điện thoại:</label><br>
  	<form:input path="SDT" type="tel" pattern="[0]{1}[0-9]{9}"/>
  	</p>
  	
  	<p>
  	<label>Email:</label><br>
  	<form:input path="EMAIL" type="email" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$"/>
  	</p>
  	
  	<p>   	<label>Điểm trung bình tích lũy:</label><br>
  	<form:input path="DIEMTBTL" type="number" min="0" max="4" step="0.01"/> </p>
  	<p>   	<label>Số tín chỉ tích lũy:</label><br>
  	<form:input path="SOTCTL" type="number" min="0" max="999" step="1"/> </p>
  	
  	<!-- 
  	<td>
  	<form:label path = "DUDKXETTN">Đủ điều kiện xét tốt nghiệp:</form:label></td>
      <td>
        <form:radiobutton path = "DUDKXETTN" value = "true" label = "Có" checked="checked"/>
        <form:radiobutton path = "DUDKXETTN" value = "false" label = "Không" />
      </td>
	<br> -->
  	<button>Thêm sinh viên</button>
</form:form>
            
            <footer>
            <div class="container">
            Khoa Công nghệ thông tin 2
            </div>
            <div>© 2022 Học viện Công nghệ Bưu chính Viễn thông - Cơ sở tại Thành phố Hồ Chí Minh</div>
        </footer>
</body>
</html>