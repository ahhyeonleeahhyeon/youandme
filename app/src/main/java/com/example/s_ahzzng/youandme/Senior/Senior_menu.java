package com.example.s_ahzzng.youandme.Senior;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.s_ahzzng.youandme.R;

public class Senior_menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.senior_menu);

        Button senior_management = (Button)findViewById(R.id. senior_btn1);
        Button senior_emergency = (Button)findViewById(R.id. senior_btn2);
        Button senior_communication = (Button)findViewById(R.id. senior_btn3);
        Button senior_consulting = (Button)findViewById(R.id. senior_btn4);

        senior_emergency.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Senior_menu.this,Senior_emergency.class);
                startActivity(intent);
            }
        });
    }
}
