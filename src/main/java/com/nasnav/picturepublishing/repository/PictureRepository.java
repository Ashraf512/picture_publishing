package com.nasnav.picturepublishing.repository;

import com.nasnav.picturepublishing.entity.Picture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PictureRepository extends JpaRepository <Picture,Long> {

    List<Picture> findBystatus (String status);

    @Modifying
    @Query("update Picture p set p.status = 'Accepted' where p.id = ?1")
     int updatePicture(Long id) ;

    }



