package com.example.s_ahzzng.youandme;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Title extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_title);
        Handler mHandler = new Handler();
        mHandler.postDelayed(new Runnable() {
//Do Something
        @Override
         public void run() {
                        // TODO Auto-generated method stub
                            Intent i = new Intent(Title.this, Choice.class);
                             startActivity(i);
                           finish();
                       }
    }, 3000);


    }
}
