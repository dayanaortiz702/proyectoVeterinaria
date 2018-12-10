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
	<div class="row container mt-2">
       <div class="col-lg-10 mx-auto">
          <h2>Modificar Empleado</h2>
            <section  class="mt-5">
             
              <div>
                <form action="updateEmpleadoList" method="post"  class="form-horizontal mt-5" >
                  <input type="hidden"  name="registro.idEmpleado" value='<s:property value="registro.idEmpleado"/>'>
                  
                  <div class="form-group row">
                    <label class="col-sm-2 control-label">Nombres</label>
                    <div class="col-sm-10">
                      <input type="text" class="form-control" name="registro.nombres" value='<s:property value="registro.nombres"/>'>
                    </div>
                  </div>
                  
                  <div class="form-group row">
                    <label class="col-sm-2 control-label">Apellidos</label>
                    <div class="col-sm-10">
                      <input type="text" class="form-control" name="registro.apellidos" value='<s:property value="registro.apellidos"/>'>
                    </div>
                  </div>
                  
                    <div class="form-group row">
                    <label class="col-sm-2 control-label">Tipo de Documento</label>
                    <div class="col-sm-10">
						<s:select name="registro.idTipoDocumento" list="cbDocumento" listKey="idTipoDocumento" listValue="descripcion" value="registro.idTipoDocumento" />
                      	
                    </div>
                  </div>
                  
                  <div class="form-group row">
                    <label class="col-sm-2 control-label">Nro de documento</label>
                    <div class="col-sm-10">
                      <input type="text" class="form-control" name="registro.nroDocumento" value='<s:property value="registro.nroDocumento"/>'>
                    </div>
                  </div>
                  
           
                  
                  <div class="form-group row">
                    <label class="col-sm-2 control-label">Teléfono</label>
                    <div class="col-sm-10">
                      <input type="text" class="form-control" name="registro.telefono" value='<s:property value="registro.telefono"/>'> 
                    </div>
                  </div>
                  
                  <div class="form-group row">
                    <label class="col-sm-2 control-label">Correo</label>
                    <div class="col-sm-10">
                      <input type="text" class="form-control" name="registro.correo" value='<s:property value="registro.correo"/>'>
                    </div>
                  </div>
                  
                  <div class="form-group row">
                    <label class="col-sm-2 control-label">Dirección</label>
                    <div class="col-sm-10">
                      <input type="text" class="form-control" name="registro.direccion" value='<s:property value="registro.direccion"/>'>
                    </div>
                  </div>                  
                         
                  <div class="form-group row">
                       <label class="control-label col-sm-2">Fecha de nacimiento</label>
                       <div class="col-sm-10">
                         <input id="dp2" type="text" size="16" class="form-control" name="registro.fecha_nac" value='<s:property value="registro.fecha_nac"/>'>
                       </div>
                  </div>
                  
                  <div class="form-group row">
                       <label class="control-label col-sm-2">Fecha de ingreso</label>
                       <div class="col-sm-10">
                         <input id="dp6" type="text" size="16" class="form-control" name="registro.fecha_ingreso" value='<s:property value="registro.fecha_ingreso"/>'>
                       </div>
                  </div>       
                            
                  
                  <div class="form-group row">
                    <label class="col-sm-2 control-label">Cargo</label>
                    <div class="col-sm-10">
                      <s:select name="registro.idCargo" list="cbCargo" listKey="idCargo" listValue="nombre" value="registro.idCargo" />
                      	
                    </div>
                  </div>
                  
                  <div class="form-group row">
                    <label class="col-sm-2 control-label">Usuario</label>
                    <div class="col-sm-10">
                       <s:select name="registro.idUsuario" list="cbUsuario" listKey="idUsuario" listValue="usuario" value="registro.idUsuario" />
                      
                    </div>
                  </div>
                  
                  
                  <div class="form-group row">
                      <div class="col-lg-offset-2 col-lg-10">
                        <button name="submitType" class="btn btn-success" type="submit">Modificar</button>                           	              
                      </div>                      	
                  </div>                  
                </form>               
	
				<form action="a_reportEmpleado">
					<input type="submit" value="Listar empleados" class="btn btn-info" />		
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