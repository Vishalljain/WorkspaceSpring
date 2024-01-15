package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.exception.CloudVendorNotFoundException;
import com.example.demo.exception.NotFoundException;
import com.example.demo.model.CloudVendor;
import com.example.demo.response.ResponseHandler;
import com.example.demo.service.CloudVendorService;

import io.swagger.annotations.ApiOperation;

import java.util.List;

@RestController
@RequestMapping("/cloudvendor")
public class CloudVendorController
{
    CloudVendorService cloudVendorService;

    public CloudVendorController(CloudVendorService cloudVendorService) {
        this.cloudVendorService = cloudVendorService;
    }

    @GetMapping("/{vendorId}")
    @ApiOperation(value ="Cloud vendor id", notes="Provide cloud vendor details",response = ResponseEntity.class)
    public ResponseEntity<Object> getCloudVendorDetails(@PathVariable("vendorId") String vendorId) throws CloudVendorNotFoundException
    {
       return ResponseHandler.responseBuilder("Requested Vendor Details are given here",
                HttpStatus.OK, cloudVendorService.getCloudVendor(vendorId));
    }

    @GetMapping("/")
    public ResponseEntity<List<CloudVendor>> getAllCloudVendorDetails()
    {
    	return new ResponseEntity<List<CloudVendor>>(cloudVendorService.getAllCloudVendors(),HttpStatus.OK);
        
    }

    @PostMapping("/")
    public String createCloudVendorDetails(@RequestBody CloudVendor cloudVendor)
    {
        cloudVendorService.createCloudVendor(cloudVendor);
        return "Cloud Vendor Created Successfully";
    }

    @PutMapping("/")
    public String updateCloudVendorDetails(@RequestBody CloudVendor cloudVendor)
    {
        cloudVendorService.updateCloudVendor(cloudVendor);
        return "Cloud Vendor Updated Successfully";
    }

    @DeleteMapping("/{vendorId}")
    public String deleteCloudVendorDetails(@PathVariable("vendorId") String vendorId)
    {
        cloudVendorService.deleteCloudVendor(vendorId);
        return "Cloud Vendor Deleted Successfully";
    }
    
    @GetMapping("name/{vendorName}")
    public List<CloudVendor> getCloudVendorByName(@PathVariable("vendorName") String vendorName) throws NotFoundException,CloudVendorNotFoundException {
    	
//    	if(cloudVendorService.getByVendorName(vendorName).isEmpty()) {
//    		System.out.println("================");
//    		System.out.println("inside if");
//    		throw new NotFoundException("Not Found user with "+vendorName);
//    		
//    	}
    	System.out.println("inside else");
		List<CloudVendor> byVendorName = cloudVendorService.getByVendorName(vendorName);
		return byVendorName;
    	
    }
}