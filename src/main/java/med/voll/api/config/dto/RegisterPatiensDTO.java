package med.voll.api.config.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RegisterPatiensDTO(
        @NotBlank String name,

        @NotBlank String phone,

        @NotBlank @Email String email,

        @NotBlank String document,

        @NotNull @Valid DataAddressDTO address

) {

}
