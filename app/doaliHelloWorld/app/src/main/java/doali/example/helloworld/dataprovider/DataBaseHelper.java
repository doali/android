package doali.example.helloworld.dataprovider;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DataBaseHelper extends SQLiteOpenHelper {
    private SQLiteDatabase db;

    static final String DB_NAME = "data";
    static final String DB_TABLE_NAME = "bibi";
    static final int DB_VERSION = 1;
    static final String CREATE_DB_TABLE =
            " CREATE TABLE " + DB_TABLE_NAME +
            " (_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
            " DATE TEXT NOT NULL, " +
            " APP TEXT NOT NULL, " +
            " INFO TEXT NOT NULL);";

    public DataBaseHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    /**
     * TODO to delete ?
     * @param context
     * @return
     */
    public static DataBaseHelper init(Context context) {
        return new DataBaseHelper(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_DB_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + DB_TABLE_NAME);
        onCreate(db);
    }
}
