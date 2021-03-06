package com.philip.myopencvapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import org.opencv.android.Utils;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
// This is Philip's project
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn = findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = "Hello";
                try{
                    Mat img = Utils.loadResource(MainActivity.this,R.drawable.ja, CvType.CV_8SC4);
                    message = "b:"+img.get(50,50)[0]+"g:"+img.get(50,50)[1]+"r:"+img.get(50,50)[3];
                    Log.d("zencher","channel"+img.channels());
                }catch(Exception e){
                    Log.d("zencher",""+e);
                }

                int[] r = getArray3d(2,1);
                Log.d("zencher", "" +r[1]);
                Toast.makeText(MainActivity.this,"hello", Toast.LENGTH_SHORT).show();
            }
        });

    }
    int[] getArray3d(int x, int y){
        int[][][] array3d = new int[5][5][5];
        for(int i = 0; i<5; i++){
            for(int j = 0 ; j<5;j++){
                for(int k = 0; k<5; k++){
                    array3d[i][j][k] = i+j+k;
                }
            }

        }
        return array3d [x][y]    ;
    }

}