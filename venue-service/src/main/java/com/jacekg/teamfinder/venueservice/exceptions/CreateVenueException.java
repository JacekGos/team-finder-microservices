package com.jacekg.teamfinder.venueservice.exceptions;

public class CreateVenueException extends RuntimeException {

	public CreateVenueException(String message, Throwable cause) {
		super(message, cause);
	}

	public CreateVenueException(String message) {
		super(message);
	}

	public CreateVenueException(Throwable cause) {
		super(cause);
	}
}