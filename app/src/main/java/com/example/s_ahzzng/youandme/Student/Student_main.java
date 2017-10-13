package com.example.s_ahzzng.youandme.Student;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.example.s_ahzzng.youandme.DB.DBhelper;
import com.example.s_ahzzng.youandme.R;
import com.example.s_ahzzng.youandme.Test.Test_title;

public class Student_main extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    DBhelper dBhelper = new DBhelper(this, "Homesharing",null,1);
    String number = "";
    String s_name = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ///////////////////////////////
        GridView gridView = (GridView)findViewById(R.id.listview_stu);
        homelistAdapter homelistAdapter = new homelistAdapter();
        gridView.setAdapter(homelistAdapter);


        dBhelper.home_list_insert(R.drawable.home1, "No.1 sharing house", "서울시 광진구 화양동","Lee A.h");
        dBhelper.home_list_insert(R.drawable.home2, "Happy House", "서울시 동작구 사당동","Lee E.S");
        dBhelper.home_list_insert(R.drawable.home3,"Smart house", "서울시 광진구 아차산로", "Jeon I.E");
        dBhelper.home_list_insert(R.drawable.home4,"Opened house","서울시 광진구 능동로 120","Son Y.Y");
       // dBhelper.home_list_insert(R.drawable.home5,"Home sharing");


        SQLiteDatabase homelist_db;
        homelist_db  = dBhelper.home_list_show();

        Cursor cursor = homelist_db.rawQuery("SELECT * FROM homelist",null);
        if(cursor.getCount() == 0)
        {
            String alert = "아직 집이 없습니다!";
            // homelistAdapter.addItem(null,alert);
        }
        while(cursor.moveToNext())
        {
            number  = cursor.getString(0);
            int url = cursor.getInt(1);
            String homename  = cursor.getString(2);
            String homeaddr = cursor.getString(3);
            String homehost= cursor.getString(4);
            homelistAdapter.addItem(url, homename, homeaddr, homehost);
        }

       gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                Intent intent  = new Intent(Student_main.this, Student_homedetail.class);
                intent.putExtra("number",number);
                startActivity(intent);
           }
       });
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.student_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {
            Intent intent = new Intent(Student_main.this , Test_title.class);
            intent.putExtra("name", s_name);

            startActivity(intent);


        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
