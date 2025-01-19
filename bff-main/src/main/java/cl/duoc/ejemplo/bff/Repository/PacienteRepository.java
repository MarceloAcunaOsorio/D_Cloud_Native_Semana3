package cl.duoc.ejemplo.bff.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.duoc.ejemplo.bff.Model.Paciente;

public interface PacienteRepository extends JpaRepository<Paciente, Long>{
    
}
