<div class="container">
	<form action="/products/${productId}/item" method="post">
		<%-- 		<input type="hidden" name="id" value="${item.id}"> --%>
		Name:<br> <input type="text" name="name"><br>
		Description:<br> <input type="text" name="description"><br>
		Quantity:<br> <input type="number" name="quantity"><br>
		Price:<br> <input type="number" name="price"> <br> <br>
		<%-- 		<input type="hidden" name="productId" value="${item.productId}"> --%>
		<input type="submit" value="Save">
	</form>
</div>