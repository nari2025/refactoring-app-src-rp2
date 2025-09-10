package jp.co.sss.crud.service;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

import jp.co.sss.crud.db.EmployeeDAO;
import jp.co.sss.crud.exception.IllegalInputException;
import jp.co.sss.crud.exception.SystemErrorException;
import jp.co.sss.crud.io.ConsoleWriter;
import jp.co.sss.crud.io.EmployeeBirthdayReader;
import jp.co.sss.crud.io.EmployeeDeptIdReader;
import jp.co.sss.crud.io.EmployeeEmpIdReader;
import jp.co.sss.crud.io.EmployeeGenderReader;
import jp.co.sss.crud.io.EmployeeNameReader;

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
		ConsoleWriter.showUpdateQuestion();
		//更新する社員のID
		EmployeeEmpIdReader employeeEmpIdReader = new EmployeeEmpIdReader();
		int empId = (Integer) employeeEmpIdReader.input();

		// 名前を入力
		EmployeeNameReader employeeNameReader = new EmployeeNameReader();
		ConsoleWriter.showEmpNameQuestion();
		String empName = (String) employeeNameReader.input();
		// 性別を入力
		EmployeeGenderReader employeeGenderReader = new EmployeeGenderReader();
		ConsoleWriter.showGenderQuestion();
		int gender = (Integer) employeeGenderReader.input();
		// 誕生日を入力
		EmployeeBirthdayReader employeeBirthdayReader = new EmployeeBirthdayReader();
		ConsoleWriter.showBirthDatQuestion();
		String birthday = (String) employeeBirthdayReader.input();
		// 部署IDを入力
		EmployeeDeptIdReader employeeDeptIdReader = new EmployeeDeptIdReader();
		ConsoleWriter.showDeptQuestion();
		int deptId = (Integer) employeeDeptIdReader.input();

		try {
			int updatedRows = employeeDAO.update(empId, empName, gender, birthday, deptId);
			ConsoleWriter.showUpdateComp(updatedRows);

		} catch (ClassNotFoundException | SQLException | IOException | ParseException e) {
			e.printStackTrace();
		}
	}

}
