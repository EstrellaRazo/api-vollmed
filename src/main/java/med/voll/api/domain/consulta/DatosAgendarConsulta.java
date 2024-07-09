package med.voll.api.domain.consulta;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import med.voll.api.domain.medico.Especialidad;

import java.time.LocalDateTime;

public record DatosAgendarConsulta(
        @NotNull(message = "Ingrese el id del paciente")
        Long idPaciente,
        Long idMedico,
        @NotNull
        @Future //para que la fecha no pueda ser una fecha que ya pasó
        LocalDateTime fecha,
        Especialidad especialidad
) {
}
