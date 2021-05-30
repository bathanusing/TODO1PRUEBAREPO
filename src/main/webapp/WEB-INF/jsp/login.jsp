<%@ include file="common/header.jspf"%>
	<form:form method="post" modelAttribute="user">
		<legend>Por Favor Ingrese</legend>
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
		<button type="submit" class="btn btn-success">Ingresar</button>
	</form:form>
	<a href="/user/register">No estas Registrado? Registrate Gratis</a>
<%@ include file="common/footer.jspf"%>