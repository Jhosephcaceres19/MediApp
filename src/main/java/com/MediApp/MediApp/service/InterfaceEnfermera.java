package com.MediApp.MediApp.service;

import java.util.List;

import com.MediApp.MediApp.model.entity.Enfermera;

public interface InterfaceEnfermera {
    Enfermera save(Enfermera enfermera);
    Enfermera findById(Long id_enfermera);
    List<Enfermera> findAll();
    void delete(Enfermera enfermera);

}
