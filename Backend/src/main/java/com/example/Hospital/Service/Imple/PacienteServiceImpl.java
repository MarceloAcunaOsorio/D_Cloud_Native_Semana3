package com.example.Hospital.Service.Imple;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.example.Hospital.exceptions.NotFoundException;
import com.example.Hospital.Model.Paciente;
import com.example.Hospital.Repository.PacienteRepository;
import com.example.Hospital.Service.PacienteService;

@Service
public class PacienteServiceImpl implements PacienteService{

    private final PacienteRepository pacienteRepository;
    
    public PacienteServiceImpl(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }


    // Implementar los métodos de la interfaz PacienteService

    // Método para obtener todos los pacientes
    @Override
    public List<Paciente> getAllPacientes() {
        return pacienteRepository.findAll();
    }


    // Método para obtener un paciente por su id
    @Override
    public Optional<Paciente> getPacienteById(Long idPaciente) {
        return pacienteRepository.findById(idPaciente);
    }


    // Método para crear un paciente
    @Override
    public Paciente createPaciente(Paciente paciente)throws IOException {     
        return pacienteRepository.save(paciente);
    }


    // Método para actualizar un paciente
    @Override
    public Paciente updatePaciente(Long idPaciente,Paciente paciente){

        if(!pacienteRepository.existsById(idPaciente)){
            throw new NotFoundException("producto no encontrado en ID:"+ paciente.getidpaciente());
        }
        paciente.setidpaciente(idPaciente);
        return pacienteRepository.save(paciente);
    }

    // metodo para elimar un paciente
    @Override
    public void deletePaciente(Paciente paciente) throws IOException {
        
        if(!pacienteRepository.existsById(paciente.getidpaciente())){
            throw new NotFoundException("producto no encontrado en ID:"+paciente.getidpaciente());
        }
        pacienteRepository.deleteById(paciente.getidpaciente());
    }
}
