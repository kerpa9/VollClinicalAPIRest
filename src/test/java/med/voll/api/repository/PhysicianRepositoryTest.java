package med.voll.api.repository;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import jakarta.persistence.EntityManager;
import med.voll.api.config.dto.DataAddressDTO;
import med.voll.api.config.dto.RegisterPatiensDTO;
import med.voll.api.config.dto.RegisterPhysicianDTO;
import med.voll.api.domain.consultations.ConsultationModel;
import med.voll.api.domain.patients.PatientsModel;
import med.voll.api.domain.physician.PhysicianModel;
import med.voll.api.domain.physician.Specialty;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
public class PhysicianRepositoryTest {

    @Autowired
    private PhysicianRepository physicianRepository;

    @Autowired
    private EntityManager em;

    @Test
    @DisplayName("Return null because a physician not available at the scheduled time")
    void testChoosephysicianModelRandomAvailable() {

        var mondayTenOclock = LocalDate.now().with(TemporalAdjusters.next(DayOfWeek.MONDAY)).atTime(10, 0);
        var physician = registerPhysician("juan", "juan@email.com", "1234568", Specialty.GYNECOLOGY);
        var patient = registerPatients("jose", "jose@email.com", "1518");
        registerConsult(physician, patient, mondayTenOclock);
        var availablePhysician = physicianRepository.choosephysicianModelRandomAvailable(Specialty.GYNECOLOGY,
                mondayTenOclock);

        assertThat(availablePhysician).isNull();
    }

    private void registerConsult(PhysicianModel physicianModel, PatientsModel patientsModel, LocalDateTime date) {

        em.persist(new ConsultationModel(null, physicianModel, patientsModel, date));

    }

    private PhysicianModel registerPhysician(String name, String email, String document, Specialty specialty) {
        var physician = new PhysicianModel(physicianData(name, email, document, specialty));
        em.persist(physician);
        return physician;

    }

    private PatientsModel registerPatients(String name, String email, String document) {
        var patient = new PatientsModel(dataPatients(name, email, document));
        em.persist(patient);
        return patient;
    }

    private RegisterPhysicianDTO physicianData(
            String name,
            String email,
            String document,
            Specialty specialty) {

        // return new RegisterPhysicianDTO(name, name, email, document, specialty, null)
        return new RegisterPhysicianDTO(name, email, "5618184", document, specialty, dataAddress());

    }

    private RegisterPatiensDTO dataPatients(
            String name,
            String email,
            String document) {

        return new RegisterPatiensDTO(name, email, "84848448", document, dataAddress());

    }

    private DataAddressDTO dataAddress() {
        return new DataAddressDTO(
                "street 1",
                "district 1",
                "city 1",
                "number 1",
                "complement 1");
    }

}
