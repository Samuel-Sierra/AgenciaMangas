/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author bocal
 */
import java.util.*;
import java.sql.*;

public class conexionM {
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
    public static int Guardar(Mangas m){
        int estatus = 0;
        try{
            Connection con = conexionM.getConnection();

            String q = "insert into mangas (codigo, costo, nombre, descripcion, genero, estado, demografia, urlI)"
                    + " values (?, ?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement ps = con.prepareStatement(q);
            ps.setInt(1, m.getCodigo());
            ps.setFloat(2, m.getCosto());
            ps.setString(3, m.getNombre());
            ps.setString(4, m.getDescripcion());
            ps.setString(5, m.getGenero());
            ps.setString(6, m.getEstado());
            ps.setString(7, m.getDemografia());
            ps.setString(8, m.getUrli());
            
            estatus = ps.executeUpdate();
            con.close();   
        }catch(Exception ed){
            System.out.println("No conecto a la tabla");
            System.out.println(ed.getMessage());
            System.out.println(ed.getStackTrace());
        }
        return estatus;
    }
    public static int Actualizar(Mangas m){
        int estatus = 0;
        try{
            Connection con = conexionU.getConnection();
            String sql= "update mangas set codigo = ?, "
                    + "costo = ?, "
                    + "nombre = ?,"
                    + "descripcion = ?, "
                    + "genero = ?, "
                    + "estado  = ?, "
                    + "demografia  = ?,"
                    + "urlI = ? "
                    + "where idM = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, m.getCodigo());
            ps.setFloat(2, m.getCosto());
            ps.setString(3, m.getNombre());
            ps.setString(4, m.getDescripcion());
            ps.setString(5, m.getGenero());
            ps.setString(6, m.getEstado());
            ps.setString(7, m.getDemografia());
            ps.setString(8, m.getUrli());
            ps.setInt(9, m.getIdm());
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
            String q ="delete from mangas where idM =?";
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
    public static Mangas getMangaById(int id){ 
        Mangas m = new Mangas();
        try{
            Connection con = conexionU.getConnection();
            String sql = "Select * from mangas "
                    + "where idM = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                
                m.setIdm(rs.getInt(1));
                m.setCodigo(rs.getInt(2));
                m.setCosto(rs.getFloat(3));
                m.setNombre(rs.getString(4));
                m.setDescripcion(rs.getString(5));
                m.setGenero(rs.getString(6));
                m.setEstado(rs.getString(7));
                m.setDemografia(rs.getString(8));
                m.setUrli(rs.getString(9));

                con.close();
            }
        }catch(Exception ed){
            System.out.println("No conecto a la tabla");
            System.out.println(ed.getMessage());
            System.out.println(ed.getStackTrace());
        
        }
        return m;
    }
    public static List<Mangas> getAllMangas(){
        List<Mangas> lista = new ArrayList<Mangas>();
        try{
            Connection con = conexionU.getConnection();
            String sql="select * from mangas";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Mangas m = new Mangas();
                    m.setIdm(rs.getInt(1));
                    m.setCodigo(rs.getInt(2));
                    m.setCosto(rs.getFloat(3));
                    m.setNombre(rs.getString(4));
                    m.setDescripcion(rs.getString(5));
                    m.setGenero(rs.getString(6));
                    m.setEstado(rs.getString(7));
                    m.setDemografia(rs.getString(8));
                    m.setUrli(rs.getString(9));

                    lista.add(m);
            }
            con.close();
        }catch(Exception ed){
            System.out.println("No conecto a la tabla");
            System.out.println(ed.getMessage());
            System.out.println(ed.getStackTrace());
        }
        return lista;        
    }
    
    //actualizacion del stock
    public boolean actualizarStock(Vector<Mangas> vp){
        boolean actualizo = false;
        Connection cn=null;
        PreparedStatement ps=null;
        ResultSet rs= null;
        
        try{
            cn = conexionM.getConnection();
            for (Mangas m : vp){
                String q = "Update Mangas set cantidad = ? where idM = ?";
                ps = cn.prepareStatement(q);
                ps.setFloat(1, m.getCosto());
                ps.setInt(2, m.getIdm());
                
                if(ps.executeUpdate()==1){
                    actualizo = true;
                }else{
                    actualizo = false;
                    break;
                }
            }
        }catch(Exception ex){
            ex.getStackTrace();
            System.out.println(ex.getMessage());
            System.out.println("Error en actualizacion de stock");
        }finally{
            try{
                rs.close();
                ps.close();
                cn.close();
            }catch(SQLException ex){
                ex.getStackTrace();
                System.out.println(ex.getMessage());
            }
        }
        return actualizo;
    }
}
