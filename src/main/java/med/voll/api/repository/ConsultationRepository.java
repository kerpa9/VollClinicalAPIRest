package med.voll.api.repository;

import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.JpaRepository;

import med.voll.api.domain.consultations.ConsultationModel;

public interface ConsultationRepository extends JpaRepository<ConsultationModel, Long>{

    boolean existsByPatientsModelIdAndDateBetween(Long PatientsId, LocalDateTime firstSchedule,
            LocalDateTime lastSchedule);

    boolean existsByPhysicianModelIdAndDate(Long idPhysicianId, LocalDateTime date);
    
    
}
