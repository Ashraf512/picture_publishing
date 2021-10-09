package com.nasnav.picturepublishing.repository;

import com.nasnav.picturepublishing.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository <Users, Long>{

     List<Users> findByUsernameAndPassword(String username, String password);
}
