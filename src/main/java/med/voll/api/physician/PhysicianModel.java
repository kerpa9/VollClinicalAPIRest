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
import med.voll.api.dto.RegisterPhysicianDTO;
import med.voll.api.dto.UpdatePhysicianDTO;

@Table(name = "physician_model")
@Entity(name = "Physician_model")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class PhysicianModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String phone;
    private String email;
    private String document;
    @Enumerated(EnumType.STRING)
    private Specialty specialty;
    // Relations to class address
    @Embedded
    private Address address;

    private Boolean active;

    public PhysicianModel(RegisterPhysicianDTO parameter) {
        this.active = true;
        this.name = parameter.name();
        this.phone = parameter.phone();
        this.email = parameter.email();
        this.document = parameter.document();
        this.specialty = parameter.specialty();
        this.address = new Address(parameter.address());

    }

    public void updateDatas(UpdatePhysicianDTO updatePhysicianDTO) {

        if (updatePhysicianDTO.name() != null) {

            this.name = updatePhysicianDTO.name();
        }

        if (updatePhysicianDTO.document() != null) {

            this.document = updatePhysicianDTO.document();
        }

        if (updatePhysicianDTO.address() != null) {

            this.address = address.updateDatasAddress(updatePhysicianDTO.address());
        }
    }

    public void setStausInactivePhysician() {
        this.active = false;
    }

}
