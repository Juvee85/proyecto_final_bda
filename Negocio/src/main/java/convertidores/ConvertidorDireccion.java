/*
 * ConvertidorDireccion.java
 */
package convertidores;

import dtos.DireccionDTO;
import pojos.Direccion;

/**
 *
 * @author Juventino López García - 00000248547
 */
public class ConvertidorDireccion extends Convertidor<DireccionDTO, Direccion> {

    public ConvertidorDireccion() {
        super(ConvertidorDireccion::convertToPojo, ConvertidorDireccion::convertToDto);
    }

    private static DireccionDTO convertToDto(Direccion direccion) {
        DireccionDTO dto = new DireccionDTO();
        dto.setCalle(direccion.getCalle());
        dto.setCiudad(direccion.getCiudad());
        dto.setCodigoPostal(direccion.getCodigoPostal());
        dto.setColonia(direccion.getColonia());
        dto.setNumeroEdificio(direccion.getNumeroEdificio());

        return dto;
    }

    private static Direccion convertToPojo(DireccionDTO dto) {
        Direccion direccion = new Direccion();
        direccion.setCalle(dto.getCalle());
        direccion.setCiudad(dto.getCiudad());
        direccion.setCodigoPostal(dto.getCodigoPostal());
        direccion.setColonia(dto.getColonia());
        direccion.setNumeroEdificio(dto.getNumeroEdificio());

        return direccion;
    }
}
