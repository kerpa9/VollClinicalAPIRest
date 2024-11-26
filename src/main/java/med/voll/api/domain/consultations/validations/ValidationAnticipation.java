package med.voll.api.domain.consultations.validations;

import java.time.Duration;
import java.time.LocalDateTime;

import med.voll.api.config.dto.ConsultationsDataDTO;
import med.voll.api.config.handleException.ValidateException;

public class ValidationAnticipation {

    public void validate(ConsultationsDataDTO consultationsDataDTO) {

        var dateConsultation = consultationsDataDTO.date();
        var now = LocalDateTime.now();
        var minutsDiference = Duration.between(now, dateConsultation).toMinutes();

        if(minutsDiference<30){
            throw new ValidateException("Schedule Selected in 30 minuts");
        }

    }

}
