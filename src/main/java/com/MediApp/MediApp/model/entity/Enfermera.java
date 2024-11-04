package com.MediApp.MediApp.model.entity;

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
@ToString
@Entity
@Table(name="enfermera")
public class Enfermera {
    @Id
    @Column(name = "id_enfermera")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_enfermera;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "turno")
    @Enumerated(EnumType.STRING)
    private Turno turno;

    @ManyToOne
    @JoinColumn(name="id_medico")
    private Medico medico;



    public enum Turno{
        Manana,
        Tarde
    }

    public Long id_enfermera(){
        return id_enfermera;
    }
    public void setId_enfermera(Long id_enfermera){
        this.id_enfermera= id_enfermera;
    }
    
    public String getNombre(){
        return nombre;
    }
    public void setNombre(String nombre){
        this.nombre=nombre;
    }

    public Turno getTurno(){
        return turno;
    }
    public void setTurno(Turno turno){
        this.turno=turno;
    }

    public Medico getMedico(){
        return medico;
    }
    public void setMedico(Medico medico){
        this.medico= medico;
    }

}
