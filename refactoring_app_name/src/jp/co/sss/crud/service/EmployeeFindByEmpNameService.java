package jp.co.sss.crud.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import jp.co.sss.crud.db.EmployeeDAO;
import jp.co.sss.crud.dto.Employee;
import jp.co.sss.crud.exception.IllegalInputException;
import jp.co.sss.crud.exception.SystemErrorException;
import jp.co.sss.crud.io.ConsoleWriter;
import jp.co.sss.crud.util.EmployeeUtil;

public class EmployeeFindByEmpNameService implements IEmployeeService {
	// DAOのインスタンスを保持
	private final EmployeeDAO employeeDAO = new EmployeeDAO();

	/**
	 * 入力された名前に該当する社員情報を検索するためのビジネスロジック
	 * 
	 * @throws ClassNotFoundException ドライバクラスが不在の場合に送出
	 * @throws SQLException           DB処理でエラーが発生した場合に送出
	 * @throws IOException            入力処理でエラーが発生した場合に送出
	 * @throws IllegalInputException 
	 * @throws SystemErrorException 
	 */
	@Override
	public void execute() throws SystemErrorException, IllegalInputException {
		//検索する社員名の入力
		String searchWord = EmployeeUtil.readEmpName();

		//DAOのfindByEmployeeName()メソッドを呼び出す
		List<Employee> searchedEmployees = employeeDAO.findByEmployeeName(searchWord);
		//結果をコンソール出力
		ConsoleWriter.showEmployees(searchedEmployees);
	}
}
