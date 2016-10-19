
import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

import com.voler.myapplication.db.MyDBOpenHelper;

/**
 * 内容提供者 后门程序,提供私有的数据给别的应用程序,默认都是空实现.
 */
public class BankDBBackdoor extends ContentProvider {

	public static final int SUCCESS = 1;
	/**
	 * 创建一个保安,检查uri的规则,如果uri匹配失败 返回-1
	 */
	static UriMatcher mUriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
	static {
		mUriMatcher.addURI("com.itheima.db", "account", SUCCESS);
	}

	@Override
	public int delete(Uri uri, String selection, String[] selectionArgs) {
		int code = mUriMatcher.match(uri);
		if (code == SUCCESS) {
			System.out.println("delete 删除数据");
			MyDBOpenHelper helper = new MyDBOpenHelper(getContext());
			SQLiteDatabase db = helper.getWritableDatabase();
			db.delete("account",selection , selectionArgs);
			//利用内容提供者的解析器,通知内容观察者数据发生了变化
			getContext().getContentResolver().notifyChange(uri, null);
		}else{
			throw new IllegalArgumentException("口令 不正确,滚犊子");
		}
		return 0;
	}

	@Override
	public String getType(Uri uri) {
		return null;
	}

	@Override
	public Uri insert(Uri uri, ContentValues values) {
		int code = mUriMatcher.match(uri);
		if (code == SUCCESS) {
			System.out.println("insert 添加数据");
			MyDBOpenHelper helper = new MyDBOpenHelper(getContext());
			SQLiteDatabase db = helper.getWritableDatabase();
			db.insert("account", null, values);
			//利用内容提供者的解析器,通知内容观察者数据发生了变化
			getContext().getContentResolver().notifyChange(uri, null);
		}else{
			throw new IllegalArgumentException("口令 不正确,滚犊子");
		}
		return null;
	}

	@Override
	public boolean onCreate() {
		return false;
	}

	@Override
	public Cursor query(Uri uri, String[] projection, String selection,
			String[] selectionArgs, String sortOrder) {
		int code = mUriMatcher.match(uri);
		if (code == SUCCESS) {
			System.out.println("query 查询数据");
			MyDBOpenHelper helper = new MyDBOpenHelper(getContext());
			SQLiteDatabase db = helper.getReadableDatabase();
			return db.query("account", projection, selection, selectionArgs, null, null, sortOrder);
		}else{
			throw new IllegalArgumentException("口令 不正确,滚犊子");
		}
	}

	@Override
	public int update(Uri uri, ContentValues values, String selection,
			String[] selectionArgs) {
		int code = mUriMatcher.match(uri);
		if (code == SUCCESS) {
			System.out.println("update 更新数据");
			MyDBOpenHelper helper = new MyDBOpenHelper(getContext());
			SQLiteDatabase db = helper.getWritableDatabase();
			db.update("account", values, selection, selectionArgs);
			//利用内容提供者的解析器,通知内容观察者数据发生了变化
			getContext().getContentResolver().notifyChange(uri, null);
		}else{
			throw new IllegalArgumentException("口令 不正确,滚犊子");
		}
		return 0;
	}

}
