package com.MediApp.MediApp.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.MediApp.MediApp.model.dao.PacienteDao;
import com.MediApp.MediApp.model.entity.Paciente;
import com.MediApp.MediApp.service.InterfacePaciente;


@Service
public class PacienteImpl implements InterfacePaciente{
    @Autowired
    private PacienteDao pacienteDao;

    @Override
    @Transactional
    public Paciente save(Paciente paciente){
        return pacienteDao.save(paciente);
    };

    @Override
    @Transactional
    public Paciente findById(Long id_paciente){
        return pacienteDao.findById(id_paciente).orElse(null);
    }

    @Override
    @Transactional
    public Paciente update(Paciente paciente){
        return pacienteDao.save(paciente);
    }

    @Override
    @Transactional
    public List<Paciente> findAll(){
        // List<Paciente> pacientes = new ArrayList<>();
        // pacienteDao.findAll().forEach(pacientes::add);
        // return pacientes;
        List<Paciente> pacientes = (List<Paciente>) pacienteDao.findAll();
        return pacientes;
    }

    @Override
    @Transactional
    public void delete(Paciente paciente){
        pacienteDao.delete(paciente);
    }


}
