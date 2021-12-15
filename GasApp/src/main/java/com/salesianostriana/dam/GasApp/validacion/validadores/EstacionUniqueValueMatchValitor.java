package com.salesianostriana.dam.GasApp.validacion.validadores;

import com.salesianostriana.dam.GasApp.model.Estacion;
import com.salesianostriana.dam.GasApp.repositorios.EstacionRepository;
import com.salesianostriana.dam.GasApp.services.EstacionService;
import com.salesianostriana.dam.GasApp.validacion.anotaciones.EstacionUniqueValueMatch;
import com.salesianostriana.dam.GasApp.validacion.anotaciones.UbicacionValueMatch;
import org.springframework.beans.PropertyAccessorFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class EstacionUniqueValueMatchValitor implements ConstraintValidator<EstacionUniqueValueMatch, Object> {
    private String ubicacionField;
    @Autowired
    private EstacionRepository estacionRepository;

    public void initialize(EstacionUniqueValueMatch constraintAnnotation) {
        ubicacionField = constraintAnnotation.ubicacionField();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext constraintValidatorContext) {
        String ubicacion= (String) PropertyAccessorFactory.forBeanPropertyAccess(value).getPropertyValue(ubicacionField);



        return StringUtils.hasText(ubicacion) && !estacionRepository.existsByUbicacion(ubicacion);

    }
}
