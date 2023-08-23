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

<h1> Thông tin sinh viên được phân công hướng dẫn </h1>

<div style="margin-left:-300px; margin-right:-300px;">
<table>
  <thead>
    <tr>
      <th>MSSV</th>
      <th>Họ tên sinh viên</th>
      <th>Chuyên ngành</th>
      <th>Số điện thoại</th>
      <th>Email</th>
      <th>Đề tài đã phân công</th>
      <th>Phân công</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td>N19DCCN123</td>
      <td>Lê Văn A</td>
      <td>Công nghệ phần mềm</td>
      <td>0934567890</td>
      <td>n19dccn123@student.ptithcm.edu.vn</td>
      <td>Quản lý đồ án tốt nghiệp cho sinh viên khoa CNTT</td>
      <td><button>Phân công</button></td>
    </tr>
    <tr>
      <td>N19DCCN133</td>
      <td>Phạm Văn Đức</td>
      <td>Hệ thống thông tin</td>
      <td>0934567890</td>
      <td>n19dccn133@student.ptithcm.edu.vn</td>
      <td>Phần mềm quản lý ký túc xá học viện cơ sở</td>
      <td><button>Phân công</button></td>
    </tr>
    <tr>
      <td>N19DCCN134</td>
      <td>Nguyễn Văn Duy</td>
      <td>Trí tuệ nhân tạo</td>
      <td>0912345678</td>
      <td>n19dccn134@student.ptithcm.edu.vn</td>
      <td>Phần mềm quản lý sân bóng đá học viện cơ sở</td>
      <td><button>Phân công</button></td>
    </tr>
  </tbody>
</table>
</div>
            
            <footer>
            <div class="container">
            Khoa Công nghệ thông tin 2
            </div>
            <div>© 2022 Học viện Công nghệ Bưu chính Viễn thông - Cơ sở tại Thành phố Hồ Chí Minh</div>
        </footer>
</body>
</html>