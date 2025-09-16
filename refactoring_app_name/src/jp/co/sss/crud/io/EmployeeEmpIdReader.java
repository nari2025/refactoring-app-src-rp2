package jp.co.sss.crud.io;

import jp.co.sss.crud.util.ConstantMsg;

public class  implements IConsoleReader {

	@Override
	public String getErrorMsg() {
		return ConstantMsg.MSG_EMPID_ERROR;
	}

	@Override
	public boolean isValid(String inputString) {
		return inputString.matches("^[1-9１-９]{1}[0-9１-９]{0,3}$");
	}

	@Override
	public boolean isParseInt() {
		return true;
	}
}
