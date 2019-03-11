<div class="container">
	<form action="/products/${product.id}/update" method="post">
		<input type="hidden" name="id" value="${product.id}">
		Name:<br> <input type="text" name="name" value="${product.name}"> <br>
		Brand:<br> <input type="number" name="brands" value="${product.brands}"><br>
		<input type="submit" value="Save">
	</form>
</div>