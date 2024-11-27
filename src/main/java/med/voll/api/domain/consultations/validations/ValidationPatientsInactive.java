package med.voll.api.domain.consultations.validations;

import jakarta.validation.ValidationException;
import med.voll.api.config.dto.ConsultationsDataDTO;
import med.voll.api.repository.PatientsRepository;

public class ValidationPatientsInactive {

    // @Autowired
    private PatientsRepository patientsRepository;

    public void validationInactive(ConsultationsDataDTO consultationsDataDTO) {
        var patientInactive = patientsRepository.findActivoById(consultationsDataDTO.idPatients());

        if (!patientInactive) {
            throw new ValidationException("Patient Inactive");
        }
    }

}
