package jp.co.sss.crud.service;

import java.sql.SQLException;
import java.text.ParseException;

import jp.co.sss.crud.db.EmployeeDAO;
import jp.co.sss.crud.exception.IllegalInputException;
import jp.co.sss.crud.exception.SystemErrorException;

public class EmployeeRegisterService implements IEmployeeService {
	// DAOのインスタンスを保持
	private final EmployeeDAO employeeDAO = new EmployeeDAO();

	/**
	 * 社員情報を1件登録
	 * @throws IllegalInputException 
	 * @throws SystemErrorException 
	 * 
	 * 
	 */
	@Override
	public void execute() throws SystemErrorException, IllegalInputException {

		try {
			employeeDAO.insert();
		} catch (ClassNotFoundException | SQLException | ParseException e) {
			e.printStackTrace();
		}
	}
}