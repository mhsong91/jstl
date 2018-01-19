<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="/WEB-INF/view/common/common.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>인서트 유저입니다</title>
</head>
<%
%>
<body>
<form action="<%=root%>/view/user/insertuser">
<h1>무조건 인서트 값을 입력하세요 안그럼 에러나요</h1>
<input type="text" name="name" placeholder="이름">
<input type="text" name="age" placeholder="나이">
<input type="text" name="id" placeholder="아이디">
<input type="text" name="pwd" placeholder="비밀번호">
<input type="text" name="address" placeholder="주소">
<input type="text" name="cino" placeholder="반번호">
<button>삽입</button>
</form>
</body>

</html>