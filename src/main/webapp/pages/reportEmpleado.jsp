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
					<s:iterator value="grdEmpleados" var="item" status="estado">
						<tr>
							<td scope="row"><s:property value="#item.idEmpleado" /></td>
							<td><s:property value="#item.nombres" /></td>
							<td><s:property value="#item.apellidos" /></td>
							<td><s:property value="#item.tipoDocumento.descripcion" /></td>
							<td><s:property value="#item.nroDocumento" /></td>
							<td><s:property value="#item.telefono" /></td>
							<td><s:property value="#item.correo" /></td>
							<td><s:property value="#item.direccion" /></td>
							<td><s:property value="#item.fecha_nac" /></td>
							<td><s:property value="#item.fecha_ingreso" /></td>
							<td><s:property value="#item.cargo.nombre" /></td>
							<td><s:property value="#item.usuario.usuario" /></td>
							<td>
								<s:a action="updateEmpleado">
						      		<s:param name="codigo" value="#item.idEmpleado"></s:param>
						      		<i class="fas fa-edit"></i>
						      	</s:a>
						      	<s:a action="deleteEmpleado">
						      		<s:param name="codigo" value="#item.idEmpleado"></s:param>
						      		<i class="fas fa-trash-alt"></i>
						      	</s:a>
							</td>
					    </tr>	
				  	</s:iterator>	       
				  </tbody>
				</table>
			
      </section>
   	  </section>
    <!--main content end-->
	</div>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>

</body>
</html>