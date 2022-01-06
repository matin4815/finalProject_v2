package com.clarity.finalproject_v2.entity;


import com.clarity.finalproject_v2.enums.Roles;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "users")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;

    private boolean enabled = true;

    @ElementCollection(targetClass = Roles.class)
    @CollectionTable(name = "authorities", joinColumns =
    @JoinColumn(name = "username", referencedColumnName = "username"))
    @Enumerated(EnumType.STRING)
    private List<Roles> roles;

    @NotNull
    @Column(unique = true)
    private String username;
    @NotNull
    private String password;

    @OneToMany(mappedBy = "user")
    private List<Post> posts;

}
