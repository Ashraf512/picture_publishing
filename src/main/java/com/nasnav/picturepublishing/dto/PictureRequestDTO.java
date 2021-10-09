package com.nasnav.picturepublishing.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.nasnav.picturepublishing.enums.CategoryEnum;
import com.nasnav.picturepublishing.enums.PictureStatusEnum;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Setter
@Getter
public class PictureRequestDTO {

    @NotNull(message = "Id Is Required")
    private  Long id;

    private String description;

    @Enumerated( EnumType.STRING )
    private CategoryEnum category;

    @NotBlank
    @Size()
    private String attachment;


    private Long users;

    @Enumerated( EnumType.STRING )
    private PictureStatusEnum status ;
}
