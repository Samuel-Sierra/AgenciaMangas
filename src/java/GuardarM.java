/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import Control.Mangas;
import Control.conexionM;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author bocal
 */
public class GuardarM extends HttpServlet {
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
        doPost(request,response);
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
        
        try (PrintWriter out = response.getWriter()) {
        String codigoS, costoS, descripcion, nombre, genero, estado, demografia, urlI;
            codigoS =request.getParameter("codM");
            int codigo = Integer.parseInt(codigoS);
            costoS =request.getParameter("cosM");
            float costo = Float.parseFloat(costoS);
            nombre =request.getParameter("nomM");
            descripcion =request.getParameter("desM");
            genero =request.getParameter("genM");
            estado = request.getParameter("estM");
            demografia = request.getParameter("demM");
            urlI=request.getParameter("urlM");

            Mangas m = new Mangas();
            m.setNombre(nombre);
            m.setCodigo(codigo);
            m.setCosto(costo);
            m.setDescripcion(descripcion);
            m.setGenero(genero);
            m.setEstado(estado);
            m.setDemografia(demografia);
            m.setUrli(urlI);
                    
            
            int estadob = conexionM.Guardar(m);
            
            if(estadob >0){
                out.println("<h1>Manga Registrado</h1>");
                out.println("<a href='SesionAdmin.jsp' style='color: #969A97;'>Regresar</a>");
            }else{
                out.println("<h1>Solo juguito contigo :P"
                        + "Caldito seas wiiiiii</h1>");
            }
        /*
            
            significa que en el select * from Datos where nombre = ? and
            password = ?
            
            */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Guardar Nuevo Usuario/title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet GuardarEmpleado at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
