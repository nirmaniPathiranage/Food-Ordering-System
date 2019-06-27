package com.example.nano_science.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Main3Activity extends AppCompatActivity {

    RecyclerView recyclerView;
    MenuAdapter adapter;
    List<Menu> menuList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        menuList = new ArrayList<>();

        recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        //adding some items to our list

        menuList.add(
                new Menu(
                        1,
                        "Biriyani",
                        "A plate of biriyani with chicken, egg and sea food",
                        250,
                        R.drawable.biriyani));

        menuList.add(
                new Menu(
                        1,
                        "Rice and Curry",
                        "A plate of rice with 4 curries",
                        120,
                        R.drawable.rice));

        menuList.add(
                new Menu(
                        1,
                        "Rice and Curry with Fish",
                        "A plate of rice with 4 curries and fish ",
                        140,
                        R.drawable.ricenfish));

        menuList.add(
                new Menu(
                        1,
                        "Rice and Curry with Chicken",
                        "A plate of rice with 4 curries and a piece of chicken",
                        160,
                        R.drawable.ricenchicken));

        menuList.add(
                new Menu(
                        1,
                        "Rice and Curry with Egg",
                        "A plate of rice with 4 curries and egg",
                        120,
                        R.drawable.ricenegg));

        menuList.add(
                new Menu(
                        1,
                        "Fried Rice - Egg",
                        "A plate of fried rice with chilly paste and egg",
                        170,
                        R.drawable.friedriceegg));

        menuList.add(
                new Menu(
                        1,
                        "Fried Rice - Chicken",
                        "A plate of fried rice with chilly paste and chicken",
                        150,
                        R.drawable.friedricechicken));


        adapter = new MenuAdapter(this, menuList);
        recyclerView.setAdapter(adapter);

    }
}
