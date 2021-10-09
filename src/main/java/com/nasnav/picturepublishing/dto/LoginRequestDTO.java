package com.nasnav.picturepublishing.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Setter
@Getter

public class LoginRequestDTO {

    private String username;
    private String password ;
}
