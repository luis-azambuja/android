package app.com.aula06.db;

import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by sala01 on 16/05/2017.
 */

public class FireData {

    private static FirebaseDatabase mDatabase;

    public FireData(){}

    public static FirebaseDatabase getDatabase() {
        if (mDatabase == null) {
            mDatabase = FirebaseDatabase.getInstance();
            mDatabase.setPersistenceEnabled(true);
        }

        return mDatabase;
    }
}
