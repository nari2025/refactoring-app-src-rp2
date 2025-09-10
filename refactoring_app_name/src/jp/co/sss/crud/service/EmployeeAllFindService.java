package jp.co.sss.crud.service;

import java.util.List;

import jp.co.sss.crud.db.EmployeeDAO;
import jp.co.sss.crud.dto.Employee;
import jp.co.sss.crud.exception.SystemErrorException;
import jp.co.sss.crud.io.ConsoleWriter;

public class EmployeeAllFindService implements IEmployeeService {
	// DAOのインスタンスを保持
	private final EmployeeDAO employeeDAO = new EmployeeDAO();

	/**
	 * 全ての社員情報を検索するためのビジネスロジック
	 * @throws SystemErrorException 
	 */
	@Override
	public void execute() throws SystemErrorException {
		// DAOのfindAll()メソッドを呼び出してリストを取得
		List<Employee> allEmployees = employeeDAO.findAll();
		//リストをコンソール出力
		ConsoleWriter.showEmployees(allEmployees);
	}
}