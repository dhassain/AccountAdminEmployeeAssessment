package com.example.ecommerce.signup.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "users")
public class SignUpModel {
    @Id
//  @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

//    @Column(name = "age")
//    private int age;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "email_id")
    private String emailId;
    @Column(name = "password")
    private String password;
}
