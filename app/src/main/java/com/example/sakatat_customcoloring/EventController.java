/*
    @author: Tyler Sakata
    This is the controller class for the coloring assignment
    - Manages taps on the drawing and changes on the seekbar.
    - Manages the textView depending on what is tapped
 */

package com.example.sakatat_customcoloring;

import android.graphics.Color;
import android.view.MotionEvent;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

public class EventController implements View.OnTouchListener, SeekBar.OnSeekBarChangeListener
{
    // instance variables
    // coloringModel is a reference to the coloringModel we will use.
    // coloringView is also a reference
    // currentPart is an integer that changes depending on which part of the drawing is clicked on
    // parts r,g,b are the respective values for any given current part.
    // text view is a reference to the text view that displays which part is selected
    private ColoringModel coloringModel;
    private ColoringView coloringView;
    private int currentPart = 0;
    private int partR;
    private int partG;
    private int partB;
    private TextView textView;

    // initialize the references to objects
    public EventController(ColoringView coloringView, TextView textView)
    {
        this.coloringView = coloringView;
        this.coloringModel = coloringView.getColoringModel();
        this.textView = textView;
    }

    // everytime surfaceview is touched this is called. Each if statement checks for the tap
    // location and sees if it is on any valid component.
    @Override
    public boolean onTouch(View view, MotionEvent motionEvent)
    {
        // bracelet stone
        if(motionEvent.getY() > coloringView.braceletCenterY - coloringView.stoneRadius
            && motionEvent.getY() < coloringView.braceletCenterY + coloringView.stoneRadius
            && motionEvent.getX() > coloringView.braceletCenterX - coloringView.stoneRadius
            && motionEvent.getX() < coloringView.braceletCenterX + coloringView.stoneRadius)
        {
            currentPart = 6;
            separateColors(coloringModel.getStoneColor());
            textView.setText("Mega bracelet stone");
        }

        // bracelet rect
        else if(motionEvent.getY() > coloringView.braceletTop
                && motionEvent.getY() < coloringView.braceletBottom
                && motionEvent.getX() > coloringView.braceletLeft
                && motionEvent.getX() < coloringView.braceletRight)
        {
            currentPart = 5;
            separateColors(coloringModel.getBraceletColor());
            textView.setText("Mega bracelet");
        }

        // button of ball
        else if(motionEvent.getY() > coloringView.ballCenterY - coloringView.buttonRadius
                && motionEvent.getY() < coloringView.ballCenterY + coloringView.buttonRadius
                && motionEvent.getX() > coloringView.ballCenterX - coloringView.buttonRadius
                && motionEvent.getX() < coloringView.ballCenterX + coloringView.buttonRadius)
        {
            currentPart = 4;
            separateColors(coloringModel.getButtonColor());
            textView.setText("Pokeball button");
        }
        // band of ball
        else if(motionEvent.getY() > coloringView.ballCenterY - coloringView.bandWidth
                && motionEvent.getY() < coloringView.ballCenterY + coloringView.bandWidth
                && motionEvent.getX() > coloringView.ballCenterX - coloringView.ballRadius
                && motionEvent.getX() < coloringView.ballCenterX + coloringView.ballRadius)
        {
            currentPart = 3;
            separateColors(coloringModel.getBandColor());
            textView.setText("Pokeball center band");
        }
        // top part of ball
        else if(motionEvent.getY() > coloringView.ballCenterY - coloringView.ballRadius
                && motionEvent.getY() < coloringView.ballCenterY - coloringView.bandWidth
                && motionEvent.getX() > coloringView.ballCenterX - coloringView.ballRadius
                && motionEvent.getX() < coloringView.ballCenterX + coloringView.ballRadius)
        {
            currentPart = 2;
            separateColors(coloringModel.getTopColor());
            textView.setText("Pokeball top section");
        }
        // bottom part of ball
        else if(motionEvent.getY() > coloringView.ballCenterY + coloringView.bandWidth
                && motionEvent.getY() < coloringView.ballCenterY + coloringView.ballRadius
                && motionEvent.getX() > coloringView.ballCenterX - coloringView.ballRadius
                && motionEvent.getX() < coloringView.ballCenterX + coloringView.ballRadius)
        {
            currentPart = 1;
            separateColors(coloringModel.getBottomColor());
            textView.setText("Pokeball bottom section");
        }
        return true;
    }

    // handles which parts gets colored. each integer corresponds to a part.
    public void colorHandler(int modifiedRGB)
    {
        if(currentPart == 1)
        {
            coloringModel.setBottomColor(modifiedRGB);
        }
        else if(currentPart == 2)
        {
            coloringModel.setTopColor(modifiedRGB);
        }
        else if(currentPart == 3)
        {
            coloringModel.setBandColor(modifiedRGB);
        }
        else if(currentPart == 4)
        {
            coloringModel.setButtonColor(modifiedRGB);
        }
        else if(currentPart == 5)
        {
            coloringModel.setBraceletColor(modifiedRGB);
        }
        else
        {
            coloringModel.setStoneColor(modifiedRGB);
        }
    }

    // helper method to separate the colors
    ///////////////////////////////////////////////////////////////////////////////////////////////
    // Thanks to Jake Uyechi and his computer architecture class for teaching me how to separate
    // the RGB values as hex values using bit shifting.
    public void separateColors(int toSeparate)
    {
        partR = (0x00FF0000 & toSeparate) >> 16;
        partG = (0x0000FF00 & toSeparate) >> 8;
        partB = (0x000000FF & toSeparate);
        MainActivity.setSeekBars(partR, partG, partB);
    }

    // seekbar listener sets the value of the respective rgb values to the value of the seekbar
    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
        if(currentPart == 0)
        {
            return;
        }
        if(seekBar.getId() == R.id.redSeekBar)
        {
            partR = i;
        }
        else if(seekBar.getId() == R.id.greenSeekBar)
        {
            partG = i;
        }
        else if(seekBar.getId() == R.id.blueSeekBar)
        {
            partB = i;
        }
        colorHandler(Color.rgb(partR, partG, partB));
        MainActivity.setSeekBarVal(partR, partG, partB);
        coloringView.invalidate();
    }

    // unused methods
    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
        // do nothing
    }
    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        // do nothing
    }
}
