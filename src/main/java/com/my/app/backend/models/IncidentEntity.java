package com.my.app.backend.models;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "incident")
public class IncidentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "incidentId")
    private Long id;

    @Column(name = "description")
    private String description;

    @CreationTimestamp
    @Column(nullable = false)
    private LocalDateTime creationDate;

    @JoinColumn(name = "userId", referencedColumnName = "userId", nullable = false)
    @ManyToOne(optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private UserEntity userId;

    @Override
    public String toString() {
        return "IncidentEntity [id=" + id + ", description=" + description + ", creationDate=" + creationDate
                + ", userId=" + userId + "]";
    }

    public IncidentEntity() { }

    public IncidentEntity(String description, UserEntity userId) {
        this.description = description;
        this.userId = userId;
    }

    
}