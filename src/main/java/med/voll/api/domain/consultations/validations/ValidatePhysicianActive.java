// package med.voll.api.domain.consultations.validations;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Component;

// import jakarta.validation.ValidationException;
// import med.voll.api.config.dto.ConsultationsDataDTO;
// import med.voll.api.repository.PhysicianRepository;


// @Component
// public class ValidatePhysicianActive implements IValidateConsultation {

//     @Autowired
//     private PhysicianRepository physicianRepository;

//     public void validate(ConsultationsDataDTO consultationsDataDTO) {

//         if (consultationsDataDTO.idPhysician() == null) {
//             return;
//         }

//         var physicianActive = physicianRepository.findActiveById(consultationsDataDTO.idPhysician());
        
//         if (!physicianActive) {
//             throw new ValidationException("Physician Inactive");
//         }

//     }
// }
