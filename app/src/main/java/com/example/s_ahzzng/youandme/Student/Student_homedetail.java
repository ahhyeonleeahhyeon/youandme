package com.example.s_ahzzng.youandme.Student;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.s_ahzzng.youandme.DB.DBhelper;
import com.example.s_ahzzng.youandme.R;

public class Student_homedetail extends AppCompatActivity {



    DBhelper dBhelper = new DBhelper(this, "Homesharing",null,1);
    String number = "";
    int url = 0;
    String text = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.student_homedetail);

        Intent intent = getIntent();
        number = intent.getExtras().getString("number");
        SQLiteDatabase db;
        db = dBhelper.home_list_show();
        Cursor cursor = db.rawQuery("SELECT * FROM homelist WHERE number ="+number+"", null);
        cursor.moveToFirst();
       // Cursor cursor = dBhelper.home_list_select(number);
        if(cursor.getCount() == 0)
        {
            String alert = "아직 집이 없습니다!";
            Toast.makeText(getApplicationContext(),number,Toast.LENGTH_LONG).show();
        }
        while(cursor.moveToNext())
        {
            number  = cursor.getString(0);
            url = cursor.getInt(1);
            text  = cursor.getString(2);
            Toast.makeText(getApplicationContext(),text,Toast.LENGTH_LONG).show();
        }

        TextView textname = (TextView)findViewById(R.id.homedetail_name);
        textname.setText(url);

        TextView texttext = (TextView)findViewById(R.id.homedetail_address);
        textname.setText(text);

        FloatingActionButton floatingActionButton  = (FloatingActionButton)findViewById(R.id.fab);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(Student_homedetail.this, Student_main.class);
                startActivity(intent1);
            }
        });

    }
}
