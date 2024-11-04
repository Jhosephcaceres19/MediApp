package com.MediApp.MediApp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.MediApp.MediApp.model.dao.AdministradorDao;
import com.MediApp.MediApp.model.entity.Administrador;
import com.MediApp.MediApp.service.InterfaceAdministrador;

@Service
public class AdministradorImpl implements InterfaceAdministrador{
    @Autowired
    private AdministradorDao administradorDao;

    @Override
    @Transactional
    public Administrador save(Administrador administrador){
        return administradorDao.save(administrador);
    }
    @Override
    @Transactional
    public Administrador findById(Long id_administrador){
        return administradorDao.findById(id_administrador).orElse(null);
    }

    @Override
    @Transactional
    public void delete(Administrador administrador){
        administradorDao.delete(administrador);
    }

}
