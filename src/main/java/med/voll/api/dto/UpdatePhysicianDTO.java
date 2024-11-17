package med.voll.api.dto;

import jakarta.validation.constraints.NotNull;

public record UpdatePhysicianDTO(@NotNull Long id, String name, String document, DataAddressDTO address) {

    
}
