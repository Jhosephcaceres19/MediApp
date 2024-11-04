package com.MediApp.MediApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.MediApp.MediApp.model.entity.Administrador;
import com.MediApp.MediApp.service.InterfaceAdministrador;

@RestController
@RequestMapping("/api/v1")
public class AdministradorController {
    @Autowired
    public InterfaceAdministrador adminstradorService;

    @PostMapping("administrador")
    public Administrador createAdministrador(@RequestBody Administrador administrador){
        return adminstradorService.save(administrador);
    }

    @GetMapping("administrador/{id_administrador}")
    public Administrador showAdministrador(@PathVariable Long id_administrador){
        return adminstradorService.findById(id_administrador);
    }

    @DeleteMapping("medico/{id_medico}")
    public void deleteAdministrador(@PathVariable Long id_administrador){
        Administrador administradorDelete = adminstradorService.findById(id_administrador);
        adminstradorService.delete(administradorDelete);
    }

}
