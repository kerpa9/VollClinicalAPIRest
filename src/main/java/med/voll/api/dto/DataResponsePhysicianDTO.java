package med.voll.api.dto;

public record DataResponsePhysicianDTO(Long id, String name, String email, String phone, String document,
        DataAddressDTO address) {

}
