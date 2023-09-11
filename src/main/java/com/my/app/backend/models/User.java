package com.my.app.backend.models;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="userList")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="userId")
    private Long id;
    
    @Column(name="mail", unique=true)
    @Email(message = "Email is not valid", regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")
    @NotBlank(message = "Email is mandatory")
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

    public User() { }

	public User(String lastName, String firstName, String phone, String mail) {
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