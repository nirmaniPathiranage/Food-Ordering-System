package com.example.nano_science.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Main5Activity extends AppCompatActivity {

    RecyclerView recyclerView;
    MenuAdapter adapter;
    List<Menu> menuList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        menuList = new ArrayList<>();

        recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        //adding some items to our list

        menuList.add(
                new Menu(
                        1,
                        "Vanilla-Chox Mix Ice Cream",
                        "A chocolate and vanilla mixed cone of ice cream",
                        100,
                        R.drawable.icecream));

        menuList.add(
                new Menu(
                        1,
                        "Ice-Cream Cake",
                        "A cake filled with ice cream of vanilla and chocolate flavours",
                        150,
                        R.drawable.icecreamcake));

        menuList.add(
                new Menu(
                        1,
                        "Chocolate Cake",
                        "A piece of cake with chocolate flavour and cream",
                        60,
                        R.drawable.chocolatecake));

        menuList.add(
                new Menu(
                        1,
                        "Chocolate Lava",
                        "A cube of chocolate lava with spreaded choco",
                        200,
                        R.drawable.chocolava));

        menuList.add(
                new Menu(
                        1,
                        "Watalappan",
                        "A cup of watalappan mixed with nuts and honey",
                        100,
                        R.drawable.watalappan));

        menuList.add(
                new Menu(
                        1,
                        "Strawberry Jelly",
                        "A cube of jelly with strawberry flavoured nuts",
                        140,
                        R.drawable.jelly));

        menuList.add(
                new Menu(
                        1,
                        "Curd and Treacle",
                        "A full cup of Sri Lankan curd with original honey ",
                        70,
                        R.drawable.curdntreacle));




        adapter = new MenuAdapter(this, menuList);
        recyclerView.setAdapter(adapter);

    }
}
