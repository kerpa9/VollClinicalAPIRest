package med.voll.api.config.dto;

import java.time.LocalDateTime;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import med.voll.api.domain.physician.Specialty;

public record ConsultationsDataDTO(

                // Long id,

                Long idPhysician,

                @NotNull Long idPatients,

                @NotNull @Future LocalDateTime date,

                Specialty specialty

) {

    // public void ConsultationsDataDTO(long idPhysician, long idPatients, LocalDateTime date, Specialty specialty) {
    //     throw new UnsupportedOperationException("Not supported yet.");

    // }

}
