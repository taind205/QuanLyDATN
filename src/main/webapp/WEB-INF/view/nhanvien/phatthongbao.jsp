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

<h1> Phát thông báo </h1>

<h3 style="color:blue;">${message}</h3>
<form:form action = "?phatthongbao" modelAttribute="thongbao">
<div>
	<label>Tên thông báo</label>
	<form:input path="TENTB" required="1"/>
</div>
<div>
	<label>Nội dung thông báo</label>
	<form:textarea path="NOIDUNGTB" rows="15" required="1"/>
</div>
<div>
	<label>Đối tượng thông báo</label>
	<form:radiobutton path="DOITUONGTB" value="SV" label="Sinh viên" required="1"/>
	<form:radiobutton path="DOITUONGTB" value="GV" label="Giảng viên" required="1"/>
	<form:radiobutton path="DOITUONGTB" value="NV" label="Nhân viên" required="1"/>
</div>


<div>
	<button>Phát thông báo</button>
</div>
</form:form>
            
            <footer>
            <div class="container">
            Khoa Công nghệ thông tin 2
            </div>
            <div>© 2022 Học viện Công nghệ Bưu chính Viễn thông - Cơ sở tại Thành phố Hồ Chí Minh</div>
        </footer>
</body>
</html>