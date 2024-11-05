package com.MediApp.MediApp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.MediApp.MediApp.model.dao.HoraDao;
import com.MediApp.MediApp.model.entity.Hora;
import com.MediApp.MediApp.service.InterfaceHora;

@Service
public class HoraImpl implements InterfaceHora{
    @Autowired
    private HoraDao horaDao;

    @Override
    @Transactional
    public Hora saveHora(Hora hora){
        return horaDao.save(hora);
    }

    @Override
    @Transactional
    public Hora findByIdHora(Long id_hora){
        return horaDao.findById(id_hora).orElse(null);
    }

    @Override
    @Transactional
    public Hora updateHora(Hora hora){
        return horaDao.save(hora);
    }
}
