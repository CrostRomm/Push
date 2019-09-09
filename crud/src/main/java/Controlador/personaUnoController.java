package Controlador;

import Modelo.personaUnoModel;
import Pojo.Persona;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.CellEditEvent;
import org.primefaces.event.RowEditEvent;
import org.primefaces.push.EventBus;
import org.primefaces.push.EventBusFactory;
import org.apache.commons.lang3.StringEscapeUtils;

/**
 * @author Cristian Romero
 * @version 1.0
 */
@ManagedBean(name = "personaUno")
@SessionScoped
public class personaUnoController implements Serializable{
    /**
     * Variable que almacena el nombre de la persona
     */
    private String name;
    /**
     * Variable que almacena el apellido de la persona
     */
    private String lastName;
    /**
     * Variable que almacena la edad de la persona
     */
    private int age;
    /**
     * Variable que almacena el nombre de usuario de la persona
     */
    private String username;
    /**
     * Variable que almacena el mensaje que se brinda al admin
     */
    private String inbox;
    /**
     * Lista que almacena temporalmente las personas
     */
    private static List<Persona> listaTemporal= new ArrayList<>();
    /**
     * Lista que almacena temporalmente los mensajes
     */
    private static List<Persona> msgTemporal= new ArrayList<>();
    /**
     * Instancia de la clase POJO de personas
     */
    Persona pojo = new Persona();
    /**
     * Instancia del modelo
     */
    personaUnoModel modelo = new personaUnoModel();
    
    /**
     * Constructor
     * @param name
     * @param lastName
     * @param age
     * @param username 
     */
    public personaUnoController(String name, String lastName, int age, String username) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.username = username;
    }
    /**
     * Crea una nueva instancia del la misma clase
     */
    public personaUnoController() {
    }
    /**
     * * Get del nombre temporal
     * @return String
     */
    public String getName() {
        return name;
    }
    /**
     * Set del nombre temporal
     * @param name 
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * Get del apellido temporal
     * @return String
     */
    public String getLastName() {
        return lastName;
    }
    /**
     * Set del apellido temporal
     * @param lastName 
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    /**
     * Get de la edad temporal
     * @return int
     */
    public int getAge() {
        return age;
    }
    /**
     * Set de la edad temporal
     * @param age 
     */
    public void setAge(int age) {
        this.age = age;
    }
    /**
     * Get del nombre de usuario temporal
     * @return String
     */
    public String getUsername() {
        return username;
    }
    /**
     * Set del nombre de usuario temporal
     */
    public void setUsername(String username) {
        this.username = username;
    }
    /**
     * Get del mesaje temporal
     * @return String
     */
    public String getInbox() {
        return inbox;
    }
    /**
     * Set del mensaje temporal
     * @param inbox 
     */
    public void setInbox(String inbox) {
        this.inbox = inbox;
    }
    /**
     * Get de la Lista temporal de personas
     * @return Lista tipo perona
     */
    public List<Persona> getListaTemporal() {
        return listaTemporal;
    }
    /**
     * Set de la lista temporal de personas
     * @param listaTemporal 
     */
    public void setListaTemporal(List<Persona> listaTemporal) {
        this.listaTemporal = listaTemporal;
    }
    /**
     * Get de la lista temporal de mensajes
     * @return Lista de personas
     */
    public List<Persona> getMsgTemporal() {
        return msgTemporal;
    }
    /**
     * Set de la lista temporal de mensajes
     * @param msgTemporal 
     */
    public void setMsgTemporal(List<Persona> msgTemporal) {
        this.msgTemporal = msgTemporal;
    }
    /**
     * Metodo que hace la actualización de datos de la lista de usuarios
     * @param event 
     */
    public void onRowEdit(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Se han editado los datos del usuario ", ((Persona) event.getObject()).getUsuario());
        FacesContext.getCurrentInstance().addMessage(null, msg);
        editarPush();
    }
     /**
      * Notifica cuando se cancela una edicion
      * @param event 
      */
    public void onRowCancel(RowEditEvent event) {
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Se cancelo la edición del usuario", ((Persona) event.getObject()).getUsuario());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    /**
     * Metodo que crea un nuevo usuario
     */
    public void onAddNew() {
        pojo.setNombre(name);
        pojo.setApellido(lastName);
        pojo.setEdad(age);
        pojo.setUsuario(username);
        
        String msge = modelo.agregaUsuario(name,lastName,age,username);
        
        if(msge.equals("ya existe el usuario")){
            FacesMessage msg = new FacesMessage("Error:  ", "Ya existe el usuario");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }else{
            
            listaTemporal.add(new Persona(name,lastName,age,username));
            FacesMessage msg = new FacesMessage("Ha sido agregado:  ", name);
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
        agregarPush();
    }
    /**
     * Metodo que notifica que celda se ha modificado
     * @param event 
     */
    public void onCellEdit(CellEditEvent event) {
        pojo.setNombre(name);
        pojo.setApellido(lastName);
        pojo.setEdad(age);
        pojo.setUsuario(username);
        Object oldValue = event.getOldValue();
        Object newValue = event.getNewValue();
         
        if(newValue != null && !newValue.equals(oldValue)) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Se ha modificado", " : " + oldValue + ", Por:  " + newValue);
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
        
    }
    /**
     * Metodo que elimina un usuario
     * @param n
     * @param a
     * @param e
     * @param u 
     */
    public void deleteRow(String n, String a, int e, String u){
        List<Persona> l = new ArrayList<>();
        pojo.setNombre(n);
        pojo.setApellido(a);
        pojo.setEdad(e);
        pojo.setUsuario(u);
        pojo.setListaPersona1(listaTemporal);
        Persona p = new Persona(n,a,e,u);
        for(Persona pe:pojo.getListaPersona1()){
            if(pe.getUsuario().equals(u)){
                l.add(pe);
            }
        }
        listaTemporal.removeAll(l);
        pojo.getListaPersona1().removeAll(l);
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Se elimino el usuario  ", " : " + pojo.getUsuario());
        FacesContext.getCurrentInstance().addMessage(null, msg);
        eliminarPush();
    }
    /**
     * mensaje de nuevo usuario
     */
    public void agregarPush(){
        try {
            String summary= "NUEVO USUARIO";
            inbox = "se agrego a la lista de usuarios: " + username;
            String CHANNEL= "/notify";
            msgTemporal.add(new Persona(inbox));
            EventBus canal = EventBusFactory.getDefault().eventBus();
            canal.publish(CHANNEL, new FacesMessage(StringEscapeUtils.escapeHtml3(summary), StringEscapeUtils.escapeHtml3(inbox)));
        } catch (Exception ex) {
            Logger.getLogger(personaUnoController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    /**
     * Mensaje de usuario eliminado
     */
    public void eliminarPush(){
        try {
            String summary= "USUARIO ELIMINADO";
            inbox = "Ya no existe el usuario: " + username;
            String CHANNEL= "/notify";
            msgTemporal.add(new Persona(inbox));
            EventBus canal = EventBusFactory.getDefault().eventBus();
            canal.publish(CHANNEL, new FacesMessage(StringEscapeUtils.escapeHtml3(summary), StringEscapeUtils.escapeHtml3(inbox)));
        } catch (Exception ex) {
            Logger.getLogger(personaUnoController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    /**
     * Mensaje de usuario editado
     */
    public void editarPush(){
        try {
            String summary= "USUARIO EDITADO";
            inbox = "Se edito el usuario: " + username;
            String CHANNEL= "/notify";
            msgTemporal.add(new Persona (inbox));
            EventBus canal = EventBusFactory.getDefault().eventBus();
            canal.publish(CHANNEL, new FacesMessage(StringEscapeUtils.escapeHtml3(summary), StringEscapeUtils.escapeHtml3(inbox)));
        } catch (Exception ex) {
            Logger.getLogger(personaUnoController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
