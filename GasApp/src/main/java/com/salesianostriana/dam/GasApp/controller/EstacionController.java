package com.salesianostriana.dam.GasApp.controller;

import com.salesianostriana.dam.GasApp.dto.ConverterEstacionDTO;
import com.salesianostriana.dam.GasApp.dto.CreatedEstacionDTO;
import com.salesianostriana.dam.GasApp.model.Estacion;
import com.salesianostriana.dam.GasApp.services.EstacionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/estacion")
public class EstacionController {

    private final EstacionService estacionService;
    private final ConverterEstacionDTO converterEstacionDTO;


    @GetMapping("/")
    public List<Estacion> findAll(){
        return estacionService.findAll();
    }

    @GetMapping("/{id}")
    public Estacion findOne(@PathVariable Long id){
        return estacionService.findOne(id);
    }

    @PostMapping("/")
    public Estacion created(@Valid @RequestBody CreatedEstacionDTO createdEstacionDTO) {
        return estacionService.created(createdEstacionDTO);
    }

    @PutMapping("/{id}")
    public Estacion edit(@Valid @RequestBody CreatedEstacionDTO createdEstacionDTO, @PathVariable Long id){
        return estacionService.edit(createdEstacionDTO, id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        return estacionService.delete(id);
    }


}
