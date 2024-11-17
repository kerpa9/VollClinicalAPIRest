package med.voll.api.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.physician.Specialty;

public record RegisterPhysicianDTO(
    
                @NotBlank
                String name,
                @NotBlank
                String phone,
                @NotBlank
                @Email
                String email,
                @NotBlank
                @Pattern(regexp="\\d{4,6}")
                String document,
                @NotNull
                Specialty specialty,
                @NotNull
                @Valid
                DataAddressDTO address ) {




}
