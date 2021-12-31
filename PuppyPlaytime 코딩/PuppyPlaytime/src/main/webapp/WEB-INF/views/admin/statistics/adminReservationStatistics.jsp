<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>개별 케이지 리스트</title>
<script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>
<style type ="text/css">

</style>
</head>
<body>
	<div>
		<table border = "1">
			<caption>예약 통계</caption>
			<colgroup>
				<col width="200px" />
				<col width="300px" />
			</colgroup>
			<thead>
				<tr>
					<th>년 - 월</th>
					<th>월별 예약 수</th>
				</tr>
			</thead>
			<tbody>
				<c:if test="${empty reservation}">
					<tr>
						<td colspan="2" align="center">승인된 예약 정보가 존재하지 않습니다.</td>
					</tr>
				</c:if>
				<c:forEach items="${reservation}" var="r">
					<tr>
						<td align ="center">${r.month}</td>
						<td align ="center">${r.reservation}회</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>