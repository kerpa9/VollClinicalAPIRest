package med.voll.api.domain.consultations.validations;

import java.time.DayOfWeek;

import jakarta.validation.ValidationException;
import med.voll.api.config.dto.ConsultationsDataDTO;

public class ValidateScheduleAvaliable {

    public void validate(ConsultationsDataDTO consultationsDataDTO) {
        var dateConsultation = consultationsDataDTO.date();
        var sunday = dateConsultation.getDayOfWeek().equals(DayOfWeek.SUNDAY);
        var scheduleBeforeClinicalOpen = dateConsultation.getHour() < 7;
        var scheduleAfterClinicalOpen = dateConsultation.getHour() > 18;

        if (sunday || scheduleAfterClinicalOpen || scheduleBeforeClinicalOpen) {
            throw new ValidationException("Limit the time schedule for reservations in the clinic");
        }

    }

}
