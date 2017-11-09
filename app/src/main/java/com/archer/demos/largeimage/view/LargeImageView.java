package com.archer.demos.largeimage.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
import android.view.MotionEvent;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Archer on 2017/11/9.
 */

public class LargeImageView extends AppCompatImageView {
    private int mImageWidth, mImageHeight;
    /**
     * 绘制的区域
     */
    private volatile Rect mRect = new Rect();

    private MoveGestureDetector mMoveGestureDetector;
    private BitmapRegionDecoder mBitmapRegionDecoder;
    private static final BitmapFactory.Options options = new BitmapFactory.Options();

    static {
        options.inPreferredConfig = Bitmap.Config.RGB_565;
    }

    public LargeImageView(Context context) {
        this(context, null);
    }

    public LargeImageView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public LargeImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mMoveGestureDetector = new MoveGestureDetector(getContext(), new MoveGestureDetector.SimpleMoveGestureDetector() {
            @Override
            public boolean onMove(MoveGestureDetector detector) {
                int moveX = (int) detector.getMoveX();
                int moveY = (int) detector.getMoveY();

                if (mImageWidth > getWidth()) {
                    mRect.offset(-moveX, 0);
                    checkWidth();
                    invalidate();
                }
                if (mImageHeight > getHeight()) {
                    mRect.offset(0, -moveY);
                    checkHeight();
                    invalidate();
                }
                return true;
            }
        });
    }

    private void checkWidth() {
        Rect rect = mRect;
        int imageWidth = mImageWidth;

        if (rect.right > imageWidth) {
            rect.right = imageWidth;
            rect.left = imageWidth - getWidth();
        }
        if (rect.left < 0) {
            rect.left = 0;
            rect.right = getWidth();
        }
    }
    private void checkHeight() {
        Rect rect = mRect;
        int imageHeight = mImageHeight;

        if (rect.bottom > imageHeight) {
            rect.bottom = imageHeight;
            rect.top = imageHeight - getHeight();
        }
        if (rect.top < 0) {
            rect.top = 0;
            rect.bottom = getHeight();
        }
    }

    public void setInputStream(InputStream is) {
        try {
            mBitmapRegionDecoder = BitmapRegionDecoder.newInstance(is, false);
            BitmapFactory.Options tmpOptions = new BitmapFactory.Options();
            tmpOptions.inJustDecodeBounds = true;
            BitmapFactory.decodeStream(is, null, tmpOptions);
//            mImageWidth = tmpOptions.outWidth;
//            mImageHeight = tmpOptions.outHeight;
            mImageWidth = mBitmapRegionDecoder.getWidth();
            mImageHeight = mBitmapRegionDecoder.getHeight();

            requestLayout();
            invalidate();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (is != null) {
                    is.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        mMoveGestureDetector.onTouchEvent(event);
        return true;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Bitmap bitmap = mBitmapRegionDecoder.decodeRegion(mRect, options);
        canvas.drawBitmap(bitmap, 0, 0, null);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int width = getMeasuredWidth();
        int height = getMeasuredHeight();
        int imageWidth = mImageWidth;
        int imageHeight = mImageHeight;
        //默认直接显示图片的中心区域
        mRect.left = imageWidth / 2 - width / 2;
        mRect.top = imageHeight / 2 - height / 2;
        mRect.right = mRect.left + width;
        mRect.bottom = mRect.top + height;
    }
}
