package jp.co.sss.crud.io;

import java.util.List;

import jp.co.sss.crud.dto.Employee;
import jp.co.sss.crud.util.ConstantMsg;

public class ConsoleWriter {
	public static void showMenu() {
		System.out.println("=== 社員管理システム ===");
		System.out.println("1.全件表示");
		System.out.println("2.社員名検索");
		System.out.println("3.部署ID検索");
		System.out.println("4.新規登録");
		System.out.println("5.更新");
		System.out.println("6.削除");
		System.out.println("7.終了");
		System.out.print("メニュー番号を入力してください：");
	}

	public static void showEmpNameQuestion() {
		System.out.print("社員名：");
	}

	public static void showGenderQuestion() {
		System.out.print("性別(0:回答しない, 1:男性, 2:女性, 9:その他):");
	}

	public static void showBirthDatQuestion() {
		System.out.print("生年月日(西暦年/月/日)：");
	}

	public static void showDeptQuestion() {
		System.out.print("部署ID(1：営業部、2：経理部、3：総務部)：");
	}

	public static void showDeptIdQuestion() {
		System.out.print(ConstantMsg.MSG_FIND_BY_DEPTNO);
	}

	public static void showEmployees(List<Employee> employees) {
		if (employees.isEmpty()) {
			showNonExistTarget();
		} else {
			showHeader();
			for (Employee employee : employees) {
				System.out.println(employee);
			}
		}
		System.out.println("");
	}

	public static void showNonExistTarget() {
		System.out.println(ConstantMsg.MSG_NO_TARGET_FOUND);
	}

	public static void showNonMatchTarget() {
		System.out.println(ConstantMsg.MSG_NO_MATCH_FOUND);
	}

	public static void showHeader() {
		System.out.println(ConstantMsg.MSG_LIST_CALAM);
	}

	public static void showCreateComp() {
		System.out.println(ConstantMsg.MSG_CREATE_COMPLETE);
	}

	public static void showUpdateComp(int updatedRows) {
		if (updatedRows > 0) {
			System.out.println(ConstantMsg.MSG_UPDATE_COMPLETE);
		} else {
			showNonMatchTarget();
		}
		System.out.println("");
	}

	public static void showDeleteComp(int deletedRows) {
		if (deletedRows > 0) {
			System.out.println(ConstantMsg.MSG_DELETE_COMPLETE);
		} else {
			showNonMatchTarget();
		}
		System.out.println("");
	}

	public static void showDeleteQuestion() {
		System.out.println(ConstantMsg.MSG_DELETE_QUESTION);
	}

	public static void showUpdateQuestion() {
		System.out.println(ConstantMsg.MSG_UPDATE_QUESTION);
	}
}