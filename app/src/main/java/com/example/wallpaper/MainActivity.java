package com.example.wallpaper;

import androidx.appcompat.app.AppCompatActivity;

import android.app.WallpaperManager;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    int images[]= new int[]{

            R.drawable.image1,//0
            R.drawable.image2,//1
            R.drawable.image3 //2
    };
    Button btn;
    int i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn=findViewById(R.id.btnChange);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //our logic here
                // need to change wallaper of our phone for every 30 sec.
                Timer t=new Timer();
                t.scheduleAtFixedRate(new TimerTask() {
                    @Override
                    public void run() {
                        //write our logic

                        WallpaperManager wallpaperManager= WallpaperManager.getInstance(getBaseContext());

                        try {
                            wallpaperManager.setBitmap(BitmapFactory.decodeResource(getResources(),images[i]));
                            i++;//0,1,2

                            if(i==3){
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                },0,5000);
            }
        });
    }
}