package med.voll.api.dto;

import med.voll.api.physician.PhysicianModel;

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
