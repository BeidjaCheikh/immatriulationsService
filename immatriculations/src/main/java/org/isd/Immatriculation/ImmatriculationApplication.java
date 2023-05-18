package org.isd.Immatriculation;
import com.github.javafaker.Faker;
import org.isd.Immatriculation.entities.Owner;
import org.isd.Immatriculation.entities.Vehicle;
import org.isd.Immatriculation.repository.OwnerRepository;
import org.isd.Immatriculation.repository.VehicleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.stream.Stream;

@SpringBootApplication
public class ImmatriculationApplication {

	public static void main(String[] args) {
		SpringApplication.run(ImmatriculationApplication.class, args);
	}
	@Bean
	CommandLineRunner start(OwnerRepository ownerRepository, VehicleRepository vehicleRepository){
		return args -> {
			Stream.of("Cheikh","Sidi","Salma","Fatima","Khalid").forEach(c->{
				String email = c.toLowerCase() + "@gmail.com";
				Owner owner=Owner.builder()
						.id(UUID.randomUUID().toString())
						.name(c)
						.birthDate(System.currentTimeMillis())
						.email(email)
						.build();
				ownerRepository.save(owner);

			});
			List<String> modeleVoitures = Arrays.asList("Toyota Corolla", "Honda Civic", "Ford Mustang", "Chevrolet Camaro","Nissan Altima","Hyundai Elantra", "Volkswagen Golf","BMW 3 Series","Mercedes-Benz C-Class","Audi A4","");
			Faker faker = new Faker();
			Random random = new Random();
			ownerRepository.findAll().forEach(owner -> {
				for (int i = 0; i < 10; i++) {
					Vehicle vehicle = Vehicle.builder()
							.matricule(faker.bothify("??#####")) // Génère une plaque d'immatriculation aléatoire
							.marque(faker.company().name()) // Génère une marque de voiture aléatoire
							.puissanceFiscale(faker.number().numberBetween(100, 200)) // Génère une puissance fiscale aléatoire entre 100 et 200
							.model(generateRandomModele(modeleVoitures, random)) // Génère un modèle de voiture aléatoire
							.owner(owner)
							.build();
					vehicleRepository.save(vehicle);
				}
			});

		};

	}
	private String generateRandomModele(List<String> modeleVoitures, Random random) {
		int randomIndex = random.nextInt(modeleVoitures.size());
		return modeleVoitures.get(randomIndex);
	}
}

