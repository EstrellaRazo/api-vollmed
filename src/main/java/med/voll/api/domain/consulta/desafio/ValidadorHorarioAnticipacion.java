package med.voll.api.domain.consulta.desafio;

import jakarta.validation.ValidationException;
import med.voll.api.domain.consulta.ConsultaRepository;
import med.voll.api.domain.consulta.DatosCancelamientoConsulta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

@Component
public class ValidadorHorarioAnticipacion implements ValidadorCancelamientoDeConsulta{

    @Autowired
    private ConsultaRepository repository;
    @Override
    public void validar(DatosCancelamientoConsulta datosCancelamientoConsulta) {
        var consulta = repository.getReferenceById(datosCancelamientoConsulta.idConsulta());
        var ahora = LocalDateTime.now();
        var horaConsulta = consulta.getFecha();

        var diferenciaHoras = Duration.between(ahora, horaConsulta).toHours();

        if(diferenciaHoras < 24){
            throw new ValidationException("la consulta sólo se puede cancelar con al menos 24 horas de anticipación");
        }
    }
}
