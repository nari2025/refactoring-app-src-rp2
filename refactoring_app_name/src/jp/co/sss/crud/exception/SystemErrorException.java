package jp.co.sss.crud.exception;

public class SystemErrorException extends Exception {
	/**
	* システムにエラー、その他のエラーがあった際に送出する例外クラス
	* 
	*/
	public SystemErrorException(String msgSystemError, Exception e) {
		super(msgSystemError, e);
	}

}
