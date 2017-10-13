package com.example.s_ahzzng.youandme.Student;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.s_ahzzng.youandme.DB.DBhelper;
import com.example.s_ahzzng.youandme.R;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Student_login extends AppCompatActivity {

    public static final int CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE = 100;
    Uri uri ;
    DBhelper dBhelper = new DBhelper(this, "Homesharing",null,1);
    String s_name;
    String s_age;
    String s_email;
    String s_home;
    String s_school;
    String s_photo;
    String s_gender = "null";
    ImageView imageView;
    String url = "";
    public static final int MEDIA_TYPE_IMAGE = 1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.student_login);

        imageView  = (ImageView)findViewById(R.id.imageView_photo) ;
        Button btnCamera = (Button)findViewById(R.id.btn_photo);
        Button btnRegister = (Button)findViewById(R.id.btn_register);


        EditText editName = (EditText)findViewById(R.id.edit_name);
        EditText editAge = (EditText)findViewById(R.id.edit_age);
        EditText editEmail = (EditText)findViewById(R.id.edit_email);
        EditText editHome = (EditText)findViewById(R.id.edit_home);
        EditText editSchool = (EditText)findViewById(R.id.edit_school);


        s_name = editName.getText().toString();
        s_age = editAge.getText().toString();
        s_email = editEmail.getText().toString();
        s_school = editSchool.getText().toString();
        s_home  = editHome.getText().toString();

        btnCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog();
            }
        });
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Student_login.this, Student_main.class);
                intent.putExtra("name", s_name);
                //dBhelper.student_register(s_name, s_age,s_email,s_home,s_school,s_gender,s_photo);
                startActivity(intent);
            }
        });
    }

    public void showDialog()
    {
        LayoutInflater layoutInflater = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(Student_login.this);
        alertDialog.setTitle("Take picture");
        alertDialog.setPositiveButton("take photo", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                uri = Uri.fromFile(getOutputFile());
                url = uri.toString();
                intent.putExtra(MediaStore.EXTRA_OUTPUT, uri);
                startActivityForResult(intent, CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE);

            }
        });
        alertDialog.setNegativeButton("close",null);

        alertDialog.show();

    }
    public File getOutputFile()
    {
        File mediaStorageDir = new File(  Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_PICTURES), "home");
        //File mediaStorageDir = new File("/storage/emulated/0/DCIM/Camera", "home");
        if (! mediaStorageDir.exists()){
            if (! mediaStorageDir.mkdirs()){
                Log.d("home", "failed to create directory");
                return null;
            }
        }
        //파일 생성하는 곳
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        File mediaFile;
        mediaFile = new File(mediaStorageDir.getPath() + File.separator +
                    "IMG_"+ timeStamp + ".jpg");
        return mediaFile;
    }


    //촬영하고 그 후 실행하는 함수

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE)
        {
            if (resultCode == Activity.RESULT_OK) {

                    Bitmap bitmap = null;
                    try {
                        bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), uri);
                        imageView.setImageBitmap(bitmap);
                        s_photo = uri.toString();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
        }
        else if (resultCode == RESULT_CANCELED)
        {
                Log.e("com", "result_canceled");
                // User cancelled the image capture
        }
        else {
                // Image capture failed, advise use
        }

    }
}




