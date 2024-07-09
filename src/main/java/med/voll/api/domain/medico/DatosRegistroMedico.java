package med.voll.api.domain.medico;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.domain.direccion.DatosDireccion;

public record DatosRegistroMedico(
        @NotBlank(message = "Ingrese un nombre") //No nulo ni en blanco
        String nombre,
        @NotBlank(message = "El email es obligatorio")
        String email,
        @NotBlank(message = "El teléfono es obligatorio")
        String telefono,
        @NotBlank(message = "Ingrese un docuemnto (debe tener entre 4 y 6 cifras)")
                @Pattern(regexp = "\\d{4,6}")
        String documento,
        @NotNull(message = "Especialidad obligatoria")
        Especialidad especialidad,
        @NotNull(message = "Ingrese una dirección")  //Null porque es un objeto
        @Valid
        DatosDireccion direccion
) {
}
