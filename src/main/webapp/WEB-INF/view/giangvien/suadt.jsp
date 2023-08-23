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

<h1> Chỉnh sửa đề tài </h1>

<h3 style="color:blue;">${message}</h3>

<form:form action = "?suadt" modelAttribute="dt">

	<p>
  	<label>Tên đề tài:</label><br>
  	<form:input path="TENDETAI" required="1"/>
  	</p>
  	
  	<p><label>Chuyên ngành: </label>
	<form:select path="CHUYENNGANH.IDCN" required="1">
	<c:forEach var="cn" items="${dscn}">
    <form:option value="${cn.IDCN}">${cn.TENCHUYENNGANH}</form:option>
    </c:forEach></form:select></p>
    
    <p>   	<label>Chi tiết đề tài:</label><br>
  	<form:textarea path="CHITIETDETAI" rows="20" style="background-color:#e1e1ea;"/> </p>
  
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