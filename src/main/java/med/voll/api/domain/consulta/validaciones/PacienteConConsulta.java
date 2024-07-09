package med.voll.api.domain.consulta.validaciones;

import jakarta.validation.ValidationException;
import med.voll.api.domain.consulta.ConsultaRepository;
import med.voll.api.domain.consulta.DatosAgendarConsulta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PacienteConConsulta implements ValidadorDeConsultas {

    @Autowired
    private ConsultaRepository consultaRepository;
    public void validar(DatosAgendarConsulta datosConsulta) {
        var primerHorario = datosConsulta.fecha().withHour(7);  //Definimos la primera hora a la que se puede agendar una consulta
        var ultimoHorario = datosConsulta.fecha().withHour(18); //Definimos la última hora a la que se peude agendar una consulta
                                                                //tomando en cuenta que la clinica cierra a las 19 horas

        var pacienteConConsulta = consultaRepository.existsByPacienteIdAndFechaBetween(datosConsulta.idPaciente(), primerHorario, ultimoHorario);

        if(pacienteConConsulta) {
            throw  new ValidationException("Este paciente ya cuenta con una consulta en el día seleccionado");
        }

    }
}
