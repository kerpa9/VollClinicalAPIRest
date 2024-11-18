package med.voll.api.config.dto;

import jakarta.validation.constraints.NotBlank;

public record DataAddressDTO(
                @NotBlank 
                String street,
                
                @NotBlank
                String district,
                
                @NotBlank
                String city,
                
                @NotBlank
                String number,
                
                @NotBlank
                String complement) {

}
