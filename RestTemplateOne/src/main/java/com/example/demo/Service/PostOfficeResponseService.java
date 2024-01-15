package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.entity.PostOfficeResponse;


public interface PostOfficeResponseService {
	
	
	
	void savePostOfficeResponse(PostOfficeResponse postOfficeResponse);
	List<PostOfficeResponse> getAllPostOfficeResponse();
	Optional<PostOfficeResponse> getPostOfficeById(int id);

}
