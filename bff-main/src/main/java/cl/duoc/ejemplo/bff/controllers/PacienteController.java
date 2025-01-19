package cl.duoc.ejemplo.bff.controllers;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cl.duoc.ejemplo.bff.Model.Paciente;
import cl.duoc.ejemplo.bff.services.PacienteService;



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

    // Crear paciente de ejemplo
    @PostMapping("/crear-ejemplo")
    public ResponseEntity<Paciente> crearPacienteEjemplo() {
        Paciente paciente = new Paciente();
        paciente.setNombre("Juan");
        paciente.setApellido("Pérez");
        paciente.setEdad(45);
        paciente.setHabitacion("301A");
        paciente.setFrecuenciaCardiaca(85.0);
        paciente.setOxigeno(96.5);
        paciente.setPresionSistolica(120.0);
        paciente.setPresionDiastolica(80.0);
        paciente.setTemperatura(37.2);
        paciente.setCondicion("Hipertensión controlada");
        paciente.setUltimoControl(LocalDateTime.parse("2023-10-15T00:00:00", DateTimeFormatter.ISO_LOCAL_DATE_TIME));
        paciente.setObservaciones("Paciente estable, continuar tratamiento");
        paciente.setHistorialMedico(List.of("Hipertensión desde 2018", "Colesterol alto"));
        paciente.setMedicamentos(List.of("Losartán 50mg", "Atorvastatina 20mg"));
        
        try {
            Paciente created = pacienteService.createPaciente(paciente);
            return new ResponseEntity<>(created, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
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

    // Obtener reporte completo de salud mejorado
    @GetMapping("/reporte-salud/{idPaciente}")
    public ResponseEntity<Map<String, Object>> getReporteSalud(@PathVariable Long idPaciente) {
        try {
            Map<String, Object> reporte = pacienteService.generarReporteSaludCompleto(idPaciente);
            return new ResponseEntity<>(reporte, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Obtener estadísticas de salud
    @GetMapping("/estadisticas-salud/{idPaciente}")
    public ResponseEntity<Map<String, Object>> getEstadisticasSalud(@PathVariable Long idPaciente) {
        try {
            Map<String, Object> estadisticas = pacienteService.obtenerEstadisticasSalud(idPaciente);
            return new ResponseEntity<>(estadisticas, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Obtener alertas de salud mejoradas
    @GetMapping("/alertas/{idPaciente}")
    public ResponseEntity<Map<String, Object>> getAlertasSalud(@PathVariable Long idPaciente) {
        try {
            Map<String, Object> alertas = pacienteService.obtenerAlertasSaludDetalladas(idPaciente);
            return new ResponseEntity<>(alertas, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Seguimiento de condiciones crónicas
    @GetMapping("/seguimiento-cronico/{idPaciente}")
    public ResponseEntity<Map<String, Object>> getSeguimientoCronico(@PathVariable Long idPaciente) {
        try {
            Map<String, Object> seguimiento = pacienteService.obtenerSeguimientoCondicionCronica(idPaciente);
            return new ResponseEntity<>(seguimiento, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Obtener historial médico completo
    @GetMapping("/historial-medico/{idPaciente}")
    public ResponseEntity<List<String>> getHistorialMedico(@PathVariable Long idPaciente) {
        try {
            List<String> historial = pacienteService.obtenerHistorialMedico(idPaciente);
            return new ResponseEntity<>(historial, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Exportar reporte en diferentes formatos
    @GetMapping("/exportar-reporte/{idPaciente}")
    public ResponseEntity<byte[]> exportarReporte(
            @PathVariable Long idPaciente,
            @RequestParam(defaultValue = "pdf") String formato) {
        try {
            byte[] reporte = pacienteService.exportarReporte(idPaciente, formato);
            HttpHeaders headers = new HttpHeaders();
            
            if (formato.equalsIgnoreCase("pdf")) {
                headers.setContentType(MediaType.APPLICATION_PDF);
                headers.setContentDispositionFormData("filename", "reporte-salud.pdf");
            } else if (formato.equalsIgnoreCase("csv")) {
                headers.setContentType(MediaType.TEXT_PLAIN);
                headers.setContentDispositionFormData("filename", "reporte-salud.csv");
            }
            
            return new ResponseEntity<>(reporte, headers, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
