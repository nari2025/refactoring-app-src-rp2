package jp.co.sss.crud.main;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

import jp.co.sss.crud.exception.IllegalInputException;
import jp.co.sss.crud.exception.SystemErrorException;
import jp.co.sss.crud.io.ConsoleWriter;
import jp.co.sss.crud.io.MenuNoReader;
import jp.co.sss.crud.service.IEmployeeService;
import jp.co.sss.crud.util.ConstantMsg;
import jp.co.sss.crud.util.ConstantValue;

/**
 * 社員情報管理システム開始クラス 社員情報管理システムはこのクラスから始まる。<br/>
 * メニュー画面を表示する。
 * 
 * 初回のコード変更（3回目）
 *
 * @author System Shared
 *
 */
public class MainSystem {

	/**
	 * 社員管理システムを起動
	 *
	 * @throws IOException 
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 * @throws ParseException 
	 * @throws IllegalInputException 
	 * @throws SystemErrorException 
	 */
	public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException, ParseException,
			SystemErrorException, IllegalInputException {
		MenuNoReader menuNoReader = new MenuNoReader();
		int menuNo = 0;

		do {
			try {
				ConsoleWriter.showMenu();
				//メニュー番号の入力
				menuNo = (int) menuNoReader.input();
				IEmployeeService service = IEmployeeService.getInstanceByMenuNo(menuNo);

				if (service != null) {
					// サービスを実行
					service.execute();
				}
			} catch (SystemErrorException e) {
				// システムエラーが発生した場合
				System.out.println(e.getMessage());
				e.printStackTrace();
				break;
			} catch (IllegalInputException e) {
				// 不正な入力があった場合
				System.out.println(e.getMessage());
				System.out.println();
				continue;
			}

		} while (menuNo != ConstantValue.FINISH);
		System.out.println(ConstantMsg.MSG_FINISH);
	}
}
