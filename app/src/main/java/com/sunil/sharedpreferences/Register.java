package com.sunil.sharedpreferences;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Sunil on 15-03-2017.
 */

public class Register extends Activity{

    private EditText email,phone,pwd,cfpass,name,name2,name3;
    private Button reg,cancel;
    RadioGroup genderRadioGroup;
    CheckBox cricket,hocky;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_activity);


        email = (EditText)findViewById(R.id.remail);
        phone = (EditText)findViewById(R.id.rphone);
        pwd = (EditText)findViewById(R.id.rpassword);
        cfpass = (EditText)findViewById(R.id.rcpass);
        name = (EditText)findViewById(R.id.rname);
        name2 = (EditText)findViewById(R.id.rmiddle);
        name3= (EditText)findViewById(R.id.rlast);
        genderRadioGroup = (RadioGroup)findViewById(R.id.gender);
        cricket = (CheckBox)findViewById(R.id.cricket);
        hocky = (CheckBox)findViewById(R.id.hocky);

        reg = (Button)findViewById(R.id.Rregister);
        cancel = (Button)findViewById(R.id.Rcancel);
        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!isValidEmail(email.getText().toString())){
                    email.setError("Enter email");
                    email.requestFocus();
                    return;
                }
                if (phone.getText().toString().isEmpty()){
                    phone.setError("Enter phone no.");
                    phone.requestFocus();
                    return;
                }
                if (pwd.getText().toString().isEmpty()){
                    pwd.setError("Enter password");
                    pwd.requestFocus();
                    return;
                }
                if (cfpass.getText().toString().isEmpty()){
                    cfpass.setError("Enter cfm password");
                    cfpass.requestFocus();
                    return;
                }
                if (name.getText().toString().isEmpty()){
                    name.setError("Enter First name");
                    name.requestFocus();
                    return;
                }
                if (name2.getText().toString().isEmpty()){
                    name2.setError("Enter middle name");
                    name2.requestFocus();
                    return;
                }
                if (name3.getText().toString().isEmpty()){
                    name3.setError("Enter last name");
                    name3.requestFocus();
                    return;
                }
                String mail,ph,pass,cpass,fname,mname,lname;
                mail = email.getText().toString();
                ph = phone.getText().toString();
                pass = pwd.getText().toString();
                cpass = cfpass.getText().toString();
                fname = name.getText().toString();
                mname = name2.getText().toString();
                lname = name3.getText().toString();

                if (pass.equals(cpass)){
                    SharedPreferences sharedPreferences = getSharedPreferences("Sunil",MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("Email",mail);
                    editor.putString("Phone",ph);
                    editor.putString("Password",pass);
                    editor.putString("Name",fname);
                    editor.putString("Middle",mname);
                    editor.putString("Last",lname);

                    Toast.makeText(Register.this, "Registered Successful", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Register.this,MainActivity.class);

                    int SelectedId = genderRadioGroup.getCheckedRadioButtonId();
                    RadioButton radioSexButton = (RadioButton)findViewById(SelectedId);
                    editor.putString("radioSex",radioSexButton.getText().toString());

                    if (cricket.isChecked() && hocky.isChecked()){
                        intent.putExtra("hobby","cricket,hocky");
                    }
                   else if (cricket.isChecked()){
                        intent.putExtra("hobby","cricket");
                    }
                    else if (hocky.isChecked()){
                        intent.putExtra("hobby","hocky");
                    }
                    else {
                        intent.putExtra("hobby","None");
                    }

                    editor.putString("hobby",cricket.getText().toString());
                    editor.putString("hobby",hocky.getText().toString());
                    editor.commit();
                    intent.putExtra("radioSex",radioSexButton.getText().toString());

                    intent.putExtra("hobby",cricket.getText().toString());
                    intent.putExtra("hobby",hocky.getText().toString());
                    startActivity(intent);
                    finish();
                }
            }

            private boolean isValidEmail(String Email) {
                String Email_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
                Pattern pattern = Pattern.compile(Email_PATTERN);
                Matcher matcher = pattern.matcher(Email);
                return matcher.matches();
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
