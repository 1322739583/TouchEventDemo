package com.xzh.touch;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class ChessView extends View {
    Paint mPaint=new Paint();
    int startX=50;
    int startY=50;
    int cellSize =50;//格子大小
    int markpadding=5;//炮位和兵位的线条间距
    public ChessView(Context context) {
        super(context);
        init();
    }

    public ChessView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {

    }

    @Override
    protected void onDraw(Canvas canvas) {
        //8*8
        //先不考虑适配的问题，先把样子画出来。
        drawGrid(canvas);
        drawJiugong(canvas);
        drawPaoMark(canvas);
        drawSoldierMark(canvas);
    }

    /**
     * 画兵线
     * @param canvas
     */
    private void drawSoldierMark(Canvas canvas) {
        canvas.drawLine(startX+cellSize*2-markpadding,startY+cellSize*2.75f,startX+cellSize*2-markpadding,startY+cellSize*3-markpadding,mPaint);
        canvas.drawLine(startX+cellSize*2+markpadding,startY+cellSize*2.75f,startX+cellSize*2+markpadding,startY+cellSize*3-markpadding,mPaint);
        canvas.drawLine(startX+cellSize*2-markpadding,startY+cellSize*3+markpadding,startX+cellSize*2-markpadding,startY+cellSize*3.25f,mPaint);
        canvas.drawLine(startX+cellSize*2+markpadding,startY+cellSize*3+markpadding,startX+cellSize*2+markpadding,startY+cellSize*3.25f,mPaint);

    }

    /**
     * 画炮位线
     * @param canvas
     */
    private void drawPaoMark(Canvas canvas) {
        //画炮位线
        //2炮
        //竖线
        canvas.drawLine(startX+cellSize-markpadding,startY+cellSize*1.75f,startX+cellSize-markpadding,startY+cellSize*2-markpadding,mPaint);
        canvas.drawLine(startX+cellSize+markpadding,startY+cellSize*1.75f,startX+cellSize+markpadding,startY+cellSize*2-markpadding,mPaint);
        canvas.drawLine(startX+cellSize-markpadding,startY+cellSize*2+markpadding,startX+cellSize-markpadding,startY+cellSize*2.25f,mPaint);
        canvas.drawLine(startX+cellSize+markpadding,startY+cellSize*2+markpadding,startX+cellSize+markpadding,startY+cellSize*2.25f,mPaint);
        //横线
        canvas.drawLine(startX+cellSize*0.75f,startY+cellSize*2-markpadding,startX+cellSize-markpadding,startY+cellSize*2-markpadding,mPaint);
        canvas.drawLine(startX+cellSize+markpadding,startY+cellSize*2-markpadding,startX+cellSize*1.25f,startY+cellSize*2-markpadding,mPaint);
        canvas.drawLine(startX+cellSize*0.75f,startY+cellSize*2+markpadding,startX+cellSize-markpadding,startY+cellSize*2+markpadding,mPaint);
        canvas.drawLine(startX+cellSize+markpadding,startY+cellSize*2+markpadding,startX+cellSize*1.25f,startY+cellSize*2+markpadding,mPaint);

        //8炮
        //竖线
        canvas.drawLine(startX+cellSize*7-markpadding,startY+cellSize*1.75f,startX+cellSize*7-markpadding,startY+cellSize*2-markpadding,mPaint);
        canvas.drawLine(startX+cellSize*7+markpadding,startY+cellSize*1.75f,startX+cellSize*7+markpadding,startY+cellSize*2-markpadding,mPaint);
        canvas.drawLine(startX+cellSize*7-markpadding,startY+cellSize*2+markpadding,startX+cellSize*7-markpadding,startY+cellSize*2.25f,mPaint);
        canvas.drawLine(startX+cellSize*7+markpadding,startY+cellSize*2+markpadding,startX+cellSize*7+markpadding,startY+cellSize*2.25f,mPaint);
        //横线
        canvas.drawLine(startX+cellSize*0.75f+cellSize*6,startY+cellSize*2-markpadding,startX+cellSize*7-markpadding,startY+cellSize*2-markpadding,mPaint);
        canvas.drawLine(startX+cellSize+markpadding+cellSize*6,startY+cellSize*2-markpadding,startX+cellSize*1.25f+cellSize*6,startY+cellSize*2-markpadding,mPaint);
        canvas.drawLine(startX+cellSize*0.75f+cellSize*6,startY+cellSize*2+markpadding,startX+cellSize-markpadding+cellSize*6,startY+cellSize*2+markpadding,mPaint);
        canvas.drawLine(startX+cellSize+markpadding+cellSize*6,startY+cellSize*2+markpadding,startX+cellSize*1.25f+cellSize*6,startY+cellSize*2+markpadding,mPaint);


        //八炮
        //竖线
        canvas.drawLine(startX+cellSize-markpadding,startY+cellSize*1.75f+cellSize*5,startX+cellSize-markpadding,startY+cellSize*2-markpadding+cellSize*5,mPaint);
        canvas.drawLine(startX+cellSize+markpadding,startY+cellSize*1.75f+cellSize*5,startX+cellSize+markpadding,startY+cellSize*2-markpadding+cellSize*5,mPaint);
        canvas.drawLine(startX+cellSize-markpadding,startY+cellSize*2+markpadding+cellSize*5,startX+cellSize-markpadding,startY+cellSize*2.25f+cellSize*5,mPaint);
        canvas.drawLine(startX+cellSize+markpadding,startY+cellSize*2+markpadding+cellSize*5,startX+cellSize+markpadding,startY+cellSize*2.25f+cellSize*5,mPaint);
        //横线
        canvas.drawLine(startX+cellSize*0.75f,startY+cellSize*2-markpadding+cellSize*5,startX+cellSize-markpadding,startY+cellSize*2-markpadding+cellSize*5,mPaint);
        canvas.drawLine(startX+cellSize+markpadding,startY+cellSize*2-markpadding+cellSize*5,startX+cellSize*1.25f,startY+cellSize*2-markpadding+cellSize*5,mPaint);
        canvas.drawLine(startX+cellSize*0.75f,startY+cellSize*2+markpadding+cellSize*5,startX+cellSize-markpadding,startY+cellSize*2+markpadding+cellSize*5,mPaint);
        canvas.drawLine(startX+cellSize+markpadding,startY+cellSize*2+markpadding+cellSize*5,startX+cellSize*1.25f,startY+cellSize*2+markpadding+cellSize*5,mPaint);

        //二炮
        //竖线
        canvas.drawLine(startX+cellSize*7-markpadding,startY+cellSize*1.75f+cellSize*5,startX+cellSize*7-markpadding,startY+cellSize*2-markpadding+cellSize*5,mPaint);
        canvas.drawLine(startX+cellSize*7+markpadding,startY+cellSize*1.75f+cellSize*5,startX+cellSize*7+markpadding,startY+cellSize*2-markpadding+cellSize*5,mPaint);
        canvas.drawLine(startX+cellSize*7-markpadding,startY+cellSize*2+markpadding+cellSize*5,startX+cellSize*7-markpadding,startY+cellSize*2.25f+cellSize*5,mPaint);
        canvas.drawLine(startX+cellSize*7+markpadding,startY+cellSize*2+markpadding+cellSize*5,startX+cellSize*7+markpadding,startY+cellSize*2.25f+cellSize*5,mPaint);
        //横线
        canvas.drawLine(startX+cellSize*0.75f+cellSize*6,startY+cellSize*2-markpadding+cellSize*5,startX+cellSize*7-markpadding,startY+cellSize*2-markpadding+cellSize*5,mPaint);
        canvas.drawLine(startX+cellSize+markpadding+cellSize*6,startY+cellSize*2-markpadding+cellSize*5,startX+cellSize*1.25f+cellSize*6,startY+cellSize*2-markpadding+cellSize*5,mPaint);
        canvas.drawLine(startX+cellSize*0.75f+cellSize*6,startY+cellSize*2+markpadding+cellSize*5,startX+cellSize-markpadding+cellSize*6,startY+cellSize*2+markpadding+cellSize*5,mPaint);
        canvas.drawLine(startX+cellSize+markpadding+cellSize*6,startY+cellSize*2+markpadding+cellSize*5,startX+cellSize*1.25f+cellSize*6,startY+cellSize*2+markpadding+cellSize*5,mPaint);
    }

    /**
     * 画九宫线
     * @param canvas
     */
    private void drawJiugong(Canvas canvas) {
        //画九宫线
        //上部分九宫
        canvas.drawLine(startX+cellSize*3,startY,startX+cellSize*5,startY+cellSize*2,mPaint);
        canvas.drawLine(startX+cellSize*5,startY,startX+cellSize*3,startY+cellSize*2,mPaint);
        //下部分九宫
        canvas.drawLine(startX+cellSize*3,startY+cellSize*7,startX+cellSize*5,startY+cellSize*9,mPaint);
        canvas.drawLine(startX+cellSize*5,startY+cellSize*7,startX+cellSize*3,startY+cellSize*9,mPaint);
    }

    /**
     * 画出大体网格
     * @param canvas
     */
    private void drawGrid(Canvas canvas) {
        //10条横线
        for (int i = 0; i <10 ; i++) {
            canvas.drawLine(startX,startY+ cellSize *i, startX+cellSize *8,startY+ cellSize *i,mPaint);
        }
        //2条旁边竖线
        canvas.drawLine(startX,startY, startX,startY+ cellSize *9,mPaint);
        canvas.drawLine(startX+cellSize*8,startY, startX+cellSize*8,startY+ cellSize *9,mPaint);

        //画上半部分竖线
        for (int i = 1; i <=7 ; i++) {
            canvas.drawLine(startX+cellSize*i,startY,startX+cellSize*i,startY+cellSize*4,mPaint);
        }
        //画下半部分竖线
        for (int i = 1; i <=7 ; i++) {
            canvas.drawLine(startX+cellSize*i,startY+cellSize*5,startX+cellSize*i,startY+cellSize*5+cellSize*4,mPaint);
        }
    }
}
