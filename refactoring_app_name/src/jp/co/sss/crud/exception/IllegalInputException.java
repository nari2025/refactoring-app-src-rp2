package jp.co.sss.crud.exception;

public class IllegalInputException extends Exception {
	/**
	* 入力値に誤りがあった際に送出する例外クラス
	*
	*/
	public IllegalInputException(String errorMsg) {
		super(errorMsg);
	}

}
