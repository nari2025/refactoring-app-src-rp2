package jp.co.sss.crud.db;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
import jp.co.sss.crud.util.ConstantMsg;
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

			//resultSetの結果Setがない場合はfalse
			if (!resultSet.isBeforeFirst()) {
				System.out.println(ConstantMsg.MSG_NO_MATCH_FOUND);
				return allEmployees;
			}
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

	public List<Employee> findByEmployeeName()
			throws ClassNotFoundException, SQLException, IOException {

		List<Employee> employees = new ArrayList<>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 検索ワード
		String searchWord = br.readLine();
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
			//該当者がいるかチェック
			if (!resultSet.isBeforeFirst()) {
				System.out.println(ConstantMsg.MSG_NO_MATCH_FOUND);
				return employees;
			}

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

				System.out.println(employee);
			}
			System.out.println("");
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

	public List<Department> findByDeptId(String deptId)
			throws ClassNotFoundException, SQLException, IOException {
		List<Department> departments = new ArrayList<>();

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
			preparedStatement.setInt(1, Integer.parseInt(deptId));

			// SQL文を実行
			resultSet = preparedStatement.executeQuery();

			if (!resultSet.isBeforeFirst()) {
				System.out.println(ConstantMsg.MSG_NO_MATCH_FOUND);
				return departments;
			}

			// DTOへの格納とリストへの追加
			while (resultSet.next()) {
				//DTO への格納
				Employee employee = new Employee();
				Department department = new Department();

				employee.setEmpId(resultSet.getInt("emp_id"));
				employee.setGender(resultSet.getInt("gender"));
				employee.setEmpName(resultSet.getString("emp_name"));
				employee.setBirthday(resultSet.getString("birthday"));

				department.setDeptId(resultSet.getInt("dept_id"));
				department.setDeptName(resultSet.getString("dept_name"));
				department.setEmployee(employee);
				//リストへの追加
				departments.add(department);
			}
			return departments;

		} finally {
			// クローズ処理
			DBManager.close(resultSet);
			// Statementをクローズ
			DBManager.close(preparedStatement);
			// DBとの接続を切断
			DBManager.close(connection);
		}
	}

	public void insert(String empName, String gender, String birthday, String deptId)
			throws ClassNotFoundException, SQLException, IOException, ParseException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			// DBに接続
			connection = DBManager.getConnection();

			// ステートメントを作成
			preparedStatement = connection.prepareStatement(ConstantSQL.SQL_INSERT);

			// 入力値をバインド
			preparedStatement.setString(1, empName);
			preparedStatement.setInt(2, Integer.parseInt(gender));
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
			preparedStatement.setObject(3, sdf.parse(birthday), Types.DATE);
			preparedStatement.setInt(4, Integer.parseInt(deptId));

			// SQL文を実行
			preparedStatement.executeUpdate();

		} finally {
			DBManager.close(preparedStatement);
			DBManager.close(connection);
		}
	}

	public void update(String empId)
			throws ClassNotFoundException, SQLException, IOException, ParseException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		try {
			// データベースに接続
			connection = DBManager.getConnection();

			// ステートメントの作成
			preparedStatement = connection.prepareStatement(ConstantSQL.SQL_UPDATE);

			System.out.print("社員名：");
			String emp_name = br.readLine();
			// 性別を入力
			System.out.print("性別(0:回答しない, 1:男性, 2:女性, 9:その他):");
			String gender = br.readLine();
			// 誕生日を入力
			System.out.print("生年月日(西暦年/月/日)：");
			String birthday = br.readLine();

			// 部署IDを入力
			System.out.print("部署ID(1：営業部、2：経理部、3：総務部)：");
			String deptId = br.readLine();

			// 入力値をバインド
			preparedStatement.setString(1, emp_name);
			preparedStatement.setInt(2, Integer.parseInt(gender));
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
			preparedStatement.setObject(3, sdf.parse(birthday), Types.DATE);
			preparedStatement.setInt(4, Integer.parseInt(deptId));
			preparedStatement.setInt(5, Integer.parseInt(empId));

			// SQL文の実行(失敗時は戻り値0)
			preparedStatement.executeUpdate(ConstantMsg.MSG_CREATE_COMPLETE);

		} finally {
			// クローズ処理
			DBManager.close(preparedStatement);
			// DBとの接続を切断
			DBManager.close(connection);
		}
	}

	public void delete() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		try {
			// データベースに接続
			connection = DBManager.getConnection();
			String empId = br.readLine();

			// ステートメントの作成
			preparedStatement = connection.prepareStatement(ConstantSQL.SQL_DELETE);

			// 社員IDをバインド
			preparedStatement.setInt(1, Integer.parseInt(empId));

			// SQL文の実行(失敗時は戻り値0)
			preparedStatement.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();

		}

		finally {
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
