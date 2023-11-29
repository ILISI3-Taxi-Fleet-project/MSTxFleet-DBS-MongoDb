package com.ilisi.mstxfleetdbsmongodb.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document(collection = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    private UUID id;

    @NotBlank(message = "Username cannot be blank")
    @Size(min = 3, max = 255, message = "Username must be between 3 and 15 characters long")
    @Indexed(unique = true)
    @JsonIgnore
    private String username;

    @NotBlank(message = "Password cannot be blank")
    // Here you can also add @Pattern for regex to enforce strong password policies
    @Size(min = 6, message = "Password must be at least 6 characters long")
    @JsonIgnore
    private String password;

    @NotBlank(message = "User type cannot be blank")
    private String user_type;

    @NotBlank(message = "Last name cannot be blank")
    private String nom;

    @NotBlank(message = "First name cannot be blank")
    private String prenom;

    @NotBlank(message = "Email cannot be blank")
    @Email(message = "Email should be valid")
    private String email;

    @NotBlank(message = "Phone cannot be blank")
    @Pattern(regexp = "^\\+?[0-9. ()-]{7,25}$", message = "Phone number is not valid")
    private String phone;
}
