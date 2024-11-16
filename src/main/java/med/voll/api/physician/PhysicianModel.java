package med.voll.api.physician;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.dataAddress.Address;
import med.voll.api.dtos.RegisterPhysicianDTO;

@Table(name = "phycisians")
@Entity(name = "phycisian")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class PhysicianModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String document;
    @Enumerated(EnumType.STRING)
    private Specialty specialty;
    // Relations to class address
    @Embedded
    private Address address;

    public PhysicianModel(RegisterPhysicianDTO parameter) {
        this.name = parameter.name();
        this.email = parameter.email();
        this.document = parameter.document();
        this.specialty = parameter.specialty();
        this.address = new Address(parameter.address());

    }

}
