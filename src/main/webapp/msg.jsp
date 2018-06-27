<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>${requestScope.msg }</h1>
<hr>
<c:forEach items="${requestScope.list}" var="u">
<hr>
<h3>姓名：${u.user_name }</h3>
<h3>年龄：${u.user_id }</h3>
<h3>密码：${u.pwd }</h3>
<h3>其他：${u.other }</h3>
<h3>姓名：${u.user_name }</h3>
</c:forEach>
</body>
</html>