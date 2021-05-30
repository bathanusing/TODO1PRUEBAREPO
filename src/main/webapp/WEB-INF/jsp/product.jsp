<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
<div class="container">
	<form:form method="post" modelAttribute="product">
		<form:hidden path="id" />
		<fieldset class="form-group">
			<form:label path="productName">Nombre</form:label>
			<form:input path="productName" type="text" class="form-control"
				required="required" />
			<form:errors path="productName" cssClass="text-warning" />
		</fieldset>

		<fieldset class="form-group">
			<form:label path="productPrice">PrecioUnitario</form:label>
			<form:input path="productPrice" type="text" class="form-control"
				required="required" />
			<form:errors path="productPrice" cssClass="text-warning" />
		</fieldset>
		<fieldset class="form-group">
			<form:label path="productDescription">Descripción</form:label>
			<form:input path="productDescription" type="text" class="form-control"
				required="required" />
			<form:errors path="productDescription" cssClass="text-warning" />
		</fieldset>
		<fieldset class="form-group">
			<form:label path="productQuantity">Cantidad</form:label>
			<form:input path="productQuantity" type="text" class="form-control"
				required="required" />
			<form:errors path="productQuantity" cssClass="text-warning" />
		</fieldset>
		<button type="submit" class="btn btn-success">Agregar</button>
	</form:form>
</div>
<%@ include file="common/footer.jspf" %>