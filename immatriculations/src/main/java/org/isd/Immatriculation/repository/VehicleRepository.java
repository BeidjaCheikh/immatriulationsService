package org.isd.Immatriculation.repository;

import org.isd.Immatriculation.entities.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource

public interface VehicleRepository extends JpaRepository<Vehicle,String> {
}
