package med.voll.api.domain.consultations;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.domain.patients.PatientsModel;
import med.voll.api.domain.physician.PhysicianModel;

@Table(name = "consultations_model")
@Entity(name = "Consultations_model")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")

public class ConsultationModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "physician_id")
    private PhysicianModel physicianModel;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patients_id")
    private PatientsModel patientsModel;

    private LocalDateTime date;

}
