package jp.co.sss.crud.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import jp.co.sss.crud.db.EmployeeDAO;
import jp.co.sss.crud.dto.Department;
import jp.co.sss.crud.exception.IllegalInputException;
import jp.co.sss.crud.exception.SystemErrorException;
import jp.co.sss.crud.util.ConstantMsg;

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
		try {
			// DAOのfindByDeptId()メソッドを呼び出してリストを取得
			List<Department> department = employeeDAO.findByDeptId();
			// レコードを出力
			System.out.println(ConstantMsg.MSG_LIST_CALAM);
			//取得したリストをループで表示
			for (Department emp : department) {
				System.out.println(emp);
			}
			System.out.println("");
		} catch (ClassNotFoundException | SQLException | IOException e) {
			// エラーハンドリング（例：エラーメッセージの表示）
			e.printStackTrace();
		}
	}
}
