package jp.co.sss.crud.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import jp.co.sss.crud.db.EmployeeDAO;
import jp.co.sss.crud.dto.Employee;
import jp.co.sss.crud.util.ConstantMsg;

public class EmployeeFindByEmpNameService implements IEmployeeService {
	// DAOのインスタンスを保持
	private final EmployeeDAO employeeDAO = new EmployeeDAO();

	/**
	 * 社員名に該当する社員情報を検索
	 *
	 * @throws ClassNotFoundException ドライバクラスが不在の場合に送出
	 * @throws SQLException           DB処理でエラーが発生した場合に送出
	 * @throws IOException            入力処理でエラーが発生した場合に送出
	 */
	public List<Employee> findByEmployeeName()
			throws ClassNotFoundException, SQLException, IOException {

		List<Employee> employees = employeeDAO.findByEmployeeName();

		System.out.println(ConstantMsg.MSG_LIST_CALAM);
		// DAOのfindAll()メソッドを呼び出してリストを取得
		for (Employee emp : employees) {
			System.out.println(emp);
		}
		System.out.println("");

		return employees;
	}

	@Override
	public void execute() {
		// TODO 自動生成されたメソッド・スタブ

	}
}
