<%@ page pageEncoding="utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Quản lý đồ án tốt nghiệp PTIT</title>

<link rel="stylesheet" href="simple-v1.css">

<script>
var idgv = [], htgv = [];
<c:forEach var="gv" items="${dsgv}">
	idgv.push(${gv.IDGV});
	htgv.push(${gv.HOGV}+" "+${gv.TENGV});
</c:forEach>
function initValue() {
		dsgv = document.get
	  var cthd = document.getElementById("cthd");
	  var tkhd = document.getElementById("tkhd");
	  var uv1 = document.getElementById("uv1");
	  var uv2 = document.getElementById("uv2");
	  var uv3 = document.getElementById("uv3");
	  
	  var v="";
	  for (let i = 0; i < idgv.length; i++) {
		  v+="<option value=\""+idgv[i]+"\">"+htgv[i]+"</option>";
		  console.log(htgv[i]);
		}
	  
	  //for(var gv in idgv){
	//	  	v+="<option value='"+${gv.IDGV}+"'>"+${gv.HOGV}+" "+${gv.TENGV}+"</option>"
	//	}
 		cthd.innerHTML = v;
		tkhd.innerHTML = v;
		uv1.innerHTML = v;
		uv2.innerHTML = v;
		uv3.innerHTML = v;
	}
</script>
</head>
<body onload="initValue();">
<jsp:include page="nav.jsp" />

<h1> Thêm hội đồng mới</h1>

<h3 style="color:blue;">${message}</h3>

<form action = "?themhd">

	<p>
  	<label>ID Hội đồng: </label><br>
  	<input required/>
  	</p>

	<p><label>Chọn chủ tịch hội đồng:</label>
	<select id="cthd" required>
	</select></p>
    
    <p><label>Chọn thư ký:</label>
	<select id="tkhd" required>
	</select></p>
    
    <p><label>Chọn ủy viên 1:</label>
	<select id="uv1" required>
	</select></p>
    
    <p><label>Chọn ủy viên 2:</label>
	<select id="uv2">
	</select></p>
    
    <p><label>Chọn ủy viên 3:</label>
	<select id="uv3">
	</select></p>
  	
  	<p>
  	<label>Ghi chú:</label><br>
  	<input name="GHICHU"/>
  	</p>
  	
  	<button>Thêm</button>
</form>
            
            <footer>
            <div class="container">
            Khoa Công nghệ thông tin 2
            </div>
            <div>© 2022 Học viện Công nghệ Bưu chính Viễn thông - Cơ sở tại Thành phố Hồ Chí Minh</div>
        </footer>
</body>
</html>