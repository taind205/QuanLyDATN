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

<h1> Sửa thông tin chuyên ngành </h1>

<h3 style="color:blue;">${message}</h3>

<form:form action = "?suacn" modelAttribute="cn">

	<p>
  	<label>ID chuyên ngành: ${cn.IDCN}</label><br>
  	<form:input path="IDCN" value="${cn.IDCN}" type="hidden"/>
  	</p>

	<p>
  	<label>Tên chuyên ngành:</label><br>
  	<form:input path="TENCHUYENNGANH" required="1"/>
  	</p>
  	
  	<p>
  	<label>Mức điểm TB để làm đồ án:</label><br>
  	<form:input path="DIEMLAMDA" type="number" min="0" max="4" step="0.01"/>
  	</p>
  	
  	<p>
  	<label>Số tín chỉ cần để làm đồ án:</label><br>
  	<form:input path="SOTCLAMDA" type="number" min="0" max="999" step="1"/>
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