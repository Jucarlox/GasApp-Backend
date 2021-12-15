package com.salesianostriana.dam.GasApp.dto;

import com.salesianostriana.dam.GasApp.model.Estacion;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class ConverterEstacionDTO {

    public Estacion convertInmobiliariaDto(CreatedEstacionDTO createdEstacionDTO) {
        return Estacion.builder()
                .nombre(createdEstacionDTO.getNombre())
                .marca(createdEstacionDTO.getMarca())
                .ubicacion(createdEstacionDTO.getUbicacion())
                .tieneAutolavado(createdEstacionDTO.isTieneAutolavado())
                .precioGasoilNormal(createdEstacionDTO.getPrecioGasoilNormal())
                .precioGasolina95Octanos(createdEstacionDTO.getPrecioGasolina95Octanos())
                .precioGasolina98(createdEstacionDTO.getPrecioGasolina98())
                .precioGasoilEspecial(createdEstacionDTO.getPrecioGasoilEspecial())
                .fechaApertura(createdEstacionDTO.getFechaApertura())
                .servicios(createdEstacionDTO.getServicios())
                .fechaRegistro(LocalDateTime.now())
                .build();

    }
}
