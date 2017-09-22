package com.insanus.course.aboutactivity.activities.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import java.util.List;

/**
 * Created by insanus on 2017/9/22.
 */

public class StackView extends View {
    private int screenX;
    private int screenY;
    private Paint paint;

    private float paintSize = 10;
    private int RectY;
    private int Stock_bottom;
    private List<Context> ContextSet;

    public void setList(List set) {
        this.ContextSet = set;
    }

    public StackView(Context context) {
        super(context);
        init();
    }

    public StackView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public StackView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public StackView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        paint = new Paint();
        paint.setStrokeWidth(paintSize);
        paint.setColor(Color.BLACK);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //设置高宽
        screenY = getHeight();
        screenX = getWidth();

        int num = 0;
        if(ContextSet != null)
        //set个数
            num = ContextSet.size();

        int padding = 50;
        RectY = (screenY - padding - padding - padding * num)
        /num;
        Stock_bottom = screenY - padding;

        float[] pts={
                padding,padding,padding,screenY-padding,
                padding,screenY-padding,screenX-padding,screenY-padding,
                screenX-padding,screenY-padding,screenX-padding,padding,
        };

        canvas.drawLines(pts,0,12,paint);


        paint.setStyle(Paint.Style.STROKE);

        for(int index = 0;index < num; index ++) {
            canvas.drawRect(padding << 1, Stock_bottom - padding - RectY, screenX - (padding << 1), Stock_bottom - padding, paint);

            Paint strPaint = new Paint();
            strPaint.setColor(Color.BLACK);
            strPaint.setTextSize(50);
            strPaint.setStyle(Paint.Style.FILL);
            strPaint.setTextAlign(Paint.Align.CENTER);

            canvas.drawText(ContextSet.get(index).getClass().getSimpleName(),(screenX - (padding << 1))/2,Stock_bottom - padding - RectY/2,strPaint);

            Stock_bottom = Stock_bottom -  RectY - padding;
        }

    }
}
