package jp.co.sss.crud.io;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class EmployeeBirthdayReader implements IConsoleReader {

	@Override
	public String getErrorMsg() {
		return "正しい形式(西暦年/月/日)で日付を入力してください";
	}

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

	@Override
	public boolean isParseInt() {
		return false;
	}
}
