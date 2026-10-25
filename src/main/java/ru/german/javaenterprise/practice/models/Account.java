package ru.german.javaenterprise.practice.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.german.javaenterprise.practice.servlets.Profile;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account {
    private Long id;
    private String name;
    private String username;
    private String password;
    private Profile profile;
}
