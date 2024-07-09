package med.voll.api.domain.consulta.validaciones;

import jakarta.validation.ValidationException;
import med.voll.api.domain.consulta.ConsultaRepository;
import med.voll.api.domain.consulta.DatosAgendarConsulta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MedicoConConsulta implements ValidadorDeConsultas {

    @Autowired
    private ConsultaRepository consultaRepository;
    public void validar(DatosAgendarConsulta datosConsulta) {
        if(datosConsulta.idMedico() == null){
            return;
        }

        var medicoConsulta = consultaRepository.existsByMedicoIdAndFecha(datosConsulta.idMedico(), datosConsulta.fecha());

        if(medicoConsulta){
            throw new ValidationException("El médico elegido ya tiene una consulta agendada para ese día y hora");
        }
    }
}
