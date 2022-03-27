package com.example.termiistaffvisitor.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDto {
    private String message;
    private String username;
    private String password;
}
