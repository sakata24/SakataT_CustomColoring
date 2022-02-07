package com.example.sakatat_customcoloring;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.SurfaceView;

public class ColoringView extends SurfaceView
{
    private ColoringModel coloringModel;

    // editable pokeball colors
    Paint ballTopColor = new Paint();
    Paint ballBottomColor = new Paint();
    Paint ballBandColor = new Paint();
    Paint ballButtonColor = new Paint();

    // editable mega bracelet colors
    Paint megaBraceletColor = new Paint();
    Paint megaBraceletStoneColor = new Paint();

    // uneditable colors
    Paint megaBraceletAccentColor = new Paint();
    Paint tableColor = new Paint();
    Paint shadowColor = new Paint();

    // draw locations
    public float ballCenterX = 550f;
    public float ballCenterY = 600f;
    public float ballRadius = 250f;
    public float buttonRadius = 40f;
    public float bandWidth = 30f;
    public float bandCenter = 60f;

    public float braceletLeft = 600f;
    public float braceletTop = -300f;
    public float braceletRight = 1300f;
    public float braceletBottom = -100f;
    public float braceletCenterX = 950f;
    public float braceletCenterY = -200f;
    public float stoneRadius = 90f;

    public ColoringView(Context context, AttributeSet attrs)
    {
        // view constructor
        super(context, attrs);

        // creating the coloring model object
        this.coloringModel = new ColoringModel();

        // essential thingy i copied from birthday cake
        setWillNotDraw(false);

        // init colors
        ballTopColor.setColor(coloringModel.getTopColor());  //pokeball red
        ballTopColor.setStyle(Paint.Style.FILL);
        ballBottomColor.setColor(coloringModel.getBottomColor());
        ballBottomColor.setStyle((Paint.Style.FILL));
        ballBandColor.setColor(coloringModel.getBandColor());
        ballBandColor.setStyle((Paint.Style.FILL));
        ballButtonColor.setColor(coloringModel.getButtonColor());
        ballButtonColor.setStyle((Paint.Style.FILL));
        megaBraceletColor.setColor(coloringModel.getBraceletColor());
        megaBraceletColor.setStyle((Paint.Style.FILL));
        megaBraceletStoneColor.setColor(coloringModel.getStoneColor());
        megaBraceletStoneColor.setStyle((Paint.Style.FILL));
        megaBraceletAccentColor.setColor(Color.BLACK);
        megaBraceletAccentColor.setStyle((Paint.Style.FILL));
        tableColor.setColor(0xFF964B00);
        tableColor.setStyle((Paint.Style.FILL));
        shadowColor.setColor(0xFF762B00);
        shadowColor.setStyle((Paint.Style.FILL));

        setBackgroundColor(Color.BLUE);  //better than black default
    }

    public void onDraw(Canvas canvas)
    {
        // TODO: Draw the picture
        // pokeball
        canvas.drawOval((ballCenterX - ballRadius), (ballCenterY - ballRadius), (ballCenterX + ballRadius), (ballCenterY + ballRadius), ballBandColor);
        canvas.drawArc((ballCenterX - ballRadius), (ballCenterY - ballRadius), (ballCenterX + ballRadius), (ballCenterY + ballRadius) - bandWidth, 180
                , 180,true, ballTopColor);
        canvas.drawArc((ballCenterX - ballRadius), (ballCenterY - ballRadius) + bandWidth, (ballCenterX + ballRadius), (ballCenterY + ballRadius), 0
                , 180,true, ballBottomColor);
        canvas.drawOval((ballCenterX - bandCenter), (ballCenterY - bandCenter), (ballCenterX + bandCenter), (ballCenterY + bandCenter), ballBandColor);
        canvas.drawOval((ballCenterX - buttonRadius), (ballCenterY - buttonRadius), (ballCenterX + buttonRadius), (ballCenterY + buttonRadius), ballButtonColor);
        // mega bracelet
        canvas.rotate(45);
        canvas.drawRect(braceletLeft, braceletTop, braceletRight, braceletBottom, megaBraceletColor);
        canvas.drawOval(braceletCenterX - stoneRadius, braceletCenterY - stoneRadius, braceletCenterX + stoneRadius, braceletCenterY + stoneRadius, megaBraceletStoneColor);
        canvas.drawRect(braceletCenterX - stoneRadius - 20, braceletTop, braceletCenterX - stoneRadius - 40, braceletBottom, megaBraceletAccentColor);
        canvas.drawRect(braceletCenterX - stoneRadius - 60, braceletTop, braceletCenterX - stoneRadius - 80, braceletBottom, megaBraceletAccentColor);
        canvas.drawRect(braceletLeft, braceletTop + 40, braceletCenterX - stoneRadius - 100, braceletTop + 60, megaBraceletAccentColor);
        canvas.drawRect(braceletLeft, braceletBottom - 40, braceletCenterX - stoneRadius - 100, braceletBottom - 60, megaBraceletAccentColor);
        canvas.drawRect(braceletCenterX - stoneRadius - 100, braceletTop, braceletCenterX - stoneRadius - 120, braceletTop + 60, megaBraceletAccentColor);
        canvas.drawRect(braceletCenterX - stoneRadius - 100, braceletBottom - 60, braceletCenterX - stoneRadius - 120, braceletBottom, megaBraceletAccentColor);

        canvas.drawRect(braceletCenterX + stoneRadius + 20, braceletTop, braceletCenterX + stoneRadius + 40, braceletBottom, megaBraceletAccentColor);
        canvas.drawRect(braceletCenterX + stoneRadius + 60, braceletTop, braceletCenterX + stoneRadius + 80, braceletBottom, megaBraceletAccentColor);
        canvas.drawRect(braceletCenterX + stoneRadius + 100, braceletTop + 40, braceletRight, braceletTop + 60, megaBraceletAccentColor);
        canvas.drawRect(braceletCenterX + stoneRadius + 100, braceletBottom - 40, braceletRight, braceletBottom - 60, megaBraceletAccentColor);
        canvas.drawRect(braceletCenterX + stoneRadius + 100, braceletTop, braceletCenterX + stoneRadius + 120, braceletTop + 60, megaBraceletAccentColor);
        canvas.drawRect(braceletCenterX + stoneRadius + 100, braceletBottom - 60, braceletCenterX + stoneRadius + 120, braceletBottom, megaBraceletAccentColor);
    }

    public ColoringModel getColoringModel()
    {
        return this.coloringModel;
    }

}
