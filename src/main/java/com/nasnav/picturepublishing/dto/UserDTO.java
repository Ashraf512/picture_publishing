package com.nasnav.picturepublishing.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.nasnav.picturepublishing.enums.GenderEnum;
import com.nasnav.picturepublishing.util.ValueOfEnum;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Setter
@Getter
public class UserDTO {

    @NotNull(message = "name is required")
    private String name;

    @NotNull(message = "username is required")
    private String username;

    @NotNull(message = "email is required")
    @Email
    private String email;

    @NotNull(message = "password is required")
    @Size(min = 8, message = "password should have at least 8 characters")
    private String password;
}
