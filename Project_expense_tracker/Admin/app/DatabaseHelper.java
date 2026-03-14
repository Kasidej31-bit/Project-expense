import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.ContentValues;
import android.database.Cursor;



public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "ProjectTracker.db";
    public static final int DATABASE_VERSION = 1;

    public static final String TABLE_PROJECTS = "projects";
    public static final String TABLE_EXPENSES = "expenses";

    // Project Columns
    public static final String COL_PROJECT_ID = "id";
    public static final String COL_PROJECT_NAME = "name";
    public static final String COL_PROJECT_DESC = "description";
    public static final String COL_START_DATE = "startDate";
    public static final String COL_END_DATE = "endDate";
    public static final String COL_MANAGER = "manager";
    public static final String COL_STATUS = "status";
    public static final String COL_BUDGET = "budget";
    public static final String COL_SPECIAL_REQ = "specialRequirements";
    public static final String COL_CLIENT_INFO = "clientInfo";

    // Expense Columns
    public static final String COL_EXPENSE_ID = "expense_id";
    public static final String COL_PROJECT_REF_ID = "project_id";
    public static final String COL_EXPENSE_DATE = "expense_date";
    public static final String COL_AMOUNT = "amount";
    public static final String COL_CURRENCY = "currency";
    public static final String COL_TYPE = "type";
    public static final String COL_PAYMENT_METHOD = "payment_method";
    public static final String COL_CLAIMANT = "claimant";
    public static final String COL_PAYMENT_STATUS = "payment_status";
    public static final String COL_DESCRIPTION = "description";
    public static final String COL_LOCATION = "location";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_PROJECTS = "CREATE TABLE " + TABLE_PROJECTS + " (" +
                COL_PROJECT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                COL_PROJECT_NAME + " TEXT NOT NULL," +
                COL_PROJECT_DESC + " TEXT NOT NULL," +
                COL_START_DATE + " TEXT NOT NULL," +
                COL_END_DATE + " TEXT NOT NULL," +
                COL_MANAGER + " TEXT NOT NULL," +
                COL_STATUS + " TEXT NOT NULL," +
                COL_BUDGET + " REAL NOT NULL," +
                COL_SPECIAL_REQ + " TEXT," +
                COL_CLIENT_INFO + " TEXT)";

        String CREATE_EXPENSES = "CREATE TABLE " + TABLE_EXPENSES + " (" +
                COL_EXPENSE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                COL_PROJECT_REF_ID + " INTEGER," +
                COL_EXPENSE_DATE + " TEXT NOT NULL," +
                COL_AMOUNT + " REAL NOT NULL," +
                COL_CURRENCY + " TEXT NOT NULL," +
                COL_TYPE + " TEXT NOT NULL," +
                COL_PAYMENT_METHOD + " TEXT NOT NULL," +
                COL_CLAIMANT + " TEXT NOT NULL," +
                COL_PAYMENT_STATUS + " TEXT NOT NULL," +
                COL_DESCRIPTION + " TEXT," +
                COL_LOCATION + " TEXT," +
                "FOREIGN KEY(" + COL_PROJECT_REF_ID + ") REFERENCES " + TABLE_PROJECTS + "(" + COL_PROJECT_ID + "))";

        db.execSQL(CREATE_PROJECTS);
        db.execSQL(CREATE_EXPENSES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_EXPENSES);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PROJECTS);
        onCreate(db);
    }

    public long insertProject(Project project) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_PROJECT_NAME, project.getName());
        values.put(COL_PROJECT_DESC, project.getDescription());
        values.put(COL_START_DATE, project.getStartDate());
        values.put(COL_END_DATE, project.getEndDate());
        values.put(COL_MANAGER, project.getManager());
        values.put(COL_STATUS, project.getStatus());
        values.put(COL_BUDGET, project.getBudget());
        values.put(COL_SPECIAL_REQ, project.getSpecialRequirements());
        values.put(COL_CLIENT_INFO, project.getClientInfo());

        return db.insert(TABLE_PROJECTS, null, values);
    }
}
