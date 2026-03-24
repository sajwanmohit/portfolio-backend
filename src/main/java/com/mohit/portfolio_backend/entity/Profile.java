package com.mohit.portfolio_backend.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String designation;

    @Column(length = 2000)
    private String about;

    private String ownerGithubProfileURL;
    private String ownerLinkedinProfileURL;
    private String ownerEmailAddress;
}