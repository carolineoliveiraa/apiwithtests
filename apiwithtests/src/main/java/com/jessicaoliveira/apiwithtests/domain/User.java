package com.jessicaoliveira.apiwithtests.domain;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@ToString
@Entity
@Table(name = "web_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @Column(unique = true)
    private String email;
    private String password;

}
