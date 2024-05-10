/*
 * Direccion.java
 */
package pojos;

import org.bson.types.ObjectId;

/**
 * 
 * @author Juventino López García - 00000248547
 */
public class Direccion {

    private ObjectId id;  
    
    private String calle;
    
    private String colonia;
    
    private String ciudad;
    
    private String codigoPostal;
    
    private String numeroEdificio;
    
    public Direccion() {
        
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getNumeroEdificio() {
        return numeroEdificio;
    }

    public void setNumeroEdificio(String numeroEdificio) {
        this.numeroEdificio = numeroEdificio;
    }
    
}
