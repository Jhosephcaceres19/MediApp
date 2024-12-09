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

import com.MediApp.MediApp.model.entity.Paciente;
import com.MediApp.MediApp.service.InterfacePaciente;

@RestController
@RequestMapping("/api/v1")
public class PacienteController {
    @Autowired
    private InterfacePaciente pacienteService;

    @PostMapping("paciente")
    public Paciente createPaciente(@RequestBody Paciente paciente){
        return pacienteService.save(paciente);
    }

    @GetMapping("paciente/{id_paciente}")
    public Paciente showPaciente(@PathVariable Long id_paciente){
        return pacienteService.findById(id_paciente);
    }
    

    @PutMapping("paciente/{id}")
    public ResponseEntity<Paciente> updatePaciente(@PathVariable("id") Long id, @RequestBody Paciente paciente) {
        Paciente existingPaciente = pacienteService.findById(id);
        if (existingPaciente != null) {
            paciente.setId_paciente(id);  // Asegurarse de que el ID se mantenga igual
            Paciente updatedPaciente = pacienteService.update(paciente);
            return new ResponseEntity<>(updatedPaciente, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Eliminar un paciente
    @DeleteMapping("paciente/{id}")
    public ResponseEntity<Void> deletePaciente(@PathVariable("id") Long id) {
        Paciente paciente = pacienteService.findById(id);
        if (paciente != null) {
            pacienteService.delete(paciente);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Obtener todos los pacientes
    @GetMapping("paciente")
    public ResponseEntity<List<Paciente>> getAllPacientes() {
        List<Paciente> pacientes = pacienteService.findAll();
        return new ResponseEntity<>(pacientes, HttpStatus.OK);
    }

}
