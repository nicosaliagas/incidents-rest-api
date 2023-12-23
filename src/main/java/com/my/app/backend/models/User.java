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
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.my.app.backend.validation.CreateUserValidation;

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
    
    @Column(name="emailAddress", unique=true)
    @Email(message = "L'email n'est pas valide", regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")
    @NotBlank(message = "L'email est obligatoire")
    private String emailAddress;
    
    @Column(name="password", nullable = false)
    @Size(min = 6, max = 10)
    @NotBlank(groups = CreateUserValidation.class, message = "Le mot de passe est obligatoire")
    private String password;

    @Column(name="lastName", nullable = false)
    private String lastName;

    @Column(name="firstName", nullable = false)
    private String firstName;

    @CreationTimestamp
    @Column(nullable = false)
    private LocalDateTime creationDate;
    
    @UpdateTimestamp
    @Column(nullable = false)
    private LocalDateTime updateDate;

    /*@JsonManagedReference
    @OneToMany(mappedBy="user", fetch = FetchType.EAGER, cascade= CascadeType.ALL)
    private List<IncidentEntity> userIncidentsList;*/

    public User() { }

	public User(String lastName, String firstName, String emailAddress, String password) {
		this.lastName = lastName;
		this.firstName = firstName;
        this.emailAddress = emailAddress;
        this.password = password;
	}

    @Override
    public String toString() {
        return "UserEntity [id=" + id + ", emailAddress=" + emailAddress + ", password=" + password + ", lastName=" + lastName + ", firstName=" + firstName
                + ", creationDate=" + creationDate + "]";
    }
}