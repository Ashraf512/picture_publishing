package com.nasnav.picturepublishing.service;

import com.nasnav.picturepublishing.dto.PictureRequestDTO;
import com.nasnav.picturepublishing.entity.Picture;
import com.nasnav.picturepublishing.enums.CategoryEnum;
import com.nasnav.picturepublishing.enums.PictureStatusEnum;
import  gov.saip.filestorage.FileStorage;

import com.nasnav.picturepublishing.dto.PictureDTO;
import com.nasnav.picturepublishing.repository.PictureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.FileSystemException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@Transactional
public class PictureService {

//    @Value("${com.nasnav.allowed-file-types}")
//    private String[] allowedFileTypes;

    @Autowired
    PictureRepository pictureRepository;

    private FileStorage fileStorageUtil;



//    public String save(MultipartFile file, int userId, int requestId, int documentTypeId) throws IOException {
//        if(!Arrays.asList(allowedFileTypes).contains(file.getContentType())) {
//            throw new FileSystemException("FILE_BAD_FORMAT");
//        }
//        String pathString = userId + "/" + requestId + "/" + documentTypeId;
//        return saveFileInLocation(file, pathString);
//    }
//
//    private String saveFileInLocation(MultipartFile file, String location) throws IOException {
//        Path path = fileStorageUtil.getRoot().resolve(location);
//        fileStorageUtil.makeDirectoryForUploadsIfNotExisting(path);
//        path = fileStorageUtil.getRoot().resolve(location + "/" + file.getOriginalFilename());
//        Files.copy(file.getInputStream() , path, StandardCopyOption.REPLACE_EXISTING);
//        return path.toString();
//    }

    public List<PictureDTO> listPictures() {
            List<Picture> pictures = pictureRepository.findAll();

            List<PictureDTO> pictureDTOS = new ArrayList<>();
            pictures.forEach(picture -> {
                pictureDTOS.add(new PictureDTO().convertEntityToDto(picture));
            });

            return pictureDTOS;
        }

    public List<PictureDTO> listAcceptedPictures() {

        String status = PictureStatusEnum.Accepted.toString();

        List<Picture> pictures = pictureRepository.findBystatus(status);

        List<PictureDTO> pictureDTOS = new ArrayList<>();
        pictures.forEach(picture -> {
            pictureDTOS.add(new PictureDTO().convertEntityToDto(picture));
        });

        return pictureDTOS;
    }

    public List<PictureDTO> listUnprocessedPictures() {

        String status = PictureStatusEnum.Unprocessed.toString();

        List<Picture> pictures = pictureRepository.findBystatus(status);

        List<PictureDTO> pictureDTOS = new ArrayList<>();
        pictures.forEach(picture -> {
            pictureDTOS.add(new PictureDTO().convertEntityToDto(picture));
        });

        return pictureDTOS;
    }


    public ResponseEntity<Object> addPicture(String username, String password,
                                             String description, MultipartFile attachment, CategoryEnum category) throws Exception {

        Picture picture = new Picture();
        picture.setDescription(description);
        picture.setCategory(category);
        picture.setStatus(PictureStatusEnum.Unprocessed);

        if(attachment.getSize() > 2000000)
        return new ResponseEntity<>("File Size must be less than 2MB" ,HttpStatus.NOT_ACCEPTABLE);


        var file = new File("pictures/"+attachment.getOriginalFilename());

        try (OutputStream os = new FileOutputStream(file)) {
            os.write(attachment.getBytes());
        }

        return null;


    }

    public Integer acceptPictures(PictureRequestDTO pictureRequestDTO) {
        Long pictureID = pictureRequestDTO.getId();
        Picture picture = new Picture();
        picture.setId(pictureRequestDTO.getId());

        picture.setStatus(PictureStatusEnum.Accepted);
        return pictureRepository.updatePicture(pictureID);

    }
}
