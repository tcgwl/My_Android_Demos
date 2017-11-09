package com.archer.demos.largeimage.listener;

import com.archer.demos.largeimage.view.MoveGestureDetector;

/**
 * Created by Archer on 2017/11/9.
 */

public interface OnMoveGestureListener {
    boolean onMoveBegin(MoveGestureDetector detector);
    boolean onMove(MoveGestureDetector detector);
    void onMoveEnd(MoveGestureDetector detector);
}
