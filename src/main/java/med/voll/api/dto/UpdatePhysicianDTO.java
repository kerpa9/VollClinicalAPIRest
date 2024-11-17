package med.voll.api.dto;

import jakarta.validation.constraints.NotNull;
import med.voll.api.dataAddress.Address;

public record UpdatePhysicianDTO(@NotNull Long id, String name, String document, Address address) {

}
