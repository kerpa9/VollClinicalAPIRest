package med.voll.api.dataAddress;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class Address {
    private String street; 
    private String district;
    private String city;
    private int number;
    private String complement;
    
}
