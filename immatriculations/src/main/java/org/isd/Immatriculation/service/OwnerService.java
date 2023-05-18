package org.isd.Immatriculation.service;

import org.isd.Immatriculation.dto.OwnerRequestDTO;
import org.isd.Immatriculation.dto.OwnerResponseDTO;

public interface OwnerService {
    OwnerResponseDTO addOwner(OwnerRequestDTO ownerRequestDTO);
    OwnerResponseDTO updateOwner(String id,OwnerRequestDTO ownerRequestDTO);

    void deleteOwnere(String id);
}
