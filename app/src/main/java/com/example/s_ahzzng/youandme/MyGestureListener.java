package com.example.s_ahzzng.youandme;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;


public class MyGestureListener extends GestureDetector.SimpleOnGestureListener{

    private static final String TAG = "Gesture";

    @Override
    public boolean onDown(MotionEvent e) {

        return true;
    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        return super.onFling(e1, e2, velocityX, velocityY);
    }

    @Override
    public boolean onDoubleTap(MotionEvent e) {
        Log.d(TAG, "ondoubletap"+e.toString());
        return true;
    }
}
