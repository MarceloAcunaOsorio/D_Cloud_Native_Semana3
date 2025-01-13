package com.example.Hospital.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Hospital.Model.Paciente;

public interface PacienteRepository extends JpaRepository<Paciente, Long>{
    
}
