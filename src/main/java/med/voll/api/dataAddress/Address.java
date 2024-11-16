package med.voll.api.dataAddress;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.dtos.DataAddressDTO;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class Address {
    private String street;
    private String district;
    private String city;
    private String number;
    private String complement;

    public Address(DataAddressDTO address) {
        this.street = address.street();
        this.district = address.district();
        this.city = address.city();
        this.number = address.number();
        this.complement = address.complement();
    }

}
