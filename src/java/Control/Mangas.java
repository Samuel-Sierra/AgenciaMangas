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
public class Mangas {
    private int idM, codigo;
    private float costo;
    private String nombre, descripcion, genero, estado, demografia, urlI;
    
    public String getUrli(){
        return urlI;
    }
    public void  setUrli(String urlI){
        this.urlI=urlI;
    }
    public int getIdm(){
        return idM;
    }
    public void setIdm(int idM){
        this.idM=idM;
    }
    public int getCodigo(){
        return codigo;
    }
    public void setCodigo(int codigo){
        this.codigo=codigo;
    }
    public float getCosto(){
        return costo;
    }
    public void setCosto(float costo){
        this.costo=costo;
    }
    public String getNombre(){
        return nombre;
    }
    public void setNombre(String nombre){
        this.nombre=nombre;
    }
    public String getDescripcion(){
        return descripcion;
    }
    public void setDescripcion(String descripcion){
        this.descripcion=descripcion;
    }
    public String getGenero(){
        return genero;
    }
    public void setGenero(String genero){
        this.genero=genero;
    }
    public String getEstado(){
        return estado;
    }
    public void setEstado(String estado){
        this.estado=estado;
    }
    public String getDemografia(){
        return demografia;
    }
    public void setDemografia(String demografia){
        this.demografia=demografia;
    }
    
}
