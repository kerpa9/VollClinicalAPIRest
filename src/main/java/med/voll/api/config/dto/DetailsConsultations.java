package med.voll.api.config.dto;

import java.time.LocalDateTime;

public record DetailsConsultations(
    Long id,
    Long idPhysician,
    Long idPatients,
    LocalDateTime date

) {

}
