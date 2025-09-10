package jp.co.sss.crud.util;

public class ConstantValue {
	/** メニュー番号の定数化 */
	public static final int FIND_ALL = 1;
	public static final int FIND_NAME = 2;
	public static final int FIND_ID = 3;
	public static final int CREATE = 4;
	public static final int UPDATE = 5;
	public static final int DELETE = 6;
	public static final int FINISH = 7;

	/** プレースホルダーの定数化 */
	public static final int NAME_PARAM_INDEX = 1;
	public static final int GENDER_PARAM_INDEX = 2;
	public static final int BIRTHDAY_PARAM_INDEX = 3;
	public static final int DEPTID_PARAM_INDEX = 4;
	public static final int EMPID_PARAM_INDEX = 5;
	public static final int DELETE_EMP_ID_PARAM_INDEX = 1;
	public static final int FINDBY_DEPTID_PARAM_INDEX = 1;

	/** 性別の定数化 */
	public static final int NO_ANSWER = 0;
	public static final int MALE = 1;
	public static final int FEMALE = 2;
	public static final int OTHER = 9;

	// 性別（日本語）の定数化
	public static final String STRING_MALE = "男性";
	public static final String STRING_FEMALE = "女性";
	public static final String STRING_OTHER = "その他";
	public static final String STRING_NO_ANSWER = "回答なし";

	/** 部署の定数化 */
	public static final int SALES_DEPT = 1;
	public static final int ACCOUNTING_DEPT = 2;
	public static final int GENERAL_AFFAIRS_DEPT = 3;
}
