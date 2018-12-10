<%@taglib prefix="s" uri="/struts-tags"%>
<%@page import="java.sql.ResultSet"%>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="shortcut icon" href="img/favicon.png">
	
  <title>Proyecto Veterinaria</title>
  
<!--   <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous"> -->
<!-- <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous"> -->
 
<!--   <link href="../css/bootstrap.min.css" rel="stylesheet"> -->
  <!-- bootstrap theme -->
  <link href="../css/bootstrap-theme.css" rel="stylesheet">
  <link href="../css/bootstrap-datepicker.css" rel="stylesheet" />


  <!-- Custom styles -->
  <link href="../css/style_datepicker.css" rel="stylesheet">
  <link href="../css/style-responsive.css" rel="stylesheet" />
  
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
	<div class="row container mt-5">
          <div class="col-lg-10 mx-auto">
            <section>
             	<h2>Modificar Producto</h2>
              <div >
                <form action="updateProductoList" method="post"  class="form-horizontal mt-5" >
                  <input type="text" name="registro.idProducto" value='<s:property value="registro.idProducto"/>'>
                  
                  <div class="form-group row">
                    <label class="col-sm-2 control-label">Descripcion</label>
                    <div class="col-sm-10">
                      <input type="text" class="form-control" name="registro.descripcion" value='<s:property value="registro.descripcion"/>'>
                    </div>
                  </div>
                  
                 <div class="form-group row">
                    <label class="col-sm-2 control-label">Marca</label>
                    <div class="col-sm-10">
                    	<s:select name="registro.idMarca" list="cbMarca" listKey="idMarca" listValue="descripcion" value="registro.idMarca" />
                      	
                    </div>
                  </div>
                  
                  
                  <div class="form-group row">
                    <label class="col-sm-2 control-label">Precio de Compra</label>
                    <div class="col-sm-10">
                      <input type="text" class="form-control" name="registro.precioCompra" value='<s:property value="precioCompra"/>'>
                    </div>
                  </div>
                  
                  <div class="form-group row">
                    <label class="col-sm-2 control-label">Categoria</label>
                    <div class="col-sm-10">
                    	<s:select name="registro.idCategoria" list="cbCategoria" listKey="idCategoria" listValue="categoria" value="registro.idCategoria" />
                      	
                    </div>
                  </div>
                  
                  <div class="form-group row">
                    <label class="col-sm-2 control-label">Proveedor</label>
                    <div class="col-sm-10">
                    	<s:select name="registro.idProveedor" list="cbProveedor" listKey="idProveedor" listValue="razonSocial" value="registro.idProveedor" />
                      	   </div>
                  </div>
                  
                   <div class="form-group row">
                    <label class="col-sm-2 control-label">Unidad de Medida</label>
                    <div class="col-sm-10">
                    	<s:select name="registro.idUniMedida" list="cbUnidad" listKey="idUniMedida" listValue="razonSocial" value="registro.idUniMedida" />
                     </div>
                  </div>
                  
                  
                  <div class="form-group row">
                    <label class="col-sm-2 control-label">Stock Actual</label>
                    <div class="col-sm-10">
                      <input type="text" class="form-control" name="registro.stockActual" value='<s:property value="registro.stockActual"/>'>
                    </div>
                  </div>
                  
                  
                  <div class="form-group row">
                    <label class="col-sm-2 control-label">Stock Minimo</label>
                    <div class="col-sm-10">
                      <input type="text" class="form-control" name="registro.stockMinimo" value='<s:property value="registro.stockMinimo"/>'> 
                    </div>
                  </div>
                  
                  <div class="form-group row">
                      <div class="col-lg-offset-2 col-lg-10">
                        <button name="submitType" class="btn btn-success" type="submit">Modificar</button>                           	              
                      </div>                      	
                  </div>   
                            
                </form>               
	
				<form action="a_reportProducto">
					<input type="submit" value="Listar Producto" class="btn btn-info" />		
				</form>	
	
              </div>
            </section>
         </div>
       </div>

 
       </section>
    
		
	 </section>
   
   
    <!--main content end-->
	</div>
	
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
		
	<!-- jquery ui -->
	  <script src="../js/jquery-ui-1.9.2.custom.min.js"></script>
	
	  <!--custom checkbox & radio-->
	  <script type="text/javascript" src="../js/ga.js"></script>
	  <!--custom switch-->
	  <script src="../js/bootstrap-switch.js"></script>
	  <!--custom tagsinput-->
	  <script src="../js/jquery.tagsinput.js"></script>
	
	  <!-- colorpicker -->
	
	  <!-- bootstrap-wysiwyg -->
	  <script src="../js/bootstrap-colorpicker.js"></script>
	  <script src="../js/bootstrap-datepicker.js"></script>
	  
	   <!-- custom form component script for this page-->
	  <script src="../js/form-component_dp.js"></script>
	  <!-- custome script for all page -->
	  <script src="../js/scripts.js"></script>
</body>
</html>