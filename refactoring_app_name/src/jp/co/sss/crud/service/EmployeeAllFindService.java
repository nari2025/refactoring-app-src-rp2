package jp.co.sss.crud.service;

import java.sql.SQLException;
import java.util.List;

import jp.co.sss.crud.db.EmployeeDAO;
import jp.co.sss.crud.dto.Employee;
import jp.co.sss.crud.io.ConsoleWriter;

public class EmployeeAllFindService implements IEmployeeService {
	// DAOのインスタンスを保持
	private final EmployeeDAO employeeDAO = new EmployeeDAO();

	/**
	 * 全ての社員情報を検索するためのビジネスロジック
	 */
	@Override
	public void execute() {
		try {
			// DAOのfindAll()メソッドを呼び出してリストを取得
			List<Employee> allEmployees = employeeDAO.findAll();
			//リストをコンソール出力
			ConsoleWriter.showEmployees(allEmployees);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}