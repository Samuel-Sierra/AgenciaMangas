/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import Control.conexionM;
import Control.Mangas;
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
public class EditarM extends HttpServlet {
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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String idMS, nombre, descripcion, demografia,estado,genero,codigoS,costoS,urlI;
            idMS=request.getParameter("idM");
            int idM = Integer.parseInt(idMS);
            codigoS =request.getParameter("codM");
            int codigo = Integer.parseInt(codigoS);
            costoS =request.getParameter("cosM");
            float costo = Float.parseFloat(costoS);
            nombre = request.getParameter("nomM");
            descripcion = request.getParameter("desM");
            demografia = request.getParameter("demM");
            estado = request.getParameter("estM");
            genero= request.getParameter("genM");
            urlI=request.getParameter("urlM");
            
            Mangas m = new Mangas();
            m.setIdm(idM);
            m.setCodigo(codigo);
            m.setCosto(costo);
            m.setNombre(nombre);
            m.setDemografia(demografia);
            m.setDescripcion(descripcion);
            m.setEstado(estado);
            m.setGenero(genero);
            m.setUrli(urlI);
            
            int estadom = conexionM.Actualizar(m);
            
            if(estadom >0){
                response.sendRedirect("SesionAdmin.jsp");
                System.out.println("Respondio");
            }else{
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet EditarU</title>");            
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>No se pudo realizar la operacion</h1>");
                out.println("<a href='SesionAdmin.jsp'>Regresar</a>");
                out.println("</body>");
                out.println("</html>");
                
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
