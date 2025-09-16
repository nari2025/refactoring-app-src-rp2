package jp.co.sss.crud.util;

import jp.co.sss.crud.dto.Employee;
import jp.co.sss.crud.exception.IllegalInputException;
import jp.co.sss.crud.exception.SystemErrorException;
import jp.co.sss.crud.io.ConsoleWriter;
import jp.co.sss.crud.io.EmployeeBirthdayReader;
import jp.co.sss.crud.io.EmployeeDeptIdReader;
import jp.co.sss.crud.io.EmployeeEmpIdReader;
import jp.co.sss.crud.io.EmployeeGenderReader;
import jp.co.sss.crud.io.EmployeeNameReader;

public class EmployeeUtil {
	/**
	 * 登録処理の際に使用する入力の記述
	 * @return 入力した内容
	 * @throws SystemErrorException : {@code ClassNotFoundException | SQLException }をキャッチしてスローする
	 */
	public static Employee readEmpDetailsInsert() throws SystemErrorException, IllegalInputException {
		String empName = readEmpName();
		int gender = readEmpGender();
		String birthday = readBirthday();
		int deptId = readDeptId();
		Employee employee = new Employee(empName, gender, birthday, deptId);
		return employee;
	}

	/**
	 * 更新処理の際に使用する入力の記述
	 * @return 入力した内容
	 * @throws SystemErrorException : {@code ClassNotFoundException | SQLException }をキャッチしてスローする
	 */
	public static Employee readEmpDetailsUpdatet() throws SystemErrorException, IllegalInputException {
		//社員のID
		EmployeeEmpIdReader employeeEmpIdReader = new EmployeeEmpIdReader();
		ConsoleWriter.showUpdateQuestion();
		int empId = (Integer) employeeEmpIdReader.input();

		String empName = readEmpName();
		int gender = readEmpGender();
		String birthday = readBirthday();
		int deptId = readDeptId();
		Employee employee = new Employee(empName, gender, birthday, deptId);
		employee.setEmpId(empId);
		return employee;
	}

	/**
	 * 削除処理の際に使用する入力の記述
	 * @return 入力した内容
	 * @throws SystemErrorException : {@code ClassNotFoundException | SQLException }をキャッチしてスローする
	 */
	public static int readDeleteeEmpId() throws SystemErrorException, IllegalInputException {
		//社員のID
		EmployeeEmpIdReader employeeEmpIdReader = new EmployeeEmpIdReader();
		ConsoleWriter.showDeleteQuestion();
		int empId = (Integer) employeeEmpIdReader.input();

		return empId;
	}

	/**
	 * 社員名の入力
	 * @return 入力した社員名
	 */
	public static String readEmpName() throws SystemErrorException, IllegalInputException {
		// 名前を入力
		EmployeeNameReader employeeNameReader = new EmployeeNameReader();
		ConsoleWriter.showEmpNameQuestion();
		String empName = (String) employeeNameReader.input();

		return empName;
	}

	/**
	 * 性別の入力
	 * @return 入力した性別
	 */
	public static int readEmpGender() throws SystemErrorException, IllegalInputException {
		// 性別を入力
		EmployeeGenderReader employeeGenderReader = new EmployeeGenderReader();
		ConsoleWriter.showGenderQuestion();
		int gender = (Integer) employeeGenderReader.input();

		return gender;
	}

	/**
	 * 誕生日の入力
	 * @return 入力した誕生日
	 */
	public static String readBirthday() throws SystemErrorException, IllegalInputException {
		// 誕生日を入力
		EmployeeBirthdayReader employeeBirthdayReader = new EmployeeBirthdayReader();
		ConsoleWriter.showBirthDatQuestion();
		String birthday = (String) employeeBirthdayReader.input();

		return birthday;
	}

	/**
	 * 部署IDの入力
	 * @return 入力した部署ID
	 */
	public static int readDeptId() throws SystemErrorException, IllegalInputException {
		// 部署IDを入力
		EmployeeDeptIdReader employeeDeptIdReader = new EmployeeDeptIdReader();
		ConsoleWriter.showDeptQuestion();
		int deptId = (Integer) employeeDeptIdReader.input();

		return deptId;
	}
}