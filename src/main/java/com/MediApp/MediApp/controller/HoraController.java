package com.MediApp.MediApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.MediApp.MediApp.model.entity.Hora;
import com.MediApp.MediApp.model.entity.Medico;
import com.MediApp.MediApp.service.InterfaceHora;
import com.MediApp.MediApp.service.InterfaceMedico;

@RestController
@RequestMapping("/api/v1")
public class HoraController {
    @Autowired
    private InterfaceHora horaService;

    @PostMapping("hora")
    public ResponseEntity<Hora> createHora(@RequestBody Hora hora) {
        return ResponseEntity.ok(horaService.saveHora(hora));
    }

    @GetMapping("hora/{id_hora}")
    public Hora showHora(@PathVariable Long id_hora){
        return horaService.findByIdHora(id_hora);
    }

    @PutMapping("hora/{id}")
    public ResponseEntity<Hora> updateHora(@PathVariable("id") Long id, @RequestBody Hora hora){
        Hora existingHora = horaService.findByIdHora(id);
        if (existingHora != null) {
            hora.setId_hora(id);
            Hora updateHora = horaService.updateHora(existingHora);
            return new ResponseEntity<>(updateHora, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
