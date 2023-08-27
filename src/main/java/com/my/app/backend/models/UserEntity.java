package com.my.app.backend.models;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="userList")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="userId")
    private Long id;
    
    @Column(name="mail", unique=true, nullable = false)
    private String mail;
    
    @Column(name="lastName", nullable = false)
    private String lastName;

    @Column(name="firstName", nullable = false)
    private String firstName;

    @Column(name="phone")
    private String phone;

    @CreationTimestamp
    @Column(nullable = false)
    private LocalDateTime creationDate;

    /*@JsonManagedReference
    @OneToMany(mappedBy="user", fetch = FetchType.EAGER, cascade= CascadeType.ALL)
    private List<IncidentEntity> userIncidentsList;*/

    public UserEntity() { }

	public UserEntity(String lastName, String firstName, String phone, String mail) {
		this.lastName = lastName;
		this.firstName = firstName;
		this.phone = phone;
        this.mail = mail;
	}

    @Override
    public String toString() {
        return "UserEntity [id=" + id + ", mail=" + mail + ", lastName=" + lastName + ", firstName=" + firstName
                + ", phone=" + phone + ", creationDate=" + creationDate + "]";
    }
}