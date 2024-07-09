package med.voll.api.domain.consulta.validaciones;

import jakarta.validation.ValidationException;
import med.voll.api.domain.consulta.DatosAgendarConsulta;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

@Component
public class HorarioAnticipacionConsulta implements ValidadorDeConsultas {
    public void validar(DatosAgendarConsulta datosConsulta) {
        var ahora = LocalDateTime.now();
        var horaConsulta = datosConsulta.fecha();
        var diferenciaHorarios = Duration.between(ahora, horaConsulta).toMinutes();

        if(diferenciaHorarios < 30) {
            throw new ValidationException("No se puede agendar la consulta con menos de 30 minutos de anticipación");
        }

    }
}
