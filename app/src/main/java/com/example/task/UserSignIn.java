package com.example.task;

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

import com.example.task.database.User;

public class UserSignIn extends AppCompatActivity {
    private static final String TAG = "UserSignIn";
    TextView register;
    Button login;
    EditText user_id,password;
    CheckBox sp;
    SQLiteDatabase db;
   // UserRegister userRegister;
    Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_sign_in);
        user_id=findViewById(R.id.login_userid);
        password=findViewById(R.id.login_pwd);
       // sp=(CheckBox)findViewById(R.id.sp);
        //userRegister=new UserRegister(this);
      //  db=userRegister.getReadableDatabase();
        register=findViewById(R.id.reg);
        login=findViewById(R.id.signin);


        /*sp.setOnCheckedChangeListener((new CompoundButton.OnCheckedChangeListener()
        {

            @Override
            public void onCheckedChanged(CompoundButton button,
                                         boolean isChecked)
            {

                // If it is checkec then show password else hide
                // password
                if (isChecked)
                {

                    sp.setText(R.string.hide_pwd);// change
                    // checkbox
                    // text

                    password.setInputType(InputType.TYPE_CLASS_TEXT);
                    password.setTransformationMethod(HideReturnsTransformationMethod
                            .getInstance());// show password
                } else

                {
                    sp.setText(R.string.show_pwd);// change
                    // checkbox
                    // text

                    password.setInputType(InputType.TYPE_CLASS_TEXT
                            | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                    password.setTransformationMethod(PasswordTransformationMethod
                            .getInstance());// hide password

                }

            }
        }));
*/


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
                Log.d(TAG, "onClick: "+User_id+"\n"+pass);
                User user=new User(UserSignIn.this);
                Boolean userIdPasswrd=user.emailpassword(User_id,pass);
                if(userIdPasswrd==true)
                {
                    Toast.makeText(getApplicationContext(),"Sucess",Toast.LENGTH_LONG).show();
                    /*Intent i=new Intent(UserSignIn.this,MainActivity.class);
                    startActivity(i);*/

                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Login failed..",Toast.LENGTH_LONG).show();


                }


            }
        });



    }
}
