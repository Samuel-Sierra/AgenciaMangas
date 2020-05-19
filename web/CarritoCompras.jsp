<%-- 
    Document   : CarritoCompras
    Created on : 16/05/2020, 05:16:01 PM
    Author     : bocal
--%>

<%@page contentType="text/html" language="java" import="javax.servlet.http.Cookie" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CarritoCompras</title>
    </head>
    <body>
        <%
            Cookie[] cookies = request.getCookies();
            String nombreP=null;
            String todo=null;
            //nombreP.getValue();
            //cantidad.getValue();
        %>
        <h1>Carrito de Compras</h1>
        <%
        if(cookies==null){
        %>
        <p>Aún no ha ingresado nada al carrito de compras</p>
        <%
        }else{
            for(int i = 0; i < cookies.length; i++){
                Cookie cookie=cookies[i];
                System.out.println(cookie.getName()+" "+cookie.getValue()+" "+i);
                if(cookie.getName().equals("nombreP"+cookie.getValue())){
                    nombreP = cookie.getValue();
                    System.out.println("chan chan "+cookie.getName()+" chan "+nombreP + " " + i);
                    //System.out.println(cookie.getValue());
        %>       
       <p><%=nombreP%></p>
        <%      }
                //System.out.println(cookie.getValue());
                //System.out.println(cookie.getName());
            }//System.out.println(todo);
        }
        %>
    </body>
</html>
