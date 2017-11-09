package com.archer.demos.largeimage.view;

import android.content.Context;
import android.graphics.PointF;
import android.view.MotionEvent;

import com.archer.demos.largeimage.listener.OnMoveGestureListener;

/**
 * Created by Archer on 2017/11/9.
 */

public class MoveGestureDetector extends BaseGestureDetector {
    private PointF mPrePointer;
    private PointF mCurrentPointer;
    //用于记录最终结果，并返回
    private PointF mFinalPointer = new PointF();

    private OnMoveGestureListener mListenter;

    public MoveGestureDetector(Context context, OnMoveGestureListener listenter) {
        super(context);
        mListenter = listenter;
    }

    @Override
    protected void handleInProgressEvent(MotionEvent event) {
        int actionCode = event.getAction() & MotionEvent.ACTION_MASK;
        switch (actionCode) {
            case MotionEvent.ACTION_CANCEL:
            case MotionEvent.ACTION_UP:
                mListenter.onMoveEnd(this);
                resetState();
                break;
            case MotionEvent.ACTION_MOVE:
                updateStateByEvent(event);
                boolean update = mListenter.onMove(this);
                if (update) {
                    mPreMotionEvent.recycle();
                    mPreMotionEvent = MotionEvent.obtain(event);
                }
                break;
        }
    }

    @Override
    protected void handleStartProgressEvent(MotionEvent event) {
        int actionCode = event.getAction() & MotionEvent.ACTION_MASK;
        switch (actionCode) {
            case MotionEvent.ACTION_DOWN:
                resetState();
                mPreMotionEvent = MotionEvent.obtain(event);
                updateStateByEvent(event);
                break;
            case MotionEvent.ACTION_MOVE:
                mGestureInProgress = mListenter.onMoveBegin(this);
                break;
        }
    }

    @Override
    protected void updateStateByEvent(MotionEvent event) {
        final MotionEvent prev = mPreMotionEvent;
        mPrePointer = caculateFocalPointer(prev);
        mCurrentPointer = caculateFocalPointer(event);

        boolean isSkipThisMoveEvent = prev.getPointerCount() != event.getPointerCount();
        mFinalPointer.x = isSkipThisMoveEvent ? 0 : mCurrentPointer.x - mPrePointer.x;
        mFinalPointer.y = isSkipThisMoveEvent ? 0 : mCurrentPointer.y - mPrePointer.y;
    }

    /**
     * 根据event计算多指中心点
     */
    private PointF caculateFocalPointer(MotionEvent event) {
        int pointerCount = event.getPointerCount();
        float x = 0, y = 0;
        for (int i = 0; i < pointerCount; i++) {
            x += event.getX(i);
            y += event.getY(i);
        }
        x /= pointerCount;
        y /= pointerCount;
        return new PointF(x, y);
    }

    public float getMoveX() {
        return mFinalPointer.x;

    }

    public float getMoveY() {
        return mFinalPointer.y;
    }

    public static class SimpleMoveGestureDetector implements OnMoveGestureListener {
        @Override
        public boolean onMoveBegin(MoveGestureDetector detector) {
            return true;
        }

        @Override
        public boolean onMove(MoveGestureDetector detector) {
            return false;
        }

        @Override
        public void onMoveEnd(MoveGestureDetector detector) {

        }
    }
}
