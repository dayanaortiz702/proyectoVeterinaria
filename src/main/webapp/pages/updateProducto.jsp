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
                  <input type="text" name="idProducto" value='<s:property value="idProducto"/>'>
                  
                  <div class="form-group row">
                    <label class="col-sm-2 control-label">descripcion</label>
                    <div class="col-sm-10">
                      <input type="text" class="form-control" name="descri" value='<s:property value="descripcion"/>'>
                    </div>
                  </div>
                  
                 <div class="form-group row">
                    <label class="col-sm-2 control-label">Marca</label>
                    <div class="col-sm-10">
                    	<input type="text" class="form-control" name="idMarca" value='<s:property value="idMarca"/>'>
                    </div>
                  </div>
                  
                  
                  <div class="form-group row">
                    <label class="col-sm-2 control-label">Precio de Compra</label>
                    <div class="col-sm-10">
                      <input type="text" class="form-control" name="precio_compra" value='<s:property value="precio_compra"/>'>
                    </div>
                  </div>
                  
                  <div class="form-group row">
                    <label class="col-sm-2 control-label">Categoria</label>
                    <div class="col-sm-10">
                    	<input type="text" class="form-control" name="idCategoria" value='<s:property value="idCategoria"/>'>
                    </div>
                  </div>
                  
                  <div class="form-group row">
                    <label class="col-sm-2 control-label">Proveedor</label>
                    <div class="col-sm-10">
                    	<input type="text" class="form-control" name="idProveedor" value='<s:property value="idProveedor"/>'>
                    </div>
                  </div>
                  
                   <div class="form-group row">
                    <label class="col-sm-2 control-label">Unidad de Medida</label>
                    <div class="col-sm-10">
                    	<input type="text" class="form-control" name="idUnidad" value='<s:property value="idUnidad"/>'>
                    </div>
                  </div>
                  
                  
                  <div class="form-group row">
                    <label class="col-sm-2 control-label">Stock Actual</label>
                    <div class="col-sm-10">
                      <input type="text" class="form-control" name="stock_actual" value='<s:property value="stock_actual"/>'>
                    </div>
                  </div>
                  
                  
                  <div class="form-group row">
                    <label class="col-sm-2 control-label">Stock Minimo</label>
                    <div class="col-sm-10">
                      <input type="text" class="form-control" name="stock_minimo" value='<s:property value="stock_minimo"/>'> 
                    </div>
                  </div>
                  
                  <div class="form-group row">
                      <div class="col-lg-offset-2 col-lg-10">
                        <button name="submitType" class="btn btn-success" type="submit">Modificar</button>    
                       	<s:if test="ctr>0">
							<span style="color: green;"><s:property value="msg" /></span>
						</s:if>
						<s:else>
							<span style="color: red;"><s:property value="msg" /></span>
						</s:else>                 
                      </div>                      	
                  </div>                  
                </form>               
	
				<form action="a_reportProducto">
					<input type="submit" value="Listar Productos" class="btn btn-info" />		
				</form>	
	
              </div>
            </section>
         </div>
       </div>

 
       </section>
    
		
	 </section>
   
   
    <!--main content end-->
	</div>
	
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
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