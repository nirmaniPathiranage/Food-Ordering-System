package com.example.nano_science.recyclerview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnBreakfast;
    Button btnLunch;
    Button btnDinner;
    Button btnDessert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnBreakfast = (Button)findViewById(R.id.breakfast);
        btnLunch = (Button)findViewById(R.id.lunch);
        btnDinner = (Button)findViewById(R.id.dinner);
        btnDessert = (Button)findViewById(R.id.dessert);

        btnBreakfast.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                openActivity2();
            }
            });

        btnLunch.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                openActivity3();
            }
        });


        btnDinner.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                openActivity4();
            }
        });


        btnDessert.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                openActivity5();
            }
        });

    }

    public void openActivity2(){
        Intent intent = new Intent(this,Main2Activity.class);
        startActivity(intent);
    }

    public void openActivity3(){
        Intent intent = new Intent(this,Main3Activity.class);
        startActivity(intent);
    }

    public void openActivity4(){
        Intent intent = new Intent(this,Main4Activity.class);
        startActivity(intent);
    }

    public void openActivity5(){
        Intent intent = new Intent(this,Main5Activity.class);
        startActivity(intent);
    }


}
