package com.example.demo.exception;

public class CloudVendorNotFoundException extends Exception {

	 public CloudVendorNotFoundException(String message) {
	        super(message);
	    }

	    public CloudVendorNotFoundException(String message, Throwable cause) {
	        super(message, cause);
	    }

}
