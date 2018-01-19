<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="/WEB-INF/view/common/common.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>인서트 유저라고 십말</title>
</head>
<body>
<form action="<%=root%>/view/user/insert">
<input type="text" name="ai" value="이름">
<input type="text" name="ai" value="나이">
<input type="text" name="ai" value="아이디">
<input type="text" name="ai" value="비밀번호">
<input type="text" name="ai" value="주소">

<input type="submit" value="삽입">
</form>
</body>
</html>