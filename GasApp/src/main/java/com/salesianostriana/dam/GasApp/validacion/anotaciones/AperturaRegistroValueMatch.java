package com.salesianostriana.dam.GasApp.validacion.anotaciones;

import com.salesianostriana.dam.GasApp.validacion.validadores.AperturaRegistroValueMatchValidator;
import com.salesianostriana.dam.GasApp.validacion.validadores.UbicacionValueMacthValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = AperturaRegistroValueMatchValidator.class)
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface AperturaRegistroValueMatch {
    String message() default "La fecha de apertura no puede ser posterior a la fecha de registro";
    Class <?> [] groups() default {};
    Class <? extends Payload> [] payload() default {};

    String fechaAperturaField();



}
