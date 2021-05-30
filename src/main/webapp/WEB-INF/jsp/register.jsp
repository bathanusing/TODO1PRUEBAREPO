<%@ include file="common/header.jspf"%>
	<form:form method="post" action="add" modelAttribute="user">
		<legend>Registrese</legend>
		<form:hidden path="id" />
		<fieldset class="form-group">
			<form:label path="username">Usuario</form:label>
			<form:input path="username" type="text" class="form-control"
				required="required" />
			<form:errors path="username" cssClass="text-warning" />
		</fieldset>
		<fieldset class="form-group">
			<form:label path="password">Clave</form:label>
			<form:input path="password" type="password" class="form-control"
				required="required" />
			<form:errors path="password" cssClass="text-warning" />
		</fieldset>
		<fieldset class="form-group">
			<form:label path="name">Nombre</form:label>
			<form:input path="name" type="text" class="form-control"
				required="required" />
			<form:errors path="name" cssClass="text-warning" />
		</fieldset>
		<fieldset class="form-group">
			<form:label path="lastname">Apellido</form:label>
			<form:input path="lastname" type="text" class="form-control"
				required="required" />
			<form:errors path="lastname" cssClass="text-warning" />
		</fieldset>
		<fieldset class="form-group">
			<form:label path="address">Dirección</form:label>
			<form:input path="address" type="text" class="form-control"
				required="required" />
			<form:errors path="address" cssClass="text-warning" />
		</fieldset>
		<fieldset class="form-group">
		<form:hidden path="roles" />
			<form:input path="roles" type="text" class="form-control"
					required="required" value="USER"/>
		</fieldset>
		<button type="submit" class="btn btn-success">Registrarse</button>
	</form:form>
	<a href="/login">Regresar</a>
<%@ include file="common/footer.jspf"%>