package com.MediApp.MediApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.MediApp.MediApp.model.entity.Medico;
import com.MediApp.MediApp.service.InterfaceMedico;

@RestController
@RequestMapping("/api/v1")
public class MedicoController {
    @Autowired
    private InterfaceMedico medicoService;

    @PostMapping("medico")
    public Medico creatMedico(@RequestBody Medico medico){
        return medicoService.save(medico);
    }

    @GetMapping("medico/(id_medico)")
    public Medico showMedico(@PathVariable Long id_medico){
        return medicoService.findById(id_medico);
    }

    @DeleteMapping("medico/{id_medico}")
    public void deleteMedico(@PathVariable Long id_medico){
        Medico medicoDelete = medicoService.findById(id_medico);
        medicoService.delete(medicoDelete);
    }
}
