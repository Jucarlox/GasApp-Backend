package com.salesianostriana.dam.GasApp.validacion.validadores;

import com.salesianostriana.dam.GasApp.validacion.anotaciones.AperturaRegistroValueMatch;
import com.salesianostriana.dam.GasApp.validacion.anotaciones.UbicacionValueMatch;
import org.springframework.beans.PropertyAccessorFactory;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDateTime;
import java.util.regex.Pattern;

public class AperturaRegistroValueMatchValidator  implements ConstraintValidator<AperturaRegistroValueMatch, Object> {

    private String fechaAperturaField;
    private String fechaRegistroField;


    public void initialize(AperturaRegistroValueMatch constraintAnnotation) {
        fechaAperturaField = constraintAnnotation.fechaAperturaField();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext constraintValidatorContext) {


        LocalDateTime fechaApertura= (LocalDateTime) PropertyAccessorFactory.forBeanPropertyAccess(value).getPropertyValue(fechaAperturaField);


        if(LocalDateTime.now().isAfter(fechaApertura) || LocalDateTime.now().equals(fechaApertura)){
            return true;
        }else{
            return false;
        }


    }
}
