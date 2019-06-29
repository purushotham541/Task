package com.example.task;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.task.database.User;

public class UserSignUp extends AppCompatActivity {

    EditText userid, pwd, confirmpass;
    Button register;
    User user;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_sign_up);
        userid =  findViewById(R.id.userid);
        pwd = findViewById(R.id.pwd);
        confirmpass =  findViewById(R.id.cnfrmPwd);
        register=findViewById(R.id.register);
        register.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                String User_Id = userid.getText().toString();
                String Password = pwd.getText().toString();
                String Confirm_Pwd = confirmpass.getText().toString();
                register =findViewById(R.id.register);
                if (User_Id.length() == 0)
                {
                    userid.setError(" Empty");
                    userid.requestFocus();
                }
                else if (Password.length() == 0)
                {
                    pwd.setError("Password not entered");
                    pwd.requestFocus();
                }
                else if (Confirm_Pwd.length() == 0)
                {
                    confirmpass.setError("Empty");
                    confirmpass.requestFocus();

                }
                else if (!pwd.getText().toString().equals(confirmpass.getText().toString())) {
                    confirmpass.setError("Password Not matched");
                    confirmpass.requestFocus();
                }
                else
                    {
                    user = new User(UserSignUp.this);
                    user.userRegistration(User_Id,Password,Confirm_Pwd);
                    Toast.makeText(getApplicationContext(), "Success..", Toast.LENGTH_LONG).show();
                    userid.setText("");
                    pwd.setText("");
                    confirmpass.setText("");
                    finish();

                }


            }
        });


    }



}
