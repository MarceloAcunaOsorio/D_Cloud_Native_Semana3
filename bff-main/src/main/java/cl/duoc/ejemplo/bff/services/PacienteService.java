package cl.duoc.ejemplo.bff.services;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import cl.duoc.ejemplo.bff.Model.Paciente;

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
    
    // Generar reporte de salud completo
    Map<String, Object> generarReporteSaludCompleto(Long idPaciente);
    
    // Obtener estadísticas de salud
    Map<String, Object> obtenerEstadisticasSalud(Long idPaciente);
    
    // Obtener alertas de salud mejoradas
    Map<String, Object> obtenerAlertasSaludDetalladas(Long idPaciente);
    
    // Seguimiento de condiciones crónicas
    Map<String, Object> obtenerSeguimientoCondicionCronica(Long idPaciente);
    
    // Obtener historial médico completo
    List<String> obtenerHistorialMedico(Long idPaciente);
    
    // Exportar reporte en diferentes formatos
    byte[] exportarReporte(Long idPaciente, String formato);
}
