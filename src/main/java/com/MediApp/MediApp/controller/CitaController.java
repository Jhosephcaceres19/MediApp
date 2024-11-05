package com.MediApp.MediApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.MediApp.MediApp.model.entity.Cita;
import com.MediApp.MediApp.service.InterfaceCita;

@RestController
@RequestMapping("/api/v1")
public class CitaController {
    @Autowired
    private InterfaceCita citaService;

    @PostMapping("cita")
    public Cita createCita(@RequestBody Cita cita){
        return citaService.save(cita);
    }

    @GetMapping("cita/{id_cita}")
    public Cita showCita(@PathVariable Long id_cita){
        return citaService.findById(id_cita);
    }

    @PutMapping("cita/{id}")
    public ResponseEntity<Cita> updateEntity(@PathVariable("id") Long id, @RequestBody Cita cita){
        Cita existingCita = citaService.findById(id);
        if (existingCita != null) {
            cita.setId_cita(id);
            Cita updateCita = citaService.updateCita(existingCita);
            return new ResponseEntity<>(updateCita, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("cita/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id){
        Cita cita = citaService.findById(id);
        if (cita != null) {
            citaService.delete(cita);
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("cita")
    public ResponseEntity<List<Cita>> getAllCitas(){
        List<Cita> citas = citaService.findAll();
        return new ResponseEntity<>(citas, HttpStatus.OK);
    }

}
