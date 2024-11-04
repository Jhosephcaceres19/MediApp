package com.MediApp.MediApp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.MediApp.MediApp.model.dao.CitaDao;
import com.MediApp.MediApp.model.entity.Cita;
import com.MediApp.MediApp.service.InterfaceCita;

@Service
public class CitaImpl implements InterfaceCita{
    @Autowired
    private CitaDao citaDao;

    @Override
    @Transactional
    public Cita save(Cita cita){
        return citaDao.save(cita);
    }

    @Override
    @Transactional
    public Cita findById(Long id_cita){
        return citaDao.findById(id_cita).orElse(null);
    }

    @Override
    @Transactional
    public Cita updateCita(Cita cita){
        return citaDao.save(cita);
    }

    @Override
    @Transactional
    public List<Cita> findAll(){
        List<Cita> citas = (List<Cita>) citaDao.findAll();
        return citas;
    }

    @Override
    @Transactional
    public void delete(Cita cita){
        citaDao.delete(cita);
    }

}
