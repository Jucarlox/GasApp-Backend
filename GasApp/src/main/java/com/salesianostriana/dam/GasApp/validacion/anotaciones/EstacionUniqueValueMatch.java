package com.salesianostriana.dam.GasApp.validacion.anotaciones;

import com.salesianostriana.dam.GasApp.model.Estacion;
import com.salesianostriana.dam.GasApp.services.EstacionService;
import com.salesianostriana.dam.GasApp.validacion.validadores.EstacionUniqueValueMatchValitor;
import com.salesianostriana.dam.GasApp.validacion.validadores.UbicacionValueMacthValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.List;

@Constraint(validatedBy = EstacionUniqueValueMatchValitor.class)
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface EstacionUniqueValueMatch {


    String message() default "No puede tener la misma ubicacion";
    Class <?> [] groups() default {};
    Class <? extends Payload> [] payload() default {};

    String ubicacionField();


}
