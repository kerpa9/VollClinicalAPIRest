package med.voll.api.config.dto;

import java.time.LocalDateTime;

import med.voll.api.domain.consultations.ConsultationModel;

public record DetailsConsultations(
        Long id,
        Long idPhysician,
        Long idPatients,
        LocalDateTime date

) {

    public DetailsConsultations(ConsultationModel consult) {

        this(consult.getId(), consult.getPhysicianModel().getId(), consult.getPatientsModel().getId(),
                consult.getDate());
    }

}
