package com.mohit.portfolio_backend.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "projects")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String description;

    private String githubUrl;

    private String liveUrl;

    private String imageUrl;

    private String techStack;

    @Column(name = "is_selected")
    private Boolean isSelected = false;
}