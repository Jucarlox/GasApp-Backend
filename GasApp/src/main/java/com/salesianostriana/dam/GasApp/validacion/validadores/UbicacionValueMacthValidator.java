package com.salesianostriana.dam.GasApp.validacion.validadores;

import com.salesianostriana.dam.GasApp.validacion.anotaciones.UbicacionValueMatch;
import org.springframework.beans.PropertyAccessorFactory;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

public class UbicacionValueMacthValidator  implements ConstraintValidator<UbicacionValueMatch, Object> {

    private String ubicacionField;

    public void initialize(UbicacionValueMatch constraintAnnotation) {
        ubicacionField = constraintAnnotation.ubicacionField();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext constraintValidatorContext) {
        String ubicacion= (String) PropertyAccessorFactory.forBeanPropertyAccess(value).getPropertyValue(ubicacionField);
        String lonMatchAndLatMatch = "^([-+]?\\d{1,2}[.]\\d+),\\s*([-+]?\\d{1,3}[.]\\d+)$";

        return Pattern.matches(lonMatchAndLatMatch,ubicacion);


    }
}
