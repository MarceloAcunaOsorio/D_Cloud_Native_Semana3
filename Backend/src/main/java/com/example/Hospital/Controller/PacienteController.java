package com.example.Hospital.Controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;

import com.example.Hospital.Model.Paciente;
import com.example.Hospital.Service.PacienteService;

@RestController
@CrossOrigin
@RequestMapping("/paciente")
public class PacienteController {

    private final PacienteService pacienteService;

    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }


    //crear paciente
    @PostMapping("/crear")
    public ResponseEntity<Paciente> createPaciente(@RequestBody Paciente paciente) {
        try {
       
            Paciente createPaciente = pacienteService.createPaciente(paciente);
            return new ResponseEntity<>(createPaciente, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        
    }


    //actualizar paciente
    @PutMapping("/{idPaciente}")
    public ResponseEntity<Paciente> updatePaciente(@PathVariable Long idPaciente, @RequestBody Paciente paciente) {
     
        try {
            
            Paciente updatePaciente = pacienteService.updatePaciente(idPaciente, paciente);
            return new ResponseEntity<>(updatePaciente, HttpStatus.OK);

        } catch (Exception e) {
            
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }



    //eliminar paciente
    @DeleteMapping("/{idPaciente}")
    public ResponseEntity<Void> deletePaciente(@PathVariable Long idPaciente)throws IOException {
        try {

           Optional<Paciente> paciente = pacienteService.getPacienteById(idPaciente);
            
           if (paciente.isPresent()) {

                pacienteService.deletePaciente(paciente.get());
                return new ResponseEntity<>(HttpStatus.OK);
            
            } else {
            
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


    //Listar todos los pacientes
    @GetMapping("/listado")
    public List<Paciente> getAllPacientes() {
        return pacienteService.getAllPacientes();
    }


    //Buscar paciente por id
    @GetMapping ("/{idPaciente}")
    public Optional<Paciente> getPacienteById(@PathVariable Long idPaciente) {
        return pacienteService.getPacienteById(idPaciente);
    }
    
}
