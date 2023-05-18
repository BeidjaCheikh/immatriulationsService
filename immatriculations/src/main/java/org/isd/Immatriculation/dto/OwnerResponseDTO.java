package org.isd.Immatriculation.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.isd.Immatriculation.entities.Vehicle;

import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OwnerResponseDTO {
    @Id
    private String id;
    private String name;
    private Long birthDate;
    private String email;
    private List<Vehicle> vehicles;
}
