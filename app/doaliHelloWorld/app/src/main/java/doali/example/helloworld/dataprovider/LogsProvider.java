package doali.example.helloworld.dataprovider;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.database.sqlite.SQLiteDatabase;

public class LogsProvider extends ContentProvider {

    static final String PROVIDER_NAME = "doali.example.helloworld.info";
    static final String URL = "content://" + PROVIDER_NAME + "/bibi";
    public static final Uri CONTENT_URI = Uri.parse(URL);

    static final UriMatcher uriMatcher;

    static final int LOG = 1;
    static final int LOG_ID = 2;

    static{
        uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        uriMatcher.addURI(PROVIDER_NAME, "bibi", LOG);
        uriMatcher.addURI(PROVIDER_NAME, "bibi/#", LOG_ID);
    }

    private SQLiteDatabase db;

    public LogsProvider() {
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        // Implement this to handle requests to delete one or more rows.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public String getType(Uri uri) {
        // TODO: Implement this to handle requests for the MIME type of the data
        // at the given URI.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        // TODO: Implement this to handle requests to insert a new row.
        long rowID = db.insert(DataBaseHelper.DB_TABLE_NAME, "", values);

        if (rowID > 0)
        {
            Uri _uri = ContentUris.withAppendedId(CONTENT_URI, rowID);
            getContext().getContentResolver().notifyChange(_uri, null);
            return _uri;
        }
        throw new SQLException("Failed to add a record into " + uri);
    }

    @Override
    public boolean onCreate() {
        // TODO: Implement this to initialize your content provider on startup.
        /*
        Context context = getContext();
        DataBaseHelper dbHelper = DataBaseHelper.init(context);

        db = dbHelper.getWritableDatabase();

        return (db == null)? false:true;
        */
        return false;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection,
                        String[] selectionArgs, String sortOrder) {
        // TODO: Implement this to handle query requests from clients.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection,
                      String[] selectionArgs) {
        // TODO: Implement this to handle requests to update one or more rows.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}