package med.voll.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import med.voll.api.domain.consultations.ConsultationModel;

public interface ConsultationRepository extends JpaRepository<ConsultationModel, Long>{
    
    
}
