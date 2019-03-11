<div class="container">
	<form action="/items/${item.id}/update" method="post">
		<input type="hidden" name="id" value="${item.id}">
		Name:<br> <input type="text" name="name" value="${item.name}"><br>
		Description:<br> <input type="text" name="description" value="${item.description}"> <br>
		Quantity:<br> <input type="number" name="quantity" value="${item.quantity}"><br>
		Price:<br> <input type="number" name="price" value="${item.price}"><br> 
		<input type="hidden" name="productId" value="${item.productId}"><br> <br>
		<input type="submit" value="Save">
	</form>
</div>