package com.salesianostriana.dam.GasApp.validacion.anotaciones;


import com.salesianostriana.dam.GasApp.validacion.validadores.UbicacionValueMacthValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = UbicacionValueMacthValidator.class)
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface UbicacionValueMatch {
    String message() default "La ubicacion no tiene altitud o latitud correspondientes";
    Class <?> [] groups() default {};
    Class <? extends Payload> [] payload() default {};

    String ubicacionField();

    @Target({ ElementType.TYPE })
    @Retention(RetentionPolicy.RUNTIME)
    @interface List {
        UbicacionValueMatch[] value();
    }
}
