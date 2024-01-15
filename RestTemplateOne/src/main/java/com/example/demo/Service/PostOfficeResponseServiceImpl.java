package com.example.demo.Service;

import java.util.List;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.PostOfficerResponseRepository;
import com.example.demo.entity.PostOfficeResponse;

@Service
public class PostOfficeResponseServiceImpl implements PostOfficeResponseService {
	
	private static final Logger logger = LoggerFactory.getLogger(PostOfficeResponseServiceImpl.class);

	
	@Autowired
	PostOfficerResponseRepository postOfficeResponseRepository;

	@Override
	public void savePostOfficeResponse(PostOfficeResponse postOfficeResponse) {
		logger.info("Creating a new postOfficeResponse: {}", postOfficeResponse);
		postOfficeResponseRepository.save(postOfficeResponse);
		logger.info("PostOffice created: {}", postOfficeResponse);
		
	}

	@Override
	public List<PostOfficeResponse> getAllPostOfficeResponse() {
		return postOfficeResponseRepository.findAll();
		
	}

	@Override
	public Optional<PostOfficeResponse> getPostOfficeById(int id) {
		
		return postOfficeResponseRepository.findById(id);
	}

}
