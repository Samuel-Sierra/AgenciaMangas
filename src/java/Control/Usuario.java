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
import java.sql.*;
public class Usuario {
    
    private int idU, dia, mes, año, cp, tel;
    private String nombre, appat, apmat, curp, calle, colonia, nombreS, contrasenaS;
    
    public Usuario(){
    
    }
    
    public Usuario verificarUsuario(String noms, String cons) throws SQLException, ClassNotFoundException{
        //objeto de usuario
        Usuario u = null;
        //objeto de conexion
        Connection con = conexionU.getConnection();
        
        
        try{
            String sql="select * from usuario where nombres = '"+noms+"' and contrasenas = '"+cons+"'";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                u = new Usuario();
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
        
        } catch(SQLException ex){
            ex.printStackTrace();
            u=null;
        }
        return u;
    }
    public int getIdu() {
        return idU;
    }
    public void setIdu(int idU) {
        this.idU = idU;
    }
    public String getNombreS(){
        return nombreS;
    }
    public void setNombreS(String nombreS) {
        this.nombreS = nombreS;
    }
    public String getContrasenaS(){
        return contrasenaS;
    }
    public void setContrasenaS(String contrasenaS) {
        this.contrasenaS = contrasenaS;
    }
    public String getNombre(){
        return nombre;
    }
    public void setNombre(String nombre){
        this.nombre=nombre;
    }
    public String getAppat(){
        return appat;
    }
    public void setAppat(String appat){
        this.appat=appat;
    }
    public String getApmat(){
        return apmat;
    }
    public void setApmat(String apmat){
        this.apmat=apmat;
    }
    public String getCurp(){
        return curp;
    }
    public void setCurp(String curp){
        this.curp=curp;
    }
    public String getCalle(){
        return calle;
    }
    public void setCalle(String calle){
        this.calle=calle;
    }
    public String getColonia(){
        return colonia;
    }
    public void setColonia(String colonia){
        this.colonia=colonia;
    }
    public int getDia() {
        return dia;
    }
    public void setDia(int dia) {
        this.dia = dia;
    }
    public int getMes() {
        return mes;
    }
    public void setMes(int mes) {
        this.mes = mes;
    }
    public int getAño() {
        return año;
    }
    public void setAño(int año) {
        this.año =año ;
    }
    public int getCp() {
        return cp;
    }
    public void setCp(int cp) {
        this.cp =cp ;
    }
    public int getTelefono() {
        return tel;
    }
    public void setTelefono(int tel) {
        this.tel = tel;
    }
    
}
