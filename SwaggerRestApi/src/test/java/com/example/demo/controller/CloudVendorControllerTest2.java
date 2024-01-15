package com.example.demo.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.example.demo.model.CloudVendor;
import com.example.demo.service.CloudVendorService;


@WebMvcTest(CloudVendorController.class)
public class CloudVendorControllerTest2 {
	
	@MockBean
    private CloudVendorService cloudVendorService;

	 @Autowired
	 private MockMvc mockMvc;
    
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
    void testGetCloudVendorDetails() throws Exception {
        // Given
        String vendorId = "123"; // Replace with a valid vendorId
        CloudVendor vendor = new CloudVendor("123", "Amazon", "USA", "xxxxx");
        Mockito.when(cloudVendorService.getCloudVendor(vendorId)).thenReturn((vendor));

        // When
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("http://localhost:8080/cloudvendor/" + vendorId)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("Requested Vendor Details are given here"))
                .andReturn();
    }
    
    
    @Test
    void testGetAllCloudVendorDetails() throws Exception {
        // Given
        List<CloudVendor> cloudVendors = Arrays.asList(
            new CloudVendor("1", "Amazon", "USA", "xxxxx"),
            new CloudVendor("2", "Google", "USA", "yyyyy")
            // Add more sample CloudVendor objects as needed
        );

        when(cloudVendorService.getAllCloudVendors()).thenReturn(cloudVendors);

        // When
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("http://localhost:8080/cloudvendor/")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        // Then
        // Perform additional assertions as needed
        // For example, you can check the response content, JSON structure, etc.
    }
    
    @Test
    void testCreateCloudVendorDetails() throws Exception {
        // Given
        String requestBody = "{\"id\":\"1\", \"name\":\"Amazon\", \"location\":\"USA\", \"description\":\"xxxxx\"}";

        // When
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("http://localhost:8080/cloudvendor/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBody))
                .andExpect(status().isOk())
                .andReturn();

        // Then
        // Verify that the cloudVendorService's createCloudVendor method is called with the correct CloudVendor object
           //verify(cloudVendorService).createCloudVendor((CloudVendor) any(CloudVendor.class));

        // Perform additional assertions as needed for the response content
        // For example, you can check the response body content:
        // String responseBody = result.getResponse().getContentAsString();
        // assertEquals("Cloud Vendor Created Successfully", responseBody);
    }


    
    
    /*
When writing unit tests for your controller classes, you have the flexibility to choose different testing approaches based on your needs. The choice between using @ExtendWith(MockitoExtension.class) and @WebMvcTest(CloudVendorController.class) depends on the scope of the test and what you want to achieve.

Using @ExtendWith(MockitoExtension.class):
This approach is typically used for plain unit tests where you want to test the controller in isolation from the Spring framework. It doesn't load the full Spring application context, and therefore, the application won't start during the test.
You manually create mock objects using @Mock, and you inject them into the controller using @InjectMocks. This approach is useful when you want to focus on testing the behavior of the controller and its interaction with the mocked dependencies.
With this approach, you don't test the actual request mapping, request handling, or the integration of the controller with other components in the Spring context.

Using @WebMvcTest(CloudVendorController.class):
This approach is used for more extensive testing involving Spring's MVC infrastructure. It loads only the required parts of the Spring application context related to the specified controller class.
The application starts up with a minimal Spring context, including the controller and its associated components like the HandlerMapping, HandlerAdapter, etc.
This allows you to test the actual request mapping, request handling, and the integration of the controller with the Spring MVC infrastructure.
For dependencies of the controller, you can use @MockBean to mock them and provide controlled behavior during the test.
     
In summary, use @ExtendWith(MockitoExtension.class) for isolated unit testing of the controller's behavior, and use @WebMvcTest(CloudVendorController.class) for more extensive integration testing, including the interaction with the Spring MVC infrastructure and handling of actual HTTP requests.

     */

    
}
    


