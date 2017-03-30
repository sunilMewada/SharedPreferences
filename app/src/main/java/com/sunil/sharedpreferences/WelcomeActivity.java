package com.sunil.sharedpreferences;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Sunil on 15-03-2017.
 */

public class WelcomeActivity extends Activity {

    private TextView mTextMessage,mText2,mText3,mText4,mText5,mText6;
    Button gmail,facebook;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome_activity);

        mTextMessage = (TextView)findViewById(R.id.text1);
        mText2 = (TextView)findViewById(R.id.text2);
        mText3 = (TextView)findViewById(R.id.text3);
        mText4 = (TextView)findViewById(R.id.text4);
        mText5 = (TextView)findViewById(R.id.text5);
        mText6 = (TextView)findViewById(R.id.text6);

        gmail =(Button)findViewById(R.id.lg_mail);
        facebook = (Button)findViewById(R.id.lg_fb);

        mTextMessage.setText("EmailId : " + getIntent().getStringExtra("Email"));
        mText2.setText("User Name : " + getIntent().getStringExtra("Name"));
        mText3.setText("Middle Name : " + getIntent().getStringExtra("Middle"));
        mText4.setText("Last Name : " + getIntent().getStringExtra("Last"));
        mText5.setText("gender : " + getIntent().getStringExtra("radioSex"));
        mText6.setText("Hobby : "+ getIntent().getStringExtra("hobby"));

        gmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.gmail.com"));
                startActivity(intent);
            }
        });
        facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse("http://www.facebook.com"));
                startActivity(intent);
            }
        });
    }
}
