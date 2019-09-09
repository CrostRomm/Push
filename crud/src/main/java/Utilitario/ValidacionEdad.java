package Utilitario;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
/**
 * @author Cristian Romero
 * @version 1.0
 */
@FacesValidator(value = "validacionEdad")
public class ValidacionEdad implements Validator{
/**
 * Sobreescritura de un metodo de validacion para la edad
 * @param context
 * @param component
 * @param value
 * @throws ValidatorException 
 */
    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        String texto = String.valueOf(value);
        try{
            int edad = Integer.parseInt(texto);
        }catch(NumberFormatException e){
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                "Ojo", "Solo se permiten numeros");
            throw new ValidatorException(msg);
        }
    }
    
}
