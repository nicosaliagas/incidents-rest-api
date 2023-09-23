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
    @Email(message = "L'email n'est pas valide", regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")
    @NotBlank(message = "L'email est obligatoire")
    private String mail;
    
    @Column(name="lastName", nullable = false)
    private String lastName;

    @Column(name="firstName", nullable = false)
    private String firstName;

    @Column(name="phone", nullable = true)
    @Pattern(regexp = "^0\\d{9}$|", message = "Le numéro de téléphone n'est pas valide")
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