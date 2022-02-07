package com.example.sakatat_customcoloring;

public class EventController
{
    private ColoringModel coloringModel;
    private ColoringView coloringView;

    public EventController(ColoringView coloringView)
    {
        this.coloringView = coloringView;
        this.coloringModel = coloringView.getColoringModel();
    }
}
