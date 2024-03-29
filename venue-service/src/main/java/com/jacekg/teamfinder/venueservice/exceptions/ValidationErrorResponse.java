package com.jacekg.teamfinder.venueservice.exceptions;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.validation.FieldError;

@Getter
@Setter
public class ValidationErrorResponse {
	
	 private int status;
	 
     private String message;
     
     private int errorCode;
     
     private List<FieldError> fieldErrors = new ArrayList<>();

     public ValidationErrorResponse(int status, String message, int errorCode) {
         this.status = status;
         this.message = message;
         this.errorCode = errorCode;
     }

     public void addFieldError(String path, String message) {
         FieldError error = new FieldError(path, message, message);
         fieldErrors.add(error);
     }

     public List<FieldError> getFieldErrors() {
         return fieldErrors;
     }
}

