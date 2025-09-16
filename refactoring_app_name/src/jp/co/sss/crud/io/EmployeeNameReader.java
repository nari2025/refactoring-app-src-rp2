package jp.co.sss.crud.io;

import jp.co.sss.crud.util.ConstantMsg;

public class EmployeeNameReader implements IConsoleReader {
	/**
	 * エラーメッセージの表示
	 * @return エラーメッセージ
	 */
	@Override
	public String getErrorMsg() {
		return ConstantMsg.MSG_EMPNAME_ERROR;
	}

	/**
	 * バリデーションチェック
	 * @return バリデーションの結果
	 */
	@Override
	public boolean isValid(String inputString) {
		return inputString.length() >= 1 && 30 >= inputString.length();
	}

	/**
	 * 数字かどうかの判定
	 * @return 数字ではないためfalseを返す
	 */
	@Override
	public boolean isParseInt() {
		return false;
	}

}
