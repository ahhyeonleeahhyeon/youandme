package com.example.s_ahzzng.youandme;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.s_ahzzng.youandme.Senior.Senior_menu;
import com.example.s_ahzzng.youandme.Student.Student_login;

//처음에 학생인지 어르신인지 선택하는 액티비티
public class Choice extends SpeechActivity {

    MyGestureListener myGestureListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choice);
        initSpeech(this);
        ImageButton btn_stu = (ImageButton)findViewById(R.id.choice_stu);
        ImageButton btn_old = (ImageButton)findViewById(R.id.choice_old);

        btn_old.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Choice.this, Senior_menu.class);
                startActivity(intent);
                //Senior 메뉴로 이동
            }
        });

        btn_stu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Choice.this, Student_login.class);
                startActivity(intent);
                //Senior 메뉴로 이동
            }
        });
    }

    @Override
    void onSpeech(String result) {
        Toast.makeText(getApplicationContext(),result, Toast.LENGTH_LONG).show();
        if(result == "노인")
        {
            Intent intent = new Intent(Choice.this, Senior_menu.class);
            startActivity(intent);
        }
        if(result == "학생")
        {
            Intent intent = new Intent(Choice.this, Student_login.class);
            startActivity(intent);
        }
    }

    @Override
    void onSmallVoice() {
        Toast.makeText(getApplicationContext(), "큰 목소리로 말하세요.", Toast.LENGTH_SHORT).show();

    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int pointer_count = event.getPointerCount(); //현재 터치 발생한 포인트 수를 얻는다.
        if(pointer_count > 3) pointer_count = 3; //4개 이상의 포인트를 터치했더라도 3개까지만 처리를 한다.
        switch(event.getAction() & MotionEvent.ACTION_MASK) {
            case MotionEvent.ACTION_POINTER_DOWN: //두 개 이상의 포인트에 대한 DOWN을 얻을 때.
                Intent intent = new Intent(Choice.this, Senior_menu.class);
                startActivity(intent);
                break;
        }
        return super.onTouchEvent(event);
    }
}
