package com.MediApp.MediApp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.MediApp.MediApp.model.dao.MedicoDao;
import com.MediApp.MediApp.model.entity.Medico;
import com.MediApp.MediApp.service.InterfaceMedico;

@Service
public class MedicoImpl implements InterfaceMedico{
    @Autowired
    private MedicoDao medicoDao;

    @Override
    @Transactional
    public Medico save(Medico medico){
        return medicoDao.save(medico);
    }

    @Override
    @Transactional
    public Medico findById(Long id_medico){
        return medicoDao.findById(id_medico).orElse(null);
    }

    @Override
    @Transactional
    public void delete(Medico medico){
        medicoDao.delete(medico);
    }

}
