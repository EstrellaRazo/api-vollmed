package med.voll.api.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.domain.consulta.AgendaDeConsultaService;
import med.voll.api.domain.consulta.DatosAgendarConsulta;
import med.voll.api.domain.consulta.DatosCancelamientoConsulta;
import med.voll.api.domain.consulta.MotivoCancelacion;
import med.voll.api.infra.errores.ValidacionDeIntegridad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
@RequestMapping("/consultas")
@SecurityRequirement(name = "bearer-key")
public class ConsultaController {

    @Autowired
    private AgendaDeConsultaService agendaDeConsultaService;

    @PostMapping
    @Transactional
    public ResponseEntity agendar(@RequestBody @Valid DatosAgendarConsulta datosConsulta) throws ValidacionDeIntegridad {
        var response = agendaDeConsultaService.agendar(datosConsulta);

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{idConsulta}")
    @Transactional
    public ResponseEntity cancelar(@PathVariable @Valid Long idConsulta, @RequestParam(name = "motivo", required = true) @Valid MotivoCancelacion motivoCancelacion) {

        var consulta = new DatosCancelamientoConsulta(idConsulta, motivoCancelacion);
        agendaDeConsultaService.cancelarConsulta(consulta);
        return ResponseEntity.noContent().build();
    }
}
