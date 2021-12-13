package com.salesianostriana.dam.GasApp.services;

import com.salesianostriana.dam.GasApp.dto.ConverterEstacionDTO;
import com.salesianostriana.dam.GasApp.dto.CreatedEstacionDTO;
import com.salesianostriana.dam.GasApp.errores.excepciones.ListEntityNotFoundException;
import com.salesianostriana.dam.GasApp.model.Estacion;
import com.salesianostriana.dam.GasApp.repositorios.EstacionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EstacionService {
    private final EstacionRepository estacionRepository;
    private final ConverterEstacionDTO converterEstacionDTO;

    public List<Estacion> findAll() {
        List<Estacion> result = estacionRepository.findAll();

        if (result.isEmpty()) {
            throw new ListEntityNotFoundException(Estacion.class);
        } else {
            return result;
        }
    }

    public Estacion findOne(Long id) {
        Optional<Estacion> result = estacionRepository.findById(id);

        if (result.isEmpty()) {
            throw new ListEntityNotFoundException(Estacion.class);
        } else {
            return result.get();
        }
    }

    public Estacion created(CreatedEstacionDTO createdEstacionDTO) {
        return estacionRepository.save(converterEstacionDTO.convertInmobiliariaDto(createdEstacionDTO));
    }


    public Estacion edit(CreatedEstacionDTO createdEstacionDTO, Long id) {

        Optional<Estacion> estacion= estacionRepository.findById(id);

        if(estacion.isEmpty()){
            return estacion.map(e->{
                e.setNombre(createdEstacionDTO.getNombre());
                e.setMarca(createdEstacionDTO.getMarca());
                e.setUbicacion(createdEstacionDTO.getUbicacion());
                e.setTieneAutolavado(createdEstacionDTO.isTieneAutolavado());
                e.setPrecioGasoilNormal(createdEstacionDTO.getPrecioGasoilNormal());
                e.setPrecioGasolina95Octanos(createdEstacionDTO.getPrecioGasolina95Octanos());
                e.setPrecioGasolina98(createdEstacionDTO.getPrecioGasolina98());
                e.setPrecioGasoilEspecial(createdEstacionDTO.getPrecioGasoilEspecial());
                estacionRepository.save(e);
                return e;
            }).get();
        }else{
            throw new ListEntityNotFoundException(Estacion.class);
        }
    }



}
