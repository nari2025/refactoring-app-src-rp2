package jp.co.sss.crud.service;

import java.sql.SQLException;
import java.util.List;

import jp.co.sss.crud.db.EmployeeDAO;
import jp.co.sss.crud.dto.Employee;
import jp.co.sss.crud.util.ConstantMsg;

public class EmployeeAllFindService implements IEmployeeService {
	// DAOのインスタンスを保持
	private final EmployeeDAO employeeDAO = new EmployeeDAO();

	/**
	 * 全ての社員情報を検索するためのビジネスロジック
	 */
	@Override
	public void execute() {
		try {
			// レコードを出力
			System.out.println(ConstantMsg.MSG_LIST_CALAM);

			// DAOのfindAll()メソッドを呼び出してリストを取得
			List<Employee> allEmployees = employeeDAO.findAll();

			// 取得したリストをループ処理で表示
			for (Employee emp : allEmployees) {
				System.out.println(emp);
			}
			System.out.println("");

		} catch (ClassNotFoundException | SQLException e) {
			// エラーハンドリング（例：エラーメッセージの表示）
			e.printStackTrace();
		}
	}

}