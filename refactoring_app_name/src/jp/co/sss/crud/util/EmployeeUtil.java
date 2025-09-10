package jp.co.sss.crud.util;

import jp.co.sss.crud.exception.IllegalInputException;
import jp.co.sss.crud.exception.SystemErrorException;
import jp.co.sss.crud.io.ConsoleWriter;
import jp.co.sss.crud.io.EmployeeBirthdayReader;
import jp.co.sss.crud.io.EmployeeDeptIdReader;
import jp.co.sss.crud.io.EmployeeEmpIdReader;
import jp.co.sss.crud.io.EmployeeGenderReader;
import jp.co.sss.crud.io.EmployeeNameReader;

public class EmployeeUtil {
	public static int readUpdateEmpId() throws SystemErrorException, IllegalInputException {
		//社員のID
		EmployeeEmpIdReader employeeEmpIdReader = new EmployeeEmpIdReader();
		ConsoleWriter.showUpdateQuestion();
		int empId = (Integer) employeeEmpIdReader.input();

		return empId;
	}

	public static int readDeleteeEmpId() throws SystemErrorException, IllegalInputException {
		//社員のID
		EmployeeEmpIdReader employeeEmpIdReader = new EmployeeEmpIdReader();
		ConsoleWriter.showDeleteQuestion();
		int empId = (Integer) employeeEmpIdReader.input();

		return empId;
	}

	public static String readEmpName() throws SystemErrorException, IllegalInputException {
		// 名前を入力
		EmployeeNameReader employeeNameReader = new EmployeeNameReader();
		ConsoleWriter.showEmpNameQuestion();
		String empName = (String) employeeNameReader.input();

		return empName;
	}

	public static int readEmpGender() throws SystemErrorException, IllegalInputException {
		// 性別を入力
		EmployeeGenderReader employeeGenderReader = new EmployeeGenderReader();
		ConsoleWriter.showGenderQuestion();
		int gender = (Integer) employeeGenderReader.input();

		return gender;
	}

	public static String readBirthday() throws SystemErrorException, IllegalInputException {
		// 誕生日を入力
		EmployeeBirthdayReader employeeBirthdayReader = new EmployeeBirthdayReader();
		ConsoleWriter.showBirthDatQuestion();
		String birthday = (String) employeeBirthdayReader.input();

		return birthday;
	}

	public static int readDeptId() throws SystemErrorException, IllegalInputException {
		// 部署IDを入力
		EmployeeDeptIdReader employeeDeptIdReader = new EmployeeDeptIdReader();
		ConsoleWriter.showDeptQuestion();
		int deptId = (Integer) employeeDeptIdReader.input();

		return deptId;
	}
}