package com.MediApp.MediApp.service;

import com.MediApp.MediApp.model.entity.Administrador;

public interface InterfaceAdministrador {
    Administrador save(Administrador administrador);
    Administrador findById(Long id_administrador);
    void delete(Administrador administrador);

}
