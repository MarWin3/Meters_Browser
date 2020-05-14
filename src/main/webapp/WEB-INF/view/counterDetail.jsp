
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="pl-pl" lang="pl-pl"
	dir="ltr">
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>Counter list</title>
<base href = "http://localhost/" />
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/bootstrap.css" />
</head>
<body style="background-color:#D5D5D5">
    <div class="container-fluid justify-content-center position-relative" style="width:80%;">
        <div class="row position-relative" style="background-color:#313DA7;">
            <div class="col-sm-2 border p-10 position-relative" >
                <br>
		            <ul class="position-absolute" style="margin:auto;">
			        <li><a href="counter/list"><img
                    src="<c:url value="/resources/image/all_counters.png"></c:url>">Wszystkie</a></li>
                    <li><a href="counter/electricity"><img
                    src="<c:url value="/resources/image/electric.png"></c:url>">Elektryczne</a></li>
                    <li><a href="counter/water"><img
                 	src="<c:url value="/resources/image/water.png"></c:url>">Wodomierze</a></li>
                    <li><a href="counter/heat"><img
                    src="<c:url value="/resources/image/heat.png"></c:url>">Ciepło</a></li>
                    <li><a href="counter/cold"><img
                    src="<c:url value="/resources/image/cold.png"></c:url>">Chłód</a></li>
                    <li><a href="counter/gas"><img
                    src="<c:url value="/resources/image/gas.png"></c:url>">Gaz</a></li>
                    <li><a href="download/reports"><img
                    src="<c:url value="/resources/image/report.png"></c:url>">Raporty</a></li>
                    </ul>
		     </div>
	    <div class="col-sm-10 border justify-content-center text-center position-relative" style="overflow:scroll; overflow-x:hidden; height:900px">
		    <br>
		    <div>
			<p>Liczniki</p>
			<table class="table-striped text-center table-light">
				<tbody style="width=50%">
				    <tr>
					<th class="p-0">Serial number</th>
					<th class="p-4">Location</th>
					<th class="p-3">Medium</th>
					<th class="p-auto">Address</th>
					<th class="p-3">Value</th>
					<th class="p-3">Unit</th>
					<th class="px-3">Date</th>


				    </tr>

				<c:forEach var="tempCounter" items="${counter}">
					<tr>
						<td class="p-0">${tempCounter.counterSerialNumber}</td>
						<td class="p-0">${tempCounter.counterLocation}</td>
						<td class="p-auto">${tempCounter.counterMedium}</td>
						<td class="p-auto">${tempCounter.counterAddress}</td>
						<td class="p-auto">${tempCounter.counterValue}</td>
						<td class="p-auto">${tempCounter.counterUnit}</td>
						<td class="px-3">${tempCounter.counterDate}</td>
					</tr>

				</c:forEach>
                </tbody>
			</table>
		    </div>
	    </div>

	    </div>
	</div>
</body>
</html>