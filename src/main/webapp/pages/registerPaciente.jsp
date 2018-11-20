<%@taglib prefix="s" uri="/struts-tags"%>
<%@page import="java.sql.ResultSet"%>
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
            	<h2>Agregar Nuevo Paciente</h2>
			<div>
				<form action="registerPaciente" class="form-horizontal mt-5">
				
					<div class="form-group row">
						<label class="col-sm-2 control-label">Nombre</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" name="nombre">
						</div>
					</div>
	
				  <div class="form-group row">
                       <label class="control-label col-sm-2">Fecha de nacimiento</label>
                       <div class="col-sm-10">
                         <input id="dp2" type="text" value="" size="16" class="form-control" name="fecha_nacimiento">
                       </div>
                  </div>
                  
                  <div class="form-group row">
                       <label class="control-label col-sm-2">Fecha de ingreso</label>
                       <div class="col-sm-10">
                         <input id="dp6" type="text" value="" size="16" class="form-control" name="fecha_ingreso">
                       </div>
                  </div>      
						<div class="form-group row">
							<label class="col-sm-2 control-label">Color</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" name="color">
							</div>
						</div>
						
						<div class="form-group row">
							<label class="col-sm-2 control-label">Sexo</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" name="sexo">
							</div>
						</div>
						
						<div class="form-group row">
							<label class="col-sm-2 control-label">Particularidad</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" name="particularidad">
							</div>
						</div>
						<div class="form-group row">
							<label class="col-sm-2 control-label">Peso</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" name="peso">
							</div>
						</div>
						
						<div class="form-group row">
							<label class="col-sm-2 control-label">Frecuencia Cardiaca</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" name="frecuencia_cardiaca">
							</div>
						</div>
						
						<div class="form-group row">
							<label class="col-sm-2 control-label">Frecuencia Respiratoria</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" name="frecuencia_respiratoria">
							</div>
						</div>
						
						<div class="form-group row">
							<label class="col-sm-2 control-label">Color Mucosa</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" name="color_mucosa">
							</div>
						</div>
						
						<div class="form-group row">
							<label class="col-sm-2 control-label">Turgencia Piel</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" name="turgencia_piel">
							</div>
						</div>
						
	
						<div class="form-group row">
							<label class="col-sm-2 control-label">Estado Reproductivo</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" name="estado_reproductivo">
							</div>
						</div>
						
						<div class="form-group row">
							<label class="col-sm-2 control-label">Estado Vacuna</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" name="estado_vacuna">
							</div>
						</div>
						
						<div class="form-group row">
							<label class="col-sm-2 control-label">Estado Desparasitacion</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" name="estado_desparasitacion">
							</div>
						</div>

						<div class="form-group row">
							<div class="col-lg-offset-2 col-lg-10">
								<button class="btn btn-success" type="submit">Registrar</button>
								<s:if test="ctr>0">
									<span style="color: green;"><s:property value="msg" /></span>
								</s:if>
								<s:else>
									<span style="color: red;"><s:property value="msg" /></span>
								</s:else>
							</div>

						</div>

					</form>

					<form action="listaPaciente.jsp">
						<input type="submit" value="Listar pacientes" class="btn btn-info" />
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