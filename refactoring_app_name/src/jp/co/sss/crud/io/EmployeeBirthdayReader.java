package jp.co.sss.crud.io;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import jp.co.sss.crud.util.ConstantMsg;

public class EmployeeBirthdayReader implements IConsoleReader {
	/**
	 * エラーメッセージの表示
	 * @return エラーメッセージ
	 */
	@Override
	public String getErrorMsg() {
		return ConstantMsg.MSG_BITHDAY_ERROR;
	}

	/**
	 * バリデーションチェック
	 * @return バリデーションの結果
	 */
	@Override
	public boolean isValid(String inputString) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		// setLenient(false)で厳密な日付チェックを行う（例: 2023/02/30は無効）
		sdf.setLenient(false);

		try {
			// parseメソッドで文字列をDate型に変換してみる
			sdf.parse(inputString);
			// 変換に成功すれば有効
			return true;
		} catch (ParseException e) {
			// 変換に失敗すれば無効
			return false;
		}
	}

	/**
	 * 数字かどうかの判定
	 * @return 数字ではないｔめfalseを返す
	 */
	@Override
	public boolean isParseInt() {
		return false;
	}
}
