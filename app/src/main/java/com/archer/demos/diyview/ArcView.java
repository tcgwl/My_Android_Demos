package com.archer.demos.diyview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Archer on 2018/4/2.
 */

public class ArcView extends View {
    private Paint mPaint;
    RectF mRectF;

    public ArcView(Context context) {
        this(context, null);
    }

    public ArcView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ArcView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mRectF = new RectF(200, 100, 800, 500);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        mPaint.setStyle(Paint.Style.FILL);//填充模式
        canvas.drawArc(mRectF, -110, 100, true, mPaint);//绘制扇形

        mPaint.setColor(Color.BLUE);
        canvas.drawArc(mRectF, 20, 140, false, mPaint);//绘制弧形

        mPaint.setStyle(Paint.Style.STROKE);//画线模式
        mPaint.setColor(Color.RED);
        canvas.drawArc(mRectF, 180, 60, false, mPaint);//绘制不封口的弧形
    }
}
