package com.nasnav.picturepublishing.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.nasnav.picturepublishing.entity.Picture;
import com.nasnav.picturepublishing.entity.Users;
import com.nasnav.picturepublishing.enums.CategoryEnum;
import com.nasnav.picturepublishing.enums.PictureStatusEnum;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Setter
@Getter
public class PictureDTO {


    private String description;

    @Enumerated( EnumType.STRING )
    private CategoryEnum category;

    @NotBlank
    @Size()
    private String attachment;


    private Long users;

    @Enumerated( EnumType.STRING )
    private PictureStatusEnum status ;

    public PictureDTO convertEntityToDto(Picture picture) {
        return null;
    }
}
