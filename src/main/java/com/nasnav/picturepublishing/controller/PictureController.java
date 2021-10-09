package com.nasnav.picturepublishing.controller;

import com.nasnav.picturepublishing.dto.PictureDTO;
import com.nasnav.picturepublishing.dto.UserDTO;
import com.nasnav.picturepublishing.enums.CategoryEnum;
import com.nasnav.picturepublishing.service.PictureService;
import com.nasnav.picturepublishing.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("pictures")
public class PictureController {

    @Autowired
    PictureService pictureService;


    private static final Logger LOGGER = LogManager.getLogger(PictureController.class);

    @PostMapping(path = "add-picture")
    public ResponseEntity<Object> register(
            @RequestHeader(name = "username") String username ,
            @RequestHeader(name= "password") String password,
            @RequestParam("description") String description ,
                                           @RequestParam("attachment") MultipartFile attachment,
                                           @RequestParam("category") CategoryEnum category ) {

        try {
            return pictureService.addPicture(username,password,description,attachment,category);
        } catch (Exception e) {
            LOGGER.error("ERROR IN 'users/register' : {}", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

//    @PostMapping("/upload")
//    //@RestResponseEntity
//    public Set<PictureDTO> uploadFile(@RequestParam("file") MultipartFile file, @RequestParam("userId") int userId,
//                                      @RequestParam("requestId") int requestId, @RequestParam("documentTypeId") int documentTypeId) throws IOException {
//
//        String filePath = pictureService.save(file, userId, requestId, documentTypeId);
//        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
//        return null;
//
//    }
    @GetMapping(value = "all-pictures")
    public ResponseEntity<List<PictureDTO>> listParticipants(){
        return ResponseEntity.ok(pictureService.listPictures());
    }


}
