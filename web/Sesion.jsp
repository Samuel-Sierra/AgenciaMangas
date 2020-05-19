<%-- 
    Document   : Sesion
    Created on : 15/05/2020, 10:27:11 PM
    Author     : bocal
--%>
<%@page import="Control.Usuario" %>
<%@page import="Control.conexionU" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mi sesión</title>
    </head>
    <body>
        <%
            String usuario = "";
            String idUS = "";
            HttpSession sessionOk = request.getSession();
            if(sessionOk.getAttribute("usuario")==null){
        %>
        <jsp:forward page="index.jsp">
            <jsp:param name="error" value="Es obligatorio identificarse"/>
        </jsp:forward>}
        <%   
            }else{
                usuario = (String)sessionOk.getAttribute("usuario");
                idUS = (String)session.getAttribute("id");
                System.out.println("ewewe "+idUS);
                int idU=Integer.parseInt(idUS);
                Usuario u = conexionU.getUsuarioById(idU);
        %>
        <header>
            <a href='Productos.jsp' style='font-size: 30pt;'>Ver los mangas</a>
            <h1>Tu sesion: <%=usuario%></h1>
            </header>
            <section>
                <article>
                <h3>Datos personales</h3>
                    <ul>
                        <li>Nombre completo: <%=u.getNombre()+" "+u.getAppat()+" "+u.getApmat()%></li>
                        <li>Curp: <%=u.getCurp()%></li>
                        <li>Direccion: <%=u.getColonia()+" "+u.getCalle()%></li>
                        <li>Fecha de nacimiento: <%=u.getDia()+" "+u.getMes()+" "+u.getAño()%></li>
                        <li>Codigo Postal: <%=u.getCp()%></li>
                        <li>Teléfono: <%=u.getTelefono()%></li>
                        </ul>
                        <a href='index.html'>Cerrar Sesión</a>
                </article>
                <article>
                <h3>Modificar datos de la cuenta</h3>
                    <form action='EditarU' method='POST' name='formulario1'>
                    <input type='hidden' name='idU' value='<%=idUS%>'/>
                    <ul>
                        <li>Nombre: <input type='text' name='nomU' value='<%=u.getNombre()%>'/></li>
                        <li>Apellido paterno: <input type='text' name='appatU' value='<%=u.getAppat()%>'/></li>
                        <li>Apellido materno: <input type='text' name='apmatU' value='<%=u.getApmat()%>'/></li>
                        <li>Curp: <input type='text' name='curpU' value='<%=u.getCurp()%>'/></li>
                        <li>Dia de nacimiento: <input type='text' name='diaU' value='<%=u.getDia()%>'/></li>
                        <li>Mes de nacimiento: <input type='text' name='mesU' value='<%=u.getMes()%>'/></li>
                        <li>Año de nacimiento: <input type='text' name='anoU' value='<%=u.getAño()%>'/></li>
                        <li>Calle: <input type='text' name='calleU' value='<%=u.getCalle()%>'/></li>
                        <li>Colonia: <input type='text' name='coloniaU' value='<%=u.getColonia()%>'/></li>
                        <li>Codigo Postal: <input type='text' name='cpU' value='<%=u.getCp()%>'/></li>
                        <li>Telefono: <input type='text' name='telU' value='<%=u.getTelefono()%>'/></li>
                    </ul>
                    <input type='submit' value='Aceptar' onclick='return validacionES()'/>
                    </form>
                    <h3>Borrar Cuenta</h3>
                    <form action='BorrarU' method='POST' name='formB'>
                    <input type='hidden' name='idU' value='<%=idUS%>'/>
                    <input type='submit' value='Aceptar' onclick='return con()'/>
                    </form>
                </article>
                <article>
                    <h3>Aquí va el supuesto historial</h3>
                </article>
            </section>
                    <%}%>
    </body>
</html>
