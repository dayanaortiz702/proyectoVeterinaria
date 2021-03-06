<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="shortcut icon" href="img/favicon.png">

  <title>Proyecto Veterinaria</title>

  <!-- Bootstrap CSS -->
  <link href="../css/bootstrap.min.css" rel="stylesheet">
  <!-- bootstrap theme -->
  <link href="../css/bootstrap-theme.css" rel="stylesheet">
  <!--external css-->
  <!-- font icon -->
  <link href="../css/elegant-icons-style.css" rel="stylesheet" />
  <link href="../css/font-awesome.min.css" rel="stylesheet" />
  <!-- full calendar css-->
  <link href="../assets/fullcalendar/fullcalendar/bootstrap-fullcalendar.css" rel="stylesheet" />
  <link href="../assets/fullcalendar/fullcalendar/fullcalendar.css" rel="stylesheet" />
  <!-- easy pie chart-->
  <link href="../assets/jquery-easy-pie-chart/jquery.easy-pie-chart.css" rel="stylesheet" type="text/css" media="screen" />
  <!-- owl carousel -->
  <link rel="stylesheet" href="../css/owl.carousel.css" type="text/css">
  <link href="../css/jquery-jvectormap-1.2.2.css" rel="stylesheet">
  <!-- Custom styles -->
  <link rel="stylesheet" href="../css/fullcalendar.css">
  <link href="../css/widgets.css" rel="stylesheet">
  <link href="../css/style.css" rel="stylesheet">
  <link href="../css/style-responsive.css" rel="stylesheet" />
  <link href="../css/xcharts.min.css" rel=" stylesheet">
  <link href="../css/jquery-ui-1.10.4.min.css" rel="stylesheet">
 
</head>

	<!--sidebar start-->
    <aside>
      <div id="sidebar" class="nav-collapse">
        <!-- sidebar menu start-->
        <ul class="sidebar-menu">
          <li class="active">
            <a class="" href="${pageContext.request.contextPath}/pages/HelloWorld.action">
                          <i class="icon_house_alt"></i>
                          <span>Inicio</span>
                      </a>
          </li>
          <li class="">
	            <a href="#" data-toggle="collapse" data-target="#mantenimiento" aria-expanded="false" class="dropdown-toggle">
	               <i class="icon_document_alt"></i>
	               <span>Mantenimiento</span>
	               <span class="menu-arrow arrow_carrot-right"></span>
	            </a>
	            
	            <ul class="sub-menu collapse" id="mantenimiento">	              
	              <li><a class="" href="${pageContext.request.contextPath}/pages/a_reportPaciente2.action">Pacientes</a></li>
	              <li><a class="" href="${pageContext.request.contextPath}/pages/a_reportHistoria2.action">Historia Clínica</a></li>
	              <li><a class="" href="${pageContext.request.contextPath}/pages/a_reportPropietario2.action">Propietarios</a></li>
	              <li><a href="${pageContext.request.contextPath}/pages/a_reportEmpleado2.action">Empleados</a></li>
	              <li><a class="" href="${pageContext.request.contextPath}/pages/a_reportProducto2.action">Productos</a></li>
	              <li><a class="" href="${pageContext.request.contextPath}/pages/a_reportProveedor2.action">Proveedores</a></li>
	              
	            </ul>
          </li>
          <li class="sub-menu">
	            <a href="#" data-target="#seguridad" class="dropdown-toggle" data-toggle="collapse" aria-expanded="false" >
                  <i class="icon_lock"></i>
                  <span>Seguridad</span>
                  <span class="menu-arrow arrow_carrot-right"></span>
	            </a>
	            <ul class="sub" id="seguridad">	
<%-- 	              <li><a class="" href="${pageContext.request.contextPath}/pages/a_reportUsuario2.action">Usuarios</a></li> --%>
<%-- 	              <li><a class="" href="${pageContext.request.contextPath}/pages/a_reportPerfil2.action">Perfiles</a></li> --%>
	            </ul>
          </li>
          
          <li class="">
       			<a href="#" data-toggle="collapse" data-target="#configuracion" aria-expanded="false" class="dropdown-toggle">
                  <i class="icon_tools"></i>
                  <span>Configuración</span>
                  <span class="menu-arrow arrow_carrot-right"></span>
                </a>
	            <ul class="sub-menu collapse" id="configuracion">	
<%-- 	              <li><a class="" href="${pageContext.request.contextPath}/pages/a_reportDistrito2.action">Distrito</a></li> --%>
<%-- 	              <li><a class="" href="${pageContext.request.contextPath}/pages/a_reportTipoPaciente2.action">Tipo de paciente</a></li> --%>
<%-- 	              <li><a class="" href="${pageContext.request.contextPath}/pages/a_reportUnidad2.action">Unidad de medida</a></li> --%>
<%-- 	              <li><a class="" href="${pageContext.request.contextPath}/pages/a_reportDocumento2.action">Tipo de documento</a></li> --%>
<%-- 	              <li><a class="" href="${pageContext.request.contextPath}/pages/a_reportCargo2.action">Cargo</a></li> --%>
<%-- 	              <li><a class="" href="${pageContext.request.contextPath}/pages/a_reportEstado2.action">Estado</a></li> --%>
<%-- 	              <li><a class="" href="${pageContext.request.contextPath}/pages/a_reportMarca2.action">Marca</a></li> --%>
<%-- 	              <li><a class="" href="${pageContext.request.contextPath}/pages/a_reportCategoria2.action">Categoria</a></li> --%>
	            </ul>
          </li>
		</ul>
          
        <!-- sidebar menu end-->
      </div>
    </aside>
    <!--sidebar end-->
	

<!-- javascripts -->
  <script src="../js/jquery.js"></script>
  <script src="../js/jquery-ui-1.10.4.min.js"></script>
  <script src="../js/jquery-1.8.3.min.js"></script>
  <script type="text/javascript" src="../js/jquery-ui-1.9.2.custom.min.js"></script>
  <!-- bootstrap -->
  <script src="../js/bootstrap.min.js"></script>
  <!-- nice scroll -->
  <script src="../js/jquery.scrollTo.min.js"></script>
  <script src="../js/jquery.nicescroll.js" type="text/javascript"></script>
  <!-- charts scripts -->
  <script src="../assets/jquery-knob/js/jquery.knob.js"></script>
  <script src="../s/jquery.sparkline.js" type="text/javascript"></script>
  <script src="../assets/jquery-easy-pie-chart/jquery.easy-pie-chart.js"></script>
  <script src="../js/owl.carousel.js"></script>
  <!-- jQuery full calendar -->
  <script src="../js/fullcalendar.min.js"></script>
    <!-- Full Google Calendar - Calendar -->
    <script src="../assets/fullcalendar/fullcalendar/fullcalendar.js"></script>
    <!--script for this page only-->
    <script src="../js/calendar-custom.js"></script>
    <script src="../js/jquery.rateit.min.js"></script>
    <!-- custom select -->
    <script src="../js/jquery.customSelect.min.js"></script>
    <script src="../assets/chart-master/Chart.js"></script>

    <!--custome script for all page-->
    <script src="../js/scripts.js"></script>
    <!-- custom script for this page-->
    <script src="../js/sparkline-chart.js"></script>
    <script src="../js/easy-pie-chart.js"></script>
    <script src="../js/jquery-jvectormap-1.2.2.min.js"></script>
    <script src="../js/jquery-jvectormap-world-mill-en.js"></script>
    <script src="../js/xcharts.min.js"></script>
    <script src="../js/jquery.autosize.min.js"></script>
    <script src="../js/jquery.placeholder.min.js"></script>
    <script src="../js/gdp-data.js"></script>
    <script src="../js/morris.min.js"></script>
    <script src="../js/sparklines.js"></script>
    <script src="../js/charts.js"></script>
    <script src="../js/jquery.slimscroll.min.js"></script>
    <script>
      //knob
      $(function() {
        $(".knob").knob({
          'draw': function() {
            $(this.i).val(this.cv + '%')
          }
        })
      });

      //carousel
      $(document).ready(function() {
        $("#owl-slider").owlCarousel({
          navigation: true,
          slideSpeed: 300,
          paginationSpeed: 400,
          singleItem: true

        });
      });

      //custom select box

      $(function() {
        $('select.styled').customSelect();
      });

      /* ---------- Map ---------- */
      $(function() {
        $('#map').vectorMap({
          map: 'world_mill_en',
          series: {
            regions: [{
              values: gdpData,
              scale: ['#000', '#000'],
              normalizeFunction: 'polynomial'
            }]
          },
          backgroundColor: '#eef3f7',
          onLabelShow: function(e, el, code) {
            el.html(el.html() + ' (GDP - ' + gdpData[code] + ')');
          }
        });
      });
    </script>
