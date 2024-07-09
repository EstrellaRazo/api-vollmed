package med.voll.api.domain.consulta;

import jakarta.validation.constraints.NotNull;

public record DatosCancelamientoConsulta(
        @NotNull(message = "Ingrese el id de la consulta")
        Long idConsulta,
        MotivoCancelacion motivo
) {
        // Constructor para crear una nueva instancia con el valor actualizado de idConsulta
        public DatosCancelamientoConsulta consultaConId(Long idConsulta) {
                return new DatosCancelamientoConsulta(idConsulta, this.motivo);
        }

        // Método estático para actualizar idConsulta en una instancia existente
        public static DatosCancelamientoConsulta setIdConsulta(DatosCancelamientoConsulta instanciaExistente, Long nuevoIdConsulta) {
                return new DatosCancelamientoConsulta(nuevoIdConsulta, instanciaExistente.motivo());
        }
}
