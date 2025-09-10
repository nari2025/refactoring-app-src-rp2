package jp.co.sss.crud.util;

public class ConstantMsg {

	/** 全件表示の際のテーブルのカラム名 */
	public static final String MSG_LIST_CALAM = "社員ID\t社員名\t性別\t生年月日\t部署名";
	/** 全件表示の際のテーブルのカラム名 */
	public static final String MSG_FIND_BY_DEPTNO = "部署ID(1：営業部、2：経理部、3：総務部)を入力してください：";
	/** 該当者がいない場合のメッセージ */
	public static final String MSG_NO_MATCH_FOUND = "該当する社員は存在しません。";
	/** 更新する社員を質問する時のメッセージ */
	public static final String MSG_UPDATE_QUESTION = "更新する社員の社員IDを入力してください：";
	/** 削除する社員を質問する時のメッセージ */
	public static final String MSG_DELETE_QUESTION = "削除する社員の社員IDを入力してください：";
	/** 登録時のメッセージ */
	public static final String MSG_CREATE_COMPLETE = "社員情報を登録しました";
	/** 更新時のメッセージ */
	public static final String MSG_UPDATE_COMPLETE = "社員情報を更新しました";
	/** 削除時のメッセージ */
	public static final String MSG_DELETE_COMPLETE = "社員情報を削除しました";
	/** 終了時のメッセージ */
	public static final String MSG_FINISH = "システムを終了します。";
	/** エラーメッセージ */
	public static final String MSG_SYSTEM_ERROR = "エラーが発生しました。";
	/**更新・削除の際に対象者がいない場合のメッセージ*/
	public static final String MSG_NO_TARGET_FOUND = "対象者がいませんでした";

	/** バリテーション */
	public static final String MSG_DEPTID_ERROR = "1以上3以下の整数を入力してください";
	public static final String MSG_BITHDAY_ERROR = "正しい形式(西暦年/月/日)で日付を入力してください";
	public static final String MSG_EMPID_ERROR = "1以上9999以下の整数を入力してください";
	public static final String MSG_GENDER_ERROR = "0か1か2か9を入力してください";
	public static final String MSG_EMPNAME_ERROR = "1文字以上30文字以下の文字列を入力してください";

}
