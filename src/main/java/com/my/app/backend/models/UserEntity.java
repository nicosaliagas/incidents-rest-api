package com.my.app.backend.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="user_list")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name="mail", unique=true, nullable = false)
    private String mail;
    
    @Column(name="lastName", nullable = false)
    private String lastName;

    @Column(name="firstName", nullable = false)
    private String firstName;

    @Column(name="phone")
    private String phone;

    public UserEntity() { }

	public UserEntity(String lastName, String firstName, String phone, String mail) {
		this.lastName = lastName;
		this.firstName = firstName;
		this.phone = phone;
        this.mail = mail;
	}

    @Override
    public String toString() {
        return "UserEntity [id=" + id + ", lastName=" + lastName + ", firstName=" + firstName + ", phone=" + phone
                + ", mail=" + mail + "]";
    }
}