package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.PostOfficeResponse;

public interface PostOfficerResponseRepository extends JpaRepository<PostOfficeResponse, Integer> {

}
