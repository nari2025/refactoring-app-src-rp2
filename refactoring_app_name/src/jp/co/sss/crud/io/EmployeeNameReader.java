package jp.co.sss.crud.io;

import jp.co.sss.crud.util.ConstantMsg;

public class EmployeeNameReader implements IConsoleReader {

	@Override
	public String getErrorMsg() {
		return ConstantMsg.MSG_EMPNAME_ERROR;
	}

	@Override
	public boolean isValid(String inputString) {
		return inputString.length() >= 1 && 30 >= inputString.length();
	}

	@Override
	public boolean isParseInt() {
		return false;
	}

}
