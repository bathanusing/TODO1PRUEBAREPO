<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
	
	<div class="container">
		<table class="table table-striped">
			<caption>Tus Productos son</caption>
			<thead>
				<tr>
					<th>Nombre</th>
					<th>Precio Unitario</th>
					<th>Descripción</th>
					<th>Cantidad</th>
					<th></th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${products}" var="product">
					<tr>
						<td>${product.productName}</td>
						<td>${product.productPrice}</td>
						<td>${product.productDescription}</td>
						<td>${product.productQuantity}</td>
						<td><a type="button" class="btn btn-success"
							href="/update-product?id=${product.id}">Actualizar Registro</a></td>
						<td><a type="button" class="btn btn-warning"
							href="/delete-product?id=${product.id}">Borrar Registro</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div>
			<a class="button" href="/addProduct">Agregar Productos</a>
		</div>
	</div>
<%@ include file="common/footer.jspf" %>