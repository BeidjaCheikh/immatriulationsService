package org.isd.Immatriculation.Mapper;

import org.isd.Immatriculation.dto.OwnerResponseDTO;
import org.isd.Immatriculation.entities.Owner;
import org.isd.Immatriculation.entities.Vehicle;
import org.isd.Immatriculation.grpc.stub.Imt;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class OwnerMapper {
    public OwnerResponseDTO fromOwner(Owner owner){
        OwnerResponseDTO ownerResponseDTO =new OwnerResponseDTO();
        BeanUtils.copyProperties(owner,ownerResponseDTO);
        return ownerResponseDTO;
    }
    public Imt.Owner fromOwners(Owner owner){
        Imt.Owner owner1= Imt.Owner.newBuilder()
                .setId(owner.getId())
                .setBirthDate(owner.getBirthDate())
                .setName(owner.getName())
                .setEmail(owner.getEmail())
                .build();
        return owner1;
    }

    public Owner fromGrpcOwner(Owner owner){
        Owner owner2=new Owner();
        owner2.setId(owner.getId());
        owner2.setName(owner.getName());
        owner2.setBirthDate(owner.getBirthDate());
        owner2.setEmail(owner.getEmail());
        return owner2;
    }
}
