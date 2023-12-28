package com.my.app.backend.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDateTime;
import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserGetDto {
    @JsonProperty("id")
    private UUID id;

    @JsonProperty("emailAddress")
    private String emailAddress;

    @JsonProperty("lastName")
    private String lastName;

    @JsonProperty("firstName")
    private String firstName;
    
    @JsonProperty("creationDate")
    private LocalDateTime creationDate;
    
    @JsonProperty("updateDate")
    private LocalDateTime updateDate;
}