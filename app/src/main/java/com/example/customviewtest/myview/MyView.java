package com.example.customviewtest.myview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.example.customviewtest.R;

public class MyView extends View {

    float circleRadius;
    Paint circlePaint;

    float x,y;

    int height;
    int width;

    public MyView(Context context) {
        super(context);
        init(null);
    }

    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public MyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public MyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        height = MeasureSpec.getSize(heightMeasureSpec);
        width = MeasureSpec.getSize(widthMeasureSpec);

    }

    void init(AttributeSet attrs) {

        circlePaint = new Paint();

        TypedArray attribs = getContext().obtainStyledAttributes(attrs, R.styleable.MyView);

        circleRadius = attribs.getDimension(R.styleable.MyView_circleRadius, 10f);

        circlePaint.setColor(attribs.getColor(R.styleable.MyView_circleColor, Color.BLUE));

        attribs.recycle();

    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawCircle(x, y, circleRadius, circlePaint);

        invalidate();

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch (event.getAction())  {
            case MotionEvent.ACTION_DOWN:
               x=  event.getX();
               y = event.getY();
            break;
            case MotionEvent.ACTION_UP:
                break;
        }

        return true;
    }


}
