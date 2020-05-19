<%-- 
    Document   : SesionAdmin
    Created on : 15/05/2020, 09:55:29 PM
    Author     : bocal
--%>
<%@page import="java.util.List"%>
<%@page import="Control.conexionM" %>
<%@page import="Control.conexionU" %>
<%@page import="Control.Usuario" %>
<%@page import="Control.Mangas" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sesion Admin</title>
    </head>
    <body>
        <h1>Vista administrador</h1>
        <table border = 1>
            <tr>
                <th>ID</th>
                <th>Nombre completo</th>
                <th>Dirección</th>
                <th>Codigo postal</th>
                <th>Curp</th>
                <th>Fecha de nacimiento</th>
                <th>Telefono</th>
                <th>Nombre de cuenta</th>
                <th>Contraseña</th>
                <th>Borrar</th>
                </tr>
            <%
            List<Usuario> listaU = conexionU.getAllUsuarios();
            List<Mangas> listaM = conexionM.getAllMangas();
            for(Usuario u:listaU){
            %>
            <tr>
                <td><%=u.getIdu()%></td>
                <td><%=u.getNombre()%> <%=u.getAppat()%> <%=u.getApmat()%></td>
                <td><%=u.getColonia()%> <%=u.getCalle()%></td>
                <td><%=u.getCp()%></td>
                <td><%=u.getCurp()%></td>
                <td><%=u.getDia()+"/"+u.getMes()+"/"+u.getAño()%></td>
                <td><%=u.getTelefono()%></td>
                <td><%=u.getNombreS()%></td>
                <td><%=u.getContrasenaS()%></td>
                <td>
                    <form action='BorrarA' method='GET'>
                    <input type='hidden' name='idU' value='<%=u.getIdu()%>'/>
                    <input type='hidden' name='ad' value='root'/><input type='submit' value='Borrar'/>
                    </form>
                </td>
            </tr>
            <%}%>
        </table><br><br>
            <table border = 1>
                <th>ID</th>
                <th>Nombre</th>
                <th>Descripcion</th>
                <th>Genero</th>
                <th>Estado</th>
                <th>Demografia</th>
                <th>Codigo</th>
                <th>Costo</th>
                <th>Editar</th>
                <th>Borrar</th>
            <%
            for (Mangas m:listaM){
            %>
            <tr>
            <td><%=m.getIdm()%></td>
            <td><%=m.getNombre()%></td>
            <td><%=m.getDescripcion()%></td>
            <td><%=m.getGenero()%></td>
            <td><%=m.getEstado()%></td>
            <td><%=m.getDemografia()%></td>
            <td><%=m.getCodigo()%></td>
            <td><%=m.getCosto()%></td>
            <td>
                <form action='PreEditarM.jsp' method='get'>
                <input type='hidden' name='idM' value='<%=m.getIdm()%>'/>
                <input type='submit' value='Editar'/>
                </form>
            </td>
            <td><form action='BorrarM' method='get'>
                <input type='hidden' name='idM' value='<%=m.getIdm()%>'/>
                <input type='submit' value='Borrar'/>
                </form>
            </td>
            </tr>
            <%}%></table>
            <br><h3>Ingresar nuevo manga</h3>
            <form action='GuardarM' method='POST' name='formulario1'>
                <label>Nombre del manga: </label><input type='text' name='nomM'/><br>
                <label>Codigo: </label><input type='text' name='codM'/><br>
                <label>Costo: </label><input type='text' name='cosM'/><br>
                <label>URL de Imagen: </label><input type='text' name='urlM'/><br>
                <label>Descripcion: </label><input type='textarea' name='desM'/><br>
                <label>Demografia: </label><select name='demM'>
                    <option>Shounen</option>
                    <option>Seinen</option>
                    <option>Shoujo</option>
                    <option>Josei</option>
                    <option>Kodomo</option>
                    </select><br>
                <label>Estado: </label><select name='estM'>
                    <option>Finalizado</option>
                    <option>Publicandose</option>
                    </select><br>
                <label>Genero: </label><select name='genM'/>
                    <option>Accion</option>
                    <option>Drama</option>
                    <option>Psico</option>
                    <option>Romance</option>
                    <option>Slice of life</option>
                    <option>Gore</option>
                    </select><br>
                <input type='submit' value='Aceptar' onclick='return validacionRM()'/>
            </form>
            <a href='IniciarSesion.jsp'>Regresar</a>
    </body>
</html>
