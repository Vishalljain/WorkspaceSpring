package com.example.demo.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.demo.exception.CloudVendorNotFoundException;
import com.example.demo.model.CloudVendor;
import com.example.demo.repository.CloudVendorRepository;
public class CloudVendorServiceImplTest3 {
	
	@Mock
    private CloudVendorRepository cloudVendorRepository;
    private CloudVendorServiceImpl cloudVendorService;
    AutoCloseable autoCloseable;
    CloudVendor cloudVendor;
    
    @BeforeEach
    void setUp() {
       autoCloseable = MockitoAnnotations.openMocks(this);
        cloudVendorService = new CloudVendorServiceImpl(cloudVendorRepository);
        cloudVendor = new CloudVendor("1", "Amazon",
               "USA", "xxxxx");
    }
    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }
    
    @Test
    void testCreateCloudVendor() {
        when(cloudVendorRepository.save(cloudVendor)).thenReturn(cloudVendor);
        assertThat(cloudVendorService.createCloudVendor(cloudVendor)).isEqualTo("Success");

    }
    
    @Test
    void testUpdateCloudVendor() {
        when(cloudVendorRepository.save(cloudVendor)).thenReturn(cloudVendor);
        assertThat(cloudVendorService.updateCloudVendor(cloudVendor)).isEqualTo("Success");
    }


    @Test
    void testGetCloudVendor() throws CloudVendorNotFoundException {
        when(cloudVendorRepository.findById("3")).thenReturn(Optional.ofNullable(cloudVendor));
        System.out.println("++++++"+cloudVendor.getVendorId());
        System.out.println("---------"+cloudVendorService.getCloudVendor("3").getVendorId());
        
        assertThat(cloudVendorService.getCloudVendor("3").getVendorName()) .isEqualTo(cloudVendor.getVendorName());
        
    }
    
    
    @Test
    void testGetByVendorName() throws CloudVendorNotFoundException {

        when(cloudVendorRepository.findByVendorName("Amazon1")).
                thenReturn( new ArrayList<CloudVendor>(Collections.singleton(cloudVendor)));

        assertThat(cloudVendorService.getByVendorName("Amazon2").get(0).getVendorId()).
                isEqualTo(cloudVendor.getVendorId());
        
        
        
    }

}
