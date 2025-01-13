package com.example.Hospital.dto;


public class PacienteDTO {
    

    private Long idPaciente;
    private String nombre;
    private int edad;
    private String habitacion;
    private double frecuenciaCardiaca;
    private double oxigeno;
    private double presionSistolica;
    private double presionDiastolica;


     //constructor
     public PacienteDTO(String nombre, int edad, String habitacion, double frecuenciaCardiaca,double oxigeno, double presionSistolica, double presionDiastolica) {
        this.nombre = nombre;
        this.edad = edad;
        this.habitacion = habitacion;
        this.frecuenciaCardiaca = frecuenciaCardiaca;
        this.oxigeno = oxigeno;
        this.presionSistolica = presionSistolica;
        this.presionDiastolica = presionDiastolica;
    }


    //getter and setter 

    public Long getIdPaciente() {
        return idPaciente;
    }


    public void setIdPaciente(Long idPaciente) {
        this.idPaciente = idPaciente;
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


   

}
