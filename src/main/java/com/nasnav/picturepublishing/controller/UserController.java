package com.nasnav.picturepublishing.controller;


import com.nasnav.picturepublishing.dto.LoginRequestDTO;
import com.nasnav.picturepublishing.dto.UserDTO;
import com.nasnav.picturepublishing.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    UserService userService;

    private static final Logger LOGGER = LogManager.getLogger(UserController.class);

    @PostMapping(path = "/register")
    public ResponseEntity<UserDTO> register(@Valid @RequestBody UserDTO userDTO) {

        try {
            return new ResponseEntity<>(userService.register(userDTO), HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.error("ERROR IN 'users/register' : {}", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PostMapping(path = "/login")
    public ResponseEntity<String> register(@Valid @RequestBody LoginRequestDTO loginRequestDTO) {

        try {
            return new ResponseEntity<>(userService.login(loginRequestDTO), HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.error("ERROR IN 'users/login' : {}", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
