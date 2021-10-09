package com.nasnav.picturepublishing.controller;

import com.nasnav.picturepublishing.dto.PictureDTO;
import com.nasnav.picturepublishing.dto.PictureRequestDTO;
import com.nasnav.picturepublishing.service.PictureService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("publishing")
public class PublishController {

    @Autowired
    PictureService pictureService;


    private static final Logger LOGGER = LogManager.getLogger(PublishController.class);

    @GetMapping(value = "all-pictures")
    public ResponseEntity<List<PictureDTO>> listPictures() {
        return ResponseEntity.ok(pictureService.listPictures());
    }

        @GetMapping(value = "get-accepted-pictures")
        public ResponseEntity<List<PictureDTO>> listAcceptedPictures(){
            return ResponseEntity.ok(pictureService.listAcceptedPictures());

    }


    @GetMapping(value = "get-unprocessed-pictures")
    public ResponseEntity<List<PictureDTO>> listUnprocessedPictures(){
        return ResponseEntity.ok(pictureService.listUnprocessedPictures());
    }

    @PostMapping(value = "accept-pictures")
    public ResponseEntity <Integer> acceptPictures(@Valid  @RequestBody PictureRequestDTO pictureRequestDTO){
        return ResponseEntity.ok(pictureService.acceptPictures(pictureRequestDTO));
    }
}
