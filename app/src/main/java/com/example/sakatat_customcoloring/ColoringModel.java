package com.example.sakatat_customcoloring;

import android.graphics.Color;

public class ColoringModel
{
    private int topColor = 0xFFEE1515;
    private int bottomColor = Color.WHITE;
    private int bandColor = Color.BLACK;
    private int buttonColor = Color.WHITE;
    private int braceletColor = Color.GRAY;
    private int stoneColor = Color.GREEN;

    public int getTopColor() {
        return topColor;
    }

    public void setTopColor(int topColor) {
        this.topColor = topColor;
    }

    public int getBottomColor() {
        return bottomColor;
    }

    public void setBottomColor(int bottomColor) {
        this.bottomColor = bottomColor;
    }

    public int getBandColor() {
        return bandColor;
    }

    public void setBandColor(int bandColor) {
        this.bandColor = bandColor;
    }

    public int getButtonColor() {
        return buttonColor;
    }

    public void setButtonColor(int buttonColor) {
        this.buttonColor = buttonColor;
    }

    public int getBraceletColor() {
        return braceletColor;
    }

    public void setBraceletColor(int braceletColor) {
        this.braceletColor = braceletColor;
    }

    public int getStoneColor() {
        return stoneColor;
    }

    public void setStoneColor(int stoneColor) {
        this.stoneColor = stoneColor;
    }
}
