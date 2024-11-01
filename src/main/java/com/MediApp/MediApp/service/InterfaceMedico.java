package com.MediApp.MediApp.service;

import com.MediApp.MediApp.model.entity.Medico;

public interface InterfaceMedico {
    Medico save(Medico medico);
    Medico findById(Long id_medico);
    void delete(Medico medico);
}
