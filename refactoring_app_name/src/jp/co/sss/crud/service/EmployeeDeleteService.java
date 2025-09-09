package jp.co.sss.crud.service;

import java.sql.SQLException;

import jp.co.sss.crud.db.EmployeeDAO;
import jp.co.sss.crud.exception.IllegalInputException;
import jp.co.sss.crud.exception.SystemErrorException;

public class EmployeeDeleteService implements IEmployeeService {
	// DAOのインスタンスを保持
	private final EmployeeDAO employeeDAO = new EmployeeDAO();

	/**
	 * 社員情報を1件削除
	 * @throws IllegalInputException 
	 * @throws SystemErrorException 
	 *
	 */
	@Override
	public void execute() throws SystemErrorException, IllegalInputException {
		try {
			employeeDAO.delete();
		} catch (ClassNotFoundException | SQLException | SystemErrorException | IllegalInputException e) {
			e.printStackTrace();
		}
	}
}
