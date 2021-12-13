package com.salesianostriana.dam.GasApp.errores.excepciones;

public class SingleEntityNotFoundException extends EntityNotFoundException{

    public SingleEntityNotFoundException(String id, Class clazz) {
        super(String.format("No se ha podido encontrar la entidad del tipo %s con ID: %s, disculpe las molestias", clazz.getName(), id));
    }
}
