package med.voll.api.physician;

public record ListDataPhysicianDTO(
        String name,
        String specialty,
        String document,
        String email) {

    public ListDataPhysicianDTO(PhysicianModel physicianModel) {
        this(physicianModel.getName(), physicianModel.getSpecialty().toString(), physicianModel.getDocument(),
                physicianModel.getEmail());
    }

}
