package com.salesianostriana.dam.GasApp.dto;

import lombok.*;

import javax.persistence.Lob;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreatedEstacionDTO {

    @NotNull(message = "{estacion.nombre.null}")
    @NotBlank(message = "{estacion.nombre.blank}")
    private String nombre;

    private String marca;

    @NotNull(message = "{estacion.ubicacion.null}")
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
