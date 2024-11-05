package com.MediApp.MediApp.service;

import com.MediApp.MediApp.model.entity.Hora;

public interface InterfaceHora {
    Hora saveHora(Hora hora);
    Hora findByIdHora(Long id_hora);
    Hora updateHora(Hora hora);


}
