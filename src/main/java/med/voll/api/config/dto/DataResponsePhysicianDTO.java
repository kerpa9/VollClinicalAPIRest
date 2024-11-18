package med.voll.api.config.dto;

public record DataResponsePhysicianDTO(Long id, String name, String email, String phone, String document,
        DataAddressDTO address) {

}
