package com.my.app.backend.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserGetDto {
    @JsonProperty("id")
    private Long id;

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