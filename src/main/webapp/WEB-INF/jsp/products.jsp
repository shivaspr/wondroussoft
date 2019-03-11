<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div>${msg}</div>
<table style="width: 50%">
	<head>
<style>
table, th, td {
	border: 2px solid black;
	border-collapse: collapse;
}

th, td {
	padding: 5px;
}

th, td {
	text-align: center;
}
</style>
	</head>
	<div class="container">
	<form action="/product"	method="get">
						<input type="submit" value="Add New Product"> </form>
	<form action="/item"	method="get">
						<input type="submit" value="Add New Item"> </form>
		<c:choose>
			<c:when test="${empty products}">
        No products found!
    </c:when>
			<c:otherwise>
				<form action="/products" method="get">
					<tr>
						<th>ID</th>
						<th>Name</th>
						<th>Brands</th>
					</tr>
					<c:forEach begin="0" end="${fn:length(products) - 1}" var="index">
						<br />
						<tr>
							<td><c:out value="${products[index].id}" /></td>
							<td><c:out value="${products[index].name}" /></td>
							<td><c:out value="${products[index].brands}" /></td>
							<td><a
								href="/products/<c:out value="${products[index].id}" />">edit</a></td>
							<td><a
								href="/products/delete/<c:out value="${products[index].id}" />">delete</a></td>
							<td><a
								href="/products/<c:out value="${products[index].id}" />/items">list</a></td>
						</tr>
					</c:forEach>
				</form>
			</c:otherwise>
		</c:choose>
	</div>
</table>