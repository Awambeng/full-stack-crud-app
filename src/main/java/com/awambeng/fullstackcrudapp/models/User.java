package com.awambeng.fullstackcrudapp.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "user_accounts", uniqueConstraints = @UniqueConstraint(columnNames = "Email"))
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "First_Name")
    private String firstName;

    @Column(name = "Last_Name")
    private String lastName;

    @Column(name = "Email")
    private String email;

    @Column(name = "Password")
    private String password;

    // we use the FetchType.EAGER to select users alongside their roles
    // we use CascadeType.ALL so that any changes made on the role table should automatically be updated in the user table
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    // since there is a many-to-many relationship between user and role then we need to create a new table using the @JoinTable annotation
    @JoinTable(
            name = "user_roles",
            joinColumns = @JoinColumn(name = "User_Id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "Role_Id", referencedColumnName = "id"))
    private List<Role> roles;
}
