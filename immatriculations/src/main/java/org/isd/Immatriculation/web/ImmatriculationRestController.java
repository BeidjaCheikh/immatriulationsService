package org.isd.Immatriculation.web;

import org.isd.Immatriculation.dto.OwnerRequestDTO;
import org.isd.Immatriculation.dto.OwnerResponseDTO;
import org.isd.Immatriculation.entities.Owner;
import org.isd.Immatriculation.repository.OwnerRepository;
import org.isd.Immatriculation.repository.VehicleRepository;
import org.isd.Immatriculation.service.OwnerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/immatriculations")
public class ImmatriculationRestController {

        private  OwnerRepository ownerRepository;

        private VehicleRepository vehicleRepository;

        private OwnerService ownerService;

    public ImmatriculationRestController(OwnerRepository ownerRepository, VehicleRepository vehicleRepository, OwnerService ownerService) {
        this.ownerRepository = ownerRepository;
        this.vehicleRepository = vehicleRepository;
        this.ownerService = ownerService;
    }

    @GetMapping("/owners")
    public List<Owner> getAllOwner() {
        return ownerRepository.findAll();
    }

    @GetMapping("/owners/{id}")
    public Owner owner(@PathVariable String id){
        return ownerRepository.findById(id).orElseThrow(()->new RuntimeException(String.format("compte not found")));
    }
    @PostMapping("/owners")

    public OwnerResponseDTO saveOwner(@RequestBody OwnerRequestDTO ownerRequestDTO){

        return ownerService.addOwner(ownerRequestDTO);
    }
    @PutMapping("/owners/{id}")
    public OwnerResponseDTO updateCompte( @PathVariable String id ,@RequestBody OwnerRequestDTO ownerRequestDTO){

        return ownerService.updateOwner(id ,ownerRequestDTO);
    }
    @DeleteMapping("/comptes/{id}")
    public boolean deleteCopmte(@PathVariable String id){
        ownerService.deleteOwnere(id);
        return true;
    }

}
