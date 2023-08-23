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

<h1> Sửa thông tin hội đồng </h1>

<h3 style="color:blue;">${message}</h3>

<form:form action = "?suahd" modelAttribute="hd">

	<p>
  	<label>ID Hội đồng: ${hd.IDHD}</label><br>
  	<form:input path="IDHD" type="hidden"/>
  	</p>

	<p><label>Chọn chủ tịch hội đồng:</label>
	<form:select path="CHUTICHHD.IDGV" required="1">
	<c:forEach var="gv" items="${dsgv}">
    <form:option value="${gv.IDGV}">${gv.HOGV} ${gv.TENGV}</form:option>
    </c:forEach></form:select></p>
    
    <p><label>Chọn thư ký:</label>
	<form:select path="THUKY.IDGV" required="1">
	<c:forEach var="gv" items="${dsgv}">
    <form:option value="${gv.IDGV}">${gv.HOGV} ${gv.TENGV}</form:option>
    </c:forEach></form:select></p>
    
    <p><label>Chọn ủy viên 1:</label>
	<form:select path="UV1.IDGV" required="1">
	<c:forEach var="gv" items="${dsgv}">
    <form:option value="${gv.IDGV}">${gv.HOGV} ${gv.TENGV}</form:option>
    </c:forEach></form:select></p>
    
    <p><label>Chọn ủy viên 2:</label>
	<form:select path="UV2.IDGV">
    <form:option value="NULL">-</form:option>
	<c:forEach var="gv" items="${dsgv}">
    <form:option value="${gv.IDGV}">${gv.HOGV} ${gv.TENGV}</form:option>
    </c:forEach>
    </form:select></p>
    
    <p><label>Chọn ủy viên 3:</label>
	<form:select path="UV3.IDGV">
    <form:option value="NULL">-</form:option>
	<c:forEach var="gv" items="${dsgv}">
    <form:option value="${gv.IDGV}">${gv.HOGV} ${gv.TENGV}</form:option>
    </c:forEach>
    </form:select></p>
  	
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