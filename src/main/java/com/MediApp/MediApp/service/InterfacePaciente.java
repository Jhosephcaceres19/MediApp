package com.MediApp.MediApp.service;

import java.util.List;

import com.MediApp.MediApp.model.entity.Paciente;

public interface InterfacePaciente {
    Paciente save(Paciente paciente);
    Paciente findById(Long id_paciente);
    Paciente update(Paciente paciente);
    List<Paciente> findAll();
    void delete(Paciente paciente);
}
