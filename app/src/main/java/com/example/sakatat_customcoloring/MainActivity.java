package com.example.sakatat_customcoloring;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // create reference to the coloringView
        ColoringView coloringView = findViewById(R.id.drawingView);
        // create the colorController
        EventController colorController = new EventController(coloringView);
        // create a reference to the "blow out" button
        //Button blowOutButton = findViewById(R.id.blowButton);
        // set the cakeController to listen to the blowOutButton
        //blowOutButton.setOnClickListener(cakeController);
    }
}