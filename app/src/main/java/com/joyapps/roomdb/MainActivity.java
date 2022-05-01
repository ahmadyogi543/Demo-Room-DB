package com.joyapps.roomdb;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import com.joyapps.roomdb.DBUtils.AppDatabase;
import com.joyapps.roomdb.DBUtils.User;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private AppDatabase appDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        appDB = AppDatabase.getInstance(this);
        this.handleBtnAddData();
        this.handleBtnGetData();
    }

    private void handleBtnAddData() {
        Button btnAddData = findViewById(R.id.btnAddData);
        btnAddData.setOnClickListener(v -> {
            User user = new User(
                    (int) (Math.random() * 1000),
                    "Ahmad",
                    "Yogi",
                    "ahmadyogi1",
                    "123");
            appDB.userDao().InsertOne(user);
            Toast.makeText(this, "Data berhasil ditambahkan!", Toast.LENGTH_SHORT).show();
        });
    }

    private void handleBtnGetData() {
        Button btnGetData = findViewById(R.id.btnGetData);
        btnGetData.setOnClickListener(v -> {
            List<User> users = appDB.userDao().getAll();
            Toast.makeText(this,
                    "Data berhasil diterima!" + users.toString(), Toast.LENGTH_SHORT).show();
        });
    }
}
