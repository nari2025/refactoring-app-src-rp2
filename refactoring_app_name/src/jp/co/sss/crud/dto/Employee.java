package jp.co.sss.crud.dto;

import jp.co.sss.crud.util.ConstantValue;

public class Employee {

	private int empId;
	private int gender;

	private String gender_ja;
	private String birthday;
	private String empName;

	private Department department;

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

	public String getGenderText(int gender) {
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
