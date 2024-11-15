package med.voll.api.dtos;

import med.voll.api.physician.Specialty;

public record RegisterPhysicianDTO(
                String name,
                String email,
                String document,
                Specialty specialty,
                DataAddressDTO address ) {


}
