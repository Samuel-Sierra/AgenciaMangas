<%-- 
    Document   : PreEditarM
    Created on : 15/05/2020, 11:04:56 PM
    Author     : bocal
--%>
<%@page import="Control.Mangas" %>
<%@page import="Control.conexionM" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar Manga</title>
    </head>
    <body>
        <%
        String idMS=request.getParameter("idM");
        System.out.println(idMS);
        int idM=Integer.parseInt(idMS);
        Mangas m=conexionM.getMangaById(idM);
        %>
        <h3>Modificar datos de la cuenta</h3>
            <form action='EditarM' method='POST' name='formulario1'>
                <input type='hidden' name='idM' value='<%=idMS%>'/>
            <ul>
                <li>Nombre: <input type='text' name='nomM' value='<%=m.getNombre()%>'/></li>
                <li>Descripcion: <input type='text' name='desM' value='<%=m.getDescripcion()%>'/></li>
                <li>Demografia: (<%=m.getDemografia()%>)<select name='demM'/>
                <option>Shounen</option>
                <option>Seinen</option>
                <option>Shoujo</option>
                    <option>Josei</option>
                    <option>Kodomo</option>
                </select></li>
                <li>Estado: (<%=m.getEstado()%>)<select name='estM'>
                    <option>Finalizado</option>
                    <option>Publicandose</option>
                </select></li>
                <li>Genero: (<%=m.getGenero()%>)<select name='genM'/>
                    <option>Accion</option>
                    <option>Drama</option>
                    <option>Psico</option>
                    <option>Romance</option>
                    <option>Slice of life</option>
                    <option>Gore</option>
                </select></li>
                <li>Codigo: <input type='text' name='codM' value='<%=m.getCodigo()%>'/></li>
                <li>Costo: <input type='text' name='cosM' value='<%=m.getCosto()%>'/></li>
                <li>Url de imagen: <input type='text' name='urlM' value='<%=m.getUrli()%>'/></li>
            </ul>
                <input type='submit' value='Aceptar' onclick='return validacionRM()'/>
            </form>
    </body>
</html>
