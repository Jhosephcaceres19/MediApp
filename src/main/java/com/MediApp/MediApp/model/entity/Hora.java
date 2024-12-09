package com.MediApp.MediApp.model.entity;

import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
@Table(name = "hora")
public class Hora {
    @Id
    @Column(name = "id_hora")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_hora;
    
    @ManyToOne
    @JoinColumn(name = "id_medico")
    private Medico medico;

    
    @Column(name = "diaSemana")
    @Enumerated(EnumType.STRING)
    private DiaSemana diaSemana;

    @Column(name = "horaInicio")
    private LocalTime horaInicio;
    @Column(name = "horaFIn")
    private LocalTime horaFin;


    public enum DiaSemana{
        Lunes,
        Martes,
        Miercoles,
        Jueves,
        Viernes,
        Sabado
    }

}
