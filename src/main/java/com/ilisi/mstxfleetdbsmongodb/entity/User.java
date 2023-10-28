package com.ilisi.mstxfleetdbsmongodb.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document(collection = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    private UUID id;
    private String username;
    private String password;
    private String user_type;
    private String nom;
    private String prenom;
    private String email;
    private String phone;

}
