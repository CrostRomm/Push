package Pojo;

import java.util.ArrayList;
import java.util.List;
/**
 * @author Cristian Roemro
 * @version 1.0
 */
public class Persona {
    /**
     * Variable que guarda el nombre 
     */
    private String nombre;
    /**
     * Variable que guarda el apellido
     */
    private String apellido;
    /**
     * Variable que guarda la edad
     */
    private int edad;
    /**
     * Variable que guarda el nombre de usuario
     */
    private String usuario;
    /**
     * Variable que guarda los mensajes
     */
    private String mensaje;
    /**
     * Lista que guarda las personas
     */
    private static List<Persona> listaPersona1 = new ArrayList<>();
    /**
     * Lista que guarda los mensajes
     */
    private static List<Persona> listaMensajes = new ArrayList<>();
    /**
     * COnstructor vacio
     */
    public Persona() {
    }
    /**
     * Constructor del POJO persona
     * @param nombre
     * @param apellido
     * @param edad
     * @param usuario 
     */
    public Persona(String nombre, String apellido, int edad, String usuario) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.usuario = usuario; 
    }
    /**
     * Constructor para los mensajes
     * @param mensaje 
     */
    public Persona(String mensaje) {
        this.mensaje = mensaje;
    }
    /**
     * Get del nombre
     * @return String
     */
    public String getNombre() {
        return nombre;
    }
    /**
     * Set del nombre
     * @param nombre 
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    /**
     * Get del apellido
     * @return String
     */
    public String getApellido() {
        return apellido;
    }
    /**
     * Set del apellido
     * @param apellido
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    /**
     * Get de la edad
     * @return Int
     */
    public int getEdad() {
        return edad;
    }
    /**
     * Set de la edad
     * @param edad 
     */
    public void setEdad(int edad) {
        this.edad = edad;
    }
    /**
     * Get del nombre de usuario
     * @return String
     */
    public String getUsuario() {
        return usuario;
    }
    /**
     * Set del nombre de usuario
     * @param usuario 
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    /**
     * Get de los mensajes
     * @return String
     */
    public String getMensaje() {
        return mensaje;
    }
    /**
     * Set de los mensajes
     * @param mensaje 
     */
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
   /**
    * Get de la lista de personas
    * @return Lista de tipo persona
    */
    public List<Persona> getListaPersona1() {
        return listaPersona1;
    }
    /**
     * Set de la lista de personas
     * @param listaPersona1 
     */
    public void setListaPersona1(List<Persona> listaPersona1) {
        this.listaPersona1 = listaPersona1;
    }
    /**
     * Get de la lista de mensajes
     * @return Lista de tipo persona
     */
    public List<Persona> getListaMensajes() {
        return listaMensajes;
    }
    /**
     * Set de la lista de mensajes
     * @param listaMensajes 
     */
    public void setListaMensajes(List<Persona> listaMensajes) {
        this.listaMensajes = listaMensajes;
    }
}
