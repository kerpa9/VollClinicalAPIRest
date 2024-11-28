package med.voll.api.domain.consultations.validations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import med.voll.api.config.dto.ConsultationsDataDTO;
import med.voll.api.config.handleException.ValidateException;
import med.voll.api.repository.ConsultationRepository;

@Component
public class ValidationPhysicianWithOtherConsultation implements IValidateConsultation {

    @Autowired
    private ConsultationRepository consultationRepository;

    @Override
    public void validate(ConsultationsDataDTO consultationsDataDTO) {
        var physicianWithOtherConsultation = consultationRepository
                .existsByPhysicianModelIdAndDate(consultationsDataDTO.idPhysician(), consultationsDataDTO.date());

        if (physicianWithOtherConsultation) {
            throw new ValidateException("The physician has another consultation");

        }

    }
}
