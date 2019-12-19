package com.example.hongligs.bean;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;

import in.srain.cube.views.ptr.PtrClassicFrameLayout;

public class PtrClassicRefreshLayout extends PtrClassicFrameLayout {
    private boolean disallowInterceptTouchEvent = false;
    public PtrClassicRefreshLayout(Context context) {
        super(context);
    }

    public PtrClassicRefreshLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public PtrClassicRefreshLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public void requestDisallowInterceptTouchEvent(boolean disallowIntercept) {
        disallowInterceptTouchEvent = disallowIntercept;
        super.requestDisallowInterceptTouchEvent(disallowIntercept);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent e) {
        switch (e.getAction()) {
            case MotionEvent.ACTION_UP:
                this.requestDisallowInterceptTouchEvent(false);
                break;
        }

        if (disallowInterceptTouchEvent) {
            return dispatchTouchEventSupper(e);
        }

        return super.dispatchTouchEvent(e);
    }

}
