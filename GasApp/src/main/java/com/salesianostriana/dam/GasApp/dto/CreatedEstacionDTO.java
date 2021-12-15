package com.salesianostriana.dam.GasApp.dto;

import com.salesianostriana.dam.GasApp.validacion.anotaciones.AperturaRegistroValueMatch;
import com.salesianostriana.dam.GasApp.validacion.anotaciones.EstacionUniqueValueMatch;
import com.salesianostriana.dam.GasApp.validacion.anotaciones.UbicacionValueMatch;
import lombok.*;
import org.hibernate.validator.constraints.UniqueElements;
import org.hibernate.validator.internal.constraintvalidators.hv.UniqueElementsValidator;

import javax.persistence.Lob;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor @AllArgsConstructor

@UbicacionValueMatch(
        ubicacionField = "ubicacion",
        message = "{estacion.ubicacion.pattern}"
)
@AperturaRegistroValueMatch(
        fechaAperturaField= "fechaApertura",
        message = "{estacion.fecha}"

)

@EstacionUniqueValueMatch(
        ubicacionField = "ubicacion",
        message = "{estacion.ubicacion.unique}"
)

public class CreatedEstacionDTO {

    @NotNull(message = "{estacion.nombre.null}")
    @NotBlank(message = "{estacion.nombre.blank}")
    private String nombre;

    private String marca;

    @NotNull(message = "{estacion.ubicacion.null}")

    //@Pattern(regexp = "^([-+]?\\d{1,2}[.]\\d+),\\s*([-+]?\\d{1,3}[.]\\d+)$",message = "{estacion.ubicacion.pattern}")
    private String ubicacion;

    private boolean tieneAutolavado=false;

    @Min(value=0, message="{estacion.precioGasoilNormal.min}")
    @NotNull(message = "{estacion.precioGasoilNormal.null}")
    private double precioGasoilNormal;

    @Min(value=0, message="{estacion.precioGasolina95Octanos.min}")
    @NotNull(message = "{estacion.precioGasolina95Octanos.null}")
    private double precioGasolina95Octanos;

    @Min(value=0, message="{estacion.precioGasoilEspecial.min}")
    private double precioGasoilEspecial;

    @Min(value=0, message="{estacion.precioGasolina98.min}")
    private double precioGasolina98;

    @Lob
    private String servicios;

    @Past
    private LocalDateTime fechaApertura;




}
