/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import Control.Usuario;
import Control.conexionU;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import java.sql.*;
import javax.servlet.http.HttpSession;

/**
 *
 * @author bocal
 */
public class ControladorIS extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        int nivel=0;
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String noms, cons;
            noms=request.getParameter("nomSU");
            cons=request.getParameter("contU");
            
            if("root".equals(noms) & "n0m3l0".equals(cons)){
                response.sendRedirect("SesionAdmin.jsp");
            }else{
                try{
                    conexionU u = new conexionU();
                    Usuario us = u.verificarUsuario(noms, cons);
                    nivel = us.getIdu();
                    String nivelS = String.valueOf(nivel);
                    if(us != null){
                        
                        HttpSession sesion = request.getSession(true);
                        sesion.setAttribute("usuario", us);
                        HttpSession sesionOK = request.getSession();
                        sesionOK.setAttribute("usuario", noms);
                        sesionOK.setAttribute("id", nivelS);
                        
                        
                        
                        response.sendRedirect("Sesion.jsp");
                    }else{
                        out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Sesion</title>"
                        + "<link rel=\"stylesheet\" type=\"text/css\" href=\"css/estilos.css\">");
                out.println("</head>");
                out.println("<body>"
                        + "<h1>No se encuentra la sesion, intentelo de nuevo</h1>"
                        + "<a href='IniciarSesion.jsp'>Regresar</a>");
                out.println("</body>");
                out.println("</html>");
            
                    }
                    System.out.println(nivel);
                }catch(Exception e){
                    System.out.println("Que pedo que pedo");
                    System.out.println(e.getMessage());
                    System.out.println(e.getStackTrace());
                }
            }
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
