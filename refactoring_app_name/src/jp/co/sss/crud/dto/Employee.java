package jp.co.sss.crud.dto;

import jp.co.sss.crud.util.ConstantValue;

public class Employee {
	// 定数をDTOクラス内に定義するか、別の定数クラスにまとめる
	private static final String STRING_MALE = "男性";
	private static final String STRING_FEMALE = "女性";
	private static final String STRING_OTHER = "その他";
	private static final String STRING_ANSWER = "回答なし";
	private int empId;
	private int gender;
	private String birthday;
	private String empName;

	private Department department;

	@Override
	public String toString() {
		String gender_ja = "";
		if (this.gender == ConstantValue.MALE) {
			gender_ja = STRING_MALE;
		} else if (this.gender == ConstantValue.FEMALE) {
			gender_ja = STRING_FEMALE;
		} else if (this.gender == ConstantValue.OTHER) {
			gender_ja = STRING_OTHER;
		} else if (this.gender == ConstantValue.NO_ANSWER) {
			gender_ja = STRING_ANSWER;
		}

		return empId + "\t" + empName + "\t" + gender_ja + "\t" + birthday
				+ "\t" + department.getDeptName();
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
