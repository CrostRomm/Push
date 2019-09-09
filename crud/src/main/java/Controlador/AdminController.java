package Controlador;

import Pojo.Persona;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

/**
 * @author Cristian Romero
 * @version 1.0
 */
@ManagedBean(name="admin")
@RequestScoped
public class AdminController implements Serializable{

    /**
     * Creates a new instance of AdminController
     */
    public AdminController() {
    }
    /**
     * Puente de comunicacion entre ambos frijoles
     */
    @ManagedProperty(value="#{personaUno}")
    personaUnoController per;
    /**
     * Get del puente de comunicacion entre beans
     * @return 
     */
    public personaUnoController getPer() {
        return per;
    }
    /**
     * Set del puente de comunicacion entre beans
     * @param per 
     */
    public void setPer(personaUnoController per) {
        this.per = per;
    }
    /**
     Metodo que llena la tabla del administrador con los mensajes
     * @return Lista de mensajes
     */
    public List<Persona> recibirMsg(){
        return per.getMsgTemporal();
    }
}
