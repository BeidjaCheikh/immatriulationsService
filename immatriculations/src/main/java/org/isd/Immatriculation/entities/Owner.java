package org.isd.Immatriculation.entities;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Date;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
    public class Owner {
        @Id
        private String id;
        private String name;
        private Long birthDate;
        private String email;

        @OneToMany(mappedBy = "owner")
        @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
        private List<Vehicle> vehicles;
    }

