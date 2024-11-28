package med.voll.api.repository;

import java.time.LocalDateTime;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import med.voll.api.domain.physician.PhysicianModel;
import med.voll.api.domain.physician.Specialty;

public interface PhysicianRepository extends JpaRepository<PhysicianModel, Long> {

    Page<PhysicianModel> findByActiveTrue(Pageable pageable);

    @Query("""
                select m from Physician_model m
                where
                m.active=TRUE
                and
                m.specialty= :specialty
                and m.id not in(
                     select c.physicianModel.id from Consultations_model c
                     where
                     c.date= :date
                )
                order by rand()
                limit 1
                """)
    PhysicianModel choosephysicianModelRandomAvailable(Specialty specialty, LocalDateTime date);

    @Query("""
            select d.active
            from Physician_model d
            where
            d.id=:idPhysician

            """)
    boolean findActiveById(Long idPhysician);

}
