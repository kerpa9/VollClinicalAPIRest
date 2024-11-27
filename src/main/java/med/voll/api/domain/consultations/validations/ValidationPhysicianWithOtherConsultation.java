package med.voll.api.domain.consultations.validations;

import med.voll.api.config.dto.ConsultationsDataDTO;
import med.voll.api.config.handleException.ValidateException;
import med.voll.api.repository.ConsultationRepository;

public class ValidationPhysicianWithOtherConsultation {
    
    private ConsultationRepository consultationRepository;

    public void validationOtherConsultation(ConsultationsDataDTO consultationsDataDTO){
        var physicianWithOtherConsultation=consultationRepository.existByPhysicianIdAndDate(consultationsDataDTO.idPhysician(),consultationsDataDTO.date());

        if(physicianWithOtherConsultation){
            throw new ValidateException("The physician has another consultation");

        }
        
    }
}
