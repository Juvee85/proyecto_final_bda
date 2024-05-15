/*
 * Convertidor.java
 */
package convertidores;

import java.util.Collection;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Clase con la definición de los métodos de un convertidor generico para
 * convertir entre objetos DTO y POJO
 *
 * @param <T> Clase de DTO entre la cual convertir
 * @param <U> Clase de POJO entre la cual convertir
 * @author Juventino López García - 00000248547
 */
public class Convertidor<T, U> {

    private final Function<T, U> fromDto;
    private final Function<U, T> fromPojo;

    /**
     * Constrictor usado por las clases que heredan de Convertidor para definir
     * las cunciones que hacen la converción de DTO a POJO y viceversa
     *
     * @param fromDto Función para convertir de DTO a POJO
     * @param fromPojo Función para convertir de POJO a DTO
     */
    public Convertidor(final Function<T, U> fromDto, final Function<U, T> fromPojo) {
        this.fromDto = fromDto;
        this.fromPojo = fromPojo;
    }

    /**
     * Convierte un DTO a un POJO
     *
     * @param dto DTO del cual se desea convertir a POJO
     * @return POJO convertido desde el DTO
     */
    public final U convertFromDto(final T dto) {
        return fromDto.apply(dto);
    }

    /**
     * Convierte un POJO a un DTO
     *
     * @param pojo POJO del cual se desea convertir a DTO
     * @return DTO convertido desde el POJO
     */
    public final T convertFromPojo(final U pojo) {
        return fromPojo.apply(pojo);
    }

    /**
     * Convierte una lista de DTOs a POJOs
     *
     * @param dtos Lista con DTOs
     * @return Lista con POJOs convertidos desde la lista dada por el parametro
     */
    public final List<U> createFromDtos(final Collection<T> dtos) {
        return dtos.stream().map(this::convertFromDto).collect(Collectors.toList());
    }

    /**
     * Convierte una lista de POJOs a DTOs
     *
     * @param pojos Lista con POJOs
     * @return Lista con DTOs convertidos deade la lista dada por el parametro
     */
    public final List<T> createFromPojos(final Collection<U> pojos) {
        return pojos.stream().map(this::convertFromPojo).collect(Collectors.toList());
    }
}