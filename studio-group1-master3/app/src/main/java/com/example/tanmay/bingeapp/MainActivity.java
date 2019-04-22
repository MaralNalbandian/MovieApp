package com.example.tanmay.bingeapp;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    SQLiteDatabase db;
    SQLiteOpenHelper openHelper;
    Cursor cursor;
    Button loginBtn, registerBtn;
    EditText usernameEt, passwordEt;
    TextView registerTv;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        usernameEt = (EditText) findViewById(R.id.usernameEditText);
        passwordEt = (EditText) findViewById(R.id.passwordEditText);
        loginBtn = (Button) findViewById(R.id.loginBtn);
        openHelper = new DatabaseHelper(this);
        db = openHelper.getReadableDatabase();
        registerTv = (TextView) findViewById(R.id.registertextView);
        registerBtn = (Button) findViewById(R.id.registerBtn);
        loginBtn.setEnabled(false);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = usernameEt.getText().toString();
                String password = passwordEt.getText().toString();
                cursor =db.rawQuery("SELECT * FROM "+DatabaseHelper.TABLE_NAME +" WHERE "
                        +DatabaseHelper.COL_2 +" =? AND " +DatabaseHelper.COL_3 +" =? ",new String[]{username, password});
                if(cursor !=null)
                {
                    if (cursor.getCount() > 0) {

                        cursor.moveToNext();
                        Toast.makeText(getApplicationContext(), "Login Successful!", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(MainActivity.this, MovieScreen.class);
                        startActivity(intent);

                    } else {
                        Toast.makeText(getApplicationContext(), "Username and/or Password Incorrect.", Toast.LENGTH_SHORT).show();
                    }
                }
            }});
        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Register.class);
                startActivity(intent);
            }
        });
        usernameEt.addTextChangedListener(loginTextWatcher);
        passwordEt.addTextChangedListener(loginTextWatcher);
    }
    private TextWatcher loginTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            String usernameInput = usernameEt.getText().toString().trim();
            String passwordInput = passwordEt.getText().toString().trim();
            loginBtn.setEnabled(!usernameInput.isEmpty() && !passwordInput.isEmpty());
        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };
}