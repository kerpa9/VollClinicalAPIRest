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
            select m from PhysicianModel m
            where
            m.active=1
            and
            m.specialty= :specialty
            and m.id not in(
                select c.physician.id from Consult c
                where
                c.date= :date
            )
            order by rand()
            limit 1
            """)
    PhysicianModel choosePhysicianRandomAvailable(Specialty specialty, LocalDateTime date);

    @Query("""
            select p.active
            from PhysicianModel p
            where
            p.id=:idPhysician

            """)
    boolean findActiveById(Long idPhysician);

}
