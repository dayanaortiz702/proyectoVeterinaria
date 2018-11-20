<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>Insert title here</title>
<!-- <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous"> -->
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">
<link href="https://fonts.googleapis.com/css?family=Anton" rel="stylesheet"></head>

  <style type="text/css">
  	#inicio {
  		height: 100%; 
	    overflow-y: scroll auto;
	}

  </style>
</head>

<body>
	<div id="inicio">
	 <!--main content start-->
    <section id="main-content">
      <section class="wrapper">
      	<h1 style="font-family: 'Anton', sans-serif; color: #088A85;">MANTENIMIENTO DE EMPLEADOS</h1>
		
		<form action="a_registerEmpleado.action" class="mt-3">
			<input type="submit" value="Nuevo Empleado" class="btn btn-success"/>		
		</form>		
		
		<s:if test="noData==true">
			<table class="table mt-3" >
				<thead class="thead-dark">
					<tr>
						<th scope="col">CODIGO</th>
						<th scope="col">NOMBRES</th>
						<th scope="col">APELLIDOS</th>
						<th scope="col">TIPO DE DOC.</th>
						<th scope="col">DOCUMENTO</th>
						<th scope="col">TELEFONO</th>
						<th scope="col">CORREO</th>
						<th scope="col">DIRECCION</th>
						<th scope="col">FECHA NACIMIENTO</th>
						<th scope="col">FECHA DE INGRESO</th>
						<th scope="col">CARGO</th>
						<th scope="col">USUARIO</th>
						<th scope="col">ACCION</th>
					</tr>
				</thead>
				<tbody>
					<s:iterator value="beanList">
						<tr>
							<td><s:property value="idEmpleado" /></td>
							<td><s:property value="nombres" /></td>
							<td><s:property value="apellidos" /></td>
							<td><s:property value="idTipoDocumento" /></td>
							<td><s:property value="nroDocumento" /></td>
							<td><s:property value="telefono" /></td>
							<td><s:property value="correo" /></td>
							<td><s:property value="direccion" /></td>
							<td><s:property value="fecha_nac" /></td>
							<td><s:property value="fecha_ingreso" /></td>
							<td><s:property value="idCargo" /></td>
							<td><s:property value="idUsuario" /></td>
							<td>
								<a href="updateEmpleado.action?submitType=updatedata&idEmpleado=<s:property value="idEmpleado"/>">
									<i class="fas fa-edit"></i>
								</a>
								<a href="deleteEmpleado.action?idEmpleado=<s:property value="idEmpleado"/>">
									<i class="fas fa-trash-alt"></i>
								</a>
							</td>
						</tr>
					</s:iterator>
				</tbody>
			</table>
		</s:if>
		<s:else>
			<div style="color: red;">No existen datos</div>
		</s:else>
      </section>
   	  </section>
    <!--main content end-->
	</div>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>

</body>
</html>