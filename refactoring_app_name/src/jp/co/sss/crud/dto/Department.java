package jp.co.sss.crud.dto;

public class Department {

	private String deptName;
	private int deptId;

	private Employee employee;

	@Override
	public String toString() {

		StringBuilder sb = new StringBuilder();

		sb.append(employee.getEmpId());
		sb.append("\t");
		sb.append(employee.getEmpName());
		sb.append("\t");
		sb.append(employee.getGenderText(employee.getGender()));
		sb.append("\t");
		sb.append(employee.getBirthday());
		sb.append("\t");
		sb.append(deptName);
		sb.append("\t");
		return sb.toString();
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public int getDeptId() {
		return deptId;
	}

	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}

	public Employee getEemployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
}
