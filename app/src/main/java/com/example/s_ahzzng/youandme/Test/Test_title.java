package com.example.s_ahzzng.youandme.Test;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.s_ahzzng.youandme.Choice;
import com.example.s_ahzzng.youandme.R;
import com.example.s_ahzzng.youandme.Title;

public class Test_title extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_title);

        Handler mHandler = new Handler();
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(Test_title.this, Test.class);
                startActivity(i);
                finish();
            }
        }, 3000);
    }
}
