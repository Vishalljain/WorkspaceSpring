package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.exception.CloudVendorNotFoundException;
import com.example.demo.exception.NotFoundException;
import com.example.demo.model.CloudVendor;
import com.example.demo.repository.CloudVendorRepository;

@Service
public class CloudVendorServiceImpl implements CloudVendorService {
	
    CloudVendorRepository cloudVendorRepository;

    public CloudVendorServiceImpl(CloudVendorRepository cloudVendorRepository) {
        this.cloudVendorRepository = cloudVendorRepository;
    }

    @Override
    public String createCloudVendor(CloudVendor cloudVendor) {
        // More Business Logic
        cloudVendorRepository.save(cloudVendor);
        return "Success";
    }

    @Override
    public String updateCloudVendor(CloudVendor cloudVendor) {
        // More Business Logic
        cloudVendorRepository.save(cloudVendor);
        return "Success";
    }

    @Override
    public String deleteCloudVendor(String cloudVendorId) {
        // More Business Logic
        cloudVendorRepository.deleteById(cloudVendorId);
        return "Success";
    }

    @Override
    public CloudVendor getCloudVendor(String cloudVendorId) throws CloudVendorNotFoundException {
        // More Business Logic
        if(cloudVendorRepository.findById(cloudVendorId).isPresent()) {
        	System.out.println("here");
        	 return cloudVendorRepository.findById(cloudVendorId).get();
            
        }
        else {
        	throw new CloudVendorNotFoundException("Requested Cloud Vendor does not exist");
        }
       
    }

    @Override
    public List<CloudVendor> getAllCloudVendors() {
        // More Business Logic
        return cloudVendorRepository.findAll();
    }

	@Override
	public List<CloudVendor> getByVendorName(String vendorName) throws CloudVendorNotFoundException {
		
		if(!cloudVendorRepository.findByVendorName(vendorName).isEmpty()) {
			List<CloudVendor> findByVendorName = cloudVendorRepository.findByVendorName(vendorName);
			return findByVendorName;
		}
		else {
			
			throw new CloudVendorNotFoundException("Requested Cloud Vendor does not exist");
		}
		
	}

   
}

