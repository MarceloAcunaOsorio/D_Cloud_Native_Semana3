package com.example.Hospital.Model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "paciente")
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="IdPaciente")
    private Long idPaciente;

    private String nombre;
    private int edad;
    private String habitacion;
    private double frecuenciaCardiaca;
    private double oxigeno;
    private double presionSistolica;
    private double presionDiastolica;

    private LocalDateTime ultimaActualizacion;




    public Paciente( String nombre, int edad, String habitacion, double frecuenciaCardiaca,
            double oxigeno, double presionSistolica, double presionDiastolica) {
      
        this.nombre = nombre;
        this.edad = edad;
        this.habitacion = habitacion;
        this.frecuenciaCardiaca = frecuenciaCardiaca;
        this.oxigeno = oxigeno;
        this.presionSistolica = presionSistolica;
        this.presionDiastolica = presionDiastolica;
    }

    //getter and setter
    public Long getidpaciente() {
        return idPaciente;
    }

    public void setidpaciente(Long idpaciente) {
        this.idPaciente = idpaciente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(String habitacion) {
        this.habitacion = habitacion;
    }

    public double getFrecuenciaCardiaca() {
        return frecuenciaCardiaca;
    }

    public void setFrecuenciaCardiaca(double frecuenciaCardiaca) {
        this.frecuenciaCardiaca = frecuenciaCardiaca;
    }

    public double getOxigeno() {
        return oxigeno;
    }

    public void setOxigeno(double oxigeno) {
        this.oxigeno = oxigeno;
    }

    public double getPresionSistolica() {
        return presionSistolica;
    }

    public void setPresionSistolica(double presionSistolica) {
        this.presionSistolica = presionSistolica;
    }

    public double getPresionDiastolica() {
        return presionDiastolica;
    }

    public void setPresionDiastolica(double presionDiastolica) {
        this.presionDiastolica = presionDiastolica;
    }

    public LocalDateTime getUltimaActualizacion() {
        return ultimaActualizacion;
    }

    public void setUltimaActualizacion(LocalDateTime ultimaActualizacion) {
        this.ultimaActualizacion = ultimaActualizacion;
    }
}
