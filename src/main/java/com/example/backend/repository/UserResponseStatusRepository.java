package com.example.backend.repository;

import com.example.backend.model.entity.UserResponseStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserResponseStatusRepository extends JpaRepository<UserResponseStatus, Integer> {


}
