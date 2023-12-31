package com.my.app.backend.models;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.beans.factory.annotation.Required;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "incident")
public class Incident {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "incidentId")
    private Long id;

    @Column(name = "description")
    @NotBlank(message = "La description est requise")
    private String description;
    
    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @CreationTimestamp
    @Column(nullable = false)
    private LocalDateTime creationDate;

    @UpdateTimestamp
    @Column(nullable = false)
    private LocalDateTime updateDate;
    
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    
    @Override
    public String toString() {
        return "IncidentEntity [id=" + id + ", category=" + category + ", description=" + description
                + ", creationDate=" + creationDate + ", user=" + user + "]";
    }

    public Incident() { }

    public Incident(String description, Category category, User user) {
        this.description = description;
        this.category = category;
        this.user = user;
    }

    
}