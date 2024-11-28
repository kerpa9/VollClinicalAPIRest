package med.voll.api.controllers;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.config.dto.DataAddressDTO;
import med.voll.api.config.dto.DataResponsePhysicianDTO;
import med.voll.api.config.dto.ListDataPhysicianDTO;
import med.voll.api.config.dto.RegisterPhysicianDTO;
import med.voll.api.config.dto.UpdatePhysicianDTO;
import med.voll.api.domain.physician.PhysicianModel;
import med.voll.api.repository.PhysicianRepository;

@RestController
@RequestMapping("/api/v1/physician")
@SecurityRequirement(name = "bearer-key")

public class PhysicianController {

    @Autowired
    private PhysicianRepository physicianRepository;

    @PostMapping
    public ResponseEntity<DataResponsePhysicianDTO> registerPhysician(
            @RequestBody @Valid RegisterPhysicianDTO parameter,
            UriComponentsBuilder uriComponentsBuilder) {
        PhysicianModel physicianModel = physicianRepository.save(new PhysicianModel(parameter));

        DataResponsePhysicianDTO dataResponsePhysician = new DataResponsePhysicianDTO(physicianModel.getId(),
                physicianModel.getName(), physicianModel.getEmail(), physicianModel.getPhone(),
                physicianModel.getSpecialty().toString(), new DataAddressDTO(physicianModel.getAddress().getStreet(),
                        physicianModel.getAddress().getDistrict(), physicianModel.getAddress().getCity(),
                        physicianModel.getAddress().getNumber(), physicianModel.getAddress().getComplement()));

        URI url = uriComponentsBuilder.path("/physician/{id}").buildAndExpand(physicianModel.getId()).toUri();

        return ResponseEntity.created(url).body(dataResponsePhysician);

    }

    // Overriding pageable values @PageableDefault(size = 2, ...)
    @GetMapping
    public ResponseEntity<Page<ListDataPhysicianDTO>> listPthysician(@PageableDefault(size = 5) Pageable pageable) {
        return ResponseEntity.ok(physicianRepository.findByActiveTrue(pageable).map(ListDataPhysicianDTO::new));
        // return
        // physicianRepository.findByActiveTrue(pageable).map(ListDataPhysicianDTO::new);
        // return physicianRepository.findAll(pageable).map(ListDataPhysicianDTO::new);

    }

    @GetMapping("/{id}")
    public ResponseEntity<DataResponsePhysicianDTO> getByIdPhysician(@PathVariable Long id) {
        PhysicianModel physicianModel = physicianRepository.getReferenceById(id);
        var physicianData = new DataResponsePhysicianDTO(physicianModel.getId(), physicianModel.getName(),
                physicianModel.getEmail(),
                physicianModel.getPhone(), physicianModel.getSpecialty().toString(),
                new DataAddressDTO(physicianModel.getAddress().getStreet(),
                        physicianModel.getAddress().getDistrict(), physicianModel.getAddress().getCity(),
                        physicianModel.getAddress().getNumber(), physicianModel.getAddress().getComplement()));
        return ResponseEntity.ok(physicianData);

    }

    @SuppressWarnings("rawtypes")
    @PutMapping
    @Transactional
    public ResponseEntity updatePhysician(@RequestBody @Valid UpdatePhysicianDTO updatePhysicianDTO) {
        PhysicianModel physicianModel = physicianRepository.getReferenceById(updatePhysicianDTO.id());
        physicianModel.updateDatas(updatePhysicianDTO);
        return ResponseEntity.ok(
                new DataResponsePhysicianDTO(physicianModel.getId(), physicianModel.getName(),
                        physicianModel.getEmail(),
                        physicianModel.getPhone(), physicianModel.getSpecialty().toString(),
                        new DataAddressDTO(physicianModel.getAddress().getStreet(),
                                physicianModel.getAddress().getDistrict(), physicianModel.getAddress().getCity(),
                                physicianModel.getAddress().getNumber(), physicianModel.getAddress().getComplement())));

    }

    // Delete database
    // @DeleteMapping("/{id}")
    // @Transactional
    // public void deletePhysician(@PathVariable Long id){
    // PhysicianModel physicianModel = physicianRepository.getReferenceById(id);
    // physicianModel.delete(physicianModel);

    // }

    // Logical delete
    @DeleteMapping("/{id}")
    @Transactional
    @SuppressWarnings("rawtypes")
    public ResponseEntity deletePhysician(@PathVariable Long id) {
        PhysicianModel physicianModel = physicianRepository.getReferenceById(id);
        physicianModel.setStausInactivePhysician();
        return ResponseEntity.noContent().build();

    }

}
