package med.voll.api.domain.patients;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.config.dto.RegisterPatiensDTO;
import med.voll.api.domain.dataAddress.Address;

@Table(name = "patients_model")
@Entity(name = "Patients_model")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")

public class PatientsModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String document;
    private String phone;
    @Embedded
    private Address address;
    private Boolean active;

    public PatientsModel(RegisterPatiensDTO registerPatiensDTO) {

        this.active = true;
        this.name = registerPatiensDTO.name();
        this.email = registerPatiensDTO.email();
        this.document = registerPatiensDTO.document();
        this.phone = registerPatiensDTO.phone();
        this.address = new Address(registerPatiensDTO.address());

    }

}
