package med.voll.api.domain.consulta.validaciones;

import jakarta.validation.ValidationException;
import med.voll.api.domain.consulta.DatosAgendarConsulta;
import med.voll.api.domain.medico.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MedicoActivo implements ValidadorDeConsultas {

    @Autowired
    MedicoRepository medicoRepository;
    public void validar(DatosAgendarConsulta datosConsulta) {
        if(datosConsulta.idMedico() == null){
            return;
        }

        var medicoActivo = medicoRepository.findActivoById(datosConsulta.idMedico());

        if(!medicoActivo){
            throw new ValidationException("No se puede agendar cita con un medico inactivo en el sistema");
        }
    }
}
