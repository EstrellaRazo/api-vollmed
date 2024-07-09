package med.voll.api.domain.paciente;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.domain.direccion.DatosDireccion;

public record DatosRegistroPaciente(
        @NotBlank(message = "Ingrese un nombre") //No nulo ni en blanco
        String nombre,
        @NotBlank(message = "El email es obligatorio")
        String email,
        @NotBlank(message = "El teléfono es obligatorio")
        String telefono,
        @NotBlank(message = "Ingrese un documento de identidad")
        @Pattern(regexp = "\\d{3}\\.?\\d{3}\\.?\\d{3}\\-?\\d{2}")
        String documentoIdentidad,
        @NotNull(message = "Ingrese una dirección")  //Null porque es un objeto
        @Valid
        DatosDireccion direccion
) {
}
