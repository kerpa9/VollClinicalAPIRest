package med.voll.api.domain.dataAddress;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.config.dto.DataAddressDTO;

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

    public Address updateDatasAddress(DataAddressDTO dataAddressDTO) {
    this.street = dataAddressDTO.street();
    this.district = dataAddressDTO.district();
    this.city = dataAddressDTO.city();
    this.number = dataAddressDTO.number();
    this.complement = dataAddressDTO.complement();
    return this;

    }

    // public Address updateDatasAddress(Address address) {
    //     this.street = address.street;
    //     this.district = address.district;
    //     this.city = address.city;
    //     this.number = address.number;
    //     this.complement = address.complement;
    //     return this;
    // }

}
