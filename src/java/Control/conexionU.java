package Control;

import java.util.*;
import java.sql.*;
public class conexionU {
    
    public static Connection getConnection(){
        String url, userName, password;
        
        url="jdbc:mysql://localhost/agenciam";
        userName="root";
        password="n0m3l0";
        
        Connection con = null;
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, userName, 
                    password);
            System.out.println("Se conecto a la BD");
        }catch(Exception e){
            System.out.println("No se conecto a la BD");
            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace());
        }
        return con;
    }
    public static int Guardar(Usuario u){
        int estatus = 0;
        try{
            Connection con = conexionU.getConnection();

            String q = "insert into usuario (dia, mes, año, cp, tel, nombre, appat, apmat, curp, calle, colonia, nombres, contrasenas)"
                    + " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement ps = con.prepareStatement(q);
            ps.setInt(1, u.getDia());
            ps.setInt(2, u.getMes());
            ps.setInt(3, u.getAño());
            ps.setInt(4, u.getCp());
            ps.setInt(5, u.getTelefono());
            ps.setString(6, u.getNombre());
            ps.setString(7, u.getAppat());
            ps.setString(8, u.getApmat());
            ps.setString(9, u.getCurp());
            ps.setString(10, u.getCalle());
            ps.setString(11, u.getColonia());
            ps.setString(12, u.getNombreS());
            ps.setString(13, u.getContrasenaS());
            
            estatus = ps.executeUpdate();
            con.close();
            
            
        }catch(Exception ed){
            System.out.println("No conecto a la tabla");
            System.out.println(ed.getMessage());
            System.out.println(ed.getStackTrace());
        
        }
        return estatus;
    }
    public static int Actualizar(Usuario u){
        int estatus = 0;
        try{
            Connection con = conexionU.getConnection();
            String sql= "update usuario set dia = ?, "
                    + "mes = ?, "
                    + "año = ?,"
                    + "cp  = ?, "
                    + "tel  = ?, "
                    + "nombre  = ?, "
                    + "appat  = ?, "
                    + "apmat  = ?, "
                    + "curp  = ?, "
                    + "calle  = ?, "
                    + "colonia  = ? "
                    + "where idU = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setInt(1, u.getDia());
            ps.setInt(2, u.getMes());
            ps.setInt(3, u.getAño());
            ps.setInt(4, u.getCp());
            ps.setInt(5, u.getTelefono());
            ps.setString(6, u.getNombre());
            ps.setString(7, u.getAppat());
            ps.setString(8, u.getApmat());
            ps.setString(9, u.getCurp());
            ps.setString(10, u.getCalle());
            ps.setString(11, u.getColonia());
            ps.setInt(12, u.getIdu());
            estatus = ps.executeUpdate();
            con.close();
        }catch(Exception ed){
            System.out.println("No conecto a la tabla");
            System.out.println(ed.getMessage());
            System.out.println(ed.getStackTrace());
        
        }
        return estatus;
    }
    public static int Eliminar(int id){
        int estatus = 0;
        try{
            Connection con = conexionU.getConnection();
            String q ="delete from usuario where idU =?";
            PreparedStatement ps = con.prepareStatement(q);
            ps.setInt(1, id);
            estatus = ps.executeUpdate();
            con.close();
        
        }catch (Exception ed){
            System.out.println("No conecto a la tabla");
            System.out.println(ed.getMessage());
            System.out.println(ed.getStackTrace());
        }
        return estatus;   
    }
    public static Usuario getUsuarioById(int id){
        Usuario u = new Usuario();
        try{
            Connection con = conexionU.getConnection();
            String sql = "Select * from usuario "
                    + "where idU = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                
                u.setIdu(rs.getInt(1));
                u.setDia(rs.getInt(2));
                u.setMes(rs.getInt(3));
                u.setAño(rs.getInt(4));
                u.setCp(rs.getInt(5));
                u.setTelefono(rs.getInt(6));
                u.setNombre(rs.getString(7));
                u.setAppat(rs.getString(8));
                u.setApmat(rs.getString(9));
                u.setCurp(rs.getString(10));
                u.setCalle(rs.getString(11));
                u.setColonia(rs.getString(12));
                u.setNombreS(rs.getString(13));
                u.setContrasenaS(rs.getString(14));

                con.close();
            }
        }catch(Exception ed){
            System.out.println("No conecto a la tabla");
            System.out.println(ed.getMessage());
            System.out.println(ed.getStackTrace());
        
        }
        return u;
    }
    public static List<Usuario> getAllUsuarios(){
        List<Usuario> lista = new ArrayList<Usuario>();
        try{
            Connection con = conexionU.getConnection();
            String sql="select * from usuario";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Usuario u = new Usuario();
                    u.setIdu(rs.getInt(1));
                    u.setDia(rs.getInt(2));
                    u.setMes(rs.getInt(3));
                    u.setAño(rs.getInt(4));
                    u.setCp(rs.getInt(5));
                    u.setTelefono(rs.getInt(6));
                    u.setNombre(rs.getString(7));
                    u.setAppat(rs.getString(8));
                    u.setApmat(rs.getString(9));
                    u.setCurp(rs.getString(10));
                    u.setCalle(rs.getString(11));
                    u.setColonia(rs.getString(12));
                    u.setNombreS(rs.getString(13));
                    u.setContrasenaS(rs.getString(14));

                    lista.add(u);
            }
            con.close();
        }catch(Exception ed){
            System.out.println("No conecto a la tabla");
            System.out.println(ed.getMessage());
            System.out.println(ed.getStackTrace());
        }
        return lista;        
    }
    public Usuario verificarUsuario(String user, String clave){
        Usuario u = new Usuario();
        try{
            
            Connection con = conexionU.getConnection();
            String sql;
            sql="Select * from usuario where nombres = ? AND contrasenas = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, user);
            ps.setString(2, clave);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                
                
                u.setIdu(rs.getInt(1));
                u.setDia(rs.getInt(2));
                u.setMes(rs.getInt(3));
                u.setAño(rs.getInt(4));
                u.setCp(rs.getInt(5));
                u.setTelefono(rs.getInt(6));
                u.setNombre(rs.getString(7));
                u.setAppat(rs.getString(8));
                u.setApmat(rs.getString(9));
                u.setCurp(rs.getString(10));
                u.setCalle(rs.getString(11));
                u.setColonia(rs.getString(12));
                u.setNombreS(rs.getString(13));
                u.setContrasenaS(rs.getString(14));

                break;
            }
        
        } catch(Exception ex){
            ex.printStackTrace();
            u=null;
        } 
        return u;
    }
}
