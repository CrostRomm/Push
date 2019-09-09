/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Pojo.Persona;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Cristian Roemro
 * @version 1.0
 */
public class personaUnoModel {
    /**
     * Instancia del POJO
     */
    Persona pojo = new Persona();
    public personaUnoModel() {
    }
    /**
     * Metodo que agrega un nuevo carro
     * @param n Nombre 
     * @param a Apellido
     * @param e Edad
     * @param u Nombre de usuario
     * @return Lista
     */
    public String agregaUsuario(String n, String a, int e, String u) {
        Persona per = new Persona(n,a,e,u);
            for(Persona p:pojo.getListaPersona1()){
                if(p.getUsuario().equals(u)){
                    return "ya existe el usuario";
                }else{
                    pojo.getListaPersona1().add(per);
                    return "";
                }
            }
            return"";
    }
    /**
     * Elimina un usuario
     * @param lista Lista de usuarios
     * @param name Nombre
     * @param last Apellido
     * @param age Edad
     * @param user Usuario
     * @return Lista de personas
     */
    public List<Persona> eliminarUsuario(List<Persona> lista, String name, String last, int age, String user){
        pojo.setListaPersona1(lista);
        List<Persona> temp = new ArrayList<>();
        for(Persona p:pojo.getListaPersona1()){
            if(p.getUsuario().equals(user)){
                temp.add(p);
            }
        }
        pojo.getListaPersona1().removeAll(temp);
        return temp;
    }
    /**
     * Almacena los mensajes en una lista
     * @param msg
     * @return Lista de tipo persona
     */
    public List<Persona> guardarMensajes(String msg){
        pojo.setMensaje(msg);
        pojo.getListaMensajes().add(new Persona(msg));
        return pojo.getListaMensajes();
    }
}
