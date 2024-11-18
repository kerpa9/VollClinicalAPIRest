package med.voll.api.config.dto;

import med.voll.api.domain.physician.PhysicianModel;

public record ListDataPhysicianDTO(
        Long id,
        String name,
        String specialty,
        String document,
        String email) {

    public ListDataPhysicianDTO(PhysicianModel physicianModel) {
        this(physicianModel.getId(), physicianModel.getName(), physicianModel.getSpecialty().toString(),
                physicianModel.getDocument(),
                physicianModel.getEmail());
    }

}
