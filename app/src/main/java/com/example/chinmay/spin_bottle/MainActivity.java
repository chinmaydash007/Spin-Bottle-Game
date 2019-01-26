package com.example.chinmay.spin_bottle;

import android.animation.Animator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
private Button button;
private Random random=new Random();
private ImageView imageView;
private int lastDirection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=findViewById(R.id.button);
        imageView=findViewById(R.id.imageView);

    }

    public void Spin(View view) {
        int newDirection=random.nextInt(3600);
        float pivotX=imageView.getWidth()/2;
        float pivotY=imageView.getHeight()/2;
        Animation rotate=new RotateAnimation(lastDirection,newDirection,pivotX,pivotY);
        rotate.setFillAfter(true);
        rotate.setDuration(2000);
        rotate.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                button.setEnabled(false);
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                button.setEnabled(true);

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        lastDirection=newDirection;
        imageView.startAnimation(rotate);

    }
}
