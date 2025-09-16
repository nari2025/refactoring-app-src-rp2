package jp.co.sss.crud.io;

import jp.co.sss.crud.util.ConstantMsg;

public class EmployeeEmpIdReader implements IConsoleReader {
	/**
	 * エラーメッセージの表示
	 * @return エラーメッセージ
	 */
	@Override
	public String getErrorMsg() {
		return ConstantMsg.MSG_EMPID_ERROR;
	}

	/**
	 * バリデーションチェック
	 * @return バリデーションの結果
	 */
	@Override
	public boolean isValid(String inputString) {
		return inputString.matches("^[1-9１-９]{1}[0-9１-９]{0,3}$");
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
