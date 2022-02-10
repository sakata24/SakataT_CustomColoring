/*
    @author: Tyler Sakata
    This is the main activity class for the coloring assignment
    - Generates the environment and handles the seekbar values
 */

package com.example.sakatat_customcoloring;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    // instance variables to be used outside of onCreate
    static SeekBar redSeekbar;
    static SeekBar greenSeekbar;
    static SeekBar blueSeekbar;

    static TextView redVal;
    static TextView greenVal;
    static TextView blueVal;

    // "main" method
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // create reference to the coloringView
        ColoringView coloringView = findViewById(R.id.drawingView);
        // create reference to the textView
        TextView textView = findViewById(R.id.nameOfComponent);
        // create the colorController
        EventController colorController = new EventController(coloringView, textView);
        // link the controller to the view
        coloringView.setOnTouchListener(colorController);
        // create a reference to the seekbars
        redSeekbar = findViewById(R.id.redSeekBar);
        greenSeekbar = findViewById(R.id.greenSeekBar);
        blueSeekbar = findViewById(R.id.blueSeekBar);
        // set the listener for the seekbars
        redSeekbar.setOnSeekBarChangeListener(colorController);
        greenSeekbar.setOnSeekBarChangeListener(colorController);
        blueSeekbar.setOnSeekBarChangeListener(colorController);
        // create a reference to the textViews
        redVal = findViewById(R.id.redVal);
        greenVal = findViewById(R.id.greenVal);
        blueVal = findViewById(R.id.blueVal);

    }
    // method to set the seekbars in here because we dont have a reference in the controller class
    public static void setSeekBars(int red, int green, int blue)
    {
        redSeekbar.setProgress(red);
        greenSeekbar.setProgress(green);
        blueSeekbar.setProgress(blue);
        setSeekBarVal(red, green, blue);
    }
    // method to set the text that shows tha value of the seekbars
    public static void setSeekBarVal(int red, int green, int blue)
    {
        redVal.setText(Integer.toString(red));
        greenVal.setText(Integer.toString(green));
        blueVal.setText(Integer.toString(blue));
    }
}