package org.isd.Immatriculation.service;

import org.isd.Immatriculation.Mapper.OwnerMapper;
import org.isd.Immatriculation.dto.OwnerRequestDTO;
import org.isd.Immatriculation.dto.OwnerResponseDTO;
import org.isd.Immatriculation.entities.Owner;
import org.isd.Immatriculation.repository.OwnerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;
@Service
@Transactional

public class OwnerServiceImpl implements OwnerService {
    private OwnerRepository ownerRepository;
    private OwnerMapper ownerMapper;

    public OwnerServiceImpl(OwnerRepository ownerRepository, OwnerMapper ownerMapper) {
        this.ownerRepository = ownerRepository;
        this.ownerMapper = ownerMapper;
    }

    @Override
    public OwnerResponseDTO addOwner(OwnerRequestDTO owner) {
        Owner owner1 = Owner.builder()
                .id(UUID.randomUUID().toString())
                .name(owner.getName())
                .birthDate(System.currentTimeMillis())
                .email(owner.getEmail())
                .build();

         Owner ownersave = ownerRepository.save(owner1);
         OwnerResponseDTO ownerResponseDTO = ownerMapper.fromOwner(ownersave);
        return ownerResponseDTO;
    }

    @Override
    public OwnerResponseDTO updateOwner(String id, OwnerRequestDTO ownerRequestDTO) {
        Owner owner1 = Owner.builder()
                .id(id)
                .name(ownerRequestDTO.getName())
                .birthDate(System.currentTimeMillis())
                .email(ownerRequestDTO.getEmail())
                .build();

        Owner ownersave = ownerRepository.save(owner1);
        OwnerResponseDTO ownerResponseDTO = ownerMapper.fromOwner(ownersave);
        return ownerResponseDTO;
    }
    @Override
    public void deleteOwnere(String id) {
        ownerRepository.deleteById(id);

    }
}
