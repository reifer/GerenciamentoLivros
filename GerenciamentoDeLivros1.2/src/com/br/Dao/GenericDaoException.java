package com.br.Dao;

public class GenericDaoException extends Exception {
	private static final long serialVersionUID = 8360898015631083132L;

	public GenericDaoException() {
	}

	public GenericDaoException(String arg0) {
		super(arg0);
	}

	public GenericDaoException(Throwable arg0) {
		super(arg0);
	}

	public GenericDaoException(String message, Throwable cause) {
		super(message, cause);
	}

	public GenericDaoException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
