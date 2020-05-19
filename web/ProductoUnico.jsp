<%-- 
    Document   : ProductoUnico
    Created on : 15/05/2020, 11:28:54 PM
    Author     : bocal
--%>
<%@page import="Control.Mangas" %>
<%@page import="Control.conexionM" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="esp">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">
        <title>DetallesProducto | Mangacomp</title>
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/font-awesome.min.css" rel="stylesheet">
        <link href="css/prettyPhoto.css" rel="stylesheet">
        <link href="css/price-range.css" rel="stylesheet">
        <link href="css/animate.css" rel="stylesheet">
            <link href="css/main.css" rel="stylesheet">
            <link href="css/responsive.css" rel="stylesheet">
        <!--[if lt IE 9]>
        <script src="js/html5shiv.js"></script>
        <script src="js/respond.min.js"></script>
        <![endif]-->       
        <link rel="shortcut icon" href="images/ico/favicon.ico">
        <link rel="apple-touch-icon-precomposed" sizes="144x144" href="images/ico/apple-touch-icon-144-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="114x114" href="images/ico/apple-touch-icon-114-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="72x72" href="images/ico/apple-touch-icon-72-precomposed.png">
        <link rel="apple-touch-icon-precomposed" href="images/ico/apple-touch-icon-57-precomposed.png">
    </head><!--/head-->

    <body>
        <%
            String idMS=request.getParameter("idMP");
            System.out.println(idMS);
            int idM=Integer.parseInt(idMS);
            Mangas m=conexionM.getMangaById(idM);
        %>
        <header id="header"><!--header-->
            <div class="header-middle"><!--header-middle-->
                <div class="container">
                    <div class="row">
                        <div class="col-sm-4">
                            <div class="logo pull-left">
                                <a href="index.html"><img src="images/home/logo.JPG" alt="" /></a>
                            </div>
                        </div>
                        <div class="col-sm-8">
                            <div class="shop-menu pull-right">
                                <div class="col-sm-3">
                            <div class="search_box pull-right">
				<input type="text" placeholder="Search"/>
                            </div>
                        </div>
                                <ul class="nav navbar-nav">
                                    <li><a href="index.html"><i class="fa fa-star"></i> Home</a></li>
                                    <li><a href="Productos.jsp"><i class="fa fa-crosshairs"></i> Productos</a></li>
                                    <li><a href="CarritoCompras"><i class="fa fa-shopping-cart"></i> Carrito</a></li>
                                    <%
                                    HttpSession sessionOk = request.getSession();
                                    if(sessionOk.getAttribute("usuario")==null){ %>
                                    <li><a href="IniciarSesion.jsp"><i class="fa fa-user"></i> IniciarSesión</a></li>
                                    <%}else{%>
                                    <li><a href="Sesion.jsp"><i class="fa fa-user"></i> Sesión</a></li>
                                    <%}%>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </div><!--/header-middle-->
            <div class="header-bottom"><!--header-bottom-->
                <div class="container">
                    <div class="row">
                        <div class="col-sm-7">
                            <div class="navbar-header">
                                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                                    <span class="sr-only">Toggle navigation</span>
                                    <span class="icon-bar"></span>
                                    <span class="icon-bar"></span>
                                    <span class="icon-bar"></span>
                                </button>
                            </div>
			</div>
                    </div>
                </div>
            </div><!--/header-bottom-->
	</header><!--/header-->
        <section>
            <div class="container">
                <div class="container">
                    <div class="product-details"><!--product-details-->
                        <div class="col-sm-5">
                            <div class="view-product">
                                <img src="<%=m.getUrli()%>" height="100%" width="100%" alt="Sin Imagen disponible"/>
                            </div>
                            <div id="similar-product" class="carousel slide" data-ride="carousel"></div>
                        </div>
                        <div class="col-sm-7">
                            <div class="product-information"><!--/product-information-->
                                <img src="images/product-details/new.jpg" class="newarrival" alt="" />
                                <h2><%=m.getNombre()%></h2>
                                <p>Web ID: <%=m.getIdm()%></p>
                                <span>
                                    <span>Mx $<%=m.getCosto()%></span>
                                    <label><%=m.getDescripcion()%></label><br>
                                    <form action="GuardarCookie" method="POST">
                                        <input type="hidden" value="<%=m.getNombre()%>" name="nomP"/>
                                        <input type="hidden" value="<%=idMS%>" name="idMS"/>
                                        <input type="text" value="1"/>
                                        <button class="btn btn-default cart">
                                            <i class="fa fa-shopping-cart"></i>
                                            Agregar al carrito
                                        </button>
                                    </form>
                                </span> 
                                <ul>
                                    <li>Genero: <label> <%=m.getGenero()%></label></li>
                                    <li>Estado: <label> <%=m.getEstado()%></label></li>
                                    <li>Demografia: <label> <%=m.getDemografia()%></label></li>
                                </ul>
                                <br>
                                
                                <a href="Productos.jsp" class="btn btn-default cart">Regresar a Productos</a>
                            </div><!--/product-information-->
                        </div>
                    </div><!--/product-details-->
                </div>
            </div>
        </section>
        <footer id="footer"><!--Footer-->
            <footer id="footer"><!--Footer-->
        <div class="footer-widget">
		<div class="container">
                    <div class="row">
                        <div class="col-sm-2">
                            <div class="single-widget">
                                <h2>MANGACOMP</h2>
                                <p>Derechos reservados de mangacomp</p>
                            </div>
                        </div>
			<div class="col-sm-2">
                            <div class="single-widget">
                                <h2>Servicios</h2>
                                <ul class="nav nav-pills nav-stacked">
                                    <li><a href="">Online Help</a></li>
                                    <li><a href="">Contact Us</a></li>
                                    <li><a href="">Order Status</a></li>
                                    <li><a href="">Change Location</a></li>
                                    <li><a href="">FAQâs</a></li>
                                </ul>
                            </div>
                        </div>
                        <div class="col-sm-2">
                            <div class="single-widget">
				<h2>Redes</h2>
				<ul class="nav nav-pills nav-stacked">
                                    <li><a href="">T-Shirt</a></li>
                                    <li><a href="">Mens</a></li>
                                    <li><a href="">Womens</a></li>
                                    <li><a href="">Gift Cards</a></li>
                                    <li><a href="">Shoes</a></li>
				</ul>
                            </div>
			</div>
			<div class="col-sm-2">
                            <div class="single-widget">
				<h2>Politicas</h2>
				<ul class="nav nav-pills nav-stacked">
                                    <li><a href="">Terms of Use</a></li>
                                    <li><a href="">Privecy Policy</a></li>
                                    <li><a href="">Refund Policy</a></li>
                                    <li><a href="">Billing System</a></li>
                                    <li><a href="">Ticket System</a></li>
				</ul>
                            </div>
			</div>
                    </div>
                </div>
            </div>
        <div class="footer-bottom">
            <div class="container">
                <div class="row">
                    <p class="pull-left">Copyright Â© 2013 E-Shopper. All rights reserved.</p>
                        <p class="pull-right">Designed by <span><a target="_blank" href="http://www.themeum.com">Themeum</a></span></p>
                </div>
            </div>
        </div>
    </footer>
	</footer><!--/Footer-->
        <script src="js/jquery.js"></script>
	<script src="js/price-range.js"></script>
        <script src="js/jquery.scrollUp.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
        <script src="js/jquery.prettyPhoto.js"></script>
        <script src="js/main.js"></script>
        <a href='Productos.jsp'>Regresar</a>
    </body>
</html>
