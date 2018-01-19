<%@page import="com.iot.test.vo.UserInfo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/view/common/common.jsp" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script>


</script>






<body>
<%
//String root = request.getContextPath();
List<UserInfo> userList = (List<UserInfo>) request.getAttribute("userList");
String str = (String) request.getAttribute("String");
if(str == null){
	str = "";	
}
%>

<br>유저리스트<br>


<table border='1'>
	<tr>
		<th>이름</th>
		<th>나이</th>
		<th>ID</th>
		<th>주소</th>
		<th>반번호</th>
	</tr>
	<c:forEach items="${userList}" var="ui">	
	<tr>
		<td>${ui.uiName }</td>
		<td>${ui.uiAge }</td>
		<td>${ui.uiId }</td>
		<td>${ui.address }</td>			
		<td>${ui.ciNo}</td>
	</tr>
	</c:forEach>
</table>

<form action="<%=root %>/view/user/search" onsubmit="return checkValue()">
	<select name="searchType">
		<option value="">선택</option>
		<option value="uiName">이름</option>
		<option value="uiAge">나이</option>
		<option value="uiId">아이디</option>
		<option value="address">주소</option>
		<option value="cino">반번호</option>
	</select>
	<input type="text" name="searchStr" value="<%=str%>"><input type="submit" value="검색">
</form>
<h1 >삭제를 하려면 꼭 입력하세요(잘못입력시 오류 나요)</h1>
<form action="<%=root%>/view/user/delete">

<input type="text" name="delete" placeholder="삭제하고 싶은 ID를 입력하세요">
<button>진짜삭제</button>
</form>
<h1>업데이트하고 싶은 유저 Id를 입력하세요 잘못하면 오류나요 아이디는 수정 불가능합니다</h1>
<form action="<%=root%>/view/user/update">
<input type="text" name="name" placeholder="이름">
<input type="text" name="age" placeholder="나이">
<input type="text" name="address" placeholder="주소">
<input type="text" name="update" placeholder="업데이트하고 싶은 유저ID를 입력하세요">
<button>진짜수정</button>
</form>
<a href="<%=root%>/view/user/insertuser.jsp"><h1>유저 추가<h1></a>
</body>
</html>