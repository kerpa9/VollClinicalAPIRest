package med.voll.api.physician;

import med.voll.api.dataAddress.DataAddress;

public record RegisterPhysicianDTO(
                String name,
                String email,
                String document,
                Specialty specialty,
                DataAddress address ) {
                    

}
