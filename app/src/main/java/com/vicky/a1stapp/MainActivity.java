package com.vicky.a1stapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.RelativeLayout;
import java.util.Random;
import android.graphics.Color;
import android.content.SharedPreferences;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity
{

    int num=0;

    int randomColor()
    {
        Random r = new Random();
        int red = r.nextInt(256);
        int green = r.nextInt(256);
        int blue = r.nextInt(256);
        return Color.rgb(red, green, blue);
    }



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        final TextView fTextView = (TextView) findViewById(R.id.HW);
        final Button fButton = (Button) findViewById(R.id.btn);
        final Button rbutton = (Button) findViewById(R.id.btn1);
        final RelativeLayout bg= (RelativeLayout) findViewById((R.id.background));
        SharedPreferences load = getSharedPreferences("Savenum", MODE_PRIVATE);
        num = load.getInt("Snum", 0);
        fTextView.setText("No. of times Clicked = " + num );


        fButton.setOnClickListener(new View.OnClickListener()
        {
            @Override


            public void onClick(View view)
            {

                    SharedPreferences load = getSharedPreferences("Savenum", MODE_PRIVATE);
                    num = load.getInt("Snum", 0);
                    if (num != 0) {
                        num++;
                        fTextView.setText("No. of times Clicked = " + num );
                        bg.setBackgroundColor(randomColor());
                        fButton.setBackgroundColor(randomColor());
                        SharedPreferences save = getSharedPreferences("Savenum", MODE_PRIVATE);
                        SharedPreferences.Editor editor = save.edit();
                        editor.putInt("Snum", num);
                        editor.apply();
                    } else {
                        //fTextView.setText(" Hi Daw");
                        num++;
                        fTextView.setText("No. of times Clicked = "+ num );
                        bg.setBackgroundColor(randomColor());
                        fButton.setBackgroundColor(randomColor());
                        SharedPreferences save = getSharedPreferences("Savenum", MODE_PRIVATE);
                        SharedPreferences.Editor editor = save.edit();
                        editor.putInt("Snum", num);
                        editor.apply();

                    }



                    // bg.setBackgroundColor(Color.RED);







            }






        }
        );

        rbutton.setOnClickListener(new View.OnClickListener() {
            @Override


            public void onClick(View view) {
                num = num * 0;
                fTextView.setText("No. of times Clicked = 0 ");
                bg.setBackgroundColor(Color.WHITE);
                fButton.setBackgroundColor(Color.LTGRAY);
                SharedPreferences save = getSharedPreferences("Savenum", MODE_PRIVATE);
                SharedPreferences.Editor editor = save.edit();
                editor.putInt("Snum", num);
                editor.apply();
                Toast.makeText(MainActivity.this,
                        "Reset Done", Toast.LENGTH_SHORT).show();
            }


        }
        );
    }




}
