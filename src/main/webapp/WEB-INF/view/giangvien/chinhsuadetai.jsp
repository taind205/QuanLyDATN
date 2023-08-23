<%@ page pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Quản lý đồ án tốt nghiệp PTIT</title>

<link rel="stylesheet" href="simple-v1.css">

</head>
<body>
<jsp:include page="nav.jsp" />

<h1> Chỉnh sửa đề tài</h1>

<form>

  <p><select>
    <option selected="selected" value="0">Chọn đề tài</option>
    <option value="2">Quản lý đồ án tốt nghiệp cho sinh viên khoa CNTT học viện cơ sở</option>
    <option value="3">Quản lý sân bóng đá học viện cơ sở</option>
    <option value="4">Quản lý thư viện học viện cơ sở</option>
    <option value="new">Thêm đề tài mới</option>
  </select></p>

  <p>
  <label>Tên đề tài</label><br>
  <input type="text" name="name" required>
  </p>

  <p><select>
    <option selected="selected" value="0">Chọn chuyên ngành</option>
    <option value="1">Công nghệ phần mềm</option>
    <option value="2">Hệ thống thông tin</option>
  </select></p>

  <p>
  <label>Chi tiết đề tài</label><br>
  <textarea rows="10"></textarea>
  </p>

	<p>
  <label>Ghi chú</label><br>
  <textarea rows="4"></textarea>
  </p>
 
  <button>Cập nhật</button>
  <button type="reset">Nhập lại</button>
</form>

<footer>
<div class="container">
Khoa Công nghệ thông tin 2
</div>
<div>© 2022 Học viện Công nghệ Bưu chính Viễn thông - Cơ sở tại Thành phố Hồ Chí Minh</div>
</footer>
</body>
</html>