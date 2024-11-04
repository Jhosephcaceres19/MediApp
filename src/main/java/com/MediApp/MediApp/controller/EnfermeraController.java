package com.MediApp.MediApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.MediApp.MediApp.model.entity.Enfermera;
import com.MediApp.MediApp.service.InterfaceEnfermera;

@RestController
@RequestMapping("api/v1")
public class EnfermeraController {
    @Autowired
    private InterfaceEnfermera enfermeraService;


    @PostMapping("enfermera")
    public Enfermera createEnfermera(@RequestBody Enfermera enfermera){
        return enfermeraService.save(enfermera);
    }
    @GetMapping("enfermera/{id_enfermera}")
    public Enfermera showEnfermera(@PathVariable Long id_enfermera){
        return enfermeraService.findById(id_enfermera);
    }

    @GetMapping("enfermera")
    public ResponseEntity<List<Enfermera>> getAllEnfermera(){
        List<Enfermera> enfermeras = enfermeraService.findAll();
        return new ResponseEntity<>(enfermeras, HttpStatus.OK);
    }

    @DeleteMapping("enfermera/{id_enfermera}")
    public void deleteEnfermera(@PathVariable Long id_enfermera){
        Enfermera enfermeraDelete = enfermeraService.findById(id_enfermera);
        enfermeraService.delete(enfermeraDelete);
    }

}
