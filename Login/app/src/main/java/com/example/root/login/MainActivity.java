package com.example.root.login;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText user, pass;
    private Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        user = (EditText) findViewById(R.id.et_user);
        pass = (EditText) findViewById(R.id.et_pass);
        login = (Button) findViewById(R.id.btn_login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = user.getText().toString();
                String password = pass.getText().toString();
                String validusername1 = "erick";
                String validusername2 = "berlian";
                String validpassword1 = "erick";
                String validpassword2 = "berlian";

                if((username.equals(validusername1) && password.equals(validpassword1)) || (username.equals(validusername2) && password.equals(validpassword2)) ){
                    Intent intent = new Intent(MainActivity.this, Login.class );
                    intent.putExtra("Username", user.getText().toString());
                    MainActivity.this.startActivity(intent);
                }else{
                    Toast.makeText(MainActivity.this,
                            "Login Failed! Wrong Username or Password",
                            Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public void onBackPressed(){
        Intent a = new Intent(Intent.ACTION_MAIN);
        a.addCategory(Intent.CATEGORY_HOME);
        a.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(a);
    }
}
