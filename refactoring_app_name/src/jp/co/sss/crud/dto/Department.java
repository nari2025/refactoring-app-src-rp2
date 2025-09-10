package jp.co.sss.crud.dto;

public class Department {

	private String deptName;
	private int deptId;

	public Department(int deptId) {
		this.deptId = deptId;
	}

	public Department() {
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
}
