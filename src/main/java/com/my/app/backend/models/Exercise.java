package com.my.app.backend.models;

import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="exercise")
public class Exercise {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name="exerciseId", columnDefinition = "BINARY(16)")
    private UUID id;
    
    @Column(name="name", unique=true)
    @NotBlank(message = "Le nom est obligatoire")
    private String name;
    
    @Column(name="instruction", columnDefinition = "TEXT")
    private String instruction;

    @Column(name="muscle")
    private String muscle;

    @Column(name="photo")
    private String photo;

    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    private User user;
    
    @CreationTimestamp
    @Column(nullable = false)
    private LocalDateTime creationDate;
    
    @UpdateTimestamp
    @Column(nullable = false)
    private LocalDateTime updateDate;

    public Exercise() { }

    public Exercise(@NotBlank(message = "Le nom est obligatoire") String name, String instruction, String muscle,
            String photo, User user) {
        this.name = name;
        this.instruction = instruction;
        this.muscle = muscle;
        this.photo = photo;
        this.user = user;
    }

    @Override
    public String toString() {
        return "Exercise [id=" + id + ", name=" + name + ", instruction=" + instruction + ", muscle=" + muscle
                + ", photo=" + photo + ", user=" + user + ", creationDate=" + creationDate + ", updateDate="
                + updateDate + "]";
    }
}