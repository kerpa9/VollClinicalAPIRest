package med.voll.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import med.voll.api.physician.PhysicianModel;

public interface PhysicianRepository extends JpaRepository<PhysicianModel, Long> {

}
