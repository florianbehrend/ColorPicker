package com.itbehrend.colorpicker;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;

import androidx.annotation.Nullable;

/**
 * A {@link FrameLayout} whose height always equals its measured width.
 *
 * <p>Used as the grid-cell root so each swatch fills its column and stays square,
 * regardless of how the {@code GridLayoutManager} divides the dialog width.
 */
public class SquareFrameLayout extends FrameLayout {

    public SquareFrameLayout(Context context) {
        super(context);
    }

    public SquareFrameLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public SquareFrameLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    @SuppressWarnings("SuspiciousNameCombination") // square by design: height spec = width spec
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        // Force a square: measure height with the same spec as width.
        super.onMeasure(widthMeasureSpec, widthMeasureSpec);
    }
}
