package edu.poly.exception;

public class UserNotFoundException extends RuntimeException {
	public UserNotFoundException() {
		super(" User Not Found Exception");
	}
}
