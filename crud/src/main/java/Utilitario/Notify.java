package Utilitario;

import Modelo.personaUnoModel;
import javax.faces.application.FacesMessage;
import org.primefaces.push.annotation.OnMessage;
import org.primefaces.push.annotation.PushEndpoint;
import org.primefaces.push.impl.JSONEncoder;

/**
 * @author Cristian Romero
 */
@PushEndpoint("/notify")
public class Notify {
    /**
     * Instancia de la clase modelo
     */
    personaUnoModel p = new personaUnoModel();
    /**
     * Se utiliza como canal para llevar los mensajes a la vista
     * @param msg mensaje que ve el admin
     * @return mensaje
     */
    @OnMessage(encoders = {JSONEncoder.class})
    public FacesMessage onMessage(FacesMessage msg){
        
        p.guardarMensajes(msg.toString());
        return msg;
    }
}
