package jp.co.sss.crud.io;

import jp.co.sss.crud.util.ConstantMsg;

public class EmployeeGenderReader implements IConsoleReader {

	@Override
	public String getErrorMsg() {
		return ConstantMsg.MSG_GENDER_ERROR;
	}

	@Override
	public boolean isValid(String inputString) {
		return inputString.matches("^|[0129０１２９]{1}$");
	}

	@Override
	public boolean isParseInt() {
		return true;
	}

}
