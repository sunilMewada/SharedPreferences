package com.sunil.sharedpreferences;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText phone,pass;
    private Button login,reg;

    private static final String DEFAULT = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        phone = (EditText)findViewById(R.id.lPhone);
        pass = (EditText)findViewById(R.id.lPass);

        login = (Button)findViewById(R.id.login);
        reg = (Button)findViewById(R.id.register);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String ph,pwd;

                ph = phone.getText().toString();
                pwd = pass.getText().toString();

                SharedPreferences sharedPreferences = getSharedPreferences("Sunil",MODE_PRIVATE);
                String spPhone  = sharedPreferences.getString("Phone",DEFAULT);
                String spPass = sharedPreferences.getString("Password",DEFAULT);
                String spemail = sharedPreferences.getString("Email",DEFAULT);
                String spname = sharedPreferences.getString("Name",DEFAULT);
                String spname2 = sharedPreferences.getString("Middle",DEFAULT);
                String spname3 = sharedPreferences.getString("Last",DEFAULT);
                String spgender = sharedPreferences.getString("radioSex",DEFAULT);
                String spCheckBox = sharedPreferences.getString("hobby",DEFAULT);
                if (spPhone.equals(ph)  && spPass.equals(pwd)){
                    Toast.makeText(MainActivity.this,"Valid user",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this,WelcomeActivity.class);
                    intent.putExtra("Email",spemail);
                    intent.putExtra("Name",spname);
                    intent.putExtra("Middle",spname2);
                    intent.putExtra("Last",spname3);
                    intent.putExtra("radioSex",spgender);
                    intent.putExtra("hobby",spCheckBox);
                    startActivity(intent);
                }else {
                    Toast.makeText(MainActivity.this,"Invalid User",Toast.LENGTH_SHORT).show();
                }
            }
        });
        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Register.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
