package med.voll.api.domain.consultations.validations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.validation.ValidationException;
import med.voll.api.config.dto.ConsultationsDataDTO;
import med.voll.api.repository.PatientsRepository;


@Component
public class ValidationPatientsInactive implements IValidateConsultation {

    @Autowired
    private PatientsRepository patientsRepository;

    public void validate(ConsultationsDataDTO consultationsDataDTO) {
        var patientInactive = patientsRepository.findActivoById(consultationsDataDTO.idPatients());

        if (!patientInactive) {
            throw new ValidationException("Patient Inactive");
        }
    }

}
