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

/**
/**
 *
 * @author bocal
 */
public class EditarU extends HttpServlet {
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
            String idUS, diaS, mesS, eseaño, cpS, telS, nombre, appat, apmat, curp, calle, colonia, nombres, contrasenas;
            idUS=request.getParameter("idU");
            int idU = Integer.parseInt(idUS);
            diaS =request.getParameter("diaU");
            int dia = Integer.parseInt(diaS);
            mesS =request.getParameter("mesU");
            int mes = Integer.parseInt(mesS);
            eseaño = request.getParameter("anoU");
            int año = Integer.parseInt(eseaño);
            cpS =request.getParameter("cpU");
            int cp = Integer.parseInt(cpS);
            telS =request.getParameter("telU");
            int tel = Integer.parseInt(telS);
            nombre = request.getParameter("nomU");
            appat = request.getParameter("appatU");
            apmat = request.getParameter("apmatU");
            curp = request.getParameter("curpU");
            calle= request.getParameter("calleU");
            colonia=request.getParameter("coloniaU");
            
            System.out.println(colonia);
            
            //ahora hago mi objeto
            Usuario u = new Usuario();
            u.setIdu(idU);
            u.setNombre(nombre);
            u.setAppat(appat);
            u.setApmat(apmat);
            u.setDia(dia);
            u.setMes(mes);
            u.setAño(año);
            u.setCp(cp);
            u.setTelefono(tel);
            u.setCurp(curp);
            u.setCalle(calle);
            u.setColonia(colonia);
            System.out.println(idU);
            
            int estado = conexionU.Actualizar(u);
            
            if(estado >0){
                response.sendRedirect("Sesion.jsp?idU="+idU+"");
                System.out.println("Respondio");
            }else{
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet EditarU</title>");            
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>No se pudo realizar la operacion</h1>");
                out.println("<a href='Sesion.jsp?idU="+idU+"'>Regresar</a>");
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
