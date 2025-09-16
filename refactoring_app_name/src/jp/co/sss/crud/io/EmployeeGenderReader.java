package jp.co.sss.crud.io;

import jp.co.sss.crud.util.ConstantMsg;

public class EmployeeGenderReader implements IConsoleReader {
	/**
	 * エラーメッセージの表示
	 * @return エラーメッセージ
	 */
	@Override
	public String getErrorMsg() {
		return ConstantMsg.MSG_GENDER_ERROR;
	}

	/**
	 * バリデーションチェック
	 * @return バリデーションの結果
	 */
	@Override
	public boolean isValid(String inputString) {
		return inputString.matches("^|[0129０１２９]{1}$");
	}

	/**
	 * 数字かどうかの判定
	 * @return 数字のため、trueを返す
	 */
	@Override
	public boolean isParseInt() {
		return true;
	}

}
