package jp.co.sss.crud.service;

import jp.co.sss.crud.db.EmployeeDAO;
import jp.co.sss.crud.exception.IllegalInputException;
import jp.co.sss.crud.exception.SystemErrorException;
import jp.co.sss.crud.util.EmployeeUtil;

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
		//削除する社員IDの入力
		int empId = EmployeeUtil.readDeleteeEmpId();
		try {
			employeeDAO.delete(empId);
		} catch (SystemErrorException e) {
			e.printStackTrace();
		}

	}
}
