package jp.co.sss.crud.io;

public class EmployeeGenderReader implements IConsoleReader {

	@Override
	public String getErrorMsg() {
		return "0か1か2か9を入力してください";
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
