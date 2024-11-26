package med.voll.api.config.dto;

import java.time.LocalDateTime;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

public record ConsultationsDataDTO(

        Long idPhysician,
        @NotNull Long idPatients,
        @NotNull @Future LocalDateTime date
        
        ) {

}
