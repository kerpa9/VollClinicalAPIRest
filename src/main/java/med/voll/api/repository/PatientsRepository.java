
package med.voll.api.repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import med.voll.api.domain.patients.PatientsModel;

public interface PatientsRepository extends JpaRepository<PatientsModel, Long> {

    Page<PatientsModel> findAllByActiveTrue(Pageable pagination);


 @Query("""
            select p.active
            from Patients_model p
            where
            p.id=:idPaciente

            """)
    boolean findActivoById(Long idPaciente);

}




