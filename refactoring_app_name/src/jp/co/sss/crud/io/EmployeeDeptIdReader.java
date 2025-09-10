package jp.co.sss.crud.io;

import jp.co.sss.crud.util.ConstantMsg;

public class EmployeeDeptIdReader implements IConsoleReader {

	@Override
	public String getErrorMsg() {
		return ConstantMsg.MSG_DEPTID_ERROR;
	}

	@Override
	public boolean isValid(String inputString) {
		return inputString.matches("^[1-3１-３]{1}$");
	}

	@Override
	public boolean isParseInt() {
		return true;
	}

}
