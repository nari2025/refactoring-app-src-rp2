package jp.co.sss.crud.exception;

import java.io.IOException;

public class SystemErrorException extends Exception {

	public SystemErrorException(String msgSystemError, IOException e) {
		super(msgSystemError, e);
	}

}
