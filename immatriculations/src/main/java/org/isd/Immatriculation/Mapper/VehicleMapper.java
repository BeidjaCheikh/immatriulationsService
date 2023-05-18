package org.isd.Immatriculation.Mapper;

import org.isd.Immatriculation.entities.Vehicle;
import org.isd.Immatriculation.grpc.stub.Imt;
import org.springframework.stereotype.Component;

@Component
public class VehicleMapper {
    public Imt.Vehicle fromVehicles(Vehicle vehicle){
        Imt.Vehicle vehicle1= Imt.Vehicle.newBuilder()
                .setId(vehicle.getId())
                .setMarque(vehicle.getMarque())
                .setMatricule(vehicle.getMatricule())
                .setModel(vehicle.getModel())
                .setPuissanceFiscale(vehicle.getPuissanceFiscale())
                .build();
        return vehicle1;
    }
}
