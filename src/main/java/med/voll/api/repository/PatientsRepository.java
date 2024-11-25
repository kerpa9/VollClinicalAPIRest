package med.voll.api.repository;

import java.awt.print.Pageable;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import med.voll.api.domain.patients.PatientsModel;

public interface PatientsRepository extends JpaRepository<PatientsModel, Long> {

    Page<PatientsModel> findAllByActiveTrue(Pageable pagination);

}
