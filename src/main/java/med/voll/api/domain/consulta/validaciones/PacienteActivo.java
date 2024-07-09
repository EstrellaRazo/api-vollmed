package med.voll.api.domain.consulta.validaciones;

import jakarta.validation.ValidationException;
import med.voll.api.domain.consulta.DatosAgendarConsulta;
import med.voll.api.domain.paciente.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PacienteActivo implements ValidadorDeConsultas {
    @Autowired
    PacienteRepository pacienteRepository;
    public void validar(DatosAgendarConsulta datosConsulta) {
        if(datosConsulta.idPaciente() == null){
            return;
        }

        var pacienteActivo = pacienteRepository.findActivoById(datosConsulta.idPaciente());

        if(!pacienteActivo){
            throw new ValidationException("No se puede agendar cita a un paciente inactivo en el sistema");
        }
    }
}
