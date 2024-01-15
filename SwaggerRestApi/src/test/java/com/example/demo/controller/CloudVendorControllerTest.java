package com.example.demo.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.demo.controller.CloudVendorController;
import com.example.demo.exception.CloudVendorNotFoundException;
import com.example.demo.model.CloudVendor;
import com.example.demo.service.CloudVendorService;

@ExtendWith(MockitoExtension.class)
public class CloudVendorControllerTest {
	
	@Mock
    private CloudVendorService cloudVendorService;

    @InjectMocks
    private CloudVendorController cloudVendorController;
    
    List<CloudVendor> mockCloudVendors;

	private CloudVendor cloudVendor;
    
    @BeforeEach
    void setUp() {
    	
    	cloudVendor = new CloudVendor("1", "Amazon", "USA", "xxxxx");
    	
    	mockCloudVendors = new ArrayList<>();
         // Add some mock data to the list
         mockCloudVendors.add(new CloudVendor("1", "Amazon", "USA", "xxxxx"));
         mockCloudVendors.add(new CloudVendor("2", "Microsoft", "USA", "yyyyy"));
    }
    
    @Test
    void testGetAllCloudVendorDetails() {
        when(cloudVendorService.getAllCloudVendors()).thenReturn(mockCloudVendors);
        ResponseEntity<List<CloudVendor>> responseEntity = cloudVendorController.getAllCloudVendorDetails();
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        
    }
    
    @Test
    void testGetAllCloudVendorDetailsFailed() {
        when(cloudVendorService.getAllCloudVendors()).thenReturn(mockCloudVendors);
        ResponseEntity<List<CloudVendor>> responseEntity = cloudVendorController.getAllCloudVendorDetails();
       // assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.ACCEPTED);
        
    }
    
    
    @Test
    void testGetAllCloudVendorDetailsById() throws CloudVendorNotFoundException {
    	 when(cloudVendorService.getCloudVendor("1")).thenReturn(cloudVendor);
    	 ResponseEntity<Object> cloudVendorDetails = (ResponseEntity<Object>) cloudVendorController.getCloudVendorDetails("1");
    	 assertThat(cloudVendorDetails.getStatusCode()).isEqualTo(HttpStatus.OK);
    	 Map<String, Object> responseMap = (Map<String, Object>) cloudVendorDetails.getBody();
    	 System.out.println(responseMap.get("message"));//Requested Vendor Details are given here
    	 System.out.println(responseMap.get("httpStatus"));//200 OK
    	 System.out.println(responseMap.get("data"));//com.example.demo.model.CloudVendor@30e868be
    	 assertThat(responseMap.get("message")).isEqualTo("Requested Vendor Details are given here");
    	 assertThat(responseMap.get("httpStatus")).isEqualTo(HttpStatus.OK);
    	 assertThat(responseMap.get("data")).isEqualTo(cloudVendor);
    	
    }
    
}
    


