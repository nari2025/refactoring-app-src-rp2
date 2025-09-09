package jp.co.sss.crud.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import jp.co.sss.crud.db.EmployeeDAO;
import jp.co.sss.crud.dto.Employee;
import jp.co.sss.crud.exception.IllegalInputException;
import jp.co.sss.crud.exception.SystemErrorException;
import jp.co.sss.crud.util.ConstantMsg;

public class EmployeeFindByEmpNameService implements IEmployeeService {
	// DAOのインスタンスを保持
	private final EmployeeDAO employeeDAO = new EmployeeDAO();

	/**
	 * 入力された名前に該当する社員情報を検索するためのビジネスロジック
	 * @throws IllegalInputException 
	 * @throws SystemErrorException 
	 */
	@Override
	public void execute() throws SystemErrorException, IllegalInputException {
		//ここでinput()を記述
		try {
			//DAOのfindByEmployeeName()メソッドを呼び出す
			List<Employee> employees = employeeDAO.findByEmployeeName();
			//レコードを出力
			System.out.println(ConstantMsg.MSG_LIST_CALAM);

			//取得したリストをループで表示
			for (Employee emp : employees) {
				System.out.println(emp);
			}
			System.out.println("");

		} catch (ClassNotFoundException | SQLException | IOException e) {
			// エラーハンドリング（例：エラーメッセージの表示）
			e.printStackTrace();
		}
	}
}
