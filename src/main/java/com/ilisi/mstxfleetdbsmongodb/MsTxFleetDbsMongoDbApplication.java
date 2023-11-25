package com.ilisi.mstxfleetdbsmongodb;

import com.ilisi.mstxfleetdbsmongodb.controller.UserController;
import com.ilisi.mstxfleetdbsmongodb.entity.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

@SpringBootApplication
public class MsTxFleetDbsMongoDbApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsTxFleetDbsMongoDbApplication.class, args);
	}

	/** give me data compatible with the following entity:
	 * @Document(collection = "users")
	 * @Data
	 * @NoArgsConstructor
	 * @AllArgsConstructor
	 * public class User {
	 *
	 *     @Id
	 *     private UUID id;
	 *
	 *     @NotBlank(message = "Username cannot be blank")
	 *     @Size(min = 3, max = 255, message = "Username must be between 3 and 15 characters long")
	 *     @Indexed(unique = true)
	 *     private String username;
	 *
	 *     @NotBlank(message = "Password cannot be blank")
	 *     // Here you can also add @Pattern for regex to enforce strong password policies
	 *     @Size(min = 6, message = "Password must be at least 6 characters long")
	 *     private String password;
	 *
	 *     @NotBlank(message = "User type cannot be blank")
	 *     private String user_type;
	 *
	 *     @NotBlank(message = "Last name cannot be blank")
	 *     private String nom;
	 *
	 *     @NotBlank(message = "First name cannot be blank")
	 *     private String prenom;
	 *
	 *     @NotBlank(message = "Email cannot be blank")
	 *     @Email(message = "Email should be valid")
	 *     private String email;
	 *
	 *     @NotBlank(message = "Phone cannot be blank")
	 *     @Pattern(regexp = "^\\+?[0-9. ()-]{7,25}$", message = "Phone number is not valid")
	 *     private String phone;
	 * }
	 * **/
	CommandLineRunner start(UserController userController){
		return args -> {
			userController.save(
					new User(
							UUID.randomUUID(),
							"walidwalid",
							"walidwalid",
							"DRIVER",
							"Walid",
							"Ahdouf",
							"walid@gmail.com",
							"0606060606"
					)
			);
		};
	}

}
