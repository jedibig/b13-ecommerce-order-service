package com.b13.orderservice.exception;

public class DaoException extends RuntimeException {

	private static final long serialVersionUID = 7994369471237629061L;

	public DaoException() {
		super("Got exception while performing exception to the database");
		
	}

	public DaoException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public DaoException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public DaoException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

}
