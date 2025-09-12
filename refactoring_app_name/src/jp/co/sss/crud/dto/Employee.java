package jp.co.sss.crud.dto;

import jp.co.sss.crud.util.ConstantValue;

public class Employee {
	/** 社員ID */
	private int empId;
	/** 性別(数字) */
	private int gender;
	/** 誕生日 */
	private String birthday;
	/** 社員名 */
	private String empName;
	/** 部署 */
	private Department department;

	/**
	 *  社員テーブルDTOのコンストラクタ
	 */
	public Employee() {
	}

	/**
	 * 社員テーブルDTOのコンストラクタ（登録時に使用)
	 */
	public Employee(String empName, int gender, String birthday, int deptId) {
		this.gender = gender;
		this.birthday = birthday;
		this.empName = empName;
		this.department = new Department(deptId);
	}

	/**
	 * 社員データを文字列にする
	 * @return 社員データの文字列
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(empId);
		sb.append("\t");
		sb.append(empName);
		sb.append("\t");
		sb.append(getGenderText(gender));
		sb.append("\t");
		sb.append(birthday);
		sb.append("\t");
		sb.append(department.getDeptName());
		sb.append("\t");

		return sb.toString();
	}

	/**
	 * 取得した性別(数字)を対応する性別(日本語)に変換する
	 * @return 性別(日本語)
	 */
	public String getGenderText(int gender) {
		/** 部署 */
		String gender_ja = "";
		if (this.gender == ConstantValue.MALE) {
			gender_ja = ConstantValue.STRING_MALE;
		} else if (this.gender == ConstantValue.FEMALE) {
			gender_ja = ConstantValue.STRING_FEMALE;
		} else if (this.gender == ConstantValue.OTHER) {
			gender_ja = ConstantValue.STRING_OTHER;
		} else if (this.gender == ConstantValue.NO_ANSWER) {
			gender_ja = ConstantValue.STRING_NO_ANSWER;
		}
		return gender_ja;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

}
