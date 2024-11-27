package med.voll.api.domain.consultations.validations;

import jakarta.validation.ValidationException;
import med.voll.api.config.dto.ConsultationsDataDTO;
import med.voll.api.repository.PhysicianRepository;

public class PhysicianActive {

    private PhysicianRepository physicianRepository;

    public void validatePhysician(ConsultationsDataDTO consultationsDataDTO) {

        if (consultationsDataDTO.idPhysician() == null) {
            return;
        }

        var physicianActive = physicianRepository.findActiveById(consultationsDataDTO.idPhysician());
        
        if (!physicianActive) {
            throw new ValidationException("Physician Inactive");
        }

    }
}
