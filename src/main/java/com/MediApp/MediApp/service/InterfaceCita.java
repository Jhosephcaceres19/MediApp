package com.MediApp.MediApp.service;

import java.util.List;

import com.MediApp.MediApp.model.entity.Cita;

public interface InterfaceCita {
    Cita save(Cita cita);
    Cita findById(Long id_cita);
    Cita updateCita(Cita cita);
    List<Cita> findAll();
    void delete(Cita cita);

}
