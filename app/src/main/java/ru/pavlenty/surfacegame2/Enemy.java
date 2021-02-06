package ru.pavlenty.surfacegame2;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.util.Log;

import java.util.Random;

public class Enemy  {
    private Bitmap bitmap;
    private int x;
    private int y;
    private int speed = 10;
    private boolean boosting;
    private int maxX;
    private int maxY;

    private final int MIN_SPEED = 1;
    private final int MAX_SPEED = 20;

    private Rect detectCollision;
    Enemy(Context context, int screenX, int screenY) {
        Random r = new Random();
        y = r.nextInt(screenY);
        x = screenX;
        maxX = screenX;
        maxY = screenY;
        speed = 10;
        bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.enemy);
        boosting = false;


        detectCollision =  new Rect(x, y, bitmap.getWidth(), bitmap.getHeight());
    }
    public void update() {
        x -= speed;
        Log.d("RRRR x=", Integer.toString(x));
        detectCollision.left = x;
        detectCollision.top = y;
        detectCollision.right = x + bitmap.getWidth();
        detectCollision.bottom = y + bitmap.getHeight();
        if (x < 0) {

            x = maxX;
            Random generator = new Random();
            y = generator.nextInt(maxY);
            speed = generator.nextInt(15);
        }

    }
    public Rect getDetectCollision() {
        return detectCollision;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getSpeed() {
        return speed;
    }
}
