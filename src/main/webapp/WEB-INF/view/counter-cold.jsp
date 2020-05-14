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
    <div class="container-fluid justify-content-center position-relative" style="width:80%; background-colour:">
        <div class="row border position-fixed" style="height:50px; width:80%">
            <div class="col-sm-12 align-self-center border justify-content-center bg-primary position-fixed" style="height:50px; width:80%">
            </div>
        </div>
        <div class="row position-relative" style="background-color:#313DA7;">
            <div class="col-sm-2 border p-10 position-relative">
            <br>
		        <ul class="position-fixed">
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
		            <div class="justify-content-center" style:"width:100%" >
			         <table class="table-striped table-responsive table-light" style:"width:50%; margin: 0 auto;" >
				            <p>Liczniki chłodu</p>
				     <tr>
					    <th class="p-0">Serial number</th>
					    <th class="p-0">Location</th>
					    <th class="p-3">Medium</th>
					    <th class="p-3">Address</th>
					    <th class="p-3">Value</th>
					    <th class="p-3">Unit</th>
					    <th class="p-3">Date</th>
					    <th class="p-3">Action</th>
				    </tr>

				    <c:forEach var="tempWat" items="${cold}">
					    <c:url var="specCounterLink" value="/counter/showSpecCounter">
						<c:param name="counterSerialNumber"
							value="${tempWat.counterSerialNumber}"></c:param>
					</c:url>
					<tr>
						<td class="p-0">${tempWat.counterSerialNumber}</td>
						<td class="p-0">${tempWat.counterLocation}</td>
						<td class="p-auto">${tempWat.counterMedium}</td>
						<td class="p-auto">${tempWat.counterAddress}</td>
						<td class="p-auto">${tempWat.counterValue}</td>
						<td class="p-auto">${tempWat.counterUnit}</td>
						<td class="p-auto">${tempWat.counterDate}</td>
						<td class="p-auto"><a href="${specCounterLink}">Wczytaj</a></td>
					</tr>

				    </c:forEach>

			    </table>
		    </div>
		   </div>
	    </div>

	    </div>
	</div>
</body>
</html>