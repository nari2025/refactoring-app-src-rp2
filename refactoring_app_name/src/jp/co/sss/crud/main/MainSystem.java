package jp.co.sss.crud.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.text.ParseException;

import jp.co.sss.crud.service.EmployeeAllFindService;
import jp.co.sss.crud.service.EmployeeDeleteService;
import jp.co.sss.crud.service.EmployeeFindByDeptIdService;
import jp.co.sss.crud.service.EmployeeFindByEmpNameService;
import jp.co.sss.crud.service.EmployeeRegisterService;
import jp.co.sss.crud.service.EmployeeUpdateService;
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
	 */
	public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException, ParseException {

		EmployeeAllFindService employeeAllFindService = new EmployeeAllFindService();
		EmployeeFindByEmpNameService employeeFindByEmpNameService = new EmployeeFindByEmpNameService();
		EmployeeFindByDeptIdService employeeFindByDeptIdService = new EmployeeFindByDeptIdService();
		EmployeeRegisterService employeeRegisterService = new EmployeeRegisterService();
		EmployeeUpdateService employeeUpdateService = new EmployeeUpdateService();
		EmployeeDeleteService employeeDeleteService = new EmployeeDeleteService();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int menuNo = 0;

		do {
			// メニューの表示
			System.out.println("=== 社員管理システム ===");
			System.out.println("1.全件表示");
			System.out.println("2.社員名検索");
			System.out.println("3.部署ID検索");
			System.out.println("4.新規登録");
			System.out.println("5.更新");
			System.out.println("6.削除");
			System.out.println("7.終了");
			System.out.print("メニュー番号を入力してください：");

			// メニュー番号の入力
			String menuNoStr = br.readLine();
			menuNo = Integer.parseInt(menuNoStr);

			// 機能の呼出
			switch (menuNo) {
			case ConstantValue.FIND_ALL:
				// 全件表示機能の呼出
				employeeAllFindService.findAll();
				break;

			case ConstantValue.FIND_NAME:
				// 社員名検索
				System.out.print("社員名:");

				// 検索機能の呼出
				employeeFindByEmpNameService.findByEmployeeName();
				break;

			case ConstantValue.FIND_ID:
				// 検索する部署IDを入力
				System.out.print("部署ID(1:営業部、2:経理部、3:総務部)を入力してください:");
				String searchDeptId = br.readLine();

				// 検索機能の呼出
				employeeFindByDeptIdService.findByDeptId(searchDeptId);
				break;

			case ConstantValue.CREATE:
				// 登録する値を入力
				System.out.print("社員名:");
				String emp_name = br.readLine();
				System.out.print("性別(0:その他, 1:男性, 2:女性, 9:回答なし):");
				String gender = br.readLine();
				System.out.print("生年月日(西暦年/月/日):");
				String birthday = br.readLine();
				System.out.print("部署ID(1:営業部、2:経理部、3:総務部):");
				String registerDeptId = br.readLine();

				// 登録機能の呼出
				employeeRegisterService.insert(emp_name, gender, birthday, registerDeptId);
				break;

			case ConstantValue.UPDATE:
				// 更新する社員IDを入力
				System.out.print(ConstantMsg.MSG_UPDATE_QUESTION);

				// 更新する値を入力する
				String updateEmpId = br.readLine();
				Integer.parseInt(updateEmpId);

				// 更新機能の呼出
				employeeUpdateService.update(updateEmpId);
				System.out.println(ConstantMsg.MSG_UPDATE_COMPLETE);

				break;

			case ConstantValue.DELETE:
				// 削除する社員IDを入力
				System.out.print(ConstantMsg.MSG_DELETE_QUESTION);

				// 削除機能の呼出
				employeeDeleteService.delete();
				break;

			}
		} while (menuNo != ConstantValue.FINISH);
		System.out.println(ConstantMsg.MSG_FINISH);
	}
}
