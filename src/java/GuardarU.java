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
 *
 * @author bocal
 */
public class GuardarU extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
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
     * Handles the HTTP <code>GET</code> method.
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
            String idUS, diaS, mesS, eseaño, cpS, telS, nombre, appat, apmat, curp, calle, colonia, nombres, contrasenas;
            int idU = 0;
            nombre = request.getParameter("nomU");
            appat = request.getParameter("appatU");
            apmat = request.getParameter("apmatU");
            curp = request.getParameter("curpU");
            eseaño = request.getParameter("anoFU");
            int año = Integer.parseInt(eseaño);
            mesS =request.getParameter("mesFU");
            int mes = Integer.parseInt(mesS);
            diaS =request.getParameter("diaFU");
            int dia = Integer.parseInt(diaS);
            colonia=request.getParameter("colDU");
            calle= request.getParameter("calleDU");
            cpS =request.getParameter("cpU");
            int cp = Integer.parseInt(cpS);
            telS =request.getParameter("telU");
            int tel = Integer.parseInt(telS);
            nombres=request.getParameter("nomCU");
            contrasenas=request.getParameter("contU");
            
            
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
            u.setNombreS(nombres);
            u.setContrasenaS(contrasenas);
                    
            
            int estado = conexionU.Guardar(u);
            
            if(estado >0){
                out.println("<h1>Usuario Registrado</h1>");
                out.println("<a href='IniciarSesion.jsp' style='color: #969A97;'>Iniciar Sesión</a>");
            }else{
                out.println("<h1>Ocurrio un error, intentelo de nuevo</h1>");
                out.println("<a href='Registrar.html' style='color: #969A97;'>Regresar</a>");
            }

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
