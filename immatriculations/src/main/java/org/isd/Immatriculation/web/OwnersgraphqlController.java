package org.isd.Immatriculation.web;

import org.isd.Immatriculation.dto.OwnerRequestDTO;
import org.isd.Immatriculation.dto.OwnerResponseDTO;
import org.isd.Immatriculation.entities.Owner;
import org.isd.Immatriculation.entities.Vehicle;
import org.isd.Immatriculation.repository.OwnerRepository;
import org.isd.Immatriculation.repository.VehicleRepository;
import org.isd.Immatriculation.service.OwnerService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.UUID;

@Controller
public class OwnersgraphqlController {

    private OwnerRepository ownerRepository;
    private VehicleRepository vehicleRepository;
    private OwnerService ownerService;

    public OwnersgraphqlController(OwnerRepository ownerRepository, VehicleRepository vehicleRepository, OwnerService ownerService) {
        this.ownerRepository = ownerRepository;
        this.vehicleRepository = vehicleRepository;
        this.ownerService = ownerService;
    }

    @QueryMapping
    public List<Owner> ownersList(){
        return ownerRepository.findAll();
    }

    @QueryMapping
    public List<Vehicle> vehicleList(){
        return vehicleRepository.findAll();
    }
    @QueryMapping
    public List<Vehicle> vehicleLists(){
        return vehicleRepository.findAll();
    }

    @QueryMapping
    public Owner ownerById(@Argument String id){
        return ownerRepository.findById(id).orElseThrow(()->new RuntimeException(String.format("Account %s not found" ,id)));
    }
    @QueryMapping
    public Vehicle VehicleById(@Argument String id){
        return vehicleRepository.findById(id).orElseThrow(()->new RuntimeException(String.format("Account %s not found" ,id)));
    }

    @MutationMapping
    public OwnerResponseDTO _addOwner(@Argument OwnerRequestDTO owner){
        return ownerService.addOwner(owner);
    }

    @MutationMapping
    public Vehicle _addVehicle(@Argument Vehicle vehicle){
        return vehicleRepository.save(vehicle);
    }

    @MutationMapping
    public boolean deleteOwner(@Argument String id){
        ownerRepository.deleteById(id);
        return true;
    }
    @QueryMapping
    public OwnerResponseDTO updateOwner(@Argument String id,@Argument OwnerRequestDTO owner){
        return ownerService.updateOwner(id, owner);
    }



}
