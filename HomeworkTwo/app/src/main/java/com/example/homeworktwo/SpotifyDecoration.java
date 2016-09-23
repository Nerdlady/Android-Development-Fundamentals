package com.example.homeworktwo;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;


public class SpotifyDecoration extends RecyclerView.ItemDecoration{
    private Paint brown;
    private Paint black;
    private Activity activity;
    private boolean isOdd;



    public SpotifyDecoration(Activity activity) {
        this.brown = new Paint(Paint.ANTI_ALIAS_FLAG);
        this.brown.setColor(0xff311B0A);
        this.black = new Paint(Paint.ANTI_ALIAS_FLAG);
        this.black.setColor(Color.BLACK);
        this.activity = activity;
        this.isOdd = true;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        outRect.top = 35;
        outRect.bottom = 35;
        outRect.left=60;
    }

    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {

        final RecyclerView.LayoutManager layoutManager = parent.getLayoutManager();
        Bitmap b;
        for (int i = 0; i < parent.getChildCount(); i++) {
            final View child = parent.getChildAt(i);
            c.drawRect(
                    layoutManager.getDecoratedLeft(child),
                    layoutManager.getDecoratedTop(child),
                    layoutManager.getDecoratedRight(child),
                    layoutManager.getDecoratedBottom(child),
                    brown);
            if (!child.isDrawingCacheEnabled()){
                ImageView image = (ImageView)child.findViewById(R.id.spotifyImageView);
                if (!isOdd){
                    b= BitmapFactory.decodeResource( activity.getResources(),R.drawable.download );

                } else {
                    b= BitmapFactory.decodeResource( activity.getResources(),R.drawable.explicit );
                }

                image.setImageBitmap(b);
                child.setDrawingCacheEnabled(true);
                isOdd = !isOdd;
            }
        }
    }
}
