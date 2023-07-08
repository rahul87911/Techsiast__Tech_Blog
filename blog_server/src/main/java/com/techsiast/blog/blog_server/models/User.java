package com.techsiast.blog.blog_server.models;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="users")
@NoArgsConstructor
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;


    private String firstname;

    private String lastname;

    private String email;


    private String phone;


    private String password;

    private String about;

}
