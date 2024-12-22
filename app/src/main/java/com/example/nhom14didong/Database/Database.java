package com.example.nhom14didong.Database;

import android.app.Activity;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class Database {
    private final static String DATABASE_NAME = "mydatabase.db";
    public static SQLiteDatabase initDatabase(Activity activity) {
        try {
            String outFileName = activity.getApplicationInfo().dataDir + "/databases/" +DATABASE_NAME;
            File f = new File(outFileName);

            if (!f.exists()) {
                InputStream e = activity.getAssets().open(DATABASE_NAME);
                File folder = new File(activity.getApplicationInfo().dataDir + "/databases/");

                if (!folder.exists()) {
                    folder.mkdir();
                }

                FileOutputStream myOutput = new FileOutputStream(outFileName);
                byte[] buffer = new byte[1024];
                int length;

                while ((length = e.read(buffer)) > 0) {
                    myOutput.write(buffer, 0, length);
                }

                myOutput.flush();
                myOutput.close();
                e.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return activity.openOrCreateDatabase(DATABASE_NAME, Context.MODE_PRIVATE, null);
    }

}
