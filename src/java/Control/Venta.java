package Control;
import java.sql.*;
import java.util.*;
public class Venta {
    private int ventaID;
    private String fechaVenta;
    private int idU;
    private double totalVenta;
    
    public Venta(){
        
    }
    
    private int ultimoCodigoInsertado(Connection cn) throws SQLException{
        int codigo= 0;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try{
            String q ="select MAX(ventaID) as Codigo from Venta";
            ps = cn.prepareStatement(q);
            rs= ps.executeQuery();
            
            while(rs.next()){
                codigo = rs.getInt("Codigo");
                break;
            }
        }catch(SQLException ex){
            ex.getStackTrace();
            System.out.println(ex.getMessage());
            System.out.println("Hay un error en ultimo codigo insertado");
            codigo=0;
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
        return codigo;
    }
    private boolean RegistrarVenta(Venta v, Vector<Detalleventa> ldv) throws SQLException{
        boolean registro = false;
        Connection cn=null;
        PreparedStatement ps=null;
        ResultSet rs= null;
        
        try{
            cn=conexionM.getConnection();
            String q="insert into Venta(fechaVenta, idU, totalVenta) values (?, ?, ?)";
            ps=cn.prepareStatement(q);
            ps.setString(1, v.getFechaVenta());
            ps.setInt(2, v.getIdU());
            ps.setDouble(3, v.getTotalVenta());
            
            if(ps.executeUpdate()==1){
                int codigo = this.ultimoCodigoInsertado(cn);
                registro = this.registroDetalleVenta(codigo,ldv,cn);
            }else{
                registro=false;
            }
        }catch(SQLException ex){
            registro = false;
            System.out.println(ex.getMessage());
            System.out.println("Error en registrarventa");
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
        return registro;
    }
    private boolean registroDetalleVenta(int codigo, Vector<Detalleventa> ldv, Connection cn){
        boolean registro=false;
        PreparedStatement ps=null;
        
        try{
            for(Detalleventa dv : ldv){
                String q="insert into detalleventa values(?, ?, ?, ?, ?)";
                ps=cn.prepareStatement(q);
                ps.setInt(1, ventaID);
                ps.setInt(2, dv.getDetVenta_Item());
                ps.setInt(3, dv.getIdM());
                ps.setInt(4, dv.getDetVenta_cantidad());
                ps.setDouble(5, dv.getDetVenta_subtotal());
                
                if(ps.executeUpdate()==1){
                    registro=true;
                }else{
                    registro=false;
                    break;
                }
            }
        }catch(SQLException ex){
            registro = false;
            ex.getStackTrace();
            System.out.println(ex.getMessage());
        }
    return registro;
    }
    public int getVentaID() {
        return ventaID;
    }

    public void setVentaID(int ventaID) {
        this.ventaID = ventaID;
    }

    public String getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(String fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public int getIdU() {
        return idU;
    }

    public void setIdU(int idU) {
        this.idU = idU;
    }

    public double getTotalVenta() {
        return totalVenta;
    }

    public void setTotalVenta(double totalVenta) {
        this.totalVenta = totalVenta;
    }
    
    
}
