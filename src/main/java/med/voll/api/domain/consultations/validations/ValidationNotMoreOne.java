package med.voll.api.domain.consultations.validations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.validation.ValidationException;
import med.voll.api.config.dto.ConsultationsDataDTO;
import med.voll.api.repository.ConsultationRepository;

@Component
public class ValidationNotMoreOne implements  IValidateConsultation{

    @Autowired
    private ConsultationRepository consultationRepository;

    public void validate(ConsultationsDataDTO consultationsDataDTO) {

        var firstSchedule = consultationsDataDTO.date().withHour(7);
        var lastSchedule = consultationsDataDTO.date().withHour(18);
        var patientsOtherConsult = consultationRepository
                .existsByPatientsModelIdAndDateBetween(consultationsDataDTO.idPatients(), firstSchedule, lastSchedule);

                if(patientsOtherConsult){
                    throw new ValidationException("Patients have already consulted elsewhere.");
                }


    }

}
