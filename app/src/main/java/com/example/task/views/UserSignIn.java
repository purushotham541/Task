package com.example.task.views;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.task.R;
import com.example.task.database.User;

public class UserSignIn extends AppCompatActivity
{
    private static final String TAG = "UserSignIn";
    TextView register;
    Button login;
    EditText user_id,password;
    CheckBox sp;
    SQLiteDatabase db;
    Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_sign_in);
        user_id=findViewById(R.id.login_userid);
        password=findViewById(R.id.login_pwd);
        register=findViewById(R.id.reg);
        login=findViewById(R.id.signin);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(UserSignIn.this,UserSignUp.class);
                startActivity(intent);

            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                String User_id = user_id.getText().toString();
                String pass = password.getText().toString();
                Log.d(TAG, "Validation check: "+User_id+" "+pass);
                User user=new User(UserSignIn.this);
                int valid=user.Login(User_id,pass);
                if(valid>0)
                {
                    Log.d(TAG, "onClick: Login success");
                    Toast.makeText(getApplicationContext(),"Login Sucess",Toast.LENGTH_LONG).show();
                    Intent i=new Intent(UserSignIn.this,MainActivity.class);
                    startActivity(i);

                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Login failed..",Toast.LENGTH_LONG).show();


                }


            }
        });



    }
}
