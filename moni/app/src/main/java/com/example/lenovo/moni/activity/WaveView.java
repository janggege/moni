package com.example.lenovo.moni.activity;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;

/*Time:2019/4/4
 *Author:刘江
 *Description:
 */public class WaveView extends View {
    private int width = 0;
    private int height = 0;
    private int baseHeight = 0;// 波浪高度
    private int waveHeight = 100;// 波峰波、波谷高度
    private int waveWidth;//波浪宽度
    private float offset = 0;//偏移量
    private Paint paint;

    public WaveView(Context context) {
        super(context);
    }

    public WaveView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initPaint();
    }


    public WaveView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    /**
     * 设置开启动画
     */
    private void startAni() {
        ValueAnimator animator = ValueAnimator.ofFloat(0, waveWidth);
        animator.setInterpolator(new LinearInterpolator());
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {

            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float animatorValue = (float) animation.getAnimatedValue();
                offset = animatorValue;
                postInvalidate();
            }
        });
        animator.setDuration(1000);
        animator.setRepeatCount(ValueAnimator.INFINITE);
        animator.start();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawPath(getPath(), paint);
    }

    //初始化paint
    private void initPaint() {
        paint = new Paint();
        paint.setColor(Color.parseColor("#88FFFFFF"));
        paint.setStyle(Paint.Style.FILL);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        width = getMeasuredWidth();
        height = getMeasuredHeight();
        waveWidth = width;
        baseHeight = height / 2;
        startAni();
    }

    /**
     * 生成path
     *
     * @return
     */
    private Path getPath() {
        int itemWidth = waveWidth / 2;//波长
        Path path = new Path();
        path.moveTo(-itemWidth * 3, baseHeight);//起始点坐标
        for (int count = -3; count < 2; count++) {
            int controlX = count * itemWidth;
            path.quadTo(controlX + itemWidth / 2 + offset,//控制点的X
                    getWaveHeight(count),//控制点的Y
                    controlX + itemWidth + offset,//结束点的X
                    baseHeight//结束点的Y
            );
        }
        //封闭区域
        path.lineTo(width, height);
        path.lineTo(0, height);
        path.close();
        return path;
    }

    //计算波峰、波谷
    private int getWaveHeight(int num) {
        if (num % 2 == 0) {
            return baseHeight - waveHeight;
        }
        return baseHeight + waveHeight;
    }


}
