/*
 * IIniciarSesionBO.java
 */
package interfaces;

import dtos.UsuarioDTO;
import excepciones.NegocioException;

/**
 *
 * @author Juventino López García - 00000248547
 */
public interface IIniciarSesionBO {

    public UsuarioDTO iniciarSesion(String telefono, String contrasenha) throws NegocioException;
}
