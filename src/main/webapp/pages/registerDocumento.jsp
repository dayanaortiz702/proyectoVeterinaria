<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html lang="en">

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
		<div class="row container ml-3">
          <div class="col-lg-10 mx-auto">
            <section>
             <h2>Agregar nuevo documento</h2><br>
              <div >
                <form action="registerDocumento"  class="form-horizontal mt-5" >
                  <div class="form-group row">
                    <label class="col-sm-2 control-label">Nombre</label>
                    <div class="col-sm-10">
                      <input type="text" class="form-control" name="registro.descripcion">
                    </div>
                  </div>
                  
                  
                </form>               
	
				<form action="listaDocumento.jsp">
					<input type="submit" value="Listar documentos" class="btn btn-info" />		
				</form>	
	
              </div>
            </section>
         </div>
    
       </div>
 
       </section>
    
		
	     </section>
   
    <!--main content end-->
	</div>
	
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
		
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