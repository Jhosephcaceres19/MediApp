package com.MediApp.MediApp.model.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
@Table(name="medico")
public class Medico {
    @Id
    @Column(name="id_medico")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_medico;

    @Column(name="nombre")
    private String nombre;

    @Column(name="apellido")
    private String apellido;

    @Enumerated(EnumType.STRING)
    @Column(name="especialidad")
    private Especialidad especialidad;

    @Column(name="numero_licencia")
    private String numero_licencia;

    @Column(name="telefono")
    private String telefono;


    @OneToMany(mappedBy = "medico", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Enfermera> enfermeras;

    @OneToMany(mappedBy = "medico", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Hora> horas;

    @OneToMany(mappedBy = "medico", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Cita> citas;


    public enum Especialidad{
        Cirujano,
        Pediatra,
        Otros
    }

    public Long getId_medico(){
        return id_medico;
    }
    public void setId_medico(Long id_medico){
        this.id_medico= id_medico;
    }

    public String getNombre(){
        return nombre;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public String getApellido(){
        return apellido;
    }
    public void setApellido(String apellido){
        this.apellido=apellido;
    }

    public Especialidad especialidad(){
        return especialidad;
    }

    public void setEspecialidad(Especialidad especialidad){
        this.especialidad= especialidad;
    }

    public String getNumero_licencia(){
        return numero_licencia;
    }
    public void setNumero_licencia(String numero_licencia){
        this.numero_licencia = numero_licencia;
    }

    public String getTelefono(){
        return telefono;
    }
    public void setTelefono(String telefono){
        this.telefono = telefono;
    }
}
