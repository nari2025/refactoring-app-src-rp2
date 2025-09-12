package jp.co.sss.crud.dto;

public class Department {

	/** 部署名 */
	private String deptName;
	/** 部署ID */
	private int deptId;

	public Department() {
	}

	public Department(int deptId) {
		this.deptId = deptId;
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
