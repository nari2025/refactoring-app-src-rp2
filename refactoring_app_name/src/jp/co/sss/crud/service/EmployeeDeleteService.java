package jp.co.sss.crud.service;

import java.sql.SQLException;

import jp.co.sss.crud.db.EmployeeDAO;
import jp.co.sss.crud.exception.IllegalInputException;
import jp.co.sss.crud.exception.SystemErrorException;
import jp.co.sss.crud.io.ConsoleWriter;
import jp.co.sss.crud.io.EmployeeEmpIdReader;

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
		ConsoleWriter.showDeleteQuestion();
		//削除する社員のIDを入力
		EmployeeEmpIdReader employeeEmpIdReader = new EmployeeEmpIdReader();
		int empId = (Integer) employeeEmpIdReader.input();
		try {
			employeeDAO.delete(empId);
		} catch (ClassNotFoundException | SQLException | SystemErrorException | IllegalInputException e) {
			e.printStackTrace();
		}

	}
}
