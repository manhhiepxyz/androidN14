package com.example.nhom14didong;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.nhom14didong.Database.Database;
import com.example.nhom14didong.Model.User;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_edit_user);



    }
    public List<User> getAllUsers() {
        List<User> userList = new ArrayList<>();
        SQLiteDatabase db = Database.initDatabase(this) ;// Lấy cơ sở dữ liệu để đọc


        Cursor cursor = db.query("NGUOIDUNG", null, null, null, null, null, null);

        if (cursor.moveToFirst()) {
            do {
                try {
                    int id = cursor.getInt(cursor.getColumnIndexOrThrow("USERID"));
                    String name = cursor.getString(cursor.getColumnIndexOrThrow("USERNAME"));
                    String pass = cursor.getString(cursor.getColumnIndexOrThrow("USERPASS"));

                    User user = new User();
                    user.setUserID(id);
                    user.setUserName(name);
                    user.setUserPass(pass);
                    userList.add(user);
                } catch (IllegalArgumentException e) {
                    // Xử lý lỗi nếu không tìm thấy cột
                    Log.e("DatabaseError", "Column not found: " + e.getMessage());
                }
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return userList;
    }
}