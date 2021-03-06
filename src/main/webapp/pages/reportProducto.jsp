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
      	<h1 style="font-family: 'Anton', sans-serif; color: #088A85;">MANTENIMIENTO DE PRODUCTO</h1>
		
		<form action="a_registerProducto.action" class="mt-3">
			<input type="submit" value="Nuevo Producto" class="btn btn-success"/>		
		</form>	
			<table class="table mt-3" >
				<thead class="thead-dark">
					<tr>
						<th scope="col">CODIGO</th>
						<th scope="col">DESCRIPCION</th>
						<th scope="col">MARCA</th>
						<th scope="col">PRECIO</th>
						<th scope="col">CATEGORIA</th>
						<th scope="col">PROVEEDOR</th>
						<th scope="col">UNIDAD DE MEDIDA</th>
						<th scope="col">STOCK ACTUAL</th>
						<th scope="col">STOCK MINIMO</th>
						
						<th scope="col">ACCION</th>
					</tr>
				</thead>
				<tbody>
					<s:iterator value="grdProducto" var="item" status="estado">
						<tr>
							<td scope="row"><s:property value="#item.idProducto" /></td>
							<td><s:property value="#item.descripcion" /></td>
							<td><s:property value="#item.marca.descripcion" /></td>
							<td><s:property value="#item.precioCompra" /></td>
							<td><s:property value="#item.categoria.categoria" /></td>
							<td><s:property value="#item.proveedor.razonSocial" /></td>
							<td><s:property value="#item.unidad.descripcion" /></td>
							<td><s:property value="#item.stockActual" /></td>
							<td><s:property value="#item.stockminimo" /></td>
							<td>
								<s:a action="updateProducto">
						      		<s:param name="codigo" value="#item.idProducto"></s:param>
						      		<i class="fas fa-edit"></i>
						      	</s:a>
						      	<s:a action="deleteProducto">
						      		<s:param name="codigo" value="#item.idProducto"></s:param>
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
</html>l>