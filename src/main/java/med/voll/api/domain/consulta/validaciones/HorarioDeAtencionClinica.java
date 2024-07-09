package med.voll.api.domain.consulta.validaciones;

import jakarta.validation.ValidationException;
import med.voll.api.domain.consulta.DatosAgendarConsulta;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;

@Component
public class HorarioDeAtencionClinica implements ValidadorDeConsultas {
    public void validar(DatosAgendarConsulta datosConsulta) {

        var domingo = DayOfWeek.SUNDAY.equals(datosConsulta);
        var antesHoraApertura = datosConsulta.fecha().getHour() < 7;
        var despuesHoraCierre = datosConsulta.fecha().getHour() > 19;

        if(domingo || antesHoraApertura || despuesHoraCierre){
            throw new ValidationException("La clinica atiende de Lunes a Sábado, en un horario de  7:00 a 19:00 horas, por favor, seleccione una hora y fecha correctos");
        }
    }
}
