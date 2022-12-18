package com.example.fractal;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorSpace;
import android.graphics.Paint;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText aMin;
    private EditText aMax;
    private EditText bMin;
    private EditText bMax;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        aMin = (EditText) findViewById(R.id.a_min);
        aMax = (EditText) findViewById(R.id.a_max);
        bMin = (EditText) findViewById(R.id.b_min);
        bMax = (EditText) findViewById(R.id.b_max);

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            Color translucentRed = Color.valueOf(1.0f, 0.0f, 0.0f, 0.5f);
            Paint my_paint = new Paint();
            drawPaint(my_paint);
        }

    }
    public void onPaintClick(View view) {
        Paint my_paint = new Paint();
        drawPaint(my_paint);
    }

    public void onClean(View view) {
    }
    public void drawPaint (Paint paint) {
        Canvas canvas = new Canvas();

        canvas.drawOval(2f,5f,5f,10f,paint);
    }
}