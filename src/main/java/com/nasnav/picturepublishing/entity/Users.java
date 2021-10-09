package com.nasnav.picturepublishing.entity;

import com.nasnav.picturepublishing.enums.GenderEnum;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;



@Entity
@Setter
@Getter
public class Users implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String username;
    private String password;
    private String email;
    @Enumerated( EnumType.STRING )
    private GenderEnum gender;


}
