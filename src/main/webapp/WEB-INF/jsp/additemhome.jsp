<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="container">
	<form action="/item" method="post">
		Name:<br> <input type="text" name="name"><br>
		Description:<br> <input type="text" name="description"><br>
		Quantity:<br> <input type="number" name="quantity"><br>
		Price:<br> <input type="number" name="price"> <br> <br>
		Select the Product Type:   
		<select name="productId">
			<c:forEach begin="0" end="${fn:length(products) - 1}" var="index">
				<option value="<c:out value="${products[index].id}" />"><c:out
						value="${products[index].name}" /></option>
			</c:forEach>
		</select> <br> <br>
		<input type="submit" value="Save">
	</form>
</div>