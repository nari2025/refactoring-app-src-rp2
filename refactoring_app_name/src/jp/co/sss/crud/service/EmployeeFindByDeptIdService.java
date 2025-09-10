package jp.co.sss.crud.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import jp.co.sss.crud.db.EmployeeDAO;
import jp.co.sss.crud.dto.Employee;
import jp.co.sss.crud.exception.IllegalInputException;
import jp.co.sss.crud.exception.SystemErrorException;
import jp.co.sss.crud.io.ConsoleWriter;
import jp.co.sss.crud.io.EmployeeDeptIdReader;

public class EmployeeFindByDeptIdService implements IEmployeeService {
	// DAOのインスタンスを保持
	private final EmployeeDAO employeeDAO = new EmployeeDAO();

	/**
	 * 部署IDに該当する社員情報を検索
	 *
	 * @throws ClassNotFoundException ドライバクラスが不在の場合に送出
	 * @throws SQLException           DB処理でエラーが発生した場合に送出
	 * @throws IOException            入力処理でエラーが発生した場合に送出
	 * @throws IllegalInputException 
	 * @throws SystemErrorException 
	 */
	@Override
	public void execute() throws SystemErrorException, IllegalInputException {
		ConsoleWriter.showDeptIdQuestion();
		//検索する部署ID
		EmployeeDeptIdReader employeeDeptIdReader = new EmployeeDeptIdReader();
		int deptId = (Integer) employeeDeptIdReader.input();

		try {
			// DAOのfindByDeptId()メソッドを呼び出してリストを取得
			List<Employee> searchedEmployees = employeeDAO.findByDeptId(deptId);
			//結果をコンソール出力
			ConsoleWriter.showEmployees(searchedEmployees);
		} catch (ClassNotFoundException | SQLException | IOException e) {
			e.printStackTrace();
		}
	}
}
