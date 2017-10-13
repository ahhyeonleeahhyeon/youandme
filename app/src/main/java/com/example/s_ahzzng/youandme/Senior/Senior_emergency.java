package com.example.s_ahzzng.youandme.Senior;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.s_ahzzng.youandme.R;

public class Senior_emergency extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_senior_emergency);

        Button btn_119= (Button)findViewById(R.id.btn_emergency_119);
        Button btn_partner= (Button)findViewById(R.id.btn_emergency_partner);


        btn_119.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tel = "911";
                startActivity(new Intent("android.intent.action.CALL", Uri.parse(tel)));
            }
        });


        btn_partner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tel = "01012345678";
                startActivity(new Intent("android.intent.action.CALL", Uri.parse(tel)));
            }
        });
    }
}
