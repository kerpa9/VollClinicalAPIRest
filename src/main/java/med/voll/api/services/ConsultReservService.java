package med.voll.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import med.voll.api.config.dto.ConsultationsDataDTO;
import med.voll.api.config.dto.DetailsConsultationsDTO;
import med.voll.api.config.handleException.ValidateException;
import med.voll.api.domain.consultations.ConsultationModel;
import med.voll.api.domain.consultations.validations.IValidateConsultation;
import med.voll.api.domain.physician.PhysicianModel;
import med.voll.api.repository.ConsultationRepository;
import med.voll.api.repository.PatientsRepository;
import med.voll.api.repository.PhysicianRepository;

@Service
public class ConsultReservService {

    @Autowired
    private PhysicianRepository physicianRepository;

    @Autowired
    private PatientsRepository patientsRepository;

    @Autowired
    private ConsultationRepository consultationRepository;

    @Autowired
    private List<IValidateConsultation> validations;

    public DetailsConsultationsDTO reserv(ConsultationsDataDTO consultationsDataDTO) {

        if (consultationsDataDTO.idPatients() != null
                && !patientsRepository.existsById(consultationsDataDTO.idPatients())) {
            throw new ValidateException("Not found patients by id");
        }

        if (consultationsDataDTO.idPhysician() != null
                && !physicianRepository.existsById(consultationsDataDTO.idPhysician())) {
            throw new ValidateException("Not found physician by id");
        }

        // Validations
        validations.forEach(v -> v.validate(consultationsDataDTO));

        var physician = choosePhysician(consultationsDataDTO);

        if (physician==null) {
            throw new ValidateException("The physician is not available at this schedule");
        }
        var patients = patientsRepository.findById(consultationsDataDTO.idPatients()).get();

        var consult = new ConsultationModel(null, physician, patients,
                consultationsDataDTO.date());
        consultationRepository.save(consult);

        return new DetailsConsultationsDTO(consult);

    }

    private PhysicianModel choosePhysician(ConsultationsDataDTO consultationsDataDTO) {

        if (consultationsDataDTO.idPhysician() != null) {
            return physicianRepository.getReferenceById(consultationsDataDTO.idPhysician());

        }

        if (consultationsDataDTO.specialty() == null) {
            throw new ValidateException("Choose a specialty because a physician has not been chosen");

        }

        return physicianRepository.choosephysicianModelRandomAvailable(consultationsDataDTO.specialty(),
                consultationsDataDTO.date());

    }

}
