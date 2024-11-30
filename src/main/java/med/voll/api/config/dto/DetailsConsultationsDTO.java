package med.voll.api.config.dto;

import java.time.LocalDateTime;

import med.voll.api.domain.consultations.ConsultationModel;

public record DetailsConsultationsDTO(
        Long id,
        Long idPhysician,
        Long idPatients,
        LocalDateTime date

) {

    public DetailsConsultationsDTO(ConsultationModel consult) {

        this(consult.getId(), consult.getPhysicianModel().getId(), consult.getPatientsModel().getId(),
                consult.getDate());
    }

}
