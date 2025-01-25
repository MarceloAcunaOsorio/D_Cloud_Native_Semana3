package cl.duoc.ejemplo.bff.Model;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Paciente")
public class Paciente {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="IdPaciente")
    private Long idPaciente;
    
    @Column(name ="Nombre")
    private String nombre;

    @Column(name ="Apellido")
    private String apellido;

    @Column(name ="edad")
    private int edad;

    @Column(name ="Habitacion")
    private String habitacion;

    @Column(name ="FrecuenciaCardiaca")
    private double frecuenciaCardiaca;

    @Column(name ="Oxigeno")
    private double oxigeno;

    @Column(name ="Presionsistolica")
    private double presionSistolica;

    @Column(name ="PresionDiastolica")
    private double presionDiastolica;

    @Column(name ="PresionArterial")
    private double presionArterial;

    @Column(name ="Temperatura")
    private double temperatura;

    @Column(name ="Condicion")
    private String condicion;

    @Column(name ="UltimoControl")
    private LocalDateTime ultimoControl;

    @Column(name ="Observaciones")
    private String observaciones;

    @Column(name ="HistorialMedico")
    private List<String> historialMedico;

    @Column(name ="UltimaActualizacion")
    private LocalDateTime ultimaActualizacion;

    @Column(name ="HistorialPresion")
    private List<Double> historialPresion;

    @Column(name ="HistorialFrecuencia")
    private List<Double> historialFrecuencia;
   
    @Column(name ="EvolucionCondicion")
    private List<String> evolucionCondicion;

    @Column(name ="Medicamentos")
    private List<String> medicamentos;

    @Column(name ="UltimosControles")
    private List<LocalDateTime> ultimosControles;

    public Paciente() {}

    public Paciente(String nombre, String apellido, int edad, String habitacion, double frecuenciaCardiaca,
            double oxigeno, double presionSistolica, double presionDiastolica, double presionArterial, 
            double temperatura, String condicion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.habitacion = habitacion;
        this.frecuenciaCardiaca = frecuenciaCardiaca;
        this.oxigeno = oxigeno;
        this.presionSistolica = presionSistolica;
        this.presionDiastolica = presionDiastolica;
        this.presionArterial = presionArterial;
        this.temperatura = temperatura;
        this.condicion = condicion;
    }

    // Getters y Setters
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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
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

    public double getPresionArterial() {
        return presionArterial;
    }

    public void setPresionArterial(double presionArterial) {
        this.presionArterial = presionArterial;
    }

    public double getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(double temperatura) {
        this.temperatura = temperatura;
    }

    public String getCondicion() {
        return condicion;
    }

    public void setCondicion(String condicion) {
        this.condicion = condicion;
    }

    public LocalDateTime getUltimoControl() {
        return ultimoControl;
    }

    public void setUltimoControl(LocalDateTime ultimoControl) {
        this.ultimoControl = ultimoControl;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public List<String> getHistorialMedico() {
        return historialMedico;
    }

    public void setHistorialMedico(List<String> historialMedico) {
        this.historialMedico = historialMedico;
    }

    public LocalDateTime getUltimaActualizacion() {
        return ultimaActualizacion;
    }

    public void setUltimaActualizacion(LocalDateTime ultimaActualizacion) {
        this.ultimaActualizacion = ultimaActualizacion;
    }

    public List<Double> getHistorialPresion() {
        return historialPresion;
    }

    public void setHistorialPresion(List<Double> historialPresion) {
        this.historialPresion = historialPresion;
    }

    public List<Double> getHistorialFrecuencia() {
        return historialFrecuencia;
    }

    public void setHistorialFrecuencia(List<Double> historialFrecuencia) {
        this.historialFrecuencia = historialFrecuencia;
    }

    public List<String> getEvolucionCondicion() {
        return evolucionCondicion;
    }

    public void setEvolucionCondicion(List<String> evolucionCondicion) {
        this.evolucionCondicion = evolucionCondicion;
    }

    public List<String> getMedicamentos() {
        return medicamentos;
    }

    public void setMedicamentos(List<String> medicamentos) {
        this.medicamentos = medicamentos;
    }

    public List<LocalDateTime> getUltimosControles() {
        return ultimosControles;
    }

    public void setUltimosControles(List<LocalDateTime> ultimosControles) {
        this.ultimosControles = ultimosControles;
    }
}
