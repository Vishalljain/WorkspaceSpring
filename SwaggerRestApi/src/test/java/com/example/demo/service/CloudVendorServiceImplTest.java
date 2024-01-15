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
@ExtendWith(MockitoExtension.class)

public class CloudVendorServiceImplTest {
	
	@Mock
    private CloudVendorRepository cloudVendorRepository;
	@InjectMocks
    private CloudVendorServiceImpl cloudVendorService;
    CloudVendor cloudVendor;
    
    @BeforeEach
    void setUp() {
        cloudVendor = new CloudVendor("1", "Amazon",
               "USA", "xxxxx");
    }
    @AfterEach
    void tearDown() throws Exception {
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

/*
 so in service class let it be constructorinjection or fieldinjection but in testing can we use @InjectMock

Yes, in the test class, you can use @InjectMocks regardless of whether the service class uses constructor injection or field injection for its dependencies. 
The purpose of @InjectMocks is to create an instance of the class under test and automatically inject the mock objects into it, regardless of how the
 dependencies are initialized in the actual service class.

Here's a summary of how @InjectMocks works:

In constructor injection, you use the constructor to explicitly inject the dependencies, and @InjectMocks will use that constructor to create an instance of the class 
under test and inject the mock dependencies.

In field injection, you use annotations like @Autowired or @Mock to inject the dependencies directly into the fields of the service class, and @InjectMocks will 
create an instance of the class under test and inject the mock dependencies directly into those fields.

Regardless of whether the dependencies are injected via the constructor or fields, Mockito will handle the injection of mock objects into the service class when you use @InjectMocks in the test class.

So, to summarize, you can use @InjectMocks in your test class, regardless of whether your service class uses constructor injection or field injection for its 
dependencies. Mockito will take care of injecting the mock objects correctly into the class under test. This allows you to focus on writing your test cases without worrying about manually managing the dependencies.
 */
