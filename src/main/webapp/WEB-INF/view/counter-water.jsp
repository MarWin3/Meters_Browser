<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="pl-pl" lang="pl-pl"
	dir="ltr">
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>Counter list</title>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css" />

</head>
<body>

	<div class="b" style="position:fixed;">
		<ul>
			<li><a href="#">Wszystkie</a></li>
			<li><a href="#"><img src="<c:url value="/resources/image/electric.png"></c:url>">Elektryczne</a></li>
			<li><a href="#"><img src="<c:url value="/resources/image/water.png"></c:url>">Wodomierze</a></li>
			<li><a href="#"><img src="<c:url value="/resources/image/heat.png"></c:url>">Ciepło</a></li>
			<li><a href="#"><img src="<c:url value="/resources/image/cold.png"></c:url>">Chłód</a></li>
			<li><a href="#"><img src="<c:url value="/resources/image/gas.png"></c:url>">Gaz</a></li>
		</ul>

	</div>
	<div class="a">

		<table>
			<p>Liczniki wody</p>
			<tr>
				<th>Serial number</th>
				<th>Location</th>
				<th>Medium</th>
				<th>Address</th>
				<th>Action</th>
			</tr>
			<c:url var="generujRaport" value="/counter/generujraport">
			</c:url>
			<c:forEach var="tempWat" items="${wat}">
				<tr>
					<td>${tempWat.counterSerialNumber}</td>
					<td>${tempWat.counterLocation}</td>
					<td>${tempWat.counterMedium}</td>
					<td>${tempWat.counterAddress}</td>
					<td><a href="${generujRaport}">Generuj</a></td>
				</tr>

			</c:forEach>

		</table>
	</div>



</body>
</html>