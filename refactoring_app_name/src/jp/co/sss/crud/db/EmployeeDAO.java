package jp.co.sss.crud.db;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import jp.co.sss.crud.dto.Department;
import jp.co.sss.crud.dto.Employee;
import jp.co.sss.crud.exception.IllegalInputException;
import jp.co.sss.crud.exception.SystemErrorException;
import jp.co.sss.crud.io.ConsoleWriter;
import jp.co.sss.crud.util.ConstantSQL;

public class EmployeeDAO {

	public List<Employee> findAll() throws ClassNotFoundException, SQLException {
		List<Employee> allEmployees = new ArrayList<>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			// DBに接続
			connection = DBManager.getConnection();

			// ステートメントを作成
			preparedStatement = connection.prepareStatement(ConstantSQL.SQL_ALL_SELECT);

			// SQL文を実行
			resultSet = preparedStatement.executeQuery();
			// DTOへの格納とリストへの追加
			while (resultSet.next()) {
				//DTO への格納
				Employee allEmployee = new Employee();
				Department department = new Department();

				department.setDeptName(resultSet.getString("dept_name"));
				allEmployee.setEmpId(resultSet.getInt("emp_id"));
				allEmployee.setGender(resultSet.getInt("gender"));
				allEmployee.setEmpName(resultSet.getString("emp_name"));
				allEmployee.setBirthday(resultSet.getString("birthday"));
				allEmployee.setDepartment(department);
				//リストへの追加
				allEmployees.add(allEmployee);
			}

		} finally {
			// クローズ処理
			DBManager.close(resultSet);
			// Statementをクローズ
			DBManager.close(preparedStatement);
			// DBとの接続を切断
			DBManager.close(connection);
		}
		return allEmployees;
	}

	public List<Employee> findByEmployeeName(String searchWord)
			throws ClassNotFoundException, SQLException, IOException, SystemErrorException, IllegalInputException {
		List<Employee> employees = new ArrayList<>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			// DBに接続
			connection = DBManager.getConnection();

			// SQL文を準備
			StringBuffer sql = new StringBuffer(ConstantSQL.SQL_SELECT_BASIC);
			sql.append(ConstantSQL.SQL_SELECT_BY_EMP_NAME);

			// ステートメントの作成
			preparedStatement = connection.prepareStatement(sql.toString());

			// 検索条件となる値をバインド
			preparedStatement.setString(1, "%" + searchWord + "%");

			// SQL文を実行
			resultSet = preparedStatement.executeQuery();
			// DTOへの格納とリストへの追加
			while (resultSet.next()) {
				//DTO への格納
				Employee employee = new Employee();
				Department department = new Department();

				department.setDeptName(resultSet.getString("dept_name"));
				employee.setEmpId(resultSet.getInt("emp_id"));
				employee.setGender(resultSet.getInt("gender"));
				employee.setEmpName(resultSet.getString("emp_name"));
				employee.setBirthday(resultSet.getString("birthday"));
				employee.setDepartment(department);
				//リストへの追加
				employees.add(employee);
			}
			return employees;

		} finally {
			// クローズ処理
			DBManager.close(resultSet);
			// Statementをクローズ
			DBManager.close(preparedStatement);
			// DBとの接続を切断
			DBManager.close(connection);
		}

	}

	public List<Employee> findByDeptId(int deptId)
			throws ClassNotFoundException, SQLException, IOException, SystemErrorException, IllegalInputException {
		List<Employee> employees = new ArrayList<>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			// DBに接続
			connection = DBManager.getConnection();

			// SQL文を準備
			StringBuffer sql = new StringBuffer(ConstantSQL.SQL_SELECT_BASIC);
			sql.append(ConstantSQL.SQL_SELECT_BY_DEPT_ID);

			// ステートメントの作成
			preparedStatement = connection.prepareStatement(sql.toString());

			// 検索条件となる値をバインド
			preparedStatement.setInt(1, deptId);

			// SQL文を実行
			resultSet = preparedStatement.executeQuery();

			// DTOへの格納とリストへの追加
			while (resultSet.next()) {
				//DTO への格納
				Employee employee = new Employee();
				Department department = new Department();

				department.setDeptName(resultSet.getString("dept_name"));
				employee.setEmpId(resultSet.getInt("emp_id"));
				employee.setGender(resultSet.getInt("gender"));
				employee.setEmpName(resultSet.getString("emp_name"));
				employee.setBirthday(resultSet.getString("birthday"));
				employee.setDepartment(department);
				//リストへの追加
				employees.add(employee);
			}
			return employees;

		} finally {
			// クローズ処理
			DBManager.close(resultSet);
			// Statementをクローズ
			DBManager.close(preparedStatement);
			// DBとの接続を切断
			DBManager.close(connection);
		}
	}

	public void insert(String empName, int gender, String birthday, int deptId)
			throws ClassNotFoundException, SQLException,
			SystemErrorException, IllegalInputException, ParseException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			// DBに接続
			connection = DBManager.getConnection();

			// ステートメントを作成
			preparedStatement = connection.prepareStatement(ConstantSQL.SQL_INSERT);

			// 入力値をバインド
			preparedStatement.setString(1, empName);
			preparedStatement.setInt(2, gender);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
			preparedStatement.setObject(3, sdf.parse(birthday), Types.DATE);
			preparedStatement.setInt(4, deptId);

			// SQL文を実行
			preparedStatement.executeUpdate();
			// 登録完了メッセージを出力
			ConsoleWriter.showCreateComp();
		} finally {
			DBManager.close(preparedStatement);
			DBManager.close(connection);
		}
	}

	public int update(int empId, String empName, int gender, String birthday, int deptId)
			throws ClassNotFoundException, SQLException, IOException, ParseException, SystemErrorException,
			IllegalInputException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			// データベースに接続
			connection = DBManager.getConnection();

			// ステートメントの作成
			preparedStatement = connection.prepareStatement(ConstantSQL.SQL_UPDATE);

			// 入力値をバインド
			preparedStatement.setString(1, empName);
			preparedStatement.setInt(2, gender);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
			preparedStatement.setObject(3, sdf.parse(birthday), Types.DATE);
			preparedStatement.setInt(4, deptId);
			preparedStatement.setInt(5, empId);

			// SQL文の実行(失敗時は戻り値0)
			int updatedRows = preparedStatement.executeUpdate();
			return updatedRows;

		} finally {
			// クローズ処理
			DBManager.close(preparedStatement);
			// DBとの接続を切断
			DBManager.close(connection);
		}
	}

	public int delete(int empId)
			throws ClassNotFoundException, SQLException, SystemErrorException, IllegalInputException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			// データベースに接続
			connection = DBManager.getConnection();

			// ステートメントの作成
			preparedStatement = connection.prepareStatement(ConstantSQL.SQL_DELETE);

			// 社員IDをバインド
			preparedStatement.setInt(1, empId);

			// SQL文の実行(失敗時は戻り値0)
			int deletedRows = preparedStatement.executeUpdate();
			return deletedRows;

		} finally {
			// Statementをクローズ
			try {
				DBManager.close(preparedStatement);
				DBManager.close(connection);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			// DBとの接続を切断
		}
	}

}
