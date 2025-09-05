package jp.co.sss.crud.util;

public class ConstantMsg {

	/** 全件表示の際のテーブルのカラム名 */
	public static final String MSG_LIST = "社員ID\t社員名\t性別\t生年月日\t部署名";
	/** 検索時に該当者がいない場合のメッセージ */
	public static final String MSG_NO_MATCH_FOUND = "該当者はいませんでした";
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

}
