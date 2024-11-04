package com.MediApp.MediApp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.MediApp.MediApp.model.dao.EnfermeraDao;
import com.MediApp.MediApp.model.entity.Enfermera;
import com.MediApp.MediApp.service.InterfaceEnfermera;

@Service
public class EnfermeraImpl implements InterfaceEnfermera{
    @Autowired
    private EnfermeraDao enfermeraDao;

    @Override
    @Transactional
    public Enfermera save(Enfermera enfermera){
        return enfermeraDao.save(enfermera);
    }

    @Override
    @Transactional
    public Enfermera findById(Long id_enfermera){
        return enfermeraDao.findById(id_enfermera).orElse(null);
    }

    @Override
    @Transactional
    public List<Enfermera> findAll(){
        List<Enfermera> enfermeras = (List<Enfermera>)enfermeraDao.findAll();
        return enfermeras;
    }

    @Override
    @Transactional
    public void delete(Enfermera enfermera){
        enfermeraDao.delete(enfermera);
    }

}
