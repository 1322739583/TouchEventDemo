package com.xzh.touch;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Display;
import android.view.View;

import androidx.annotation.Nullable;

public class JunQiView extends View {
    private static final String TAG = "JunQiView";
    private Paint mBorderPaint;
    private Paint mStationPaint;
    private Point mScreenSize;
    private int mBorderMargin = 15;//border margin
    private int borderStrothWidth = 10;
    private int mStationMargin = 10;

    private int stationStrothWidth = 5;
    //这个stationWidth =width+stationStrothWidth
 //   private int stationWidth = (480 - mBorderMargin * 2 - borderStrothWidth * 2 - mStationMargin * 5 * 2) / 5;
     private int stationWidth= (800 - mBorderMargin * 2 -borderStrothWidth*2- mStationMargin * 17*2) / 17;
   // private  int stationWidth=35;


    public JunQiView(Context context) {
        super(context);
     //   init(context);



        //context.getcon
    }

    public JunQiView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
       // init(context);
    }

    private void init(Context context) {
        mBorderPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mBorderPaint.setDither(true);
        mBorderPaint.setColor(Color.GRAY);
        mBorderPaint.setStyle(Paint.Style.STROKE);
        mBorderPaint.setStrokeWidth(borderStrothWidth);

        mStationPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mStationPaint.setDither(true);
        mStationPaint.setColor(Color.GRAY);
        mStationPaint.setStyle(Paint.Style.STROKE);
        mStationPaint.setStrokeWidth(stationStrothWidth);


        Display display = ((Activity) context).getWindowManager().getDefaultDisplay();
        Point point = new Point();
        display.getSize(point);
        Log.d("JunQiView", point.x + "");
        Log.d("JunQiView", point.y + "");
        Log.e(TAG, "Context:"+context.getClass().getSimpleName());
        Log.e(TAG, "ApplicationContext:"+context.getApplicationContext().getClass().getSimpleName());
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);


        Rect border = new Rect();

        border.top = mBorderMargin;
        border.left = mBorderMargin;
        border.bottom = 800 - mBorderMargin;
        border.right = 480 - mBorderMargin;
        //站位和营地
        for (int i = 0; i < 5; i++) {
            Rect station = new Rect();
            station.top = mBorderMargin + borderStrothWidth + mStationMargin + stationStrothWidth / 2;
            station.left = mBorderMargin + borderStrothWidth + mStationMargin * (i * 2 + 1) + stationWidth * i+100;
            station.right = station.left + stationWidth;
            station.bottom = station.top + stationWidth;
            canvas.drawRect(station, mStationPaint);
            for (int j = 1; j < 17; j++) {
                Rect stationH = new Rect();
                stationH.top = mBorderMargin + borderStrothWidth + mStationMargin * (j* 2 + 1) +stationWidth*j;
                stationH.left = mBorderMargin + borderStrothWidth + mStationMargin * (i * 2 + 1) + stationWidth * i+100;
                stationH.right = stationH.left + stationWidth;
                stationH.bottom = stationH.top + stationWidth;
                canvas.drawRect(stationH, mStationPaint);
            }
        }
        canvas.drawRect(border, mBorderPaint);

    }

}
