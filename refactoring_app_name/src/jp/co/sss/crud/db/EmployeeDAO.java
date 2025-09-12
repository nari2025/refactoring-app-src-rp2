package jp.co.sss.crud.db;

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
import jp.co.sss.crud.exception.SystemErrorException;
import jp.co.sss.crud.io.ConsoleWriter;
import jp.co.sss.crud.util.ConstantMsg;
import jp.co.sss.crud.util.ConstantSQL;
import jp.co.sss.crud.util.ConstantValue;

public class EmployeeDAO implements IEmployeeDAO {
	/**
	* 社員を全件表示する
	* @return 社員リスト
	*/
	public List<Employee> findAll() throws SystemErrorException {
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
		} catch (ClassNotFoundException | SQLException e) {
			throw new SystemErrorException(ConstantMsg.MSG_SYSTEM_ERROR, e);
		} finally {
			// クローズ処理
			try {
				DBManager.close(resultSet);
				// Statementをクローズ
				DBManager.close(preparedStatement);
				// DBとの接続を切断
				DBManager.close(connection);
			} catch (SQLException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
		}
		return allEmployees;
	}

	/**
	* 入力された社員名と部分一致するデータを表示させる
	* @return 一致した社員データリスト
	*/
	public List<Employee> findByEmployeeName(String searchWord)
			throws SystemErrorException {
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
			preparedStatement.setString(ConstantValue.NAME_PARAM_INDEX, "%" + searchWord + "%");

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
		} catch (ClassNotFoundException | SQLException e) {
			throw new SystemErrorException(ConstantMsg.MSG_SYSTEM_ERROR, e);
		} finally {
			try {
				// クローズ処理
				DBManager.close(resultSet);
				// Statementをクローズ
				DBManager.close(preparedStatement);
				// DBとの接続を切断
				DBManager.close(connection);
			} catch (SQLException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}

		}
	}

	/**
	* 入力された部署IDと一致するデータを表示させる
	* @return 一致した社員データリスト
	*/
	public List<Employee> findByDeptId(int deptId)
			throws SystemErrorException {
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
			preparedStatement.setInt(ConstantValue.FINDBY_DEPTID_PARAM_INDEX, deptId);

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
		} catch (ClassNotFoundException | SQLException e) {
			throw new SystemErrorException(ConstantMsg.MSG_SYSTEM_ERROR, e);
		} finally {
			try {
				// クローズ処理
				DBManager.close(resultSet);
				// Statementをクローズ
				DBManager.close(preparedStatement);
				// DBとの接続を切断
				DBManager.close(connection);
			} catch (SQLException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
		}
	}

	/**
	* 新規登録
	* 
	*/
	public void insert(Employee employee)
			throws SystemErrorException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			// DBに接続
			connection = DBManager.getConnection();

			// ステートメントを作成
			preparedStatement = connection.prepareStatement(ConstantSQL.SQL_INSERT);

			// Employeeオブジェクトから入力値を取得してバインド
			preparedStatement.setString(ConstantValue.NAME_PARAM_INDEX, employee.getEmpName());
			preparedStatement.setInt(ConstantValue.GENDER_PARAM_INDEX, employee.getGender());
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
			preparedStatement.setObject(ConstantValue.BIRTHDAY_PARAM_INDEX, sdf.parse(employee.getBirthday()),
					Types.DATE);
			preparedStatement.setInt(ConstantValue.DEPTID_PARAM_INDEX, employee.getDepartment().getDeptId());

			// SQL文を実行
			preparedStatement.executeUpdate();
			// 登録完了メッセージを出力
			ConsoleWriter.showCreateComp();
		} catch (ClassNotFoundException | SQLException | ParseException e) {
			throw new SystemErrorException(ConstantMsg.MSG_SYSTEM_ERROR, e);
		} finally {
			try {
				DBManager.close(preparedStatement);
				DBManager.close(connection);
			} catch (SQLException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
		}
	}

	/**
	* 入力された社員IDと一致する社員のデータを更新する
	* @return 更新した件数
	*/
	public Integer update(Employee employee)
			throws SystemErrorException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			// データベースに接続
			connection = DBManager.getConnection();

			// ステートメントの作成
			preparedStatement = connection.prepareStatement(ConstantSQL.SQL_UPDATE);

			// Employeeオブジェクトから入力値を取得してバインド
			preparedStatement.setString(ConstantValue.NAME_PARAM_INDEX, employee.getEmpName());
			preparedStatement.setInt(ConstantValue.GENDER_PARAM_INDEX, employee.getGender());
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
			preparedStatement.setObject(ConstantValue.BIRTHDAY_PARAM_INDEX, sdf.parse(employee.getBirthday()),
					Types.DATE);
			preparedStatement.setInt(ConstantValue.DEPTID_PARAM_INDEX, employee.getDepartment().getDeptId());
			preparedStatement.setInt(ConstantValue.EMPID_PARAM_INDEX, employee.getEmpId());

			// SQL文の実行(失敗時は戻り値0)
			int updatedRows = preparedStatement.executeUpdate();
			return updatedRows;

		} catch (ClassNotFoundException | SQLException | ParseException e) {
			throw new SystemErrorException(ConstantMsg.MSG_SYSTEM_ERROR, e);
		} finally {
			// クローズ処理
			try {
				DBManager.close(preparedStatement);
				DBManager.close(connection);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			// DBとの接続を切断
		}
	}

	/**
	* 入力された社員IDと一致する社員のデータを削除する
	* @return 削除した件数
	*/
	public Integer delete(Integer empId)
			throws SystemErrorException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		Integer deletedRows = null;

		try {
			// データベースに接続
			connection = DBManager.getConnection();

			// ステートメントの作成
			preparedStatement = connection.prepareStatement(ConstantSQL.SQL_DELETE);

			// 社員IDをバインド
			preparedStatement.setInt(ConstantValue.DELETE_EMP_ID_PARAM_INDEX, empId);

			// SQL文の実行(失敗時は戻り値0)
			deletedRows = preparedStatement.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {
			throw new SystemErrorException(ConstantMsg.MSG_SYSTEM_ERROR, e);
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
		return deletedRows;
	}
}
