package com.example.Hospital.Service;  

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import com.example.Hospital.Model.Paciente;


public interface PacienteService {
    
    //listar todos los pacientes
    List<Paciente> getAllPacientes();
    
    //buscar paciente por id
    Optional<Paciente> getPacienteById(Long idPaciente);
    
    //crear paciente
    Paciente createPaciente(Paciente idPaciente) throws IOException;

    //actualizar paciente
    Paciente updatePaciente(Long idPaciente,Paciente paciente);
    
    //eliminar paciente
    void deletePaciente(Paciente paciente) throws IOException;
}