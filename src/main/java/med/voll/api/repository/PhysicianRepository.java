package med.voll.api.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import med.voll.api.domain.physician.PhysicianModel;

public interface PhysicianRepository extends JpaRepository<PhysicianModel, Long> {
    
    Page<PhysicianModel> findByActiveTrue(Pageable pageable);

}
