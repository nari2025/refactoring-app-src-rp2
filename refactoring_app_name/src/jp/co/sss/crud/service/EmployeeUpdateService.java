package jp.co.sss.crud.service;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

import jp.co.sss.crud.db.EmployeeDAO;
import jp.co.sss.crud.exception.IllegalInputException;
import jp.co.sss.crud.exception.SystemErrorException;
import jp.co.sss.crud.util.ConstantMsg;

public class EmployeeUpdateService implements IEmployeeService {
	// DAOのインスタンスを保持
	private final EmployeeDAO employeeDAO = new EmployeeDAO();

	/**
	 * 社員情報を1件更新
	 * @throws IllegalInputException 
	 * @throws SystemErrorException 
	 * 
	 * 
	 */
	@Override
	public void execute() throws SystemErrorException, IllegalInputException {
		System.out.print(ConstantMsg.MSG_UPDATE_QUESTION);

		try {
			employeeDAO.update();
		} catch (ClassNotFoundException | SQLException | IOException | ParseException e) {
			e.printStackTrace();
		}
	}

}
