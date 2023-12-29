package com.my.app.backend.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDateTime;
import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExerciseDto {
    @JsonProperty("id")
    private UUID id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("instruction")
    private String instruction;

    @JsonProperty("muscle")
    private String muscle;

    @JsonProperty("photo")
    private String photo;

    @JsonProperty("user_id")
    private String user;

    @JsonProperty("creationDate")
    private LocalDateTime creationDate;
    
    @JsonProperty("updateDate")
    private LocalDateTime updateDate;
}