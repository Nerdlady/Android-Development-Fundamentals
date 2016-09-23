package com.example.homeworktwo;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.v7.widget.RecyclerView;
import android.view.View;


public class SofbusDecorationRecyclerView extends RecyclerView.ItemDecoration {
    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDraw(c, parent, state);
        final RecyclerView.LayoutManager layoutManager = parent.getLayoutManager();
        Paint paint = new Paint();
        paint.setColor(0xff5EDEF5);
        paint.setFlags(Paint.ANTI_ALIAS_FLAG);

        int index = parent.getChildCount() / 2;

        final View child = parent.getChildAt(index);
        c.drawRect(
            layoutManager.getDecoratedLeft(child)+10,
            layoutManager.getDecoratedTop(child)+10,
            layoutManager.getDecoratedRight(child)-10,
            layoutManager.getDecoratedBottom(child),paint
            );
    }
}
