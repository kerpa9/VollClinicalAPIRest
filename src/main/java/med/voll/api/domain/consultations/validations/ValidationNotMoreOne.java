package med.voll.api.domain.consultations.validations;

import jakarta.validation.ValidationException;
import med.voll.api.config.dto.ConsultationsDataDTO;
import med.voll.api.repository.ConsultationRepository;

public class ValidationNotMoreOne {

    private ConsultationRepository consultationRepository;

    public void validationsConsult(ConsultationsDataDTO consultationsDataDTO) {

        var firstSchedule = consultationsDataDTO.date().withHour(7);
        var lastSchedule = consultationsDataDTO.date().withHour(18);
        var patientsOtherConsult = consultationRepository
                .existsByPatientsIdAndDateBetween(consultationsDataDTO.idPatients(), firstSchedule, lastSchedule);

                if(patientsOtherConsult){
                    throw new ValidationException("Patients have already consulted elsewhere.");
                }


    }

}
