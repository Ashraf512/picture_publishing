package com.nasnav.picturepublishing.entity;

import com.nasnav.picturepublishing.enums.CategoryEnum;
import com.nasnav.picturepublishing.enums.PictureStatusEnum;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Setter
@Getter
public class Picture implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;

    @Enumerated( EnumType.STRING )
    private CategoryEnum category;

    private String attachment;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users users;

    @Enumerated( EnumType.STRING )
    private PictureStatusEnum status ;




}
