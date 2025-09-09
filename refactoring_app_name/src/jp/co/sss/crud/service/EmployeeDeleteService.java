package jp.co.sss.crud.service;

import java.io.IOException;
import java.sql.SQLException;

import jp.co.sss.crud.db.EmployeeDAO;
import jp.co.sss.crud.util.ConstantMsg;

public class EmployeeDeleteService implements IEmployeeService {
	// DAOのインスタンスを保持
	private final EmployeeDAO employeeDAO = new EmployeeDAO();

	/**
	 * 社員情報を1件削除
	 *
	 * @throws ClassNotFoundException ドライバクラスが不在の場合に送出
	 * @throws SQLException           DB処理でエラーが発生した場合に送出
	 * @throws IOException            入力処理でエラーが発生した場合に送出
	 */
	public void delete() {
		employeeDAO.delete();
		System.out.println(ConstantMsg.MSG_DELETE_COMPLETE);
	}

	@Override
	public void execute() {
		// TODO 自動生成されたメソッド・スタブ

	}
}
