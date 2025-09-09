package jp.co.sss.crud.service;

import java.io.IOException;

import jp.co.sss.crud.exception.IllegalInputException;
import jp.co.sss.crud.exception.SystemErrorException;
import jp.co.sss.crud.io.ConsoleWriter;
import jp.co.sss.crud.util.ConstantMsg;
import jp.co.sss.crud.util.ConstantValue;

/**
 * 社員管理のためのビジネスロジックインターフェース
 */
public interface IEmployeeService {

	/**
	 * サービスクラスのインスタンスを生成する
	 * @param menuNo
	 * @return IEmployeeServiceを実装したサービスクラス
	 * @throws IOException 
	 */
	public static IEmployeeService getInstanceByMenuNo() throws IOException {
		IEmployeeService newInstance = null;

		ConsoleWriter consoleWriter = new ConsoleWriter();
		int menuNo = consoleWriter.menuSelect();
		/*====menuNoごとにインスタンスを生成する。必要に応じてcaseを追加する====*/
		switch (menuNo) {
		//menu1 全件検索
		case ConstantValue.FIND_ALL:
			newInstance = new EmployeeAllFindService();
			break;
		case ConstantValue.FIND_NAME:
			newInstance = new EmployeeFindByEmpNameService();
			break;
		case ConstantValue.FIND_ID:
			newInstance = new EmployeeFindByDeptIdService();
			break;
		case ConstantValue.CREATE:
			newInstance = new EmployeeRegisterService();
			break;
		case ConstantValue.UPDATE:
			newInstance = new EmployeeUpdateService();
			break;
		case ConstantValue.DELETE:
			newInstance = new EmployeeDeleteService();
			break;
		case ConstantValue.FINISH:
			System.out.println(ConstantMsg.MSG_FINISH);
			break;

		}
		return newInstance;
	}

	/**
	 * ビジネスロジックの実行
	 * DAOのメソッドを呼び出し、ユースケース（登録や更新）を実装する
	 * また実行結果のコンソールへの表示を行う
	 * 
	 * @throws SystemErrorException, IllegalInputException
	 */
	public void execute() throws SystemErrorException, IllegalInputException;

}
