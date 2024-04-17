package com.example.hostelmanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
GridView MyGrid ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

     MyGrid = findViewById(R.id.idDashBoard);

        ArrayList<TitleModel> TitleModelArrayList = new ArrayList<TitleModel>();
        TitleModelArrayList.add(new TitleModel("Student Management", R.drawable.ic_launcher_background));
        TitleModelArrayList.add(new TitleModel("Room Management", R.drawable.ic_launcher_background));
        TitleModelArrayList.add(new TitleModel("Room Allotment", R.drawable.ic_launcher_background));
        TitleModelArrayList.add(new TitleModel("Room Availability", R.drawable.ic_launcher_background));
        TitleModelArrayList.add(new TitleModel("Fee Management", R.drawable.ic_launcher_background));
        TitleModelArrayList.add(new TitleModel("Notifications Management", R.drawable.ic_launcher_background));
    }

}